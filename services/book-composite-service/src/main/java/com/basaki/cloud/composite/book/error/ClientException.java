package com.basaki.cloud.composite.book.error;

import lombok.Getter;

/**
 * {@code ClientException} represents a client exception that can be thrown when
 * a Feign client encounters a client exception.
 * <p/>
 *
 * @author Indra Basak
 */
@Getter
public class ClientException extends RuntimeException {
    private Object errorInfo;

    /**
     * Constructs a client exception.
     *
     * @param message   the error message
     * @param errorInfo the unserialized error info object sent from a client
     *                  REST controller
     */
    public ClientException(String message, Object errorInfo) {
        super(message);
        this.errorInfo = errorInfo;
    }
}
