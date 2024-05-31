package net.ccts.data;

public class Book extends Media{
  private String title;
  private String author;
  private int rating;
  
  /*** Constructor ****/
  public Book(String title, String author, String id) {
    super(id, title);
    this.author = author;
    this.rating = 0;
  }
  
  public String getAuthor() {
    return author;
  }
  
  public int getRating() {
    return rating;
  }
  
  @Override
  public String toString() {
    String info = "\"" + getTitle() + "\", written by " + author;
    if (rating != 0) {
      info += ", rating is " + rating;
    }
    return info;
  }

  /*** Mutator methods ***/
  public void setTitle(String t) {
    title = t;
  }

  public void setAuthor(String a) {
    author = a;
  }

  
}
