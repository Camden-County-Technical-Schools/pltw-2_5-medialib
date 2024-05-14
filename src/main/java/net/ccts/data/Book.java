package net.ccts.data;

/*
 * Activity 2.5.7
 *
 * A Book class for the MediaLibrary program
 */
public class Book
{
  private String isbn;
  private String title;
  private String author;
  private int rating;
  
  /*** Constructor ****/
  public Book(String t, String a, String i)
  {
    this.title = t;
    this.author = a;
    this.isbn = i;
  }
  
   /*** Accessor methods ***/
  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }
  
  public int getRating() {
    return rating;
  }
  
  public String toString() 
  {
    String info = "\"" + title + "\", written by " + author;
    info += ", ISBN: " + this.isbn;
    if (rating != 0) {
      info += ", rating is " + rating;
    }
    return info;
  }

  /*** Mutator methods ***/
  public void setTitle(String t) {
    this.title = t;
  }

  public void setAuthor(String a) {
    this.author = a;
  }

  public void setRating(int r) {
    this.rating = r;
  }

  public String getISBN() {
    return this.isbn;
  }

  public void setISBN(String i) {
    this.isbn = i;
  }

  @Override
  public int hashCode() {
    return this.isbn.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Book))
      return false;
    Book b = (Book) o;
    return b.hashCode() == this.hashCode();
  }
}
