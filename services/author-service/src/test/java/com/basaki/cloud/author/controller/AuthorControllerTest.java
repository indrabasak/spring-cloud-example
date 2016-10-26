package com.basaki.cloud.author.controller;

import com.basaki.cloud.author.error.AuthorNotFoundException;
import com.basaki.cloud.author.model.Author;
import com.basaki.cloud.author.boot.TestAuthorApplication;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * {@code AuthorControllerTest} is the functional test for {@code
 * AuthorController} using rest assured framework and mock controller.
 * <p/>
 *
 * @author Indra Basak
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = TestAuthorApplication.class)
public class AuthorControllerTest {

    private static final String BASE_URL = "http://localhost";

    @Value("${local.server.port}")
    private Integer port;

    @Mock
    private AuthorController controller;

    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.port = port;
    }

    @Test
    public void getAuthor() throws Exception {
        Mockito.
                when(controller.getAuthor(3)).
                thenReturn(new Author("John Doe", "Nothing great."));

        given().log().
                all().
                standaloneSetup(controller).
                when().
                get("/authors/3").
                then().
                statusCode(200).
                body("author", equalTo("John Doe")).
                body("biography", equalTo("Nothing great."));
    }

    @Test(expected = Exception.class)
    public void getAuthorWithException() throws Exception {
        Mockito.
                when(controller.getAuthor(4)).thenThrow(
                new AuthorNotFoundException("Author not found with id 4"));

        given().log().
                all().
                standaloneSetup(controller).
                when().
                get("/authors/4");
    }
}