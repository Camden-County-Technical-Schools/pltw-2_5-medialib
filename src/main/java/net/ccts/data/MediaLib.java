package net.ccts.data;

/**
 * Activity 2.5.7
 * 
 * A MediaLib class for the MediaLibrary program
 */
public class MediaLib {
  
  private ArrayList<Book> books = new Book[10];
  private ArrayList<Album> albums = new Album[50];

  /** 
   * @param is the index that is used
   * @return returns the position of index in books
  */
  public Book fetchBook(int index){
    if(index < 0 || index >= books.length){
    throw new IllegalArgumentException("Index is out of bounds ");
    }
    return books[index];
  }

  public Album fetchAlbum(int index){
  if(index < 0 || index >= albums.length){
    throw new IllegalArgumentException("Index is out of bounds ");
    }
  return albums[index];
  }  
  public media fetchMedia(int index){
    ArrayList<media> += ArrayList<Album> +ArrayList<Book>;
    return ArrayList<media>;
  }
   /** 
   * @param is the index that is used
   * @return returns the position of index in albums
  */
  
  public void setBook(int index, Book b){
    if(index < 0 || index >= books.length){
      throw new IllegalArgumentException("Index is out of bounds ");
    }
    this.books[index] = b;
  }
   /** 
   * @param is the index that is used
   * @return returns the position of index in books
  */ 
  public void setAlbum (int index, Album a){
    if(index < 0 || index >= albums.length){
        throw new IllegalArgumentException("Index is out of bounds ");
    }
    this.albums[index] = a; 
  }
   /** 
   * @param is the index that is used
   * @return returns the position of index in albums
  */
  public Book removeBook(int index){
  if(index < 0 || index >= books.length){
        throw new IllegalArgumentException("Index is out of bounds ");
    }
    Book tmp = this.books[index];
    this.books[index] = null;
    return tmp; 
  }
   /** 
   * @param is the index that is used
   * @return returns the position of index in books
   * @tmp is used to temporaily hold the element in books at index
  */
  public Album removeAlbum(int index){
    if(index < 0 || index >= albums.length){
        throw new IllegalArgumentException("Index is out of bounds ");
      }
      Album tmp = this.albums[index];
      this.albums[index] = null;
      return tmp;
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


}