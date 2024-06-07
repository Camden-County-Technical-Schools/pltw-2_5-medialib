package net.ccts.api;

import com.fasterxml.jackson.annotation.JsonGetter;
import net.ccts.data.Album;

public class AlbumApiData {
    public static final String NODE_NAME = "album";
    private Album album;

    public AlbumApiData(Album album) {
        this.album = album;
    }

    @JsonGetter("id")
    public String getId() {
        return album.getId();
    }

    @JsonGetter("title")
    public String getTitle() {
        return album.getTitle();
    }

    @JsonGetter("artist")
    public String getArtist() {
        return album.getArtist();
    }

    @JsonGetter("rating")
    public int getRating() {
        return album.getRating();
    }

    @JsonGetter("numTracks")
    public int getNumTracks() {
        return album.getNumTracks();
    }

    @JsonGetter("genre")
    public String getGenre() {
        return album.getGenre();
    }
}
