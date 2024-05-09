package net.ccts.data;
/**
 * Public Class Album is used to get the artist, name, releaseyear/month/day
 * There are limits on the releaseyear/month/day
 */
public class Album{
    
    
private String name;
private String artist;
private int releaseYear;
private int releaseMonth;
private int releaseDay;

    public Album(String n, String a){
        this.name = n;
        this.artist = a;
    }

        public String getName(){
            return this.name;
        }
        public String getArtist(){
            return this.artist;


        }
        public int getreleaseYear(){
            return releaseYear;
        }
        public int getreleaseMonth(){
            return releaseMonth;


        }
        public int getreleaseDay(){
            return releaseDay;


        }
        public void setName(String n){
            this.name = n;

        }
        public void setArtist(String a){
            this.artist = a;

        }
        public void setreleaseYear(int releaseYear){
            if (releaseYear < 1800 || releaseYear > 9999){
                throw new IllegalArgumentException(
                    "Release year must be between 1800 and 9999, receive"
                   + releaseYear);
            }
        this.releaseYear = releaseYear;

    }
    public void setreleaseMonth(int releaseMonth){
        if (releaseMonth < 1 || releaseMonth > 12){
            throw new IllegalArgumentException(
                "Release Month must be between 1 and 12, receive"
                 + releaseMonth);
        }
        this.releaseMonth = releaseMonth;

    }
    public void setreleaseDay(int releaseDay){
        if (releaseDay < 1 || releaseDay > 31){
            throw new IllegalArgumentException(
                "Release Day must be between 1 and 31, receive"
                 + releaseDay);
        }        
        this.releaseDay = releaseDay;

    }
    private boolean validReleaseDate()

    @Override
    public String toString(){
        return this.name + " - Release: " + this.releaseYear + "-" +
        this.releaseMonth + "-"  + this.releaseDay;
    }


}
