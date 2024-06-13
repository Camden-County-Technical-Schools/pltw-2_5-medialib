package net.ccts.data;

import java.util.ArrayList;

public class MediaLib {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Album> albums = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void setAlbum(int id, Album album) {
        if (id < 0 || id >= albums.size()) {
            throw new IllegalArgumentException("Index is out of bounds.");
        }
        albums.set(id, album);
    }

    public void setBook(int id, Book book){
        if (id < 0 || id >= books.size()) {
            throw new IllegalArgumentException("Index is out of bounds.");
        }
        books.set(id, book);
    }

    public Book fetchBook(int id) {
        if (id < 0 || id >= books.size()) {
            throw new IllegalArgumentException("Index is out of bounds.");
        }
        return books.get(id);
    }

    public Book removeBook(int id) {
        if (id < 0 || id >= books.size()) {
            throw new IllegalArgumentException("Index is out of bounds.");
        }
        return books.remove(id);
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    public Album fetchAlbum(int id) {
        if (id < 0 || id >= albums.size()) {
            throw new IllegalArgumentException("Index is out of bounds.");
        }
        return albums.get(id);
    }

    public Album removeAlbum(int id) {
        if (id < 0 || id >= albums.size()) {
            throw new IllegalArgumentException("Index is out of bounds.");
        }
        return albums.remove(id);
    }

    public ArrayList< Media > fetchAllMedia() {
        ArrayList<Media> allMedia = new ArrayList<>();
        allMedia.addAll(books);
        allMedia.addAll(albums);
        return allMedia;
    }
}
