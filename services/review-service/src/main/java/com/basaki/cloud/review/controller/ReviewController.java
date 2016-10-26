package com.basaki.cloud.review.controller;

import com.basaki.cloud.review.api.ReviewService;
import com.basaki.cloud.review.model.ReviewList;
import com.basaki.cloud.review.helper.ReviewWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@code ReviewController} is the spring REST controller for review controller.
 * <p/>
 *
 * @author Indra Basak
 */
@RestController
@Slf4j
@Api(value = "Review API",
        description = "Rev API",
        produces = "application/json", tags = {"API"})
public class ReviewController implements ReviewService {

    @Autowired
    private ReviewWorker worker;

    @ApiOperation(
            value = "Retrieves a list of reviews.",
            notes = "Requires book identifier",
            response = ReviewList.class)
    public ReviewList getReviews(@PathVariable("id") Integer id) {
        return worker.getReviews(id);
    }
}
