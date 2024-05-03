package net.ccts.data;

/** 
* The Album class is used to track data relating to an album
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

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return releaseYear;
    }

    public int getMonth() {
        return releaseMonth;
    }

    public int getDay() {
        return releaseDay;
    }

    public void setName(String n) {
    this.name = n;
    }

    public void setArtist(String a) {
    this.artist = a;
    }

    public void setReleaseDay(int releaseDay) {
        if(releaseDay < 1 || releaseDay > 31) {
            throw new IllegalArgumentException("Release day must be between 1 and 31, received" + releaseDay);
        }
        this.releaseDay = releaseDay;
    }

    public void setReleaseMonth(int releaseMonth) {
        if(releaseMonth < 1 || releaseMonth > 12) {
            throw new IllegalArgumentException("Release month must be between 1 and 12, received" + releaseMonth);
        }
        this.releaseMonth = releaseMonth;
    }
    
    public void setReleaseYear(int releaseYear) {
        if(releaseYear < 1800 || releaseYear > 9999) {
            throw new IllegalArgumentException("Release year must be between 1800 and 9999, received" + releaseYear);
        }
        this.releaseYear = releaseYear;
    }
    
    @Override
    public String toString() {
        String info = this.name;
        if(this.releaseYear > 0 && this.releaseMonth > 0 && this.releaseDay > 0) {
            info = info + " - Release: " + this.releaseYear + "." + this.releaseMonth + "." + this.releaseDay;

    }
    return info;
    }
}