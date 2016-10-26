package com.basaki.cloud.review.controller;

import com.basaki.cloud.review.model.Review;
import com.basaki.cloud.review.model.ReviewList;
import com.basaki.cloud.review.boot.TestReviewApplication;
import io.restassured.RestAssured;
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

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static java.util.Arrays.asList;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * {@code ReviewControllerTest} is the functional test for {@code
 * ReviewController} using rest assured framework and mock controller.
 * <p/>
 *
 * @author Indra Basak
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = TestReviewApplication.class)
public class ReviewControllerTest {

    private static SimpleDateFormat dateFormatter =
            new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");

    private static final String BASE_URL = "http://localhost";

    @Value("${local.server.port}")
    private Integer port;

    @Mock
    private ReviewController controller;

    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.port = port;
    }

    @Test
    public void getReviews() throws Exception {
        List<Review> reviews = asList(
                new Review("John Doe",
                        "Great book...",
                        dateFormatter.parse("08/05/1999 00:00:00 PDT")));
        ReviewList list = new ReviewList();
        list.setReviews(reviews);

        Mockito.
                when(controller.getReviews(3)).
                thenReturn(list);

        given().log().
                all().
                standaloneSetup(controller).
                when().
                get("/reviews/3").
                then().
                statusCode(200).
                log().
                body().
                body("reviews.size()", equalTo(1)).
                body("reviews[0].reviewer", equalTo("John Doe")).
                body("reviews[0].comment", equalTo("Great book..."));
    }
}