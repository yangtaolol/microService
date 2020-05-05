package com.yangtao.springcloud.microservicegateway.config;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class RouterConfig {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes().route(predicateSpec -> predicateSpec
                .path("/getToken").and().predicate(p->{
                    return p.getAttribute("appName") != null;
                })
                .uri("http://localhost:8080"))
                .build();
    }

    @Bean
    public GlobalFilter authFilter(Environment env){
        String value = env.getProperty("auth.isEnabled");
        boolean isEnabled = value == null || Boolean.parseBoolean(value);
        return new GlobalAuthFilter(env);
    }
}
