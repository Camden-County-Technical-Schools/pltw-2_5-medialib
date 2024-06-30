package net.ccts.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity 2.5.7
 *
 * A MediaLib class for the MediaLibrary program
 */
public class MediaLib
{
    private ArrayList<Book> books = new ArrayList<Book>(10);
    private ArrayList<Album> albums = new ArrayList<Album>(50);

    public void addBook(Book b) {
        this.books.add(b);
    }

    public void addAlbum(Album a) {
        this.albums.add(a);
    }

    public Book fetchBook(int index) {
        if (index < 0 || index >= books.size()) {
            throw new IllegalArgumentException("Books index is out of bounds: " + index);
        }
        return books.get(index);
    }

    public Album fetchAlbum(int index) {
        if (index < 0 || index >= albums.size()) {
            throw new IllegalArgumentException("Album index is out of bounds: " + index);
        }
        return albums.get(index);
    }

    public void setBook(int index, Book b) {
        if (index < 0 || index >= books.size()) {
            throw new IllegalArgumentException("Books index is out of bounds: " + index);
        }
        books.set(index, b);
    }

    public void setAlbum(int index, Album a) {
        if (index < 0 || index >= albums.size()) {
            throw new IllegalArgumentException("Album index is out of bounds: " + index);
        }
        albums.set(index, a);
    }

    public Book removeBook(int index) {
        if (index < 0 || index >= books.size()) {
            throw new IllegalArgumentException("Books index is out of bounds: " + index);
        }
        return books.remove(index);
    }


    public Album removeAlbum(int index) {
        if (index < 0 || index >= albums.size()) {
            throw new IllegalArgumentException("Album index is out of bounds: " + index);
        }

        return albums.remove(index);
    }

    public List<Media> fetchAllMedia() {
        ArrayList<Media> allMedia = new ArrayList<>(this.books);
        allMedia.addAll(this.albums);
        return allMedia;
    }

    public int getNumberAlbums() {
        return this.albums.size();
    }

    public int getNumberBooks() {
        return this.books.size();
    }
}