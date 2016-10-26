package com.basaki.cloud.author.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * {@code AuthorApplication} represents the entry point for author controller
 * spring boot application. {@code EnableDiscoveryClient} annotation is used for
 * registering with Eureka (Netflix Service Discovery Server and Client). You
 * can also use {@code EnableEurekaClient} annotation instead.
 * <p/>
 *
 * @author Indra Basak
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {
        "com.basaki.cloud.author.config",
        "com.basaki.cloud.author.controller",
        "com.basaki.cloud.author.error",
        "com.basaki.cloud.author.helper"})
public class AuthorApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorApplication.class, args);
    }
}
