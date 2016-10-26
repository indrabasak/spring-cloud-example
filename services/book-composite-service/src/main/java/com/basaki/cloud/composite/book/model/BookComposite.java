package com.basaki.cloud.composite.book.model;

import com.basaki.cloud.author.model.Author;
import com.basaki.cloud.book.model.Book;
import com.basaki.cloud.review.model.ReviewList;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@code BookComposite} represents a composite book used in our cloud example.
 * <p/>
 *
 * @author Indra Basak
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookComposite {
    private Book book;
    private Author author;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ReviewList reviews;
}
