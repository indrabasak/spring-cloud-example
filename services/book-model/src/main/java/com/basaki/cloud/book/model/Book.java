package com.basaki.cloud.book.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@code Book} represents a book used in our cloud example.
 * <p/>
 *
 * @author Indra Basak
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int id;
    private String title;
    private String author;
}
