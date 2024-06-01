package net.ccts.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class MediaLibTest {

    @Test
    public void testAddBook() {
        MediaLib lib = new MediaLib();
        Book b1 = new Book("9781603095273", "title1", "author1");
        Book b2 = new Book("9781603095136", "title2", "author2");
        lib.addBook(b1);
        lib.addBook(b2);
        lib.setBook(0, b2);
        assertEquals(b2.getTitle(), lib.fetchBook(0).getTitle());
    }

    @Test
    public void testSetBook() {
        MediaLib lib = new MediaLib();
        Book b1 = new Book("9781603095273", "title1", "author1");
        Book b2 = new Book("9781603095136", "title2", "author2");
        lib.addBook(b1);
        lib.addBook(b2);
        lib.setBook(0, b2);
        assertEquals(b2.getTitle(), lib.fetchBook(0).getTitle());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetBookException1() {
        MediaLib lib = new MediaLib();
        Book b1 = new Book("9781603095273", "title1", "author1");
        lib.setBook(-1, b1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetBookException99() {
        MediaLib lib = new MediaLib();
        Book b1 = new Book("9781603095273", "title1", "author1");
        lib.setBook(99, b1);
    }

    @Test
    public void testSetAlbum() {
        MediaLib lib = new MediaLib();
        Album a1 = new Album("r27826851", "name1", "artist1");
        Album a2 = new Album("r27826852", "name2", "artist2");
        lib.addAlbum(a1);
        lib.addAlbum(a2);
        lib.setAlbum(0, a2);
        assertEquals(a2.getTitle(), lib.fetchAlbum(0).getTitle());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetAlbumException1() {
        MediaLib lib = new MediaLib();
        Album a1 = new Album("r27826851", "name1", "artist1");
        lib.setAlbum(-1, a1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetAlbumException99() {
        MediaLib lib = new MediaLib();
        Album a1 = new Album("r27826851", "name1", "artist1");
        lib.setAlbum(99, a1);
    }

    @Test
    public void testRemoveBook() {
        MediaLib lib = new MediaLib();
        Book b1 = new Book("9781603095273", "title1", "author1");
        Book b2 = new Book("9781603095136", "title2", "author2");
        lib.addBook(b1);
        lib.addBook(b2);

        Book removed = lib.removeBook(1);
        assertEquals(b2.getTitle(), removed.getTitle());
        assertNull(lib.fetchBook(1));
    }

    @Test
    public void testRemoveAlbum() {
        MediaLib lib = new MediaLib();
        Album a1 = new Album("r27826851", "name1", "artist1");
        Album a2 = new Album("r27826852", "name2", "artist2");
        lib.addAlbum(a1);
        lib.addAlbum(a2);

        Album removed = lib.removeAlbum(1);
        assertEquals(a2.getArtist(), removed.getArtist());
        assertNull(lib.fetchAlbum(1));
    }

    @Test
    public void testFetchAllMedia() {
        MediaLib lib = new MediaLib();
        Album a1 = new Album("r27826851", "name1", "artist1");
        Album a2 = new Album("r27826852", "name2", "artist2");
        Book b1 = new Book("9781603095273", "title1", "author1");
        Book b2 = new Book("9781603095136", "title2", "author2");

        lib.addBook(b1);
        lib.addBook(b2);
        lib.addAlbum(a1);
        lib.addAlbum(a2);

        List<Media> allMedia = lib.fetchAllMedia();
        assertEquals(allMedia.size(), 4);
    }

    @Test
    public void testFetchEmptyMedia() {
        MediaLib lib = new MediaLib();

        List<Media> allMedia = lib.fetchAllMedia();
        assertEquals(allMedia.size(), 0);
    }
}