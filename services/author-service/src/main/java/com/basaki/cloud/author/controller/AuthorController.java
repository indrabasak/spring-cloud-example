package com.basaki.cloud.author.controller;

import com.basaki.cloud.author.api.AuthorService;
import com.basaki.cloud.author.model.Author;
import com.basaki.cloud.author.helper.AuthorWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@code AuthorController} is the spring REST controller for author
 * controller.
 * <p/>
 *
 * @author Indra Basak
 */
@RestController
@Slf4j
@Api(value = "Author API",
        description = "Author API",
        produces = "application/json", tags = {"API"})
public class AuthorController implements AuthorService {

    @Autowired
    private AuthorWorker worker;

    @ApiOperation(
            value = "Retrieves a book author.",
            notes = "Requires book identifier",
            response = Author.class)
    @Override
    public Author getAuthor(@PathVariable("id") Integer id) {
        return worker.getAuthor(id);
    }
}
