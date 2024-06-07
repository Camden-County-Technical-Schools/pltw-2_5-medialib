package net.ccts.biz;

import net.ccts.data.Album;
import java.util.HashMap;
import java.util.Map;

public class AlbumManager {
    private static Map<String, Album> albums = new HashMap<>();

    public static Album findAlbum(String id) {
        return albums.get(id);
    }

    public static void removeAlbum(Album album) {
        albums.remove(album.getId());
    }

    public static Album registerAlbum(Album album) {
        albums.put(album.getId(), album);
        return album;
    }
}
