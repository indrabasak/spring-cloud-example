package com.basaki.cloud.composite.book.controller;

import com.basaki.cloud.author.model.Author;
import com.basaki.cloud.book.model.Book;
import com.basaki.cloud.composite.book.boot.TestBookCompositeApplication;
import com.basaki.cloud.composite.book.model.BookComposite;
import com.basaki.cloud.review.model.Review;
import com.basaki.cloud.review.model.ReviewList;
import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.text.SimpleDateFormat;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static java.util.Arrays.asList;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * {@code BookCompositeControllerTest} is the functional test for {@code
 * BookCompositeController} using rest assured framework and mock controller.
 * <p/>
 *
 * @author Indra Basak
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = TestBookCompositeApplication.class)
public class BookCompositeControllerTest {
    private static SimpleDateFormat dateFormatter =
            new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");

    private static final String BASE_URL = "http://localhost";

    @Value("${local.server.port}")
    private Integer port;

    @Mock
    private BookCompositeController controller;

    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.port = port;
    }

    @Test
    public void getBook() throws Exception {
        BookComposite book = new BookComposite();
        book.setBook(new Book(3, "Test Book", "Test Author"));
        book.setAuthor(new Author("John Doe", "Nothing great."));

        List<Review> reviews = asList(
                new Review("John Doe",
                        "Great book...",
                        dateFormatter.parse("08/05/1999 00:00:00 PDT")));
        ReviewList list = new ReviewList();
        list.setReviews(reviews);
        book.setReviews(list);

        Mockito.
                when(controller.getBook(3)).
                thenReturn(book);

        RestAssuredMockMvc.given().log().
                all().
                standaloneSetup(controller).
                when().
                get("/books/3").
                then().
                statusCode(200).
                log().
                body().
                body("book.id", equalTo(3)).
                body("book.title", equalTo("Test Book")).
                body("book.author", equalTo("Test Author")).
                body("author.author", equalTo("John Doe")).
                body("author.biography", equalTo("Nothing great.")).
                body("reviews.size()", equalTo(1)).
                body("reviews.reviews[0].reviewer", equalTo("John Doe")).
                body("reviews.reviews[0].comment", equalTo("Great book..."));
    }
}