package net.ccts.api;

import net.ccts.biz.BookManager;
import net.ccts.data.Book;
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

public class BookResource extends ApiResource {
    public static final String BOOK_ID_PARAM = "id";

    private String id;
    private Book book;

    @Override
    protected void doInit() throws ResourceException {
        // Get the "id" attribute from the URI template /books/{id}
        this.id = (String) getRequest().getAttributes().get(BOOK_ID_PARAM);
        this.book = BookManager.findBook(this.id);
        setExisting(this.book != null);
    }

    private String validateClientRequest() {
        if (sessionToken == null || sessionToken.isEmpty())
            return "Request invalid: no session token provided";
        if (this.id == null || this.id.isEmpty())
            return "Request invalid: " + BOOK_ID_PARAM + " missing or empty";
        if (this.book == null)
            return "Request invalid: " + BOOK_ID_PARAM + " " + this.id + " not found";

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
        BookApiData data = new BookApiData(this.book);
        setStatus(Status.valueOf(200));
        return new JacksonRepresentation<>(data);
    }

    @Override
    @Get("xml")
    public Representation getXmlRepresentation() throws IOException {
        DomRepresentation representation = new DomRepresentation(MediaType.TEXT_XML);
        // Generate a DOM document representing the item.
        Document d = representation.getDocument();

        Element elmBook = d.createElement(BookApiData.NODE_NAME);
        d.appendChild(elmBook);
        Element elmId = d.createElement("id");
        elmId.appendChild(d.createTextNode(this.book.getId()));
        elmBook.appendChild(elmId);
        Element elmTitle = d.createElement("title");
        elmTitle.appendChild(d.createTextNode(this.book.getTitle()));
        elmBook.appendChild(elmTitle);
        Element elmAuthor = d.createElement("author");
        elmAuthor.appendChild(d.createTextNode(this.book.getAuthor()));
        elmBook.appendChild(elmAuthor);
        Element elmRating = d.createElement("rating");
        elmRating.appendChild(d.createTextNode(Integer.toString(this.book.getRating())));
        elmBook.appendChild(elmRating);
        
        d.normalizeDocument();
        setStatus(Status.SUCCESS_OK);
        // Returns the XML representation of this document.
        return representation;
    }

    /**
     * Handle DELETE requests.
     */
    @Delete
    public void removeBook() {
        if (this.book != null) {
            // Remove the book from BookManager
            BookManager.removeBook(this.book);
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
    public void registerBook(Representation entity) throws IOException {
        // The PUT request updates or creates the resource.
        if (this.book == null) {
            this.book = new Book(this.id, "default title", "default author");
        }

        // Update the details
        Form form = new Form(entity);
        book.setTitle(form.getFirstValue("title"));
        book.setAuthor(form.getFirstValue("author"));
        // TODO: set other fields as necessary

        // TODO: wrap in try/catch
        this.book = BookManager.registerBook(this.book);

        setStatus(Status.SUCCESS_OK);
    }
}
