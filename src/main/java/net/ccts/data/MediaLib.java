package net.ccts.data;
import java.util.ArrayList;

/**
 * Activity 2.5.7
 * 
 * A MediaLib class for the MediaLibrary program
 **/
public class MediaLib {
  
  private ArrayList<Book> books = new ArrayList<>(10);
  private ArrayList<Album> albums = new ArrayList<>(50);

  public MediaLib(){
    books = new ArrayList<>(10);
    albums = new ArrayList<>(50);
  }
  /** 
   * @param is the index that is used
   * @return returns the position of index in books
  **/
  public Book fetchBook(int index){
    if(index < 0 || index >= books.size()){
    throw new IllegalArgumentException("Index is out of bounds ");
    }
    return books.get(index);
  }

  public Album fetchAlbum(int index){
  if(index < 0 || index >= albums.size()){
    throw new IllegalArgumentException("Index is out of bounds ");
    }
  return albums.get(index);
  }  
  public ArrayList<Media> fetchAllMedia(){
    ArrayList<Media> allMedia = new ArrayList<>();
    for(Book b: books)  {
      if(b != null)
      allMedia.add(b);
    }
    for(Album a : albums){
      if (a !=null)
      allMedia.add(a);
    }
    return allMedia;
  }
   /** 
   * @param is the index that is used
   * @return returns the position of index in albums
  */
  
  public void setBook(int index, Book b){
    if(index < 0 || index > this.books.size()){
      throw new IllegalArgumentException("Index is out of bounds ");
    }
    this.books.set(index, b);
  }
   /** 
   * @param is the index that is used
   * @return returns the position of index in books
  */ 
  public void setAlbum (int index, Album a){
    if(index < 0 || index >= albums.size()){
        throw new IllegalArgumentException("Index is out of bounds ");
    }
    this.albums.set(index, a) ; 
  }
   /** 
   * @param is the index that is used
   * @return returns the position of index in albums
  */
  public Book removeBook(int index){
  if(index < 0 || index >= books.size()){
        throw new IllegalArgumentException("Index is out of bounds ");
    }
    return books.remove(index);
  }
   /** 
   * @param is the index that is used
   * @return returns the position of index in books
   * @tmp is used to temporaily hold the element in books at index
  */
  public Album removeAlbum(int index){
    if(index < 0 || index >= albums.size()){
        throw new IllegalArgumentException("Index is out of bounds ");
      }
     return albums.remove(index);
  }
 /** 
   * @param is the index that is used
   * @return returns the position of index in albums
   * @tmp is used to temporaily hold the element in albums at index
  */
  public String toString() 
  {
    String info = "";
    
    return info;
  }
  public void addBook(Book b){
    books.add(b);
  }
  public void addAlbum(Album a){
    albums.add(a);
  }


}