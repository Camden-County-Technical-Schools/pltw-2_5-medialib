package net.ccts.data;

/**
 * Base class for media items
 * It tracks attributes
 */
public abstract class Media {
    protected String id; // Required variable, will be a value like ISBN or ISRC
    protected String title; // Required variable

    // Constructor for the required member variables
    public Media(String id, String title) {
        this.id = id;
        this.title = title;
    }

    // Accessor and mutator methods
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
