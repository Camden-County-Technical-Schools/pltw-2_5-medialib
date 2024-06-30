package net.ccts.biz;

import net.ccts.data.Album;
import net.ccts.data.Book;
import net.ccts.data.MediaLib;

public class MediaManager {
    private static final MediaLib mediaLib = new MediaLib();

    public static void addAlbum(Album album) {
        mediaLib.addAlbum(album);
    }

    public static void addBook(Book book) {
        mediaLib.addBook(book);
    }

    private static int findAlbumIndex(Album album) {
        return findAlbumIndex(album.getId());
    }

    private static int findAlbumIndex(String id) {
        int i = 0;
        int end = mediaLib.getNumberAlbums();
        while (i < end) {
            Album a = mediaLib.fetchAlbum(i);
            if (a != null && a.getId().equals(id)) {
                break;
            }
            i++;
        }
        if (i == end) {
            return -1;
        }
        return i;
    }

    public static Album findAlbumById(String id) {
        int albumIndex = findAlbumIndex(id);
        if (albumIndex == -1) {
            return null;
        }
        return mediaLib.fetchAlbum(albumIndex);
    }


    private static int findBookIndex(Book book) {
        return findBookIndex(book.getId());
    }

    private static int findBookIndex(String id) {
        int i = 0;
        int end = mediaLib.getNumberBooks();
        for ( ; i < end; i++) {
            Book b = mediaLib.fetchBook(i);
            if (b != null && b.getId().equals(id)) {
                break;
            }
        }
        if (i == end) {
            return -1;
        }
        return i;
    }

    public static Book findBookById(String id) {
        int bookIndex = findBookIndex(id);
        if (bookIndex == -1) {
            return null;
        }
        return mediaLib.fetchBook(bookIndex);
    }

    public static Album removeAlbum(Album album) {
        int albumIndex = findAlbumIndex(album);
        if (albumIndex == -1) {
            return null;
        }
        return mediaLib.removeAlbum(albumIndex);
    }

    public static Book removeBook(Book book) {
        int bookIndex = findBookIndex(book);
        if (bookIndex == -1) {
            return null;
        }
        return mediaLib.removeBook(bookIndex);
    }
}
