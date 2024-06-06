package net.ccts.data;

import java.time.YearMonth;

/**
 * Represents an album in a music collection.
 * Users can create instances of the Album class by providing the name of the album and the name of the artist.
 * Users can also specify the release date of the album.
 * Once created, users can retrieve album information and update the release date.
 */
public class Album extends Media {
    private String artist;
    private int releaseYear;
    private int releaseMonth;
    private int releaseDay;

    // Constructors
    public Album(String id, String name, String artist) {
        super(id, name);  // Call the constructor of the parent Media class
        this.artist = artist;
    }

    // Get name (previously getTitle)
    public String getName() {
        return super.getTitle();  // Get the title from the parent Media class
    }

    // Set name
    public void setName(String name) {
        super.setTitle(name);  // Set the title in the parent Media class
    }

    // Get artist
    public String getArtist() {
        return artist;
    }

    // Set artist
    public void setArtist(String artist) {
        this.artist = artist;
    }

    // Get release year
    public int getReleaseYear() {
        return releaseYear;
    }

    // Set release year with validation
    public void setReleaseYear(int releaseYear) {
        if (releaseYear < 1800 || releaseYear > 9999) {
            throw new IllegalArgumentException(
                "Release year must be between 1800 and 9999, received " + releaseYear);
        } else {
            this.releaseYear = releaseYear;
        }
    }

    // Get release month
    public int getReleaseMonth() {
        return releaseMonth;
    }

    // Set release month with validation
    public void setReleaseMonth(int releaseMonth) {
        if (releaseMonth < 1 || releaseMonth > 12) {
            throw new IllegalArgumentException(
                "Release month must be between 1 and 12, received " + releaseMonth);
        } else {
            this.releaseMonth = releaseMonth;
        }
    }

    // Get release day
    public int getReleaseDay() {
        return releaseDay;
    }

    // Set release day with validation
    public void setReleaseDay(int releaseDay) {
        if (releaseDay < 1 || releaseDay > 31) {
            throw new IllegalArgumentException(
                "Release day must be between 1 and 31, received " + releaseDay);
        } else {
            this.releaseDay = releaseDay;
            validateReleaseDate();  
        }
    }

    // Override toString method
    @Override
    public String toString() {
        String info = getName();
        if (this.releaseYear > 0 && this.releaseMonth > 0 && this.releaseDay > 0) {
            info = info + " - Release: " + this.releaseYear + "-" +
                this.releaseMonth + "-" + this.releaseDay;
        }
        return info;
    }

    // Validate release date
    private void validateReleaseDate() {
        if (releaseYear != 0 && releaseMonth != 0 && releaseDay != 0) {
            YearMonth yearMonth = YearMonth.of(releaseYear, releaseMonth);
            int lastDayOfMonth = yearMonth.lengthOfMonth();

            if (releaseDay > lastDayOfMonth) {
                throw new IllegalArgumentException("Invalid release day for the specified month and year");
            }

            if (releaseMonth == 2 && releaseDay == 29 && !yearMonth.isLeapYear()) {
                throw new IllegalArgumentException("Invalid release day for February in a non-leap year");
            }
        }
    }
}
