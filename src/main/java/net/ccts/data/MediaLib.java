package net.ccts.data;

import java.util.ArrayList;

/**
 * The MediaLib class manages a collection of books and albums.
 * It allows fetching, adding, setting, and removing books and albums.
 * Additionally, it can fetch all non-null media items in a single list.
 */
public class MediaLib {

  private ArrayList<Book> books;
  private ArrayList<Album> albums;

  public MediaLib() {
    books = new ArrayList<Book>(10);
    albums = new ArrayList<Album>(50);
    // Initializing the lists with null elements to match the initial array sizes
    
  }

  public Book fetchBook(int index) {
    if (index < 0 || index >= books.size()) {
      throw new IllegalArgumentException("Index is out of bounds");
    }
    return books.get(index);
  }

  public Album fetchAlbum(int index) {
    if (index < 0 || index >= albums.size()) {
      throw new IllegalArgumentException("Index is out of bounds");
    }
    return albums.get(index);
  }

  public void setBook(int index, Book b) {
    if (index < 0 || index >= books.size()) {
      throw new IllegalArgumentException("Index is out of bounds");
    }
    books.set(index, b);
  }

  public void setAlbum(int index, Album a) {
    if (index < 0 || index >= albums.size()) {
      throw new IllegalArgumentException("Index is out of bounds");
    }
    albums.set(index, a);
  }

  public Book removeBook(int index) {
    if (index < 0 || index >= books.size()) {
      throw new IllegalArgumentException("Index is out of bounds");
    }
    return books.remove(index);
  }

  public Album removeAlbum(int index) {
    if (index < 0 || index >= albums.size()) {
      throw new IllegalArgumentException("Index is out of bounds");
    }
    return albums.remove(index);
  }

  public ArrayList<Media> fetchAllMedia() {
    ArrayList<Media> allMedia = new ArrayList<Media>();
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

  public void addBook(Book b) {
    books.add(b);
  }

  public void addAlbum(Album a) {
    albums.add(a);
  }

  @Override
  public String toString() {
    StringBuilder info = new StringBuilder();
    info.append("Books:\n");
    for (Book book : books) {
      if (book != null) {
        info.append(book.toString()).append("\n");
      }
    }
    info.append("Albums:\n");
    for (Album album : albums) {
      if (album != null) {
        info.append(album.toString()).append("\n");
      }
    }
    return info.toString();
  }
}