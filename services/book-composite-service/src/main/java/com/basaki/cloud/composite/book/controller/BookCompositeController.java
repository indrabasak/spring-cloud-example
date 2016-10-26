/**
 *
 */
package com.basaki.cloud.composite.book.controller;

import com.basaki.cloud.composite.book.helper.BookCompositeWorker;
import com.basaki.cloud.composite.book.model.BookComposite;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@code AuthorController} is the spring REST controller for composite book
 * controller.
 * <p/>
 *
 * @author Indra Basak
 */
@RestController
@Slf4j
@Api(value = "Book Composite API",
        description = "Book Composite API",
        produces = "application/json", tags = {"API"})
public class BookCompositeController {

    @Autowired
    private BookCompositeWorker worker;

    @ApiOperation(
            value = "Retrieves a composite book.",
            notes = "Requires a book identifier",
            response = BookComposite.class)

    @RequestMapping(method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE}, value = "/books/{id}")
    @ResponseBody
    public BookComposite getBook(@PathVariable Integer id) {
        return worker.getBookASync(id);
    }
}
