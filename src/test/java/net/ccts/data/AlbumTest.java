package net.ccts.data;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlbumTest {
    private Album testAlbum;
    private String testName = "testName";
    private String testArtist = "testArtist";
    private int testReleaseYear = 2024;
    private int testReleaseMonth = 12;
    private int testReleaseDay = 24;

    @Before
    public void setUp() throws Exception {
        testAlbum = new Album("r27826851", testName, testArtist);
        testAlbum.setReleaseYear(testReleaseYear);
        testAlbum.setReleaseMonth(testReleaseMonth);
        testAlbum.setReleaseDay(testReleaseDay);
    }

    @Test
    public void testCtor() {
        String id = "r27826851";
        String name = "name";
        String artist = "artist";
        Album a1 = new Album(id, name, artist);
        assertEquals(id, a1.getId());
        assertEquals(name, a1.getName());
        assertEquals(artist, a1.getArtist());
    }

    @Test
    public void testSetTitle() {
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
        int releaseMonth = 1;
        int releaseDay = 20;
        testAlbum.setReleaseMonth(releaseMonth);
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

    @Test
    public void testToString() {
        String expected = testName + " - Release: " + testReleaseYear + "-"
                + testReleaseMonth + "-" + testReleaseDay;
        assertEquals(expected, testAlbum.toString());
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