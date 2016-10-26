package com.basaki.cloud.composite.book.client.author;

import com.basaki.cloud.author.api.AuthorService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * {@code AuthServiceClient} is the Feign client for author REST controller.
 * <p/>
 *
 * @author Indra Basak
 */
@FeignClient(name = "author", fallback = AuthorServiceFallbackClient.class)
public interface AuthorServiceClient extends AuthorService {
}
