package com.yangtao.springcloud.consumer.movie;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
/*@RibbonClient(name = "microservice-consumer-movie", configuration = FooConfiguration.class)*/
@EnableFeignClients
public class MovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, args);
        ObjectMapper objectMapper = new ObjectMapper();
    }

}
