package net.ccts.data;

/*
 * Activity 2.5.7
 *
 * A Book class for the MediaLibrary program
 */
public class Album
{
  private String name;
  private String artist;
  private int releaseYear;
  private int releaseMonth;
  private int releaseDay;
  
  /*** Constructor ****/
  public Album(String t, String a)
  {
    name = t;
    artist = a;
  }
  
   /*** Accessor methods ***/
  public String getname() {
    return name;
  }

  public String getArtist() {
    return artist;
  }
  
  public int getreleaseDay() {
    return releaseDay;
  }

  public int getreleaseMonth() {
    return releaseMonth;
  }

  public int getreleaseYear() {
    return releaseYear;
  }
@Override
  public String toString() 
  {
    String info = "\"" + name + "\", written by " + artist;
    if (releaseDay != 0 && releaseMonth != 0 && releaseYear != 0) 
    { 
      info += ", release date is " + releaseYear + "-" + releaseMonth + "-" + releaseDay;
    }
    return info;
  }

  /*** Mutator methods ***/
  public void setname(String t) {
    name = t;
  }

  public void setartist(String a) {
    artist = a;
  }

  public void setreleaseDay(int d) {
    if (d < 1 || d > 31)
      throw new IllegalArgumentException("release day must be between 1 and 31, received " + d);
    releaseDay = d;
  }

  public void setreleaseMonth(int m) {
    if (m < 1 || m > 12)
      throw new IllegalArgumentException("release month must be between 1 and 12, received " + m);
    releaseMonth = m;
  }

  public void setreleaseYear(int y) {
    if (y < 1800 || y > 9999)
      throw new IllegalArgumentException("release day must be between 1800 and 9999, received " + y);
    releaseYear = y;
  }

}
