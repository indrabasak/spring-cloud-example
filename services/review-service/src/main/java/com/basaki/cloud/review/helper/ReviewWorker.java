package com.basaki.cloud.review.helper;

import com.basaki.cloud.review.error.ReviewNotFoundException;
import com.basaki.cloud.review.model.Review;
import com.basaki.cloud.review.model.ReviewList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import static java.util.Arrays.asList;

/**
 * {@code ReviewWorker} does the actual processing of review controller.
 * <p/>
 *
 * @author Indra Basak
 */
@Service
public class ReviewWorker {

    private static SimpleDateFormat dateFormatter =
            new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");

    @Autowired
    private ResourceBundleMessageSource msgResource;

    public ReviewList getReviews(int id) {
        if (id > 70 && id < 80) {
            Locale locale = LocaleContextHolder.getLocale();
            String msg = msgResource.getMessage("error.review.not.found",
                    new Object[]{id},
                    locale);
            throw new ReviewNotFoundException(msg);
        }

        ReviewList list = new ReviewList();
        try {
            List<Review> reviews = asList(
                    new Review("A Customer",
                            "Dancing animal book is a winner with my 1 year old son!",
                            dateFormatter.parse("08/05/1999 00:00:00 PDT")),
                    new Review("Reviewer Dr. Beth",
                            "A wonderful story and activity book combined!",
                            dateFormatter.parse(
                                    "12/10/2004 00:00:00 PDT")),
                    new Review("History_of_Art_Geek ",
                            "Your baby will love this funny, little, board book!",
                            dateFormatter.parse(
                                    "05/15/2002 00:00:00 PDT")));
            list.setReviews(reviews);
        } catch (ParseException e) {
            //do nothing
        }

        return list;
    }
}
