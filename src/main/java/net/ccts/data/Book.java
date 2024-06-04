package net.ccts.data;

import javax.xml.crypto.Data;

/*
 * Activity 2.5.7
 *
 * A Book class for the MediaLibrary program
 */
public class Book extends Media {
  private String author;
  private int rating;
  
  /*** Constructor ****/
  public Book(String id, String t, String a)
  {
    super(id, t);
    this.author = a;
  }
  
   /*** Accessor methods ***/
  public String getTitle() {
    return super.getTitle();
  }

  public String getAuthor() {
    return author;
  }
  
  public int getRating() {
    return rating;
  }
  
  public String toString() 
  {
    String info = "\"" + super.getTitle() + "\", written by " + author;
    info += ", ISBN: " + super.getId();
    if (rating != 0) {
      info += ", rating is " + rating;
    }
    return info;
  }

  /*** Mutator methods ***/
  public void setTitle(String t) {
    super.setTitle(t);
  }

  public void setAuthor(String a) {
    this.author = a;
  }

  public void setRating(int r) {
    this.rating = r;
  }

  @Override
  public int hashCode() {
    return this.getId().hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Book))
      return false;
    Book b = (Book) o;
    return b.hashCode() == this.hashCode();
  }
}
