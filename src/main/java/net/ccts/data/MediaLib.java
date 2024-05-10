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

  public Book fetchbook(int index) {
    if(index < 0 || index >= books.length) {
      throw new IllegalArgumentException("Index" + index + "is out of bounds.");
    }
    return this.books[index];
  }

    public Album fetchAlbum(int index) {
    if(index < 0 || index >= albums.length) {
      throw new IllegalArgumentException("Index" + index + "is out of bounds");
    }
    return this.albums[index];
  }

  public void setBook(int index, Book b) {
    if(index < 0 || index >= books.length) {
      throw new IllegalArgumentException("Index" + index + "is out of bounds");
    }
    this.books[index] = b;
  } 

  public void setAlbum(int index, Album a) {
    if(index < 0 || index >= albums.length) {
      throw new IllegalArgumentException("Index" + index + "is out of bounds");
    }
    this.albums[index] = a;
  } 

  public Book removeBook(int index) {
    if(index < 0 || index >= books.length) {
      throw new IllegalArgumentException("Index" + index + "is out of bounds");
    }
    Book tmp = this.books[index];
    this.books[index] = null;
    return tmp;
  }

  public Album removeAlbum(int index) {
    if(index < 0 || index >= albums.length) {
      throw new IllegalArgumentException("Index" + index + "is out of bounds");
    }
    Album tmp = this.albums[index];
    this.albums[index] = null;
    return tmp;
  }


  public String toString() 
  {
    String info = "";
    
    return info;
  }
}