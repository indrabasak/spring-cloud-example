package com.basaki.cloud.review.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * {@code TestReviewApplication} represents the entry point for review controller
 * test spring boot application.
 * <p/>
 *
 * @author Indra Basak
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.basaki.cloud.review.config",
        "com.basaki.cloud.review.controller",
        "com.basaki.cloud.review.error",
        "com.basaki.cloud.review.helper"})
public class TestReviewApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestReviewApplication.class, args);
    }
}
