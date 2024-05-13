/* Adds the class to the net.ccts.data package */
package net.ccts.data;


import java.time.YearMonth;

/* The Album class is used to track data relating to a specific album */
public class Album {

    private String name;
    private String artist;
    private int releaseYear;
    private int releaseMonth;
    private int releaseDay;

    /* Constructor */
    public Album(String n, String a) {
        this.name = n;
        this.artist = a;
    }


    /* Accessor Methods */
    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getReleaseMonth() {
        return releaseMonth;
    }

    public int getReleaseDay() {
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
        if (y <1800 || y > 9999
                || !validateReleaseDate(y, releaseMonth, releaseDay)) {
            throw new IllegalArgumentException("Invalid release date, release year must be between 1800 and 9999, received" + y);
        }
        this.releaseYear = y;
    }

    public void setReleaseMonth(int m) {
        if (m < 1 || m >  12
                || !validateReleaseDate(releaseYear, m, releaseDay)) {
            throw new IllegalArgumentException("Invalid release date, release month must be between 1 and 12, received" + m);
        }
        this.releaseMonth = m;
    }

    public void setReleaseDay(int d) {
        if (d < 1 || d > 31
               || !validateReleaseDate(releaseYear, releaseMonth, d)) {
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

    private boolean validateReleaseDate(int releaseYear, int releaseMonth, int releaseDay) {
        if (releaseYear != 0 && releaseMonth != 0 && releaseDay != 0) {
            YearMonth yearMonth = YearMonth.of(releaseYear, releaseMonth);
            int lastDayOfMonth = yearMonth.lengthOfMonth();

            if (releaseDay > lastDayOfMonth) {
                return false;
            }

            if (releaseMonth == 2 && releaseDay == 29 && !yearMonth.isLeapYear()) {
                return false;
            }
        }
        return true;
    }

}


