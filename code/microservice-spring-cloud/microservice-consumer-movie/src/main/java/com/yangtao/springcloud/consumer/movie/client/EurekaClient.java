package com.yangtao.springcloud.consumer.movie.client;

import com.yangtao.springcloud.consumer.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "xxx", url = "http://localhost:9000/", configuration = FeignConfiguration.class)
public interface EurekaClient {

    @RequestMapping(value = "/eureka/apps/{appName}")
    String getUserInfo(@PathVariable String appName);
}
