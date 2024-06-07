package net.ccts.api;

import com.fasterxml.jackson.annotation.JsonGetter;
import net.ccts.data.Book;

public class BookApiData {

    public static final String NODE_NAME = "book";
    private final Book book;

    public BookApiData(Book book) {
        this.book = book;
    }

    @JsonGetter("id")
    public String getId() {
        return book.getId();
    }

    @JsonGetter("title")
    public String getTitle() {
        return book.getTitle();
    }

    @JsonGetter("author")
    public String getAuthor() {
        return book.getAuthor();
    }

    @JsonGetter("rating")
    public int getRating() {
        return book.getRating();
    }
}
