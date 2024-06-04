package net.ccts.data;

import java.util.ArrayList;


/**
 * Activity 2.5.7
 * 
 * A MediaLib class for the MediaLibrary program
 */
public class MediaLib{

  public static ArrayList<Book> books = new ArrayList<>(10);
  public static ArrayList<Album> albums = new ArrayList<>(50);

  public Book fetchBook(int index){
    if (index < 0 || index >= books.size()){
      throw new IllegalArgumentException("index is out of bounds");
    }
    return books.get(index);    
  }
    

  public Album fetchAlbum(int index){
    if (index < 0 || index >= albums.size()){
      throw new IllegalArgumentException("index is out of bounds");
    }
    return albums.get(index);
  }
  

  public void setBook(int index, Book b){
    if (index < 0 || index >= books.size()){
      throw new IllegalArgumentException("Index is out of bound");
    }
    books.set(index, b);
  }

  public void setAlbum(int index, Album a){
    if (index < 0 || index >= albums.size() ){
      throw new IllegalArgumentException("Index is out of bound");
    }
    albums.set(index, a);
  }

  public Book removeBook(int index){
    if (index < 0 || index >= books.size() ){
      throw new IllegalArgumentException("Index is out of bound");
    }
    return books.remove(index);
  }

   public Album removeAlbum(int index){
    if (index < 0 || index >= albums.size() ){
      throw new IllegalArgumentException("Index is out of bound");
    }
    return albums.remove(index);
  }

  public String toString() 
  {
    String info = "";
    
    return info;
  }

  public static ArrayList<Media> fetchAllMedia(){
    ArrayList<Media> allMedia = new ArrayList<>();
    
    for (Book b : books){
      if(b != null){
        allMedia.add(b);
      }
    }

    for (Album a : albums){
      if(a != null){
        allMedia.add(a);
      }
    }

    return allMedia;
    
  }

  public void addBook(Book b){
    books.add(b);
  }

  public void addAlbum(Album a){
    albums.add(a);
  }
}