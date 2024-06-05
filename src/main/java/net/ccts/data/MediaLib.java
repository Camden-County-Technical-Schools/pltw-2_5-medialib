package net.ccts.data;
import java.util.ArrayList;

/**
 * Activity 2.5.7
 * 
 * A MediaLib class for the MediaLibrary program.
 * This class manages a collection of books and albums, providing methods to add, fetch, and remove media items.
 */
public class MediaLib {
  private ArrayList<Book> books = new ArrayList<>(10);
  private ArrayList<Album> albums = new ArrayList<>(50);

  public MediaLib() {
    // Initialize the ArrayLists with the specified initial capacity
    books = new ArrayList<>(10);
    albums = new ArrayList<>(50);
  }

  /**
   * Fetch a book at the specified index.
   * 
   * @param index The index of the book to fetch.
   * @return The book at the specified index.
   */
  public Book fetchBook(int index) {
    if (index < 0 || index >= books.size()) {
      throw new IllegalArgumentException("Index is out of bounds");
    }
    return books.get(index);
  }

  /**
   * Fetch an album at the specified index.
   * 
   * @param index The index of the album to fetch.
   * @return The album at the specified index.
   */
  public Album fetchAlbum(int index) {
    if (index < 0 || index >= albums.size()) {
      throw new IllegalArgumentException("Index is out of bounds");
    }
    return albums.get(index);
  }

  /**
   * Set a book at the specified index.
   * 
   * @param index The index to set the book at.
   * @param b     The book to set.
   */
  public void setBook(int index, Book b) {
    if (index < 0 || index >= books.size()) {
      throw new IllegalArgumentException("Index is out of bounds");
    }
    books.set(index, b);
  }

  /**
   * Set an album at the specified index.
   * 
   * @param index The index to set the album at.
   * @param a     The album to set.
   */
  public void setAlbum(int index, Album a) {
    if (index < 0 || index >= albums.size()) {
      throw new IllegalArgumentException("Index is out of bounds");
    }
    albums.set(index, a);
  }

  /**
   * Remove a book at the specified index.
   * 
   * @param index The index of the book to remove.
   * @return The removed book.
   */
  public Book removeBook(int index) {
    if (index < 0 || index >= books.size()) {
      throw new IllegalArgumentException("Index is out of bounds");
    }
    return books.remove(index);
  }

  /**
   * Remove an album at the specified index.
   * 
   * @param index The index of the album to remove.
   * @return The removed album.
   */
  public Album removeAlbum(int index) {
    if (index < 0 || index >= albums.size()) {
      throw new IllegalArgumentException("Index is out of bounds");
    }
    return albums.remove(index);
  }

  /**
   * Fetch all media items (books and albums).
   * 
   * @return An ArrayList containing all non-null books and albums.
   */
  public ArrayList<Media> fetchAllMedia() {
    ArrayList<Media> allMedia = new ArrayList<>();
    allMedia.addAll(books);
    allMedia.addAll(albums);
    return allMedia;
  }

  /**
   * Add a book to the collection.
   * 
   * @param b The book to add.
   */
  public void addBook(Book b) {
    books.add(b);
  }

  /**
   * Add an album to the collection.
   * 
   * @param a The album to add.
   */
  public void addAlbum(Album a) {
    albums.add(a);
  }

  @Override
  public String toString() {
    String info = "";
    for (Book book : books) {
      info += book.toString() + "\n";
    }
    for (Album album : albums) {
      info += album.toString() + "\n";
    }
    return info;
  }
}