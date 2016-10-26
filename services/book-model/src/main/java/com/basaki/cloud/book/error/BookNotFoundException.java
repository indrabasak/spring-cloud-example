package com.basaki.cloud.book.error;

import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * {@code BookNotFoundException} is a runtime exception that can be thrown
 * when a book is not found.
 * <p/>
 *
 * @author Indra Basak
 */
@NoArgsConstructor
@ToString(callSuper = true)
public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String message) {
        super(message);
    }
}
