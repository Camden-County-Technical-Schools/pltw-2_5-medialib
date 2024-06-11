package net.ccts.data;
//An album is part of a media libray that could represent music, movies, or books

public class Album extends Media {
    private String artist;
    private int releaseYear;
    private int releaseDay;
    private int releaseMonth;

    public Album(String id, String title, String a) {
        super(id, title);
        this.artist = a;
    }
    public String getArtist() {
        return this.artist;
    }
   public String getName() {
    return super.getTitle();
   }
    public int getReleaseYear() { 
        return this.releaseYear;
    }
    public int getReleaseDay() { 
        return this.releaseDay;
    }
    public int getReleaseMonth() {
        return this.releaseMonth;
    }

    public void setArtist(String a){
        this.artist = a;
    }
    public void setReleaseYear(int releaseYear){
        if (releaseYear < 1800 || releaseYear > 9999) {
            //String msg = String.format("Release year must be between 1800 and 9999, received %d", releaseYear);
            throw new IllegalArgumentException ("Release year must be between 1800 and 9999, received" +releaseYear);
        } else {
            this.releaseYear = releaseYear;
        }
    }

    public void setReleaseMonth(int releaseMonth){
        if (releaseMonth < 1 || releaseMonth > 12) {
            throw new IllegalArgumentException("Release month must be between 1 and 12, received" +releaseMonth);
        } else {
            this.releaseMonth = releaseMonth;

        }
    }        
      
    public void setReleaseDay(int releaseDay){
        if (releaseDay < 1 || releaseDay > 31) {
            throw new IllegalArgumentException( "Release day must be between 1 and 31, received" + releaseDay);
        }else{
            this.releaseDay = releaseDay;
        }
    }
    @Override
    public String toString() {
       String info = getTitle();
       if (this.releaseYear > 0 && this.releaseMonth > 0 && this.releaseDay > 0) {
        return getTitle() +" - Release: " + this.releaseYear +"-" + this.releaseMonth + "-" + this.releaseDay;
       } 
       return info;
    }
    public void setName(String n){
        super.setTitle(n);

    }
}
