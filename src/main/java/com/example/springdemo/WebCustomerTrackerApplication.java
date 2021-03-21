package com.example.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:spring-mvc-crud-demo-servlet.xml")
public class WebCustomerTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebCustomerTrackerApplication.class, args);
    }

}
