package net.ccts.data;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    private Book testBook;
    private String testISBN = "9781603095273";
    private String testTitle = "testTitle";
    private String testAuthor = "testAuthor";


    @Before
    public void setUp() {
        testBook = new Book(testISBN, testTitle, testAuthor);
    }

    @Test
    public void testCtor() {
        String id = "9781603095136";
        String title = "aTitle";
        String author = "anAuthor";
        Book b1 = new Book(id, title, author);
        assertEquals(id, b1.getId());
        assertEquals(title, b1.getTitle());
        assertEquals(author, b1.getAuthor());
    }

    @Test
    public void testISBN() {
        assertEquals(testISBN, testBook.getId());
    }

    @Test
    public void testTitle() {
        String title = "t1";
        testBook.setTitle(title);
        assertEquals(title, testBook.getTitle());
    }

    @Test
    public void testAuthor() {
        String author = "a1";
        testBook.setAuthor(author);
        assertEquals(author, testBook.getAuthor());
    }

}
