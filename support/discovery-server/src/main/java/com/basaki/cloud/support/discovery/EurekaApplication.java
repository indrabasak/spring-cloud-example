package com.basaki.cloud.support.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * The {@code EurekaApplication} represents a {@code EnableEurekaServer} that is
 * used for setting up an application as a Eureka (Netflix Service Discovery
 * Server and Client) server.
 * <p/>
 *
 * @author Indra Basak
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
