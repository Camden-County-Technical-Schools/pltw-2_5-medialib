package net.ccts.data;

/* The album class is supposed to be used to find the name of a song, the artist, and the release date */
public class Album extends Media {

    private String name;
    private String artist; 
    private int releaseYear;
    private int releaseMonth;
    private int releaseDay; 

    public Album(String id, String title, String name, String artist, int releaseYear, int releaseMonth, int releaseDay) {
        super(id, title);
        this.name = name;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.releaseMonth = releaseMonth;
        this.releaseDay = releaseDay;
    }

    public String getName() {
        return this.name;
    }

    public String getArtist() {
        return this.artist;
    }

    public int getReleaseYear() {
        return this.releaseYear;
    }

    public int getReleaseMonth() {
        return this.releaseMonth;
    }

    public int getReleaseDay() {
        return this.releaseDay;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setReleaseYear(int releaseYear) {
        if (releaseYear < 1800 || releaseYear > 9999) {
            throw new IllegalArgumentException("Release year must be between 1800 and 9999, received " + releaseYear);
        }
        this.releaseYear = releaseYear;
    }

    public void setReleaseMonth(int releaseMonth) {
        if (releaseMonth < 1 || releaseMonth > 12) {
            throw new IllegalArgumentException("Release month must be between 1 and 12, received " + releaseMonth);
        }
        this.releaseMonth = releaseMonth;
    }

    public void setReleaseDay(int releaseDay) {
        if (releaseDay < 1 || releaseDay > 31) {
            throw new IllegalArgumentException("Release day must be between 1 and 31, received " + releaseDay);
        }
        this.releaseDay = releaseDay;
    }

    @Override
    public String toString() {
        String info = this.name;
        if (this.releaseYear > 0 && this.releaseMonth > 0 && this.releaseDay > 0) {
            info += " - Release: " + this.releaseYear + "-" + this.releaseMonth + "-" + this.releaseDay;
        }
        return info;
    }
}
