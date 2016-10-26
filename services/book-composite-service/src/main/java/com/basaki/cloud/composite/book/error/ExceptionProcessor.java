package com.basaki.cloud.composite.book.error;

import com.basaki.cloud.book.model.BookErrorInfo;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * {@code ExceptionProcessor } processes composite book controller exceptions.
 * <p/>
 *
 * @author Indra Basak
 */
@ControllerAdvice
public class ExceptionProcessor {

    /**
     * Handles {@code HystrixRuntimeException} exception. It unwraps the root
     * cause and checks if it is of type {@code ClientException}. If it is,
     * retrieves the error info from the exception. cIt replaces the external
     * REST call URL with the URL called by the client of the this REST
     * controller.
     *
     * @param req HTTP request to extract the URL
     * @param ex  wrapped exception
     * @return ths error information that is sent to the client
     */
    @ExceptionHandler(HystrixRuntimeException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public Object handleHystrixRuntimeException(
            HttpServletRequest req, HystrixRuntimeException ex) {
        Object info = null;

        Throwable t = ex.getCause();
        if (t instanceof ClientException) {
            ClientException cex = (ClientException) t;
            info = cex.getErrorInfo();
            if (info instanceof BookErrorInfo) {
                BookErrorInfo binfo = (BookErrorInfo) info;
                binfo.setUrl(req.getRequestURL().toString());
            }
        } else if (t instanceof ServerException) {
            ServerException se = (ServerException) t;
            info = se.getMessage();
        } else {
            BookErrorInfo binfo = new BookErrorInfo();
            binfo.setUrl(req.getRequestURL().toString());
            binfo.setCode(HttpStatus.NOT_FOUND.value());
            binfo.setMessage(ex.getMessage());
            binfo.setType("client-error");
            info = binfo;
        }

        return info;
    }
}
