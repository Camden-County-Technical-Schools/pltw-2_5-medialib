package net.ccts.data;

/*
 * Activity 2.5.7
 *
 * A Book class for the MediaLibrary program
 */
public class Book extends Media
{
  private String author;
  private int rating;
  
  /*** Constructor ****/
  public Book(String id, String t, String a)
  {
    super(id, t);
    author = a;
    rating = 0;
  }
  

  public String getAuthor() {
    return author;
  }
  
  public int getRating() {
    return rating;
  }
  
  public String toString() 
  {
    String info = "\"" + super.title + "\", written by " + author;
    if (rating != 0) 
    { 
      info += ", rating is " + rating;
    }
    return info;
  }

  public void setAuthor(String a) {
    author = a;
  }
}
