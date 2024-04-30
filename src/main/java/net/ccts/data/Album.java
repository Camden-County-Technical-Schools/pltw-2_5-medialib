package net.ccts.data;
// Fill later
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

public String getName() {
  return name;
}

public String getArtist() {
  return artist;
}

public int getreleaseYear() {
  return releaseYear;
}
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

public int getreleaseMonth() {
  return releaseMonth;
}

public void setreleaseMonth (int releaseMonth) {
     if(releaseMonth < 1 || releaseYear >  12) {

throw new IllegalArgumentException(
  "Release month must be between 1 and 12, recieved"
  + releaseMonth);
  } else{
    this.releaseMonth = releaseMonth;
    }
}
public int getreleaseDay() {
  return releaseDay;
}
public void setreleaseDay(int releaseDay) {
     if(releaseDay < 1 || releaseYear >  31) {

throw new IllegalArgumentException(
  "Release day must be between 1 and 31, recieved"
  + releaseDay);
  } else{

    this.releaseDay = releaseDay;
    }
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

    