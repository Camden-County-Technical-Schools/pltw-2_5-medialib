package net.ccts.data;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AlbumTest {

    @Test
    public void ctorTest() {
        String n = "name1";
        String a = "artist1";

        Album album = new Album(n, a);
        assertEquals(n, album.getName());
        assertEquals(a, album.getArtist());
    }

}