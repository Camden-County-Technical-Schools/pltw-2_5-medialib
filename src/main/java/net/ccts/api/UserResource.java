package net.ccts.api;

import net.ccts.biz.UserManager;
import net.ccts.data.User;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.ext.xml.DomRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
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
        // Get the "login" attribute from the URI template /users/{login}
        this.login = (String) getRequest().getAttributes().get(USER_LOGIN_PARAM);
        this.user = UserManager.findUser(this.login);
        setExisting(this.user != null);
    }

    private String validateClientRequest() {
        if (sessionToken == null || sessionToken.isEmpty())
            return "Request invalid: no session token provided";
        if (this.login == null || this.login.isEmpty())
            return "Request invalid: " + USER_LOGIN_PARAM + " missing or empty";
        if (this.user == null)
            return "Request invalid: " + USER_LOGIN_PARAM + " " + this.login + " not found";

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
        UserApiData data = new UserApiData(this.user);
        return new JacksonRepresentation<UserApiData>(data);
    }

    @Override
    @Get("xml")
    public Representation getXmlRepresentation() throws IOException {
        DomRepresentation representation = new DomRepresentation(
                MediaType.TEXT_XML);
        // Generate a DOM document representing the item.
        Document d = representation.getDocument();

        Element elmUser = d.createElement("user");
        d.appendChild(elmUser);
        Element elmLogin = d.createElement("login");
        elmLogin.appendChild(d.createTextNode(this.user.getLogin()));
        elmUser.appendChild(elmLogin);



        d.normalizeDocument();

        // Returns the XML representation of this document.
        return representation;
    }

}
