package net.ccts.data;

public class Album extends Media{
    private String artist;
    private int releaseYear;
    private int releaseMonth;
    private int releaseDay;

    public Album(String name, String artist, String id) {
        super (id, name);
        this.artist = artist;
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
            throw new IllegalArgumentException("Release year must be between 1800 and 9999, received " + releaseYear);
        }
        this.releaseYear = releaseYear;
    }

    public int getReleaseMonth() {
        return releaseMonth;
    }

    public void setReleaseMonth(int releaseMonth) {
        if (releaseMonth < 1 || releaseMonth > 12) {
            throw new IllegalArgumentException("Release month must be between 1 and 12, received " + releaseMonth);
        }
        this.releaseMonth = releaseMonth;
    }

    public int getReleaseDay() {
        return releaseDay;
    }

    public void setReleaseDay(int releaseDay) {
        if (releaseDay < 1 || releaseDay > 31) {
            throw new IllegalArgumentException("Release day must be between 1 and 31, received " + releaseDay);
        }
        this.releaseDay = releaseDay;
    }

    @Override
    public String toString() {
        return getTitle() + " - Release: " + releaseYear + "-" + releaseMonth + "-" + releaseDay;
    }
}