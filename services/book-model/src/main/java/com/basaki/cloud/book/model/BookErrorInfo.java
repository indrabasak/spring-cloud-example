package com.basaki.cloud.book.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@code BookErrorInfo} is the human readable error information which is sent
 * when a book is not found.
 * <p/>
 *
 * @author Indra Basak
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookErrorInfo {
    private String url;
    private int code;
    private String type;
    private String message;
}