package com.yangtao.springcloud.microservicegateway.config;

import com.yangtao.springcloud.microservicegateway.entity.Token;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class GlobalAuthFilter implements GlobalFilter, Ordered {

    public static ConcurrentHashMap<String, Token> map = new ConcurrentHashMap<>();

    private Environment env;

    public GlobalAuthFilter(Environment env){
        this.env = env;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String strValue = env.getProperty("auth.isEnabled");
        boolean isEnabled = strValue == null || Boolean.parseBoolean(strValue);
        String appName = env.getProperty("spring.application.name");
        if (!isEnabled) {
            return chain.filter(exchange);
        }
        String path = exchange.getRequest().getPath().value();
        String requestToken = exchange.getRequest().getQueryParams().getFirst("token");
        String[] arr = path.substring(1).split("/");
        if (arr.length == 2 && (arr[0].equalsIgnoreCase(appName)) && "getToken".equals(arr[1])) {
            return chain.filter(exchange);
        }
        Token token;
        if (arr.length == 0
                || (token = map.get(arr[0].toLowerCase())) == null
                || !token.isValid()
                || requestToken == null
                || !requestToken.equals(token.getValue())) {
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        return chain.filter(exchange);
    }


    @Override
    public int getOrder() {
        return -1;
    }
}
