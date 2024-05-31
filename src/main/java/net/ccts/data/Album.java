/*
 * Activity 2.5.7
 *
 * An Album class for the MediaLibrary program
 */
package net.ccts.data;
public class Album extends Media{  
  private String artist;
  private int releaseYear;
  private int releaseMonth;
  private int releaseDay;


public Album(String t, String a, String id)
  {
    super (id, t);
    this.artist = a;
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

public void setReleaseYear(int t) {
  if (t > 1799 && t < 10000)
    releaseYear = t;
  throw new IllegalArgumentException("Release year must be between 1800 and 9999, received" + t);
  }

  public void setReleaseMonth(int t) {
  if (t > 0 && t < 13)
    releaseMonth = t;
  throw new IllegalArgumentException("Release month must be between 1 and 12, received" + t);
  }

  public void setReleaseDay(int t) {
  if (t > 0 && t < 32)
    releaseDay = t;
  throw new IllegalArgumentException("Release day must be between 1 and 31, received" + t);
  }


  public void setArtist(String a) {
    artist = a;
  }
@Override
public String toString() {
  String info = title + "Release: " + releaseYear + " - " + releaseMonth + " - " + releaseDay;
  return info;
}


}