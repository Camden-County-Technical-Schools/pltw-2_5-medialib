package net.ccts.data;

/*
 * Activity 2.5.7
 *
 * A Book class for the MediaLibrary program
 */
public class Book extends Media {

    private String title;
    private String author;
    private int rating;

    /*** Constructor ***/
    public Book(String t, String a, String id) {
        super(id, t); // Call to superclass constructor (Media class)
        this.title = t; // Initialize instance variable title
        this.author = a; // Initialize instance variable author
        this.rating = 0; // Initialize instance variable rating
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

    public String toString() {
        String info = "\"" + title + "\", written by " + author;
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
}
