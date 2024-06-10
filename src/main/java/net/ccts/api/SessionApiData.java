package net.ccts.api;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import net.ccts.data.User;
import net.ccts.data.UserQuestion;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.UUID;

@JsonRootName(value = SessionApiData.NODE_NAME)
public class SessionApiData {
    public static final String NODE_NAME = "session";
    public static final String LOGIN_NODE = "login";
    public static final String PASSWORD_NODE = "password";
    public static final String SESSION_ID_NODE = "sessionId";

    private String login;
    private char[] password;
    private String sessionId;

    public SessionApiData(String login, char[] password) {
        this.login = login;
        this.password = password;
    }

    public SessionApiData(User u, String sessionId) {
        this.login = u.getLogin();
        this.password = u.getPassword();
        this.sessionId = sessionId;
    }

    public SessionApiData(User u) {
        this.login = u.getLogin();
        this.password = u.getPassword();
        this.sessionId = UUID.randomUUID().toString();
    }

    @JsonGetter(LOGIN_NODE)
    public String getLogin() {
        return this.login;
    }

    @JsonIgnore
    public char[] getPassword() {
        return this.password;
    }

    @JsonGetter(SESSION_ID_NODE)
    public String getSessionId() {
        return this.sessionId;
    }

    public void append(Element element) {
        Document doc = element.getOwnerDocument();
        Element elmSession = doc.createElement(NODE_NAME);
        element.appendChild(elmSession);

        Element elmLogin = doc.createElement(LOGIN_NODE);
        elmLogin.appendChild(doc.createTextNode(this.getLogin()));
        elmSession.appendChild(elmLogin);

        Element elmSessionId = doc.createElement(SESSION_ID_NODE);
        elmSessionId.appendChild(doc.createTextNode(this.getSessionId()));
        elmSession.appendChild(elmSessionId);
    }

}
