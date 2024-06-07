package net.ccts.api;

import net.ccts.biz.AlbumManager;
import net.ccts.data.Album;
import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.ext.xml.DomRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ResourceException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.IOException;

public class AlbumResource extends ApiResource {
    public static final String ALBUM_ID_PARAM = "id";

    private String id;
    private Album album;

    @Override
    protected void doInit() throws ResourceException {
        // Get the "id" attribute from the URI template /albums/{id}
        this.id = (String) getRequest().getAttributes().get(ALBUM_ID_PARAM);
        this.album = AlbumManager.findAlbum(this.id);
        setExisting(this.album != null);
    }

    private String validateClientRequest() {
        if (sessionToken == null || sessionToken.isEmpty())
            return "Request invalid: no session token provided";
        if (this.id == null || this.id.isEmpty())
            return "Request invalid: " + ALBUM_ID_PARAM + " missing or empty";
        if (this.album == null)
            return "Request invalid: " + ALBUM_ID_PARAM + " " + this.id + " not found";

        return null;
    }

    @Override
    @Get("json")
    public Representation getJsonRepresentation() {
        String validationMessage = this.validateClientRequest();
        if (validationMessage != null) {
            setStatus(Status.valueOf(400));
            return getErrorAsJSON(validationMessage);
        }
        AlbumApiData data = new AlbumApiData(this.album);
        setStatus(Status.valueOf(200));
        return new JacksonRepresentation<AlbumApiData>(data);
    }

    @Override
    @Get("xml")
    public Representation getXmlRepresentation() throws IOException {
        DomRepresentation representation = new DomRepresentation(
                MediaType.TEXT_XML);
        // Generate a DOM document representing the item.
        Document d = representation.getDocument();

        Element elmAlbum = d.createElement(AlbumApiData.NODE_NAME);
        d.appendChild(elmAlbum);
        Element elmId = d.createElement("id");
        elmId.appendChild(d.createTextNode(this.album.getId()));
        elmAlbum.appendChild(elmId);
        Element elmTitle = d.createElement("title");
        elmTitle.appendChild(d.createTextNode(this.album.getTitle()));
        elmAlbum.appendChild(elmTitle);
        Element elmArtist = d.createElement("artist");
        elmArtist.appendChild(d.createTextNode(this.album.getArtist()));
        elmAlbum.appendChild(elmArtist);
        Element elmRating = d.createElement("rating");
        elmRating.appendChild(d.createTextNode(String.valueOf(this.album.getRating())));
        elmAlbum.appendChild(elmRating);
        Element elmNumTracks = d.createElement("numTracks");
        elmNumTracks.appendChild(d.createTextNode(String.valueOf(this.album.getNumTracks())));
        elmAlbum.appendChild(elmNumTracks);
        Element elmGenre = d.createElement("genre");
        elmGenre.appendChild(d.createTextNode(this.album.getGenre()));
        elmAlbum.appendChild(elmGenre);

        d.normalizeDocument();
        setStatus(Status.SUCCESS_OK);
        // Returns the XML representation of this document.
        return representation;
    }

    /**
     * Handle DELETE requests.
     */
    @Delete
    public void removeAlbum() {
        if (this.album != null) {
            // Remove the album from AlbumManager
            AlbumManager.removeAlbum(this.album);
        }

        // Tells the client that the request has been successfully fulfilled.
        setStatus(Status.SUCCESS_NO_CONTENT);
    }

    /**
     * Handle PUT requests.
     *
     * @throws IOException
     */
    @Put
    public void registerAlbum(Representation entity) throws IOException {
        // The PUT request updates or creates the resource.
        if (this.album == null) {
            this.album = new Album(this.id, "default title", "default artist");
        }

        // Update the description.
        Form form = new Form(entity);
        album.setTitle(form.getFirstValue("title"));
        album.setArtist(form.getFirstValue("artist"));
        album.setRating(Integer.parseInt(form.getFirstValue("rating")));
        album.setNumTracks(Integer.parseInt(form.getFirstValue("numTracks")));
        album.setGenre(form.getFirstValue("genre"));

        // Wrap in try/catch if necessary
        this.album = AlbumManager.registerAlbum(this.album);

        setStatus(Status.SUCCESS_OK);
    }
}
