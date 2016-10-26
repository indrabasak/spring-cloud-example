package com.basaki.cloud.book.error;

import com.basaki.cloud.book.model.BookErrorInfo;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * {@code ExceptionProcessor } processes book controller exceptions.
 * <p/>
 *
 * @author Indra Basak
 */
@ControllerAdvice
public class ExceptionProcessor {

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public BookErrorInfo handleCustomerNotFoundException(HttpServletRequest req,
            BookNotFoundException ex) {
        String errorURL = req.getRequestURL().toString();
        int code = HttpStatus.NOT_FOUND.value();
        String type = "bookNotFound";

        return new BookErrorInfo(errorURL, code, type, ex.getMessage());
    }
}