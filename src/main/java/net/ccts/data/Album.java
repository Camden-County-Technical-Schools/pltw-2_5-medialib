package net.ccts.data;
import java.time.YearMonth;
import java.time.LocalDate;

/** 
* The Album class is used to track data relating to an album
*/

public class Album extends Media{

private String artist;
private int releaseYear; 
private int releaseMonth; 
private int releaseDay;

public Album(String id, String n, String a) {
    super(id, n);
    this.artist = a;

}

public String getName() {
    return title;
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

public void setName(String n) {
    super.title = n;
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
    String info = super.title;
    if(this.releaseYear > 0 && this.releaseMonth > 0 && this.releaseDay > 0) {
        info = info + " - Release: " + this.releaseYear + "-" + this.releaseMonth + "-" + this.releaseDay;

    }
    return info;
}

private void validateReleaseDate() {
    if(releaseYear != 0 && releaseMonth != 0 && releaseDay != 0) {
        YearMonth yearMonth = YearMonth.of(releaseYear, releaseMonth);
        int lastDayOfMonth = yearMonth.lengthOfMonth();

        if(releaseDay > lastDayOfMonth) {
            throw new IllegalArgumentException("Invalid release day for the specified month and year");
        }

        if(releaseMonth == 2 && releaseDay == 29 && !yearMonth.isLeapYear()) {
            throw new IllegalArgumentException("Invalid release day for February in a non-leap year");
            
    }            
}
}
}