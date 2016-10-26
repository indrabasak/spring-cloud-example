package com.basaki.cloud.author.helper;

import com.basaki.cloud.author.error.AuthorNotFoundException;
import com.basaki.cloud.author.model.Author;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;

/**
 * {@code AuthorWorker} does the actual processing of author controller.
 * <p/>
 *
 * @author Indra Basak
 */
@Service
public class AuthorWorker {

    @Autowired
    private ResourceBundleMessageSource msgResource;

    public Author getAuthor(int id) {
        if (id > 50 && id < 75) {
            Locale locale = LocaleContextHolder.getLocale();
            String msg = msgResource.getMessage("error.author.not.found",
                    new Object[]{id},
                    locale);
            throw new AuthorNotFoundException(msg);
        }

        Author author = new Author();
        author.setAuthor("Sandra Boynton");
        author.setBiography(String.join(" ",
                "Sandra Boynton is a popular American cartoonist, children's author,",
                "songwriter, producer, and director. Since 1974, Boynton has written and ",
                "illustrated over fifty children's books and seven general audience books,",
                "including five New York Times Bestsellers."));

        return author;
    }
}
