package net.ccts.data;
// An album is part of a media library that could represent music, movies, or books
public class Album {
 private String name;
 private String artist;
 private int releaseYear;
 private int releaseMonth;
 private int releaseDay;


public Album(String n, String a) {
this.name=n;
this.artist=a;
}

public String getName(){
    return this.name;
    } 
public String getArtist(){
    return this.artist;

    } 
public int getYear(){
    return this.releaseYear;
    }

public void setReleaseYear(int y){
    if (releaseYear < 1800 || releaseYear>9999){
        throw new IllegalArgumentException(
        "Release year must be between 1800 and 9999, received" + y);
        } else {
        this.releaseYear=y; 
            }
        }

public int getMonth(){
    return this.releaseMonth;
        } 
public void setReleaseMonth(int m){
    if (releaseMonth < 1 || releaseMonth>12){
        throw new IllegalArgumentException(
        "Release month must be between 1 and 12, received" + m);
        } else {
        this.releaseMonth=m; 
            }
        }
            
public int getDay(){
    return this.releaseDay;
        } 
public void setReleaseDay(int d){
    if (releaseMonth < 1 || releaseMonth>31){
        throw new IllegalArgumentException(
        "Release day must be between 1 and 31, received" + d);
        } else {
         this.releaseDay=d; 
            }
        }
public void setName(String n){ 
    this.name= n;
        }
                        
public void setArtist(String a){ 
    this.artist=a;
}

@Override
public String toString() {
    String info = this.name;
    if (this.releaseYear > 0 && this.releaseMonth > 0 && this.releaseDay > 0) {
    return this.name + "- Release:" + this.releaseYear + "-" + this.releaseMonth + "-" + this.releaseDay; 
    }
    return info;
    } 
                                
}