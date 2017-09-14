package com.basaki.cloud.support.discovery.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * {@code SecurityConfiguration} is the base Spring security
 * configuration for Eureka server. It can handle multiple users and passwords.
 * <p/>
 *
 * @author Indra Basak
 * @since 9/8/17
 */
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@EnableConfigurationProperties(SecurityAuthProperties.class)
@Slf4j
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private SecurityAuthProperties properties;

    @Autowired
    public SecurityConfiguration(SecurityAuthProperties properties) {
        this.properties = properties;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().fullyAuthenticated()
                .and().httpBasic().and().csrf().disable();

        http.sessionManagement().sessionCreationPolicy(
                SessionCreationPolicy.STATELESS);
    }

    /**
     * Configures the security provider. The base class delegates the
     * security provider to a child class.
     *
     * @param auth builder for creating the security manager
     * @throws Exception
     */
    protected void configure(AuthenticationManagerBuilder auth) throws
            Exception {
        properties.getUsers().entrySet().stream()
                .forEach(e -> {
                    try {
                        auth.inMemoryAuthentication().withUser(
                                e.getKey()).password(
                                e.getValue().getPassword()).roles("USER");
                    } catch (Exception excp) {
                        throw new RuntimeException(excp);
                    }
                });
    }
}
