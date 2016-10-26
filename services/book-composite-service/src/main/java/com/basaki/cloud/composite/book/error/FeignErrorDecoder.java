package com.basaki.cloud.composite.book.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import java.io.InputStream;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * {@code FeignErrorDecoder} is an application specific Feign error decoder. It
 * unserializes the response body and turns it to a REST client specific error
 * object. The error object is wrapped inside a {@code ClientException}
 * <p/>
 *
 * @author Indra Basak
 */
@Getter
@Slf4j
public abstract class FeignErrorDecoder implements ErrorDecoder {

    @Autowired
    private ObjectMapper mapper;

    /**
     * Decodes the client exception from the response payload.
     *
     * @param methodKey the method key
     * @param response  the response object
     * @return the decoded client exception
     */
    @Override
    public Exception decode(String methodKey, Response response) {
        Exception ex;
        try {
            ex = decodeError(response);

            if (ex == null) {
                ex = new ErrorDecoder.Default().decode(methodKey, response);
            }

            return ex;
        } catch (Exception e) {
            log.error(
                    "An unexpected error occurred during decoding error " + e);
            throw FeignException.errorStatus(methodKey, response);
        }
    }

    /**
     * Decodes an exception from the response body and turn it into a client or
     * server exception based on the response status.
     *
     * @param response
     * @return decoded exception
     * @throws IOException if any any errors occur during processing
     */
    private Exception decodeError(Response response) throws IOException {
        Exception bexp = null;
        final byte[] body = readResponse(response);

        if (body == null) {
            return bexp;
        }

        String rspString = new String(body);

        //client side error
        if (response.status() >= 400 && response.status() <= 499) {
            log.debug("Decoding client side error.");

            bexp = handleClientException(rspString);

            if (bexp == null) {
                bexp = new ClientException(rspString, rspString);
            }
        }

        //server side error
        if (response.status() >= 500 && response.status() <= 599) {
            log.debug("Decoding server side error.");

            bexp = handleServerException(rspString);

            if (bexp == null) {
                bexp = new ServerException(rspString);
            }
        }

        return bexp;
    }

    /**
     * Reads the response readResponse and returns it as byte array.
     *
     * @param response the response object
     * @return the readResponse content
     * @throws IOException if any error occurs during response processing
     */
    private static byte[] readResponse(Response response) throws IOException {
        InputStream istream = response.body().asInputStream();
        byte[] byteArray = new byte[istream.available()];
        istream.read(byteArray);

        return byteArray;
    }

    public abstract Exception handleClientException(String responseBody);

    public abstract Exception handleServerException(String responseBody);
}
