package net.ccts.data;

/**
 * Activity 2.5.7
 *
 * A MediaLib class for the MediaLibrary program
 */
public class MediaLib
{
    private Book[] books = new Book[10];
    private Album[] albums = new Album[50];

    public Book fetchBook(int index) {
        if (index < 0 || index >= books.length) {
            throw new IllegalArgumentException("Books index is out of bounds: " + index);
        }
        return books[index];
    }

    public Album fetchAlbum(int index) {
        if (index < 0 || index >= albums.length) {
            throw new IllegalArgumentException("Album index is out of bounds: " + index);
        }
        return albums[index];
    }

    public void setBook(int index, Book b) {
        if (index < 0 || index >= books.length) {
            throw new IllegalArgumentException("Books index is out of bounds: " + index);
        }
        books[index] = b;
    }

    public void setAlbum(int index, Album a) {
        if (index < 0 || index >= albums.length) {
            throw new IllegalArgumentException("Album index is out of bounds: " + index);
        }
        albums[index] = a;
    }

    public Book removeBook(int index) {
        if (index < 0 || index >= books.length) {
            throw new IllegalArgumentException("Books index is out of bounds: " + index);
        }

        Book removedBook = books[index];
        books[index] = null;
        return removedBook;
    }


    public Album removeAlbum(int index) {
        if (index < 0 || index >= albums.length) {
            throw new IllegalArgumentException("Album index is out of bounds: " + index);
        }

        Album removedAlbum = albums[index];
        albums[index] = null;
        return removedAlbum;
    }

}