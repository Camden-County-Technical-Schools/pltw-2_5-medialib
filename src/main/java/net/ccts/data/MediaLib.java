package net.ccts.data;

import java.util.ArrayList;

/**
 * Activity 2.5.7
 * 
 * manages a collection of books and albums.
 */
public class MediaLib {

  private ArrayList<Book> books = new ArrayList<>(10);
  private ArrayList<Album> albums = new ArrayList<>(50);

  /**
   * Fetches the book at the specified index.
   * 
   * @param index an int index of the book to fetch
   * @return the book at the specified index
   * @throws IllegalArgumentException if the index is out of bounds
   */
  public Book fetchBook(int index) {
    if (index < 0 || index >= books.size()) {
      throw new IllegalArgumentException("Index is out of bounds");
    }
    return books.get(index);
  }

  /**
   * Fetches the album at the specified index.
   * 
   * @param index an int index of the album to fetch
   * @return the album at the specified index
   * @throws IllegalArgumentException if the index is out of bounds
   */
public Album fetchAlbum(int index) {
    if (index < 0 || index >= albums.size()) {
      throw new IllegalArgumentException("Index is out of bounds.");
    }
    return albums.get(index);
  }

  /**
   * Sets the book at the specified index.
   * 
   * @param index an int index where the book will be set
   * @param b the book to set at the specified index
   * @throws IllegalArgumentException if the index is out of bounds
   */
  public void setBook(int index, Book b) {
    if (index < 0 || index >= books.size()) {
      throw new IllegalArgumentException("Index is out of bounds.");
    }
    books.set(index, b);
  }

  /**
   * Sets the album at the specified index.
   * 
   * @param index an int index where the album will be set
   * @param a the album to set at the specified index
   * @throws IllegalArgumentException if the index is out of bounds
   */
  public void setAlbum(int index, Album a) {
    if (index < 0 || index >= albums.size()) {
      throw new IllegalArgumentException("Index is out of bounds.");
    }
    albums.set(index, a);
  }

  /**
   * Removes the book at the specified index.
   * 
   * @param index an int index of the book to remove
   * @return the removed book
   * @throws IllegalArgumentException if the index is out of bounds
   */
  public Book removeBook(int index) {
      if (index < 0 || index >= books.size()) {
        throw new IllegalArgumentException("Index is out of bounds.");
      }
      return books.remove(index);
  }

  /**
   * Removes the album at the specified index.
   * 
   * @param index = int index of the album to get rid of 
   * @return the removed album
   * @throws IllegalArgumentException if ind isnt in bounds 
   */
  public Album removeAlbum(int index) {
    if (index < 0 || index >= albums.size()) {
      throw new IllegalArgumentException("Index is out of bounds.");
    }
    return albums.remove(index);
  }

  /**
   * Fetches all non-null media items from books and albums lists.
   * 
   * @return a combined ArrayList of non-null books and albums
   */
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

  /**
   * Adds a book to the MediaLib's book list.
   * 
   * @param b the book to add
   */
  public void addBook(Book b) {
    books.add(b);
  }

  /**
   * Adds an album to the MediaLib's album list.
   * 
   * @param a the album to add
   */
  public void addAlbum(Album a) {
    albums.add(a);
  }

  @Override
  public String toString() {
  return "MediaLib{" +
    "books=" + books +
    ", albums=" + albums +
    '}';
  }
}
