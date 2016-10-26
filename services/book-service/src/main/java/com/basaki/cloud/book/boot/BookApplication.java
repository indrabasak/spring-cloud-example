package com.basaki.cloud.book.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

/**
 * {@code BookApplication} represents the entry point for book controller
 * spring boot application. {@code @EnableDiscoveryClient} is used for
 * registering with Eureka (Netflix Service Discovery Server and Client). You
 * can also use {@code @EnableEurekaClient}
 * <p/>
 *
 * @author Indra Basak
 */
@SpringBootApplication
@EnableHystrix
@EnableDiscoveryClient
@ComponentScan(basePackages = {
        "com.basaki.cloud.book.config",
        "com.basaki.cloud.book.controller",
        "com.basaki.cloud.book.error",
        "com.basaki.cloud.book.helper"})
public class BookApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }
}
