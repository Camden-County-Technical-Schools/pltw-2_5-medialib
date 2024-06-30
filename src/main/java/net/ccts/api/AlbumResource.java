package net.ccts.api;

import net.ccts.biz.MediaManager;
import net.ccts.biz.SessionManager;
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
        super.doInit();
        // Get the "id" attribute from the URI template /albums/{id}
        this.id = (String) getRequest().getAttributes().get(ALBUM_ID_PARAM);
        this.album = MediaManager.findAlbumById(this.id);
    }

    private String validateClientRequest(boolean tokenOnly) {
        if (sessionToken == null || sessionToken.isEmpty())
            return "Request invalid: no session token provided";
        if (SessionManager.findUserBySession(sessionToken) == null)
            return "Request invalid: session token invalid";
        if (tokenOnly)
            return null;

        if (this.id == null || this.id.isEmpty())
            return "Request invalid: " + ALBUM_ID_PARAM + " missing or empty";

        return null;
    }

    @Override
    @Get("json")
    public Representation getJsonRepresentation() {
        String validationMessage = this.validateClientRequest(false);
        if (validationMessage != null) {
            setStatus(Status.valueOf(400));
            return getErrorAsJSON(validationMessage);
        }
        if (this.album == null) {
            setStatus(Status.valueOf(404));
            return getErrorAsJSON("No album found with id " + this.id);
        }

        AlbumApiData data = new AlbumApiData(album);
        setStatus(Status.valueOf(200));
        return new JacksonRepresentation<AlbumApiData>(data);
    }

    @Override
    @Get("xml")
    public Representation getXmlRepresentation() throws IOException {
        String validationMessage = this.validateClientRequest(false);
        if (validationMessage != null) {
            setStatus(Status.valueOf(400));
            return getErrorAsJSON(validationMessage);
        }
        if (this.album == null) {
            setStatus(Status.valueOf(404));
            return getErrorAsJSON("No album found with id " + this.id);
        }

        DomRepresentation representation = new DomRepresentation(
                MediaType.TEXT_XML);
        Document d = representation.getDocument();
        Element apiElement = d.createElement(ApiResource.DOCUMENT_ELEMENT_NODE_NAME);
        d.appendChild(apiElement);

        AlbumApiData data = new AlbumApiData(this.album);
        data.append(apiElement);

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
            MediaManager.removeAlbum(this.album);
        }

        // Tells the client that the request has been successfully fulfilled.
        setStatus(Status.SUCCESS_NO_CONTENT);
    }

    /**
     * Handle PUT requests.
     *
     */
    @Put("json")
    public Representation putAlbum(Representation entity) {
        // The PUT request updates or creates the resource.
        String validationMessage = this.validateClientRequest(true);
        if (validationMessage != null) {
            setStatus(Status.valueOf(400));
        }
        if (this.album == null) {
            this.album = new Album("id", "name", "artist");
        }
        try {
            JacksonRepresentation<AlbumApiData> jackson = new JacksonRepresentation<>(entity, AlbumApiData.class);
            AlbumApiData apiData = jackson.getObject();
            Album toSave = apiData.getAlbum();
            MediaManager.addAlbum(toSave);
            setStatus(Status.SUCCESS_OK);
            return new JacksonRepresentation<>(new AlbumApiData(toSave));
        } catch (IOException e) {
            e.printStackTrace(System.err);
            setStatus(Status.valueOf(500));
            return getErrorAsJSON(e.getMessage());
        }
    }
}
