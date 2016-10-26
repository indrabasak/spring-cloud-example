package com.basaki.cloud.review.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * {@code ReviewApplication} represents the entry point for review controller
 * spring boot application. {@code @EnableDiscoveryClient} is used for
 * registering with Eureka (Netflix Service Discovery Server and Client). You
 * can also use {@code @EnableEurekaClient}
 * <p/>
 *
 * @author Indra Basak
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {
        "com.basaki.cloud.review.config",
        "com.basaki.cloud.review.controller",
        "com.basaki.cloud.review.error",
        "com.basaki.cloud.review.helper"})
public class ReviewApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReviewApplication.class, args);
    }
}
