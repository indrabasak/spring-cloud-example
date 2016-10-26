package com.basaki.cloud.support.gateway.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

/**
 * The {@code GatewayApplication} represents a Zuul proxy server which acts as a
 * gateway application that uses Netflix Zuul to forward requests to the controller
 * application.
 *
 * @author Indra Basak
 */
@SpringBootApplication
@EnableZuulProxy
@ComponentScan(basePackages = {
        "com.basaki.cloud.support.gateway.controller"})
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
