package net.ccts.data;
import java.util.ArrayList;
import java.util.*;
/**
 * Activity 2.5.7
 * 
 * A MediaLib class for the MediaLibrary program
 */
public class MediaLib
{
  private  ArrayList<Book> books = new ArrayList<Book>(10);
  private  ArrayList<Album> albums = new ArrayList<Album>(50);
  
  public Book fetchBook(int index){
  if (index < 0 || index >= books.size()){
    throw new IllegalArgumentException("Index is out of bounds");
  }
  return books.get(index);
  }
  public Album fetchAlbum(int index){
    if (index < 0 || index >= albums.size()){
    throw new IllegalArgumentException("Index is out of bounds");
  }
  return albums.get(index);
  }
  public void setBook(int index, Book b){
    if (index < 0 || index >= books.size()){
    throw new IllegalArgumentException("Index is out of bounds");
  }
    books.set(index, b);
  }
  public void setAlbum(int index, Album a){
    if (index < 0 || index >= albums.size()){
    throw new IllegalArgumentException("Index is out of bounds");
  }
    albums.set(index, a);
  }
  public Book removeBook(int index){
    if (index < 0 || index >= books.size()){
    throw new IllegalArgumentException("Index is out of bounds");
  }
  return books.remove(index);
  }
  public Album removeAlbum(int index){
    if (index < 0 || index >= albums.size()){
    throw new IllegalArgumentException("Index is out of bounds");
  }
  return albums.remove(index);
  }
  public String toString() 
  {
    String info = "";
    
    return info;
  }
  public ArrayList<Media> fetchAllMedia(){
    ArrayList<Media> allMedia = new ArrayList<Media>(books);
    allMedia.addAll(albums);
    return allMedia;

  }

  public void addBook(Book b){
    books.add(b);
  }
  public void addAlbum(Album a){
    albums.add(a);
  }
}