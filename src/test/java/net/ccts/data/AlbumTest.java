package net.ccts.data;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.lang.model.type.ArrayType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AlbumTest {
    private Album testAlbum;

    @Before
    public void setUp() throws Exception {
        testAlbum = new Album("testName", "testArtist");
    }

    @Test
    public void testCtor() {
        String name = "name";
        String artist = "artist";
        Album a1 = new Album(name, artist);
        assertEquals(a1.getName(), name);
        assertEquals(a1.getArtist(), artist);
    }

    @Test
    public void testSetName() {
        String name = "name";
        testAlbum.setName(name);

        assertEquals(testAlbum.getName(), name);
    }

    @Test
    public void testSetArtist() {
        String a = "artist";
        testAlbum.setArtist(a);

        assertEquals(testAlbum.getArtist(), a);
    }

    @Test
    public void testSetReleaseYear() {
        int releaseYear = 1990;
        testAlbum.setReleaseYear(releaseYear);
        assertEquals(testAlbum.getReleaseYear(), releaseYear);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetReleaseYearEarly() {
        int releaseYear = 1000;
        testAlbum.setReleaseMonth(1);
        testAlbum.setReleaseDay(1);
        testAlbum.setReleaseYear(releaseYear);
        assertEquals(testAlbum.getReleaseYear(), releaseYear);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetReleaseYearLate() {
        int releaseYear = 10000;
        testAlbum.setReleaseMonth(1);
        testAlbum.setReleaseDay(1);
        testAlbum.setReleaseYear(releaseYear);
        assertEquals(testAlbum.getReleaseYear(), releaseYear);
    }

    @Test
    public void testSetReleaseMonth() {
        int releaseMonth = 2;
        testAlbum.setReleaseMonth(releaseMonth);
        assertEquals(testAlbum.getReleaseMonth(), releaseMonth);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetReleaseMonthEarly() {
        int releaseMonth = 0;
        testAlbum.setReleaseYear(2000);
        testAlbum.setReleaseDay(1);
        testAlbum.setReleaseMonth(releaseMonth);
        assertEquals(testAlbum.getReleaseMonth(), releaseMonth);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetReleaseMonthLate() {
        int releaseMonth = 20;
        testAlbum.setReleaseYear(2000);
        testAlbum.setReleaseDay(1);
        testAlbum.setReleaseMonth(releaseMonth);
        assertEquals(testAlbum.getReleaseMonth(), releaseMonth);
    }

    @Test
    public void testSetReleaseDay() {
        int releaseDay = 20;
        testAlbum.setReleaseDay(releaseDay);
        assertEquals(testAlbum.getReleaseDay(), releaseDay);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetReleaseDayEarly() {
        int releaseDay = 0;
        testAlbum.setReleaseYear(2000);
        testAlbum.setReleaseMonth(1);
        testAlbum.setReleaseDay(releaseDay);
        assertEquals(testAlbum.getReleaseDay(), releaseDay);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetReleaseDayLate1() {
        int releaseDay = 32;
        testAlbum.setReleaseYear(2000);
        testAlbum.setReleaseMonth(1);
        testAlbum.setReleaseDay(releaseDay);
        assertEquals(testAlbum.getReleaseDay(), releaseDay);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetReleaseDayLate2() {
        int releaseDay = 31;
        testAlbum.setReleaseYear(2000);
        testAlbum.setReleaseMonth(4);
        testAlbum.setReleaseDay(releaseDay);
        assertEquals(testAlbum.getReleaseDay(), releaseDay);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testSetReleaseDayLate3() {
        int releaseDay = 29;
        testAlbum.setReleaseYear(2001);
        testAlbum.setReleaseMonth(2);
        testAlbum.setReleaseDay(releaseDay);
        assertEquals(testAlbum.getReleaseDay(), releaseDay);
    }

    @Ignore
    @Test
    public void testSetReleaseDayLeap() {
        int releaseDay = 29;
        testAlbum.setReleaseYear(2000);
        testAlbum.setReleaseMonth(2);
        testAlbum.setReleaseDay(releaseDay);
        assertEquals(testAlbum.getReleaseDay(), releaseDay);
    }
}