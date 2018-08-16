package com.baidu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class Springboot1Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Springboot1Application.class, args);
    }

     protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
          return builder.sources(Springboot1Application.class);
     }
}
