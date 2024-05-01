package net.ccts.core;

import net.ccts.data.Book;
import net.ccts.data.MediaLib;

/*
 * Activity 2.5.7
 * 
 * The runner for the MediaLibrary program
 */
public class MediaLibRunner
{
  public static void main(String[] args)
  {
    
    MediaLib myLib = new MediaLib();
    MediaLib myLib2 = new MediaLib();
    Book newBook = new Book("To Kill a Mockingbird", "Lee");
    Book myBook = new Book("The Lord of the Rings", "Tolkien");

    int myRating = 2;

    System.out.println("Welcome to your Media Library");
    System.out.println("Book created " + myBook);
  
    myLib.addBook(myBook);
    myBook.adjustRating(myRating);
   
    System.out.println("MyRating: " + myRating);
    
    myBook.setTitle("Harry Potter");
    myLib2.addBook(newBook);

    System.out.println("Book: " + myBook); 
    myBook.adjustRating(1);
    System.out.println("Library: \n" + myLib);

    /* 
    System.out.println("You have a NEW Library");
    System.out.println(myLib2);
  
    newBook = new Book("1984", "Orwell");
    System.out.println(myLib2); // will still say "To Kill a Mockingbird"
    */

    // System.out.println("Before Test: " + newBook); // 1984
    // myLib.testBook(newBook);
    // System.out.println("Post Test: " + newBook); // Hidden Pictures
    
    Book a = newBook;
    System.out.println(newBook.equals(a));

    // System.out.println(a.title); // shows an error because title is a private field
   
  }
}