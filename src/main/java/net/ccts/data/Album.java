package net.ccts.data;
// calls for the class album
public class Album{

    private String name;
    private String artist;
    private int releaseYear;
    private int releaseMonth;
    private int releaseDay;
// constructor
    public Album(String n, String a) {
        this.name = n;
        this.artist = a;
    }
// accessors
    public String getName() {
        return name;
    }
    public String getArtist() {
        return artist;
    }
    public int getReleaseYear() {
        return releaseYear;
    }

// mutators
     public void setName(String t) {
        name = t;
    }

    public void setArtist(String a) {
        artist = a;
    }
    public void setReleaseYear(int releaseYear) {
        if (releaseYear < 1800 || releaseYear > 9999) {
            throw new IllegalArgumentException(
                "Release year must be set between 1800 and 9999, received "
                + releaseYear);
        }
        this.releaseYear = releaseYear;
    }

    public void setReleaseMonth(int releaseMonth) {
        if (releaseMonth < 1 || releaseMonth > 12) {
            throw new IllegalArgumentException(
                "Release month must set between 1 and 12, received "
                + releaseMonth);
        }
        this.releaseMonth = releaseMonth;
    }

    public void setReleaseDay(int releaseDay) {
        if (releaseDay < 1 || releaseDay > 31) {
            throw new IllegalArgumentException(
                "Release day must be set between 1 and 31, received "
            + releaseDay);
        }
        this.releaseDay = releaseDay;
    }
    @Override
    public String toString() {
        String info = this.name;
        if (this.releaseYear > 0 && this.releaseMonth > 0 && this.releaseDay > 0) {
            info = info + " - Release: " + this.releaseYear + "-"+
            this.releaseMonth + "-" + this.releaseDay;
        }



    return info;
}
}
