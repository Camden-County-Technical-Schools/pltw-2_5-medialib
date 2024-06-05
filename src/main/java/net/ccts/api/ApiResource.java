package net.ccts.api;

import org.restlet.data.Cookie;
import org.restlet.data.Header;
import org.restlet.data.MediaType;
import org.restlet.ext.xml.DomRepresentation;
import org.restlet.ext.jackson.*;
import org.restlet.representation.Representation;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import org.restlet.util.Series;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.IOException;

public abstract class ApiResource extends ServerResource {
    public static final String SESSION_TOKEN = "X-Session-Token";

    protected String sessionToken;

    public abstract Representation getXmlRepresentation() throws IOException;

    public abstract Representation getJsonRepresentation();

    @Override
    protected void doInit() throws ResourceException {
        super.doInit();
        this.sessionToken = findSessionToken();
    }

    public String findSessionToken() {
        String token = getHeaderValue(SESSION_TOKEN);
        if (token == null || token.isEmpty()) {
            token = getCookieValue(SESSION_TOKEN);
        }
        return token;
    }

    public String getHeaderValue(String header) {
        Series<Header> headers = getRequest().getHeaders();
        return headers.getFirstValue(header);
    }

    public void setHeaderValue(String header, String value) {
        Series<Header> headers = getRequest().getHeaders();
        headers.set(header, value);
    }

    public void addHeaderValue(String header, String value) {
        Series<Header> headers = getRequest().getHeaders();
        headers.add(header, value);
    }

    public String getCookieValue(String cookie) {
        Series<Cookie> cookies = getRequest().getCookies();
        return cookies.getFirstValue(cookie);
    }

    public void setCookieValue(String cookie, String value) {
        Series<Cookie> cookies = getRequest().getCookies();
        cookies.set(cookie, value);
    }

    public static Representation getErrorAsXML(String message) throws IOException {
          return getErrorAsXML(new ErrorApiData(message));
    }

    public static Representation getErrorAsXML(ErrorApiData error) throws IOException {
        DomRepresentation representation = new DomRepresentation(
                MediaType.TEXT_XML);
        Document d = representation.getDocument();

        Element elmError = d.createElement(ErrorApiData.NODE_NAME);
        d.appendChild(elmError);
        Element elmMessage = d.createElement(ErrorApiData.MESSAGE_NODE);
        elmMessage.appendChild(d.createTextNode(error.getMessage()));
        elmError.appendChild(elmMessage);

        d.normalizeDocument();
        return representation;
    }

    public static Representation getErrorAsJSON(String message) {
        return getErrorAsJSON(new ErrorApiData(message));
    }

    public static Representation getErrorAsJSON(ErrorApiData error) {
        return new JacksonRepresentation<ErrorApiData>(error);
    }

}
