package com.basaki.cloud.composite.book.helper;

import com.basaki.cloud.author.model.Author;
import com.basaki.cloud.book.model.Book;
import com.basaki.cloud.composite.book.client.author.AuthorServiceClient;
import com.basaki.cloud.composite.book.client.book.BookServiceClient;
import com.basaki.cloud.composite.book.client.review.ReviewServiceClient;
import com.basaki.cloud.composite.book.model.BookComposite;
import com.basaki.cloud.review.model.ReviewList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * {@code BookCompositeWorker} does the actual processing of composite book
 * controller. It calls book, author, and review controller to create a composite
 * book.
 * <p/>
 *
 * @author Indra Basak
 */
@Service
@Slf4j
public class BookCompositeWorker {

    @Autowired
    private BookServiceClient bookClient;

    @Autowired
    private AuthorServiceClient authorClient;

    @Autowired
    private ReviewServiceClient reviewClient;

    /**
     * Retrieves a composite book synchronously. Makes synchronous calls to
     * book, author, and review services.
     *
     * @param id abook id
     * @return a composite book
     */
    public BookComposite getBookSync(Integer id) {
        Book book = bookClient.getBook(id);
        Author author = authorClient.getAuthor(id);
        ReviewList reviews = reviewClient.getReviews(id);

        BookComposite bookComp = new BookComposite(book, author, reviews);

        return bookComp;
    }

    /**
     * Retrieves a composite book by fetching book synchronously, author, and
     * reviews in parallel.
     *
     * @param id a book id
     * @return a composite book
     */
    public BookComposite getBookASync(Integer id) {
        Book book = bookClient.getBook(id);
        Observable<Author> authorObs = getAuthor(book.getId());
        Observable<ReviewList> reviewsObs = getReviews(book.getId());

        Observable<BookComposite> obs = Observable.zip(authorObs, reviewsObs,
                (author, reviewList) -> {

                    BookComposite bookComp =
                            new BookComposite(book, author, reviewList);
                    return bookComp;
                });

        return obs.toBlocking().first();
    }

    /**
     * Makes a reactive call to fetch an author from the author controller. If
     * there is any exception encountered during the call, catches the exception
     * and returns a null object.
     *
     * @param id the book id
     * @return an author object wrapped inside an observable
     */
    private Observable<Author> getAuthor(final int id) {
        return Observable.create(
                (Subscriber<? super Author> sub) -> sub.onNext(
                        authorClient.getAuthor(id)))
                .onErrorReturn(throwable -> {
                    log.info(
                            "Exception encountered during retrieval of author. " + throwable.getMessage());
                    return null;
                }).subscribeOn(Schedulers.io());
    }

    /**
     * Makes a reactive call to fetch reviews author from the review controller. If
     * there is any exception encountered during the call, catches the exception
     * and returns a null object.
     *
     * @param id the book id
     * @return a list of review object wrapped inside an observable
     */
    private Observable<ReviewList> getReviews(final int id) {
        return Observable.create(
                (Subscriber<? super ReviewList> sub) -> sub.onNext(
                        reviewClient.getReviews(id)))
                .onErrorReturn(throwable -> {
                    log.info(
                            "Exception encountered during retrieval of reviews. " + throwable.getMessage());
                    return null;
                }).subscribeOn(Schedulers.io());
    }
}
