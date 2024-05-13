package net.ccts.data;
import java.time.YearMonth;
import java.time.LocalDate;
/**
 * Represents an album in a music collection.
 * Users can create instances of the Album class by providing the name of the album and the name of the artist.
 * Users can also specify the release date of the album.
 * Once created, users can retrieve album information and update the release date.
 */
public class Album{
  private String name;
  private String artist;
  private int releaseYear;
  private int releaseMonth;
  private int releaseDay;

// Constructors
public Album(String n, String a) {
  this.name = n;
  this.artist = a;

    }

// Get name
public String getName() {
  return name;
}
// Get Artist
public String getArtist() {
  return artist;
}
public void setName(String n) {
  this.name = n;
}
public void setArtist(String a) {
  this.artist = a;
}

// Get Release Year
public int getreleaseYear() {
  return releaseYear;
}
// Parameter of release year. So the number provided must be between the years 1800 and 9999.
public void setreleaseYear(int releaseYear) {
    if(releaseYear <1800 || releaseYear > 9999) {

throw new IllegalArgumentException(
  "Release year must be between 1800 and 9999, recieved"
  + releaseYear); 
  }
  else{
    this.releaseYear = releaseYear;
    }
  }    
// Get release Month
public int getreleaseMonth() {
  return releaseMonth;
}
// Parameter for the Month selection between 1 & 12.
public void setreleaseMonth (int releaseMonth) {
     if(releaseMonth < 1 || releaseYear >  12) {

throw new IllegalArgumentException(
  "Release month must be between 1 and 12, recieved"
  + releaseMonth);
  } else{
    this.releaseMonth = releaseMonth;
    }
}
// Get release Day.
public int getreleaseDay() {
  return releaseDay;
}
// Parameter for release Day between 1 & 31
public void setreleaseDay(int releaseDay) {
     if(releaseDay < 1 || releaseYear >  31) {

throw new IllegalArgumentException(
  "Release day must be between 1 and 31, recieved"
  + releaseDay);
  } else{

    this.releaseDay = releaseDay;
    }
}
// Overriding java givens
@Override
public String toString() {
  String info = this.name;
  if (this.releaseYear > 0 && this.releaseMonth > 0 && this.releaseDay > 0) {
    info = info + " - Release: " + this.releaseYear + "-"+
    this.releaseMonth + "-" + this.releaseDay;

}
return info;
}
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



    