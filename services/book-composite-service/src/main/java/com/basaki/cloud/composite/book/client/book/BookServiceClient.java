package com.basaki.cloud.composite.book.client.book;

import com.basaki.cloud.book.api.BookService;
import com.basaki.cloud.composite.book.config.SpringConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * {@code BookServiceClient} is the Feign client for author REST controller. It has
 * a custom error decoder if an error is encountered during the call.
 * <p/>
 *
 * @author Indra Basak
 */
@FeignClient(name = "book",
        configuration = {BookServiceClientConfiguration.class,
                SpringConfiguration.class})
public interface BookServiceClient extends BookService {

}
