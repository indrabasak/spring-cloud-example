package com.basaki.cloud.support.gateway.controller;

import com.basaki.cloud.support.gateway.model.ErrorInfo;
import javax.servlet.http.HttpServletRequest;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@code CustomErrorController} is the spring REST controller for Zuul error
 * handling. TODO: Still not working properly controller.
 * <p/>
 *
 * @author Indra Basak
 */
@RestController
@Getter
public class CustomErrorController implements ErrorController {

    @Value("${error.path:/error}")
    private String errorPath;

    @RequestMapping(value = "${error.path:/error}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity error(HttpServletRequest request) {
        final int status = getErrorStatus(request);
        final String msg = getErrorMessage(request);
        ErrorInfo info = new ErrorInfo();
        info.setCode(status);
        info.setMessage(msg);
        info.setUrl(request.getRequestURI());
        return ResponseEntity.status(status).body(info);
    }

    private int getErrorStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute(
                "javax.servlet.error.status_code");
        return statusCode != null ? statusCode : HttpStatus.INTERNAL_SERVER_ERROR.value();
    }

    private String getErrorMessage(HttpServletRequest request) {
        final Throwable exc =
                (Throwable) request.getAttribute("javax.servlet.error.error");
        return exc != null ? exc.getMessage() : "Unexpected error occurred";
    }
}
