package net.ccts.data;
import java.util.ArrayList;
/**
 * Activity 2.5.7
 * 
 * A MediaLib class for the MediaLibrary program
 */
public class MediaLib {

    private ArrayList<Book> books = new ArrayList<>(10);
    private ArrayList<Album> albums = new ArrayList<>(50);

    public Book fetchBook(int index) {
        if (index < 0 || index >= books.size()) {
            throw new IllegalArgumentException("Index is out of bounds");
        }
        return this.books.get(index);
    }

    public Album fetchAlbum(int index) {
        if (index < 0 || index >= albums.size()) {
            throw new IllegalArgumentException("Index is out of bounds");
        }
        return this.albums.get(index);
    }

    public void setBook(int index, Book b) {
        if (index < 0 || index >= books.size()) {
            throw new IllegalArgumentException("Index is out of bounds");
        }
        this.books.set(index, b);
    }

    public void setAlbum(int index, Album a) {
        if (index < 0 || index >= albums.size()) {
            throw new IllegalArgumentException("Index is out of bounds");
        }
        this.albums.set(index, a);
    }

    public Book removeBook(int index) {
        if (index < 0 || index >= books.size()) {
            throw new IllegalArgumentException("Index is out of bounds");
        }
        return this.books.remove(index);
    }

    public Album removeAlbum(int index) {
        if (index < 0 || index >= albums.size()) {
            throw new IllegalArgumentException("Index is out of bounds");
        }
        return this.albums.remove(index);
    }
    public ArrayList<Media> fetchAllMedia() {
        ArrayList<Media> allMedia = new ArrayList<>();
        allMedia.addAll(books);
        allMedia.addAll(albums);
        return allMedia;
    }
public void addBook(Book b) {
    this.books.add(b);
}

public void addAlbum(Album a) {
    this.albums.add(a);
}

    public String toString() {
        String info = "";

        return info;
    }
}
