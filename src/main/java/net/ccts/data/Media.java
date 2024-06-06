package net.ccts.data;
public abstract class Media {
    // Abstract class to represent various types of media.
    
    // Internal member variables
    protected String id;
    protected String title;

    public Media(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}