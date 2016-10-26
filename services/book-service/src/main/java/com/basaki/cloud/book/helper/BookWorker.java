package com.basaki.cloud.book.helper;

import com.basaki.cloud.book.error.BookNotFoundException;
import com.basaki.cloud.book.model.Book;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;

/**
 * {@code BookWorker} does the actual processing of book controller.
 * <p/>
 *
 * @author Indra Basak
 */
@Service
public class BookWorker {

    @Autowired
    private ResourceBundleMessageSource msgResource;

    public Book getBook(int id) {
        if (id > 99) {
            Locale locale = LocaleContextHolder.getLocale();
            String msg = msgResource.getMessage("error.book.not.found",
                    new Object[]{id},
                    locale);
            throw new BookNotFoundException(msg);
        }

        Book book = new Book();
        book.setId(id);
        book.setAuthor("Sandra Boynton");
        book.setTitle("Barnyard Dance!");

        return book;
    }
}
