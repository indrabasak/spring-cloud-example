package com.basaki.cloud.author.error;

import com.basaki.cloud.author.model.AuthorErrorInfo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * {@code ExceptionProcessor } processes author controller exceptions.
 * <p/>
 *
 * @author Indra Basak
 */
@ControllerAdvice
public class ExceptionProcessor {

    @ExceptionHandler(AuthorNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public AuthorErrorInfo handleCustomerNotFoundException(
            HttpServletRequest req,
            AuthorNotFoundException ex) {
        String errorURL = req.getRequestURL().toString();
        int code = HttpStatus.NOT_FOUND.value();
        String type = "authorNotFound";

        return new AuthorErrorInfo(errorURL, code, type, ex.getMessage());
    }
}
