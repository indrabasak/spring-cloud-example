package com.basaki.cloud.composite.book.client.book;

import feign.Logger;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * {@code BookServiceClientConfiguration} is the Feign client configuration for
 * book feign controller client.
 * <p/>
 *
 * @author Indra Basak
 */
@Configuration
@Slf4j
public class BookServiceClientConfiguration {

    @Bean
    public Logger.Level feignLoggerLevel() {

        if (log.isDebugEnabled()) {
            return Logger.Level.FULL;
        } else {
            return Logger.Level.BASIC;
        }
    }

    @Bean
    public ErrorDecoder errorDecode() {
        return new BookErrorDecoder();
    }
}
