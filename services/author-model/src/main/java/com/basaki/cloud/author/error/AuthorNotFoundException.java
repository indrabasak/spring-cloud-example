package com.basaki.cloud.author.error;

import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * {@code AuthorNotFoundException} is a runtime exception that can be thrown
 * when an author is not found.
 * <p/>
 *
 * @author Indra Basak
 */
@NoArgsConstructor
@ToString(callSuper = true)
public class AuthorNotFoundException extends RuntimeException {

    public AuthorNotFoundException(String message) {
        super(message);
    }
}
