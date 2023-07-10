package com.codeup.codeupspringblog;

import java.lang.module.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
