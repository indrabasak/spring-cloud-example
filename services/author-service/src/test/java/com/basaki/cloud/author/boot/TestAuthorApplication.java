package com.basaki.cloud.author.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * {@code TestAuthorApplication} represents the entry point for author controller
 * test spring boot application.
 * <p/>
 *
 * @author Indra Basak
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.basaki.cloud.author.config",
        "com.basaki.cloud.author.controller",
        "com.basaki.cloud.author.error",
        "com.basaki.cloud.author.helper"})
public class TestAuthorApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestAuthorApplication.class, args);
    }
}
