package net.ccts.data;

/*
 * Activity 2.5.7
 *
 * A books class for the MediaLibrary program
 */
public class Book extends Media {
  private String author;
  private int rating;
  
  /*** Constructor ****/
  
  public Book(String t, String a)
  {
    super.setTitle(t);
    author = a;
    rating = 0;
  }
  
   /*** Accessor methods ***/

  public String getAuthor() {
    return author;
  }
  
  public int getRating() {
    return rating;
  }
  
  @Override
  public String toString() 
  {
    String info = "\"" + super.getTitle() + "\", written by " + author;
    if (rating != 0) 
    { 
      info += ", rating is " + rating;
    }
    return info;
  }

  /*** Mutator methods ***/
  @Override
  public void setTitle(String t) {
    super.setTitle(t);
  }

  public void setAuthor(String a) {
    author = a;
  }

  public void adjustRating(int r) {

    if (r >= 0 && r <= 10) this.rating += r;
   
  }

  public boolean equals(Book b) {

    return super.getTitle().equals(b.getTitle()) && this.author.equals(b.author);
  }
}
