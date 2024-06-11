package net.ccts.core;

import net.ccts.api.RestApiApplication;
import net.ccts.data.*;
import org.restlet.Component;
import org.restlet.Server;
import org.restlet.data.Protocol;

/*
 * Activity 2.5.7
 * 
 * The runner for the MediaLibrary program
 */
public class MediaLibRunner
{
  public static void main(String[] args) throws Exception {
    Component c = new Component();
    c.getClients().add(Protocol.FILE);
    Server server = c.getServers().add(Protocol.HTTP, 8080);

    server.getContext().getParameters().add("useForwardedForHeader", "true");
    c.getDefaultHost().attach(new RestApiApplication());
    c.start();


//    MediaLib myLib = new MediaLib();
//    MediaLib myLib2 = new MediaLib();
//    Book newbooks = new Book("9780060173227", "To Kill a Mockingbird", "Lee");
//    Book mybooks = new Book("9788845270741", "The Lord of the Rings", "Tolkien");
//
//    int myRating = 2;
//
//    System.out.println("Welcome to your Media Library");
//    System.out.println("books created " + mybooks);
//
//    // myLib.addbooks(mybooks);
//    mybooks.adjustRating(myRating);
//
//    System.out.println("MyRating: " + myRating);
//
//    mybooks.setTitle("Harry Potter");
//    // myLib2.addbooks(newbooks);
//
//    System.out.println("books: " + mybooks);
//    mybooks.adjustRating(1);
//    System.out.println("Library: \n" + myLib);
//
//    /*
//    System.out.println("You have a NEW Library");
//    System.out.println(myLib2);
//
//    newbooks = new books("1984", "Orwell");
//    System.out.println(myLib2); // will still say "To Kill a Mockingbird"
//    */
//
//    // System.out.println("Before Test: " + newbooks); // 1984
//    // myLib.testbooks(newbooks);
//    // System.out.println("Post Test: " + newbooks); // Hidden Pictures
//
//    Book a = newbooks;
//    System.out.println(newbooks.equals(a));
//
//    // System.out.println(a.title); // shows an error because title is a private field
   
  }
}