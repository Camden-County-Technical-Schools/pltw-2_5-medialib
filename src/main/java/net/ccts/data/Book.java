package net.ccts.data;

public class Book extends Media{
    private String author;

    public Book(String ID, String title, String author) {
        super(ID, title);
        this.author = author;
    }

    public String getTitle() {
        return super.title;
    }

    public void setTitle(String title) {
        super.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
