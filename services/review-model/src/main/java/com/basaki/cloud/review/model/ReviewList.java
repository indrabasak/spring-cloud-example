package com.basaki.cloud.review.model;

import java.util.List;
import lombok.Data;


/**
 * {@code ReviewList} represents a wrapper class for a list of reviews due to
 * problems associated with unmarshalling a collection of returned objects.
 * <p/>
 *
 * @author Indra Basak
 */
@Data
public class ReviewList {
    private List<Review> reviews;
}
