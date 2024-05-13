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

public Book fetchBook(int index){
  if (index < 0 || index >= books.length){
    throw new IllegalArgumentException("index out of bounds");
  }
  return books[index];
}

public Album fetchAlbum(int index){
  if (index < 0 || index >= albums.length){
    throw new IllegalArgumentException("index out of bounds");
  }
  return albums[index];
}

public void setBook(int index, Book b){
  if (index < 0 || index >= books.length){
    throw new IllegalArgumentException("index out of bounds");
  }
  this.books[index] = b;
}

public void setAlbum(int index, Album b){
  if (index < 0 || index >= albums.length){
    throw new IllegalArgumentException("index out of bounds");
  }
  this.albums[index] = b;
}

public Book removeBook(int index){
  if (index < 0 || index >= books.length){
    throw new IllegalArgumentException("index out of bounds");
  }
  Book temp = books[index];
  books[index] = null;
  return temp;
}

public Album removeAlbum(int index){
  if (index < 0 || index >= albums.length){
    throw new IllegalArgumentException("index out of bounds");
  }
  Album temp = albums[index];
  albums[index] = null;
  return temp;
}


  public String toString() 
  {
    String info = "";
    
    return info;
  }
}