package com.basaki.cloud.book.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * {@code TestBookApplication} represents the entry point for book controller
 * test spring boot application.
 * <p/>
 *
 * @author Indra Basak
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.basaki.cloud.book.config",
        "com.basaki.cloud.book.controller",
        "com.basaki.cloud.book.error",
        "com.basaki.cloud.book.helper"})
public class TestBookApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestBookApplication.class, args);
    }
}
