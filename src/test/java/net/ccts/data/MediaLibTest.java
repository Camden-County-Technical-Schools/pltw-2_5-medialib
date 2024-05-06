package net.ccts.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MediaLibTest {

    @Test
    public void testsetBook() {
        MediaLib lib = new MediaLib();
        Book b1 = new Book("title1", "author1");
        Book b2 = new Book("title2", "author2");
        lib.setBook(0, b1);
        lib.setBook(1, b2);
        assertEquals(b1.getTitle(), lib.fetchBook(0).getTitle());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testsetBookException1() {
        MediaLib lib = new MediaLib();
        Book b1 = new Book("title1", "author1");
        lib.setBook(-1, b1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testsetBookException99() {
        MediaLib lib = new MediaLib();
        Book b1 = new Book("title1", "author1");
        lib.setBook(99, b1);
    }

    @Test
    public void testsetAlbum() {
        MediaLib lib = new MediaLib();
        Album a1 = new Album("name1", "artist1");
        Album a2 = new Album("name2", "artist2");
        lib.setAlbum(0, a1);
        lib.setAlbum(1, a2);
        assertEquals(a2.getArtist(), lib.fetchAlbum(1).getArtist());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testsetAlbumException1() {
        MediaLib lib = new MediaLib();
        Album a1 = new Album("name1", "artist1");
        lib.setAlbum(-1, a1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testsetAlbumException99() {
        MediaLib lib = new MediaLib();
        Album a1 = new Album("name1", "artist1");
        lib.setAlbum(99, a1);
    }

    @Test
    public void testremoveBook() {
        MediaLib lib = new MediaLib();
        Book b1 = new Book("title1", "author1");
        Book b2 = new Book("title2", "author2");
        lib.setBook(0, b1);
        lib.setBook(1, b2);

        Book removed = lib.removeBook(1);
        assertEquals(b2.getTitle(), removed.getTitle());
        assertNull(lib.fetchBook(1));
    }

    @Test
    public void testRemoveAlbum() {
        MediaLib lib = new MediaLib();
        Album a1 = new Album("name1", "artist1");
        Album a2 = new Album("name2", "artist2");
        lib.setAlbum(0, a1);
        lib.setAlbum(1, a2);

        Album removed = lib.removeAlbum(1);
        assertEquals(a2.getArtist(), removed.getArtist());
        assertNull(lib.fetchAlbum(1));
    }
}