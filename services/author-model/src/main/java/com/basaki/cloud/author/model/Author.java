package com.basaki.cloud.author.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@code Author} represents an author of a book used in our cloud example.
 * <p/>
 *
 * @author Indra Basak
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    private String author;
    private String biography;
}
