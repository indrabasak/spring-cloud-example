package com.basaki.cloud.review.api;

import com.basaki.cloud.review.model.ReviewList;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * {@code ReviewService} represents the interface of review REST controller.
 * Useful for Feign client.
 * <p/>
 *
 * @author Indra Basak
 */
public interface ReviewService {

    @RequestMapping(method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            value = "/reviews/{id}")
    @ResponseBody
    ReviewList getReviews(@PathVariable("id") Integer id);
}
