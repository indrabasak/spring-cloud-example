package com.basaki.cloud.book.controller;

import com.basaki.cloud.book.api.BookService;
import com.basaki.cloud.book.model.Book;
import com.basaki.cloud.book.helper.BookWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * {@code BookController} is the spring REST controller for book
 * controller.
 * <p/>
 *
 * @author Indra Basak
 */
@RestController
@Slf4j
@Api(value = "Book API",
        description = "Book API",
        produces = "application/json", tags = {"API"})
public class BookController implements BookService {

    @Autowired
    private BookWorker worker;

    @ApiOperation(
            value = "Retrieves a book.",
            notes = "Requires book identifier",
            response = Book.class)
    @Override
    public Book getBook(@PathVariable("id") Integer id) {
        return worker.getBook(id);
    }
}
