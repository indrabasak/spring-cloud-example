package com.basaki.cloud.support.gateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@code AuthErrorInfo} is the human readable error information which is sent
 * when an author is not found.
 * <p/>
 *
 * @author Indra Basak
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo {
    private String url;
    private int code;
    private String type;
    private String message;
}