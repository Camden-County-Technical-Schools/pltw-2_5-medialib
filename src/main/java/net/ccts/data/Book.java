package net.ccts.data;

/*
 Activity 2.5.7
 
 A Book class for the MediaLibrary program
 */
public class Book extends Media
{
  private String author;
  private int rating;

  // Constructor
  public Book(String id, String title, String author)
  {
    super(id, title);
    this.author = author;
    this.rating = 0;
  }

  // Accessor methods 
  @Override
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
    String info = "\"" + getTitle() + "\", written by " + author;
    if (rating != 0) 
    { 
      info += ", rating is " + rating;
    }
    return info;
  }

  // Mutator methods 
  @Override
  public void setTitle(String title) {
    super.setTitle(title);
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}
