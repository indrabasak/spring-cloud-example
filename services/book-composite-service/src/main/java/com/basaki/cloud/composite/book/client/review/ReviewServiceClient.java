package com.basaki.cloud.composite.book.client.review;

import com.basaki.cloud.review.api.ReviewService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * {@code ReviewServiceClient} is the Feign client for review REST controller.
 * <p/>
 *
 * @author Indra Basak
 */
@FeignClient(name = "review")
public interface ReviewServiceClient extends ReviewService {
}
