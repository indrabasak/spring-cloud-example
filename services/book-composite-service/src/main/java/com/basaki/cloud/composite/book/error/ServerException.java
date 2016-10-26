package com.basaki.cloud.composite.book.error;

/**
 * {@code ServerException} represents a server exception that can be thrown when
 * a Feign client encounters a server exception.
 * <p/>
 *
 * @author Indra Basak
 */
public class ServerException extends RuntimeException {

    public ServerException(String message) {
        super(message);
    }
}
