package com.basaki.cloud.composite.book.boot;

import com.basaki.cloud.composite.book.client.author.AuthorServiceClient;
import com.basaki.cloud.composite.book.client.book.BookServiceClient;
import com.basaki.cloud.composite.book.client.review.ReviewServiceClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

/**
 * {@code BookCompositeApplication} represents the entry point for composite
 * book controller spring boot application. The {@code EnableDiscoveryClient}
 * annotation is used for registering with Eureka (Netflix Service Discovery
 * Server and Client). You can also use {@code EnableEurekaClient} annotation
 * instead. The {@code EnableCircuitBreaker} annotation is used to enable
 * Hystrix which implements Netflix's circuit breaker pattern.
 * <p/>
 *
 * @author Indra Basak
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrix
@ComponentScan(basePackages = {
        "com.basaki.cloud.composite.book.client",
        "com.basaki.cloud.composite.book.config",
        "com.basaki.cloud.composite.book.controller",
        "com.basaki.cloud.composite.book.error",
        "com.basaki.cloud.composite.book.helper",
        "com.basaki.cloud.composite.book.model"})
@EnableFeignClients(clients = {BookServiceClient.class,
        AuthorServiceClient.class, ReviewServiceClient.class})
public class BookCompositeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookCompositeApplication.class, args);
    }
}