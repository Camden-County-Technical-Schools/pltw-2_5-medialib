package net.ccts.biz;

import net.ccts.data.Book;
import java.util.HashMap;
import java.util.Map;

public class BookManager {
    private static Map<String, Book> books = new HashMap<>();

    public static Book findBook(String id) {
        return books.get(id);
    }

    public static void removeBook(Book book) {
        books.remove(book.getId());
    }

    public static Book registerBook(Book book) {
        books.put(book.getId(), book);
        return book;
    }
}