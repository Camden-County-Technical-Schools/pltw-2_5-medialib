package net.ccts.data;

// An album is a media tool that contains 6 or more recordings of music
public class Album {

    private String artist;
    private int releaseYear;
    private String name;
    private int releaseDay;
    private int releaseMonth;

    public Album(String n, String a) {
        this.name = n;
        this.artist = a;
    }

    public String getArtist() {
        return this.artist;
    }

    public int getReleaseYear() {
        return this.releaseYear;
    }

    public String getName() {
        return this.name;
    }

    public int getReleaseDay() {
        return this.releaseDay;
    }

    public int getReleaseMonth() {
        return this.releaseMonth;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setArtist(String a) {
        this.artist = a;
    }

    public void setReleaseMonth(int m) {
        if (m < 1 || m > 12) {
            throw new IllegalArgumentException(
                "Release month must be between 1 and 12, received " + m);
        }
        this.releaseMonth = m;
    }

    public void setReleaseDay(int d) {
        if (d < 1 || d > 31) {
            throw new IllegalArgumentException(
                "Release Day must be between 1 and 31, received " + d);
        }
        this.releaseDay = d;
    }

    public void setReleaseYear(int y) {
        if (y < 1800 || y > 9999) {
            throw new IllegalArgumentException(
                "Release Year must be between 1800 and 9999, received " + y);
        }
        this.releaseYear = y;
    }

    @Override
    public String toString() {
        return this.name + " - Release: " + this.releaseYear + "-" + this.releaseMonth + "-" + this.releaseDay;
    }
}
