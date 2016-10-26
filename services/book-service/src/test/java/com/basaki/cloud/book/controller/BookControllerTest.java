package com.basaki.cloud.book.controller;

import com.basaki.cloud.book.model.Book;
import com.basaki.cloud.book.boot.TestBookApplication;
import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * {@code BookControllerTest} is the functional test for {@code
 * BookController} using rest assured framework and mock controller.
 * <p/>
 *
 * @author Indra Basak
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = TestBookApplication.class)
public class BookControllerTest {

    private static final String BASE_URL = "http://localhost";

    @Value("${local.server.port}")
    private Integer port;

    @Mock
    private BookController controller;

    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.port = port;
    }

    @Test
    public void getBook() throws Exception {
        Mockito.
                when(controller.getBook(3)).
                thenReturn(new Book(3, "Test Book", "Test Author"));

        RestAssuredMockMvc.given().log().
                all().
                standaloneSetup(controller).
                when().
                get("/books/3").
                then().
                statusCode(200).
                body("id", equalTo(3)).
                body("title", equalTo("Test Book")).
                body("author", equalTo("Test Author"));
    }
}
