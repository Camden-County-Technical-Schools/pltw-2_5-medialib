package net.ccts.data;

/**
 * Activity 2.5.7
 * 
 * A MediaLib class for the MediaLibrary program
 */
public class MediaLib {
  
private Book[] Books = new Book[10];

private Album[] Albums = new Album[50];

public Book fetchBook(int index) {
  if (index < 0 || index >= Books.length){
    throw new IllegalArgumentException("The index" + "(" + index + ")" + "is out of bounds.");
  }
  return this.Books[index];
}

public Album fetchAlbum(int index) {
    if (index < 0 || index >= Albums.length){
      throw new IllegalArgumentException("The index" + "(" + index + ")" + "is out of bounds.");
    }
    return this.Albums[index];
  }

public void setBook(int index, Book b){
  if (index < 0 || index >= Books.length){
      throw new IllegalArgumentException("The index" + "(" + index + ")" + "is out of bounds.");
    }
    this.Books[index] = b;
  }

public void setAlbum(int index, Album a){
 if (index < 0 || index >= Albums.length){
      throw new IllegalArgumentException("The index" + "(" + index + ")" + "is out of bounds.");
    }
    this.Albums[index] = a;
  }

public Book removeBook(int index){
 if (index < 0 || index >= Books.length){
      throw new IllegalArgumentException("The index" + "(" + index + ")" + "is out of bounds.");
    }
    Book top = this.Books[index];
    this.Books[index] = null;
    return top;
}

public Album removeAlbum(int index){
 if (index < 0 || index >= Albums.length){
      throw new IllegalArgumentException("The index" + "(" + index + ")" + "is out of bounds.");
    }
    Album top = this.Albums[index];
    this.Albums[index] = null;
    return top;
}
  public String toString() 
  {
    
    String info = "";
    
    return info;
  }
}
