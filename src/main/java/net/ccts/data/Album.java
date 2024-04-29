package net.ccts.data;
/**
 * an album is a collection or a single song that needs to have a title and an artist name
 * release date is optional
 * @author gitpod
 */
public class Album {

    private String name;
    private String artist;

    private int releaseYear;
    private int releaseMonth;
    private int releaseDay;

    /**
     * The public constructor initializing the basic requirements for a song/album title
     * @param n - name/title of the album
     * @param a - artist or creator of the album
     */
    public Album(String n, String a) {
        
        name = n;
        artist = a;
    }

    // accessors methods

    /**
     * reset the name field of the album
     * @param n - name of the album
     */
    public void setName(String n) {
        this.name = n;
    }

    /**
     * reset the artist field of the album
     * @param a 0 artist of the album
     */
    public void setArtist(String a) {
        this.artist = a;
    }

    /**
     * set the release year of the album with a year between 1800 and 9999
     * @param y - year the album was released
     */
    public void setYear(int y) {
        if (y >= 1800 && y <= 9999) this.releaseYear = y;
        else throw new IllegalArgumentException("Release year must be between 1800 and 9999, received " + y);
        
    }

    /**
     * set the release month of the album with a motnh between 1 and 12
     * @param m - month the album was released
     */
    public void setMonth(int m) {
        if (m >= 1 && m <= 12) this.releaseMonth = m;
        else throw new IllegalArgumentException("Release month must be between 1 and 12, received " + m);
    }

    /**
     * set the release day of the album with a day between 1 and 31 along with
     * being a value inline with the amount of days per month
     * @param d - day the album was released
     */
    public void setDay(int d) {
        if (d >= 1 && d <= 31) {
            switch (this.releaseMonth) {
                case 1: 
                    if (d >= 1 && d <= 31) this.releaseDay = d;
                    break;
                case 2:
                    if (this.releaseYear % 4 == 0) {
                        if (d >= 1 && d <= 29) this.releaseDay = d;
                    }
                    if (d >= 1 && d <= 28) this.releaseDay = d;
                    break;
                case 3:
                    if (d >= 1 && d <= 31) this.releaseDay = d;
                    break;
                case 4:
                    if (d >= 1 && d <= 30) this.releaseDay = d;
                    break;
                case 5:
                    if (d >= 1 && d <= 31) this.releaseDay = d;
                    break;
                case 6:
                    if (d >= 1 && d <= 30) this.releaseDay = d;
                    break;
                case 7:
                    if (d >= 1 && d <= 31) this.releaseDay = d;
                    break;
                case 8:
                    if (d >= 1 && d <= 31) this.releaseDay = d;
                    break;
                case 9:
                    if (d >= 1 && d <= 30) this.releaseDay = d;
                    break;
                case 10:
                    if (d >= 1 && d <= 31) this.releaseDay = d;
                    break;
                case 11:
                    if (d >= 1 && d <= 30) this.releaseDay = d;
                    break;
                case 12:
                    if (d >= 1 && d <= 31) this.releaseDay = d;
                    break;
                
                default:
                    throw new IllegalArgumentException("Release Day is invalid for selected release Date, you have month " + this.releaseMonth + "with day: " + d);

            }
        }
        else throw new IllegalArgumentException("Release day must be a value between 1 and 31, received " + d);
        
    }


    // mutator methods
    /**
     * retrieve the name set in constructor, or changed by set method
     * @return name of album
     */
    public String getName() {
        return name;
    }

    /**
     * retrieve the artist name set in constructor, or changed by set method
     * @return artist of album
     */
    public String getArtist() {
        return artist;
    }

    /**
     * retrieve the release year set in constructor, or changed by set method
     * @return release year of album
     */
    public int getYear() {
        return releaseYear;
    }

    /**
     * retrieve the release month set in constructor, or changed by set method
     * @return release month of album
     */
    public int getMonth() {
        return releaseMonth;
    }

    /**
     * retrieve the release day set in constructor, or changed by set method
     * @return release day of album
     */
    public int getDay() {
        return releaseDay;
    }

    // additional mmethods

    /**
     * changes the format of the final recieved album
     * @return the title, artist, and release date of the album
     */
    @Override
    public String toString() {
        String a = "Title: " + name + " | Artist: " + artist + " | Release Date(YYYY/MM/DD): " + releaseYear + "-" + releaseMonth + "-" + releaseDay;
        return a;
    }
    
}
