package net.ccts.data;

import java.util.ArrayList;

/**
 * Represents a media library containing books and albums.
 */
public class MediaLib {
    private ArrayList<Book> books;
    private ArrayList<Album> albums;

    public MediaLib() {
        // Initialize ArrayLists with initial sizes
        books = new ArrayList<>(10);
        albums = new ArrayList<>(50);
    }

    public Book fetchBook(int index) {
        if (index < 0 || index >= books.size()) {
            throw new IllegalArgumentException("Book index is out of bounds.");
        }
        return books.get(index);
    }

    public Album fetchAlbum(int index) {
        if (index < 0 || index >= albums.size()) {
            throw new IllegalArgumentException("Album index is out of bounds.");
        }
        return albums.get(index);
    }

    public void setBook(int index, Book b) {
        if (index < 0 || index >= books.size()) {
            throw new IllegalArgumentException("Book index is out of bounds.");
        }
        books.set(index, b);
    }

    public void setAlbum(int index, Album a) {
        if (index < 0 || index >= albums.size()) {
            throw new IllegalArgumentException("Album index is out of bounds.");
        }
        albums.set(index, a);
    }

    public Book removeBook(int index) {
        if (index < 0 || index >= books.size()) {
            throw new IllegalArgumentException("Book index is out of bounds.");
        }
        return books.remove(index);
    }

    public Album removeAlbum(int index) {
        if (index < 0 || index >= albums.size()) {
            throw new IllegalArgumentException("Album index is out of bounds.");
        }
        return albums.remove(index);
    }

    public ArrayList<Media> fetchAllMedia() {
        ArrayList<Media> allMedia = new ArrayList<>();
        allMedia.addAll(books);
        allMedia.addAll(albums);
        return allMedia;
    }

    public void addBook(Book b) {
        books.add(b);
    }

    public void addAlbum(Album a) {
        albums.add(a);
    }
}
