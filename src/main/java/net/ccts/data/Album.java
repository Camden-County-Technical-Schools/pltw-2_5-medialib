package net.ccts.data;
/**
 * shows the things required for an 
 * album such as name and the artists
 * and the release times
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

    public void setName(String n) {
        this.name = n; 
    }

    public void setArtist(String a) {
        this.artist = a; 
    }

    public void setReleaseYear(int releaseYear) {
        if(releaseYear < 1800 || releaseYear > 9999){
            throw new IllegalArgumentException(
                "Release year must be between 1800 and 9999, received" + releaseYear); 
        } else {
            this.releaseYear = releaseYear; 
        }
    }

    public void setReleaseMonth(int releaseMonth) {
        if(releaseMonth < 1 || releaseMonth > 12){
            throw new IllegalArgumentException(
                "Release year must be between 1 and 12, received" + releaseMonth); 
        } else {
            this.releaseMonth = releaseMonth;
        }     
    }

    public void setReleaseDay(int releaseDay) {
        if(releaseDay < 1 || releaseDay > 31){
            throw new IllegalArgumentException(
                "Release year must be between 1 and 31, received "  + releaseDay); 
        } else {
            this.releaseDay = releaseDay; 
        } 
    }

    @Override 
    public String toString() {
        return this.name + " Release:" + this.releaseYear + "-" + this.releaseMonth + "-" +
        this.releaseDay; 
    }

}   