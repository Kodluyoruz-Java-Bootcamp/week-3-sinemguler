package com.emlakcepteservice;


import com.emlakcepteservice.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class EmlakcepteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmlakcepteServiceApplication.class, args);
    }

    @Bean
    public UserService userService() {
        return new UserService();
    }


}
