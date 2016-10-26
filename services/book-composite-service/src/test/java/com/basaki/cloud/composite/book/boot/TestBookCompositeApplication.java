package com.basaki.cloud.composite.book.boot;

import com.basaki.cloud.composite.book.client.author.AuthorServiceClient;
import com.basaki.cloud.composite.book.client.book.BookServiceClient;
import com.basaki.cloud.composite.book.client.review.ReviewServiceClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * {@code TestBookCompositeApplication} represents the entry point for composite
 * book controller test spring boot application.
 * <p/>
 *
 * @author Indra Basak
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.basaki.cloud.composite.book.client",
        "com.basaki.cloud.composite.book.config",
        "com.basaki.cloud.composite.book.controller",
        "com.basaki.cloud.composite.book.error",
        "com.basaki.cloud.composite.book.helper",
        "com.basaki.cloud.composite.book.model"})
@EnableFeignClients(clients = {BookServiceClient.class,
        AuthorServiceClient.class, ReviewServiceClient.class})
public class TestBookCompositeApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestBookCompositeApplication.class, args);
    }
}
