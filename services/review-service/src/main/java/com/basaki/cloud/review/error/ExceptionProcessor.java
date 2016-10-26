package com.basaki.cloud.review.error;

import com.basaki.cloud.review.model.ReviewErrorInfo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * {@code ExceptionProcessor } processes review controller exceptions.
 * <p/>
 *
 * @author Indra Basak
 */
@ControllerAdvice
public class ExceptionProcessor {

    @ExceptionHandler(ReviewNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ReviewErrorInfo handleCustomerNotFoundException(
            HttpServletRequest req,
            ReviewNotFoundException ex) {
        String errorURL = req.getRequestURL().toString();
        int code = HttpStatus.NOT_FOUND.value();
        String type = "authorNotFound";

        return new ReviewErrorInfo(errorURL, code, type, ex.getMessage());
    }
}
