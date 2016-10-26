package com.basaki.cloud.review.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@code ReviewErrorInfo} is the human readable error information which is sent
 * when no review is found for a book.
 * <p/>
 *
 * @author Indra Basak
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewErrorInfo {
    private String url;
    private int code;
    private String type;
    private String message;
}
