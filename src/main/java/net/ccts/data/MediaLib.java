package net.ccts.data;

import java.util.ArrayList;
/**
 * Activity 2.5.7
 * 
 * A MediaLib class for the MediaLibrary program
 */

/**
 * The MediaLib class represents a media library that stores and manages a collection
 * of books and albums. It provides methods to add, fetch, remove, and retrieve all media items.
 */
public class MediaLib {

    private ArrayList<Book> books;
    private ArrayList<Album> albums;

    public MediaLib() {
        books = new ArrayList<>(10);
        albums = new ArrayList<>(50);
    }

    public Book fetchBook(int index) {
        if (index < 0 || index >= books.size()){
            throw new IllegalArgumentException("The index (" + index + ") is out of bounds.");
        }
        return this.books.get(index);
    }

    public Album fetchAlbum(int index) {
        if (index < 0 || index >= albums.size()){
            throw new IllegalArgumentException("The index (" + index + ") is out of bounds.");
        }
        return this.albums.get(index);
    }

    public void setBook(int index, Book b){
        if (index < 0 || index >= books.size()){
            throw new IllegalArgumentException("The index (" + index + ") is out of bounds.");
        }
        this.books.set(index, b);
    }

    public void setAlbum(int index, Album a){
        if (index < 0 || index >= albums.size()){
            throw new IllegalArgumentException("The index (" + index + ") is out of bounds.");
        }
        this.albums.set(index, a);
    }

    public Book removeBook(int index){
        if (index < 0 || index >= books.size()){
            throw new IllegalArgumentException("The index (" + index + ") is out of bounds.");
        }
        return this.books.remove(index);
    }

    public Album removeAlbum(int index){
        if (index < 0 || index >= albums.size()){
            throw new IllegalArgumentException("The index (" + index + ") is out of bounds.");
        }
        return this.albums.remove(index);
    }

    public void addBook(Book b) {
        this.books.add(b);
    }

    public void addAlbum(Album a) {
        this.albums.add(a);
    }

    public ArrayList<Media> fetchAllMedia() {
        ArrayList<Media> allMedia = new ArrayList<>();
        for (Book book : books) {
            if (book != null) {
                allMedia.add(book);
            }
        }
        for (Album album : albums) {
            if (album != null) {
                allMedia.add(album);
            }
        }
        return allMedia;
    }

    @Override
    public String toString() {
        String info = "";
        return info;
    }
}
