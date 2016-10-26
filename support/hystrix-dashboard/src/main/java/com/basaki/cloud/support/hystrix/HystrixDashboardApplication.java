package com.basaki.cloud.support.hystrix;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The {@code HystrixDashboardApplication} is used for setting up the Hystrix
 * Dashboard. Hystrix dashboard can be visited at /hystrix and from there point
 * the dashboard to an individual instances of /hystrix.stream endpoint in a
 * Hystrix client application.
 * <p/>
 *
 * @author Indra Basak
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableDiscoveryClient
@EnableTurbine
@Controller
public class HystrixDashboardApplication {

    @RequestMapping("/")
    public String home() {
        return "forward:/hystrix";
    }

    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(HystrixDashboardApplication.class).web(true);
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(HystrixDashboardApplication.class).web(
                true).run(args);
    }
}
