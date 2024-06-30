package net.ccts.api;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import net.ccts.data.Album;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.yaml.snakeyaml.events.Event;

@JsonRootName(value = AlbumApiData.NODE_NAME)
public class AlbumApiData {
    public static final String NODE_NAME = "album";
    public static final String LIST_NAME = "albums";
    public static final String ID_NODE = "id";
    public static final String NAME_NODE = "name";
    public static final String ARTIST_NODE = "artist";

    private Album album;

    public AlbumApiData() {
        this.album = new Album(null, null, null);
    }

    public AlbumApiData(Album album) {
        this.album = album;
    }

    @JsonIgnore
    public Album getAlbum() {
        return album;
    }

    @JsonGetter(ID_NODE)
    public String getId() {
        return album.getId();
    }

    @JsonGetter(NAME_NODE)
    public String getName() {
        return album.getName();
    }

    @JsonGetter(ARTIST_NODE)
    public String getArtist() {
        return album.getArtist();
    }

    @JsonSetter(ID_NODE)
    public void setId(String s) {
        album.setId(s);
    }

    @JsonSetter(NAME_NODE)
    public void setName(String s) {
        album.setName(s);
    }

    @JsonSetter(ARTIST_NODE)
    public void setArtist(String s) {
        album.setArtist(s);
    }

    public void append(Element element) {
        Document doc = element.getOwnerDocument();
        Element elmAlbum = doc.createElement(NODE_NAME);
        element.appendChild(elmAlbum);

        Element elmID = doc.createElement(ID_NODE);
        elmID.appendChild(doc.createTextNode(this.getId()));
        elmAlbum.appendChild(elmID);

        Element elmName = doc.createElement(NAME_NODE);
        elmName.appendChild(doc.createTextNode(this.getName()));
        elmAlbum.appendChild(elmName);

        Element elmArtist = doc.createElement(ARTIST_NODE);
        elmArtist.appendChild(doc.createTextNode(this.getArtist()));
        elmAlbum.appendChild(elmArtist);
    }

}
