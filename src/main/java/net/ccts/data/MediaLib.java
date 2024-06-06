package net.ccts.data;
import java.util.ArrayList;

/**
 * Activity 2.5.7
 * 
 * A MediaLib class for the MediaLibrary program
 */
public class MediaLib
{

  private ArrayList<Book> books = new ArrayList<Book>(10);
  private ArrayList<Album> albums = new ArrayList<Album>(50);

  public Book fetchBook(int index) {
    if(index < 0 || index >= books.size()) {
      throw new IllegalArgumentException("Index" + index + "is out of bounds.");
    }
    return this.books.get(index);
  }

    public Album fetchAlbum(int index) {
    if(index < 0 || index >= albums.size()) {
      throw new IllegalArgumentException("Index" + index + "is out of bounds");
    }
    return this.albums.get(index);
  }

  public void setBook(int index, Book b) {
    if(index < 0 || index >= books.size()) {
      throw new IllegalArgumentException("Index" + index + "is out of bounds");
    }
    this.books.set(index, b);
  } 

  public void setAlbum(int index, Album a) {
    if(index < 0 || index >= albums.size()) {
      throw new IllegalArgumentException("Index" + index + "is out of bounds");
    }
    this.albums.set(index, a);
  } 

  public Book removeBook(int index) {
    if(index < 0 || index >= books.size()) {
      throw new IllegalArgumentException("Index" + index + "is out of bounds");
    }
    Book tmp = this.books.get(index);
    this.books.set(index, null);
    return tmp;
  }

  public Album removeAlbum(int index) {
    if(index < 0 || index >= albums.size()) {
      throw new IllegalArgumentException("Index" + index + "is out of bounds");
    }
    Album tmp = this.albums.get(index);
    this.albums.set(index, null);
    return tmp;
  }


  public String toString() 
  {
    String info = "";
    
    return info;
  }

  public ArrayList<Media> fetchAllMedia() {
    ArrayList<Media> nonnull = new ArrayList<Media>();

    for (Book b : books) {
      if (b != null)
        nonnull.add(b);
    }

    for (Album a : albums) {
      if (a != null)
        nonnull.add(a);
    }

    return nonnull;
  }

  public void addBook(Book b) {
    this.books.add(b);
  }

  public void addAlbum(Album a) {
    this.albums.add(a);
  }
}