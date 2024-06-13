package net.ccts.data;
/**
 * shows the things required for an 
 * album such as name and the artists
 * and the release times
 */
public class Album extends Media {
    // private String name; 
    private String artist;

    private int releaseYear; 
    private int releaseMonth;
    private int releaseDay;

    public Album(String id, String title, String artist) {
        super(id, title); 
        this.artist = artist; 
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
    public String getName() {
        return super.getTitle();
    }

    public void setName(String n) {
        super.setTitle(n); 
    }

    public String getArtist() {
        return this.artist; 
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
        return super.getTitle() + " - Release: " + this.releaseYear + "-" + this.releaseMonth + "-" +
        this.releaseDay; 
    }

}   