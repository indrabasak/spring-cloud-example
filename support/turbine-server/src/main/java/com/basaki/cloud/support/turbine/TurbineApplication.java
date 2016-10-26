package com.basaki.cloud.support.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 * The {@code TurbineApplication} is used for setting up Turbine to work with
 * AMQP messaging. Turbine pulls metrics from all the distributed Hystrix
 * commands via Rabbit MQ.
 *
 * @author Indra Basak
 */
@SpringBootApplication
@EnableTurbineStream
@EnableEurekaClient
public class TurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbineApplication.class, args);
    }
}
