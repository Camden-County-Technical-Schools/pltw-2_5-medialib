package net.ccts.data;

/**
 * Activity 2.5.7
 * 
 * A MediaLib class for the MediaLibrary program
 */
public class MediaLib{

  private Book[] books = new Book[10];
  private Album[] albums = new Album[50];

  public Book fetchBook(int index){
    if (index < 0 || index >= books.length){
      throw new IllegalArgumentException("index is out of bounds");
    }
    return books[index];    
  }
    

  public Album fetchAlbum(int index){
    if (index < 0 || index >= albums.length){
      throw new IllegalArgumentException("index is out of bounds");
    }
    return albums[index];
  }
  

  public void setBook(int index, Book b){
    if (index < 0 || index >= books.length){
      throw new IllegalArgumentException("Index is out of bound");
    }
    this.books[index] = b;
  }

  public void setAlbum(int index, Album a){
    if (index < 0 || index >= albums.length ){
      throw new IllegalArgumentException("Index is out of bound");
    }
    this.albums[index] = a;
  }

  public Book removeBook(int index){
    if (index < 0 || index >= books.length ){
      throw new IllegalArgumentException("Index is out of bound");
    }
    Book temp = this.books[index];
    this.books[index] = null;
    return temp;
  }

   public Album removeAlbum(int index){
    if (index < 0 || index >= albums.length ){
      throw new IllegalArgumentException("Index is out of bound");
    }
    Album temp = this.albums[index];
    this.albums[index] = null;
    
    return temp;
  }

  public String toString() 
  {
    String info = "";
    
    return info;
  }
}