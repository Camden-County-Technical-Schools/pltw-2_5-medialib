package net.ccts.api;

import net.ccts.biz.SessionManager;
import net.ccts.biz.UserManager;
import net.ccts.data.User;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.ext.xml.DomRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.IOException;

public class SessionResource extends ApiResource {
    public static final String SESSION_ID_PARAM = "sessionId";

    private String sessionId;

    @Override
    protected void doInit() throws ResourceException {
        super.doInit();
        this.sessionId = (String) getRequest().getAttributes().get(SESSION_ID_PARAM);
    }

    private String validateClientRequest() {
        if (!super.validateSessionToken())
            return "Request invalid: no valid session token provided";

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

        if (this.sessionId == null || this.sessionId.isEmpty()) {
            setStatus(Status.valueOf(400));
            return getErrorAsJSON("Session ID is required");
        }
        User bySession = SessionManager.findUserBySession(this.sessionId);
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
        String validationMessage = this.validateClientRequest();
        if (validationMessage != null) {
            setStatus(Status.valueOf(400));
            return getErrorAsXML(validationMessage);
        }

        if (this.sessionId == null || this.sessionId.isEmpty()) {
            setStatus(Status.valueOf(400));
            return getErrorAsXML("Session ID is required");
        }
        User bySession = SessionManager.findUserBySession(this.sessionId);
        if (bySession == null) {
            setStatus(Status.valueOf(404));
            return getErrorAsXML("No session found");
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
        String validationMessage = this.validateClientRequest();
        if (validationMessage != null) {
            setStatus(Status.valueOf(400));
        }
        if (this.sessionId == null || this.sessionId.isEmpty()) {
            setStatus(Status.valueOf(400));
        } else {
            SessionManager.removeSession(this.sessionId);
            setStatus(Status.SUCCESS_NO_CONTENT);
        }
    }

    @Post("json")
    public Representation loginJson(Representation entity) {
        try {
            JacksonRepresentation<LoginApiData> jackson = new JacksonRepresentation<>(entity, LoginApiData.class);
            LoginApiData loginApiData = jackson.getObject();

            User user = UserManager.handleLogin(loginApiData.getUsername(), loginApiData.getPassword());
            if (user == null) {
                setStatus(Status.valueOf(400));
                return getErrorAsJSON("Login failed");
            } else {
                SessionApiData sessionData = SessionManager.createSession(user);
                setStatus(Status.valueOf(200));
                return new JacksonRepresentation<SessionApiData>(sessionData);
            }
        } catch (IOException e) {
            e.printStackTrace(System.err);
            setStatus(Status.valueOf(500));
            return getErrorAsJSON(e.getMessage());
        }
    }

}
