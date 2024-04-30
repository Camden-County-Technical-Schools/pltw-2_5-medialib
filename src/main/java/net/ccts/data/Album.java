package net.ccts.data;

/**
 *
 */

public class Album {

    private String name;
    private String artist;
    private int releaseYear;
    private int releaseMonth;
    private int releaseDay;


    public Album(String n, String a) {
        this.name = n;
        this.artist = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        if (releaseYear < 1800 || releaseYear > 9999) {
            String msg = String.format("Release year must be between 1800 and 9999, received %d", releaseYear);
            throw new IllegalArgumentException(msg);
        }
        this.releaseYear = releaseYear;
    }

    public int getReleaseMonth() {
        return releaseMonth;
    }

    public void setReleaseMonth(int releaseMonth) {
        this.releaseMonth = releaseMonth;
    }

    public int getReleaseDay() {
        return releaseDay;
    }

    public void setReleaseDay(int releaseDay) {
        this.releaseDay = releaseDay;
    }
}