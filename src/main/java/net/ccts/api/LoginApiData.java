package net.ccts.api;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonRootName(value = LoginApiData.NODE_NAME)
public class LoginApiData {
    public static final String NODE_NAME = "login";
    public static final String USERNAME_NODE = "username";
    public static final String PASSWORD_NODE = "password";

    private String username;
    private char[] password;

    public LoginApiData() {
        //empty ctor
    }

    @JsonGetter(USERNAME_NODE)
    public String getUsername() {
        return username;
    }

    @JsonSetter(USERNAME_NODE)
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonGetter(PASSWORD_NODE)
    public char[] getPassword() {
        return password;
    }

    @JsonSetter(PASSWORD_NODE)
    public void setPassword(char[] password) {
        this.password = password;
    }
}
