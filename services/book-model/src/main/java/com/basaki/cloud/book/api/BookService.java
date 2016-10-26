package com.basaki.cloud.book.api;

import com.basaki.cloud.book.model.Book;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * {@code BookService} represents the interface of book REST controller.
 * Useful for Feign client.
 * <p/>
 *
 * @author Indra Basak
 */
public interface BookService {
    @RequestMapping(method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE}, value = "/books/{id}")
    @ResponseBody
    Book getBook(@PathVariable("id") Integer id);
}
