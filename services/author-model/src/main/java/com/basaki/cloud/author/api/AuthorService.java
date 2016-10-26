package com.basaki.cloud.author.api;

import com.basaki.cloud.author.model.Author;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * {@code AuthorService} represents the interface of author REST controller.
 * Useful for Feign client.
 * <p/>
 *
 * @author Indra Basak
 */
public interface AuthorService {

    @RequestMapping(method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE}, value = "/authors/{id}")
    @ResponseBody
    Author getAuthor(@PathVariable("id") Integer id);
}
