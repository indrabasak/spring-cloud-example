package com.basaki.cloud.review.error;

import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * {@code ReviewNotFoundException} is a runtime exception that can be thrown
 * when no review for a book is not found.
 * <p/>
 *
 * @author Indra Basak
 */
@NoArgsConstructor
@ToString(callSuper = true)
public class ReviewNotFoundException extends RuntimeException {

    public ReviewNotFoundException(String message) {
        super(message);
    }
}
