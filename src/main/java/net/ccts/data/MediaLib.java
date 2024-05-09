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

  /**
   * @param books.length -> 0
   * @return return books[index]
   */
  public Book fetchBook(int index){
    if(index < 0 || index >= books.length){
      throw new IllegalArgumentException("Index is out of bounds");
    }
    return books[index];
  }


  /**
   * @param albums.length -> 0
   * @return return albums[index]
   */
  public Album fetchAlbum(int index){
    if(index < 0 || index >= albums.length){
      throw new IllegalArgumentException("Index is out of bounds");
    }
    return albums[index];
  }


  /**
   * @param books.length -> 0
   * @return this.books[index] = b
   */
  public void setBook(int index, Book b){
    if(index < 0 || index >= books.length){
      throw new IllegalArgumentException("Index is out of bounds");

    }
    this.books[index] = b;
  }


  /**
   * @param albums.length -> 0
   * @return this.albums[index] = a
   */
  public void setAlbum(int index, Album a){
    if(index < 0 || index >= albums.length){
      throw new IllegalArgumentException("Index is out of bounds");

    }
    this.albums[index] = a;
  }


  /**
   * @param this.books.length -> 0
   * @return return tmp
   */
  public Book removeBook(int index){
    if (index < 0 || index >= this.books.length){
      throw new IllegalArgumentException("index is out of bounds");
    }
    Book tmp = this.books[index];
    this.books[index] = null;
    return tmp;
  }


  /**
   * @param this.albums.length -> 0
   * @return return tmp
   */
  public Album removeAlbum(int index) { 
    if (index < 0 || index >= this.albums.length) {
      throw new IllegalArgumentException("Index is out of bounds");
    }
    Album tmp = this.albums[index];
    this.albums[index] = null;
    return tmp;
  }

/**
 * return info
 */
  public String toString() {
    String info = "";
    return info;
  }

}