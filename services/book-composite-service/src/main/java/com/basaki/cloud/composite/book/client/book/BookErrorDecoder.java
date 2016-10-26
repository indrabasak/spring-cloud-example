package com.basaki.cloud.composite.book.client.book;

import com.basaki.cloud.book.model.BookErrorInfo;
import com.basaki.cloud.composite.book.error.ClientException;
import com.basaki.cloud.composite.book.error.FeignErrorDecoder;

/**
 * {@code BookErrorDecoder } is a custom error decoder for book controller Feign
 * client.
 * <p/>
 *
 * @author Indra Basak
 */
public class BookErrorDecoder extends FeignErrorDecoder {

    /**
     * Handles a client exception by converting the exception response body into
     * {@code BookErrorInfo} and wrapping it around inside a {@code
     * ClientException}
     *
     * @param responseBody response body
     * @return a client exception
     */
    @Override
    public Exception handleClientException(String responseBody) {
        Exception excp = null;

        try {
            BookErrorInfo errorInfo =
                    getMapper().readValue(responseBody, BookErrorInfo.class);

            if (errorInfo != null) {
                return new ClientException(errorInfo.getMessage(), errorInfo);
            }

        } catch (Exception e) {
            //do nothing
        }

        return excp;
    }

    @Override
    public Exception handleServerException(String responseBody) {
        return null;
    }
}
