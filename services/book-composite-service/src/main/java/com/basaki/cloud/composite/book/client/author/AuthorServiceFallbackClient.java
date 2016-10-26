package com.basaki.cloud.composite.book.client.author;

import com.basaki.cloud.author.model.Author;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * {@code AuthServiceFallbackClient} is the Feign fallback client for author
 * REST controller if the controller is down or an author is not found for a book.
 * <p/>
 *
 * @author Indra Basak
 */
@Component
public class AuthorServiceFallbackClient implements AuthorServiceClient {

    @Override
    public Author getAuthor(@PathVariable("id") Integer id) {
        return new Author("Anonymous Author",
                "No biography found for the author...");
    }
}
