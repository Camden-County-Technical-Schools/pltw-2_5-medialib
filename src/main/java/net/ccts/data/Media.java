package net.ccts.data;



public class Media {

    protected String id;
    protected String title;

    public Media(String i, String t){
        this.id = i;
        this.title = t;
    }

    public String getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;

    }

}
