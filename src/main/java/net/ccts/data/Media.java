package net.ccts.data;
/*
 * Activity 2.5.7
 *
 * A Media class for the MediaLibrary program
 */
public abstract class Media {
    protected String id;
    protected String title;
public Media()
    {
    }
public Media(String id, String t)
    {
    this.id = id;
    this.title = t;
    }
public String getTitle() {
    return this.title;
}
public String getId() {
    return this.id;
}
  public void setTitle(String t) {
    this.title = t;
  }
}