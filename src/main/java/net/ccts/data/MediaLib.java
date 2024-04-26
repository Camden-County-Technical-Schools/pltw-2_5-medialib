package net.ccts.data;

/**
 * Activity 2.5.7
 * 
 * A MediaLib class for the MediaLibrary program
 */
public class MediaLib
{
  private Book book;

  public void addBook(Book b)
  {
    book = b;
  }

  public String toString() 
  {
    String info = "";
    
    if (book != null) info = book.toString();
    
    return info;
  }

  /* 
  public void testBook(Book tester) {
    tester.setTitle("Hidden Pictures");
    System.out.println("Book Title changed.");
  }
  */
}