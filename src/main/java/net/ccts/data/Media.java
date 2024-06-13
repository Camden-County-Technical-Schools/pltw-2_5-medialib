package net.ccts.data;

public abstract class Media(){

    Protected String id;
    Private String title;


public Media(String id, String T){
id = id;
T = title;
}
public String setId(String id){
  if(index < 0 || index >= id.length){
      throw new IllegalArgumentException("Index is out of bounds ");
    }
    this.id = id;
}
public String setTitle(String t){
  if(index < 0 || index >= t.length){
      throw new IllegalArgumentException("Index is out of bounds ");
    }
    this.title = t;
}
public void getId(){

}
public void getTitle(){
    
}
}
