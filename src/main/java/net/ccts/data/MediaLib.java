package net.ccts.data;

/**
 * Activity 2.5.7
 * 
 * A MediaLib class for the MediaLibrary program
 */
public class MediaLib
{
  private Book[] books = new Book[10];
  private Album[] album = new Album[50];

  public Book fetchBook(int index) {
    if (index < 0 || index >= books.length) {
      throw new IllegalArgumentException(" Books index is out of bounds.");
    }
    return books[index];
  }

  public Album fetchAlbum(int index) {
    if (index < 0 || index >= album.length) {
      throw new IllegalArgumentException(" Album index is out of bounds.");
    }
    return album[index];
  }

   public void setBook(int index, Book b) {
    if (index < 0 || index >= books.length) {
      throw new IllegalArgumentException(" Books index is out of bounds.");
    }
    books[index] = b; 
   }
 
   public void setAlbum(int index, Album a) {
   if (index < 0 || index >= album.length) {
      throw new IllegalArgumentException(" Album index is out of bounds.");
    }
    album[index] = a; 
   }

  public Book removeBook(int index) { 
    if (index < 0 || index >= books.length) {
      throw new IllegalArgumentException(" Books index is out of bounds.");
    }

    Book removedBook = books[index];
    books[index] = null;
    return removedBook;
  }

  
  public Album removeAlbum(int index) { 
    if (index < 0 || index >= album.length) {
      throw new IllegalArgumentException(" Album index is out of bounds.");
    }

    Album removedAlbum = album[index];
    album[index] = null;
    return removedAlbum;

  }
 
  /** public void addBook(Book b)
  {
    book = b;
  }
  */

  public String toString() 
  {
    String info = "";
    
    return info;
  }
}