package net.ccts.data;

public abstract class Media{

    protected String id;
    protected String title;


public Media(String id, String title){
this.id = id;
this.title = title;
}
// public String setId(String id){
//   if(index < 0 || index >= id.length){
//       throw new IllegalArgumentException("Index is out of bounds ");
//     }
//     this.id = id;
// }
public void setTitle(String t){
    this.title = t;
}
public String getId(){
return id;
}
public String getTitle(){
    return title;
}
}
