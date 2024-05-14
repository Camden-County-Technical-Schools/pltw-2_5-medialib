package net.ccts.core;

import net.ccts.data.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/*
 * Activity 2.5.7
 * 
 * The runner for the MediaLibrary program
 */
public class MediaLibRunner
{
  public static void main(String[] args)
  {
    demoSets();
  }

  private static void demoSets() {
    Album a1 = new Album("Saviors", "Green Day");
    Album a2 = new Album("Blue Electric Light", "Lenny Kravitz");
    Album a3 = new Album("Blue Electric Light", "Lenny Kravitz");

    LinkedHashSet<Album> albumSet = new LinkedHashSet<>(6);
    albumSet.add(a1);
    albumSet.add(a2);
    albumSet.add(a3);
    albumSet.add(a1);
    albumSet.add(a2);
    albumSet.add(a3);

    System.out.println("Albums: ");
    for (Album album : albumSet) {
      System.out.println(album);
    }

    Book b1 = new Book("The Ukraine", "Artem Chapeye", "9781644212950");
    Book b2 = new Book("Wandering Stars - A novel", "Tommy Orange", "9780593318256");
    Book b3 = new Book("Wandering Stars", "Tommy Orange", "9780593318256");

    LinkedHashSet<Book> bookSet = new LinkedHashSet<>(6);
    bookSet.add(b1);
    bookSet.add(b2);
    bookSet.add(b3);
    bookSet.add(b1);
    bookSet.add(b2);
    bookSet.add(b3);

    System.out.println("\r\nBooks: ");
    for (Book book : bookSet) {
      System.out.println(book);
    }

  }

  private static void demoMaps() {
    HashMap<String, Integer> hashMap = new HashMap<>(100);
    LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(100);
    for (int i = 0; i < 100; i++) {
      String key = "0" + i;
      if (key.length() < 3) {
        key = "0" + key;
      }
      hashMap.put(key, Integer.valueOf(i));
      linkedHashMap.put(key, Integer.valueOf(i));
    }

    System.out.println("HashMap contents: ");
    for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }

    System.out.println("LinkedHashMap contents: ");
    for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
}