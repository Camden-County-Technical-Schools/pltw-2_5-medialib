package net.ccts.api;

import net.ccts.biz.UserManager;
import net.ccts.data.User;
import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.data.Parameter;
import org.restlet.data.Status;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.ext.xml.DomRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.IOException;
import java.util.Map;

public class SessionResource extends ApiResource {
    private String sessionId;

    @Override
    protected void doInit() throws ResourceException {
        super.doInit();
        this.sessionId = (String) getRequest().getAttributes().get(SessionApiData.SESSION_ID_NODE);
    }

    @Override
    @Get("json")
    public Representation getJsonRepresentation() {
        if (this.sessionId == null || this.sessionId.isEmpty()) {
            setStatus(Status.valueOf(400));
            return getErrorAsJSON("Session ID is required");
        }
        User bySession = UserManager.findUserBySession(this.sessionId);
        if (bySession == null) {
            setStatus(Status.valueOf(404));
            return getErrorAsJSON("No session found");
        }
        SessionApiData session = new SessionApiData(bySession, this.sessionId);
        setStatus(Status.valueOf(200));
        return new JacksonRepresentation<SessionApiData>(session);
    }

    @Override
    @Get("xml")
    public Representation getXmlRepresentation() throws IOException {
        if (this.sessionId == null || this.sessionId.isEmpty()) {
            setStatus(Status.valueOf(400));
            return getErrorAsJSON("Session ID is required");
        }
        User bySession = UserManager.findUserBySession(this.sessionId);
        if (bySession == null) {
            setStatus(Status.valueOf(404));
            return getErrorAsJSON("No session found");
        }

        DomRepresentation representation = new DomRepresentation(
                MediaType.TEXT_XML);
        Document d = representation.getDocument();
        Element apiElement = d.createElement(ApiResource.DOCUMENT_ELEMENT_NODE_NAME);
        d.appendChild(apiElement);

        SessionApiData session = new SessionApiData(bySession, this.sessionId);
        session.append(apiElement);

        d.normalizeDocument();
        setStatus(Status.SUCCESS_OK);
        // Returns the XML representation of this document.
        return representation;
    }

    /**
     * Handle DELETE requests.
     */
    @Delete
    public void removeSession() {
        if (this.sessionId == null || this.sessionId.isEmpty()) {
            setStatus(Status.valueOf(400));
        } else {
            UserManager.removeSession(this.sessionId);
            setStatus(Status.SUCCESS_NO_CONTENT);
        }
    }

    @Post
    public Representation loginJson(Representation entity) throws IOException {
        User user = this.handleLogin(entity);
        if (user == null) {
            setStatus(Status.valueOf(400));
            return getErrorAsJSON("Login failed");
        } else {
            SessionApiData sessionData = new SessionApiData(user);
            setStatus(Status.valueOf(200));
            return new JacksonRepresentation<SessionApiData>(sessionData);
        }
    }

    @Post("xml")
    public Representation loginXml(Representation entity) throws IOException {
        User user = this.handleLogin(entity);
        if (user == null) {
            setStatus(Status.valueOf(400));
            return getErrorAsXML("Login failed");
        } else {
            DomRepresentation representation = new DomRepresentation(
                    MediaType.TEXT_XML);
            Document d = representation.getDocument();
            Element apiElement = d.createElement(ApiResource.DOCUMENT_ELEMENT_NODE_NAME);
            d.appendChild(apiElement);

            SessionApiData sessionData = new SessionApiData(user);
            sessionData.append(apiElement);

            d.normalizeDocument();

            setStatus(Status.valueOf(200));
            return new JacksonRepresentation<SessionApiData>(sessionData);
        }
    }

    private User handleLogin(Representation entity) {
        Form form = new Form(entity);
        String login = form.getFirstValue(SessionApiData.LOGIN_NODE);
        char[] password = form.getFirstValue(SessionApiData.PASSWORD_NODE, true, "").toCharArray();

        return UserManager.handleLogin(login, password);
    }

}
