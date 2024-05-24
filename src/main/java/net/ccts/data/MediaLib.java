package net.ccts.data;

import java.util.ArrayList;

/**
 * Activity 2.5.7
 * 
 * A MediaLib class for the MediaLibrary program
 */
public class MediaLib
{
  private ArrayList<Book> books = new ArrayList<>(10);
  private ArrayList<Album> albums = new ArrayList<>(50);
 
// accessor methods 
  /**
   * retrieves a stored book in an array at a provided index
   * @return this.books[index] - returning the book from this specific book array
   * @param index - locations of desired change
   */
  public Book fetchBook(int index) {
    if (index < 0 || index >= this.books.size()) throw new IllegalArgumentException("Index out of bounds.");
    return this.books.get(index);
  }

  /**
   * retrieves a stored album in an array at a provided index
   * @return this.albums[index] - returning the album from this specific album array
   * @param index - location of desired change
   */
  public Album fetchAlbum(int index) {
    if (index < 0 || index >= this.albums.size()) throw new IllegalArgumentException("Index out of bounds.");
    return this.albums.get(index);
  }

  /**
   * retrieve all media created that does not have a null value
   * @return allMedia - an ArrayList with Book and Album objects inside
   */
  public ArrayList<Media> fetchAllMedia() {
    ArrayList<Media> allMedia = new ArrayList<>();

    for (Book b : books) {
      if (b != null) allMedia.add(b);
    }

    for (Album a : albums) {
      if (a != null) allMedia.add(a);
    }

    return allMedia;
  }

  // mutator methods

  /**
   * change the book value saved at index and changing it to the value saved at b
   * @param index - the location of the desired change
   * @param b - a book object containing a title and author
   */
  public void setBook(int index, Book b) {
    if (index >= 0 && index < this.books.size()) this.books.set(index, b);
    else if (index == this.books.size()) this.books.add(b); 
    else throw new IllegalArgumentException("Index out of bounds.");
    
  }


  /**
   * change the album value saved at index and changing it to the value saved at a
   * @param index - the location of the desired change
   * @param a - an album object containing a name and artist
   */
  public void setAlbum(int index, Album a) {
    if (index >= 0 && index < this.albums.size()) this.albums.set(index, a);
    else if (index == this.albums.size()) this.albums.add(a); 
    else throw new IllegalArgumentException("Index out of bounds.");
  }
  
  /**
   * change the book at the index to ull and return old book value
   * @param index - location of desired change
   * @return temp - the name of the book before being set to null
   */
  public Book removeBook(int index) {
    Book temp;
    if (index >= 0 && index < this.books.size()) {
      temp = this.books.get(index); 
      this.books.set(index, null);
    }
    else throw new IllegalArgumentException("Index out of bounds.");
    return temp;

  }

  /**
   * change the album at the index to ull and return old album value
   * @param index - location of desired change
   * @return temp - the name of the album before being set to null
   */
  public Album removeAlbum(int index) {
    Album temp;
    if (index >= 0 && index < this.albums.size()) {
      temp = this.albums.get(index); 
      this.albums.set(index, null);
    } 
    else throw new IllegalArgumentException("Index out of bounds.");
    return temp;
  }

  @Override
  public String toString() 
  {
    String info = "";
    
    // if (books != null) info = books.toString();
    
    return info;
  }

  /* 
  public void testbooks(books tester) {
    tester.setTitle("Hidden Pictures");
    System.out.println("books Title changed.");
  }
  */
}