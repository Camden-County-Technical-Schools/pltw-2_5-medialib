package net.ccts.data;

/**
 * Activity 2.5.7
 * 
 * A MediaLib class for the MediaLibrary program
 */
public class MediaLib
{
  private Book[] books = new Book[10];
  private Album[] albums = new Album[50];
 
// accessor methods 
  /**
   * retrieves a stored book in an array at a provided index
   * @return this.books[index] - returning the book from this specific book array
   * @param index - locations of desired change
   */
  public Book fetchBook(int index) {
    if (index < 0 || index >= this.books.length) throw new IllegalArgumentException("Index out of bounds.");
    return this.books[index];
  }

  /**
   * retrieves a stored album in an array at a provided index
   * @return this.albums[index] - returning the album from this specific album array
   * @param index - location of desired change
   */
  public Album fetchAlbum(int index) {
    if (index < 0 || index >= this.albums.length) throw new IllegalArgumentException("Index out of bounds.");
    return this.albums[index];
  }

  // mutator methods

  /**
   * change the book value saved at index and changing it to the value saved at b
   * @param index - the location of the desired change
   * @param b - a book object containing a title and author
   */
  public void setBook(int index, Book b) {
    if (index >= 0 && index < this.books.length) this.books[index] = b;
    else throw new IllegalArgumentException("Index out of bounds.");
  }

  /**
   * change the album value saved at index and changing it to the value saved at a
   * @param index - the location of the desired change
   * @param a - an album object containing a name and artist
   */
  public void setAlbum(int index, Album a) {
    if (index >= 0 && index < this.albums.length) this.albums[index] = a;
    else throw new IllegalArgumentException("Index out of bounds.");
  }

  public Book removeBook(int index) {
    Book temp;
    if (index >= 0 && index < this.books.length) {
      temp = this.books[index]; 
      this.books[index] = null;
    }
    else throw new IllegalArgumentException("Index out of bounds.");
    return temp;

  }

  public Album removeAlbum(int index) {
    Album temp;
    if (index >= 0 && index <= this.albums.length) {
      temp = this.albums[index]; 
      this.albums[index] = null;
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