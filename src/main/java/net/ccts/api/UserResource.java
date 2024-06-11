package net.ccts.api;

import net.ccts.biz.UserManager;
import net.ccts.data.User;
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

public class UserResource extends ApiResource {
    public static final String USER_LOGIN_PARAM = "login";

    private String login;
    private User user;

    @Override
    protected void doInit() throws ResourceException {
        super.doInit();
        // Get the "login" attribute from the URI template /users/{login}
        this.login = (String) getRequest().getAttributes().get(USER_LOGIN_PARAM);
        this.user = UserManager.findUser(this.login);
    }

    private String validateClientRequest() {
        if (validateSessionToken())
            return "Request invalid: no valid session token provided";
        if (this.login == null || this.login.isEmpty())
            return "Request invalid: " + USER_LOGIN_PARAM + " missing or empty";

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
        if (this.user == null) {
            setStatus(Status.valueOf(404));
            return getErrorAsJSON("User not found");
        }
        UserApiData data = new UserApiData(this.user);
        setStatus(Status.valueOf(200));
        return new JacksonRepresentation<UserApiData>(data);
    }

    @Override
    @Get("xml")
    public Representation getXmlRepresentation() throws IOException {
        String validationMessage = this.validateClientRequest();
        if (validationMessage != null) {
            setStatus(Status.valueOf(400));
            return getErrorAsXML(validationMessage);
        }
        if (this.user == null) {
            setStatus(Status.valueOf(404));
            return getErrorAsXML("User not found");
        }

        DomRepresentation representation = new DomRepresentation(
                MediaType.TEXT_XML);
        Document d = representation.getDocument();
        Element apiElement = d.createElement(ApiResource.DOCUMENT_ELEMENT_NODE_NAME);
        d.appendChild(apiElement);

        UserApiData userApiData = new UserApiData(this.user);
        userApiData.append(apiElement);

        d.normalizeDocument();
        setStatus(Status.SUCCESS_OK);
        // Returns the XML representation of this document.
        return representation;
    }

    /**
     * Handle DELETE requests.
     */
    @Delete
    public void removeUser() {
        String validationMessage = this.validateClientRequest();
        if (validationMessage != null) {
            setStatus(Status.valueOf(400));
        } else if (this.user == null) {
            setStatus(Status.valueOf(404));
            setExisting(false);
        } else {
            UserManager.removeUser(this.user);

            // Tells the client that the request has been successfully fulfilled.
            setStatus(Status.SUCCESS_NO_CONTENT);
        }
    }

    /**
     * Handle PUT requests.
     *
     * @throws IOException
     */
    @Put
    public void registerUser(Representation entity) throws IOException {
        // The PUT request updates or creates the resource.
        if (this.user == null) {
            this.user = new User(this.login, new char[] {'c','h','a','n','g','e'},
                    "change this");
        }

        // Update the description.
        Form form = new Form(entity);
        user.setFirstName(form.getFirstValue(UserApiData.FIRSTNAME_NODE));
        //TODO - set other fields

        try {
            if (this.user.getRegistered() == null)
                this.user = UserManager.registerUser(this.user);
            else
                this.user = UserManager.updateUser(this.user);

            setStatus(Status.SUCCESS_OK);
        } catch (Exception e) {
            setStatus(Status.SERVER_ERROR_INTERNAL);
        }
    }

}
