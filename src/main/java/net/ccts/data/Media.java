package net.ccts.data;

/**
  The Media class tracks common properties 
  such as id and title, which are essential 
  identifiers for different types of media.
 */
public abstract class Media {

    // Protected member variables to be accessed by subclasses
    protected String id;    // Required variable (e.g., ISBN, ISRC)
    protected String title; // Required variable

    /**
      Constructor to initialize the Media object with the required parameters.
     
      @param id    the unique identifier for the media (e.g., ISBN or ISRC)
      @param title the title of the media
     */
    public Media(String id, String title) {
        this.id = id;
        this.title = title;
    }

    /**
      Gets the id of the media.
     
      @return the id of the media
     */
    public String getId() {
        return id;
    }

    /**
      Gets the title of the media.
     
      @return the title of the media
     */
    public String getTitle() {
        return title;
    }

    /**
      Sets the title of the media.
     
      @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
