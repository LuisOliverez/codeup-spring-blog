package com.codeup.codeupspringblog;


import java.sql.DriverManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootConfiguration(proxyBeanMethods = false)
@ImportAutoConfiguration
@SpringBootApplication
public class CodeupSpringBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeupSpringBlogApplication.class, args);
    }

}
