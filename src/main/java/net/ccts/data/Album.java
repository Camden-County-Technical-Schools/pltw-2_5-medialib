/* Adds the class to the net.ccts.data package */
package net.ccts.data;


/* The Album class is used to track data relating to a specific album */
public class Album {

    private String name; 
    private String artist; 
    private int releaseYear; 
    private int releaseMonth; 
    private int releaseDay; 

    /* Constructor */
    public Album(String n, String a, int y, int m, int d) {
        this.name = n;
        this.artist = a;
        this.releaseYear = y;
        this.releaseMonth = m;
        this.releaseDay = d;
    }


    /* Accessor Methods */
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

    /* Mutator Methods */
    public void setName(String n) {
        this.name = n;
    }

    public void setArtist(String a) {
        this.artist = a;
    }

    public void setReleaseYear(int y) {
        if (!validateReleaseDate(y, releaseMonth, releaseDay)) {
        throw new IllegalArgumentException("Invalid release date, release year must be between 1800 and 9999, received" + y);
        }
        this.releaseYear = y;
    }

    public void setReleaseMonth(int m) {
        if (!validateReleaseDate(releaseYear, m, releaseDay)) {
        throw new IllegalArgumentException("Invalid release date, release month must be between 1 and 12, received" + m);
        }
        this.releaseMonth = m;
    }

    public void setReleaseDay(int d) {
        if (!validateReleaseDate(releaseYear, releaseMonth, d)) {
        throw new IllegalArgumentException("Invalid release date, release day must be between 1 and 31, received" + d);
        }
        this.releaseDay = d;
    }
    
    /* toString Method */
    @Override
    public String toString() {
        String info = this.name;
        if (this.releaseYear > 0 && this.releaseMonth > 0 && this.releaseDay > 0) {
        return this.name + "- Release:" + this.releaseYear + "-" + this.releaseMonth + "-" + releaseDay; 
        }
        return info;
        } 

    
    /* ValidateReleasedDate Method */
    private boolean validateReleaseDate(int y, int m, int d) {
        if (y == 0 || m == 0 || d == 0) 
            return true;
    
        
        if (y < 1800 || y > 9999) {
            return false;
        }
        
        if (m < 1 || m > 12) {
            return false;
        }

        if (d < 1 || d > 31) {
            return false;
        }

        return true; 
    }
}


