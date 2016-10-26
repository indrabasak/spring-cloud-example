package com.basaki.cloud.book.controller;

import com.basaki.cloud.book.model.Book;
import com.basaki.cloud.book.helper.BookWorker;
import com.basaki.cloud.book.boot.TestBookApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * {@code BookControllerMvcTest} is the functional test for {@code
 * BookController} using Spring MVC test framework.
 * <p/>
 *
 * @author Indra Basak
 */
@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
@ContextConfiguration(classes = TestBookApplication.class)
public class BookControllerMvcTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookWorker worker;

    @Test
    public void testGetBook() throws Exception {
        Book book = new Book();
        book.setId(3);
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        given(worker.getBook(3)).willReturn(book);

        mvc.perform(get("/books/3")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{'id':3,'title':'Test Book','author':'Test Author'}"));
    }
}
