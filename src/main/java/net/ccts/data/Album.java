package net.ccts.data;

/*Implement the class conforming to this spec to earn up to 8 points.
Structure of the Album class and comment: 1 point
Member variables: 2 points
Constructor: 2 points
Methods: 3 points*/
public class Album {

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

public String getartist (){
  return this.artist;
}

public int getreleaseYear(){
  return this.releaseYear;
}
public int getreleaseMonth(){
  return this. releaseMonth;
}
public int getreleaseDay(){
  return this.releaseDay;
}


public void setName(String n){
   this.name = n;
}
public void setArtist(String a){
  this.artist = a;
}
public void setReleaseYear(int releaseY){
  if(releaseYear < 1800 || releaseYear >9999){
    throw new IllegalArgumentException(
      "release year must be between 1800 and  9999, received " 
      + releaseYear );
  }
  this.releaseYear = releaseY;
}
public void setReleaseMonth(int releaseM){
  if(releaseMonth < 1 || releaseMonth > 12){
    throw new IllegalArgumentException(
      "release month must be between 1 and  12, received " 
      + releaseMonth );
  }
  this.releaseMonth = releaseM;
}
public void setReleaseDay (int releaseD){
  if(releaseDay < 1|| releaseDay > 31){
    throw new IllegalArgumentException(
      "release day must be between 1 and  31, received " 
      + releaseDay );
  }
  this.releaseDay = releaseD;
}
@Override
public String toString(){
  String info = this.name;
  if(this.releaseYear > 0 && this.releaseMonth > 0 && this.releaseDay > 0){
    info = info + " - Release:" + this.releaseYear + "-"+ this.releaseMonth + "-" + this.releaseDay;
  }
      return this.name + " - Release" + this.releaseYear + "-" + this.releaseMonth + "-" + this.releaseDay;
}
}  