package net.ccts.data;

/**
 * Hold and sort media with an id number and a title.
 * @author AkiotheChaoticPan
 */
public abstract class Media {
    
    private String id; 
    private String title;

    /**
     * A public constructor that initilizes the id and title of the media
     * @param i - the isbn or isrc/ id of the media provided by the user
     * @param t - the title of the media provided by the user
     */
    public Media(String i, String t) {

        this.id = i;
        this.title = t;

    }

    public Media() {
        
    }

    // methods

    // accessor methods

    /**
     * retrieve the ID of the media
     * @return this.id - the id value of the media
     */
    public String getID() {
        return this.id;
    }

    /**
     * retrieve the title of the media
     * @return this.title - the title value of the media
     */
    public String getTitle() {
        return this.title;
    }

    // mutator methods

    /**
     * set title to the string value provided by the user
     * @param t - title value provided by the user
     */
    public void setTitle(String t) {
        this.title = t;
    }
}
