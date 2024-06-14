package net.ccts.data;

import java.time.ZonedDateTime;
import java.util.ArrayList;

/**
 * This class represents a user with login credentials and profile information.
 */
public class User {

    // Internal member variables
    private String login;
    private char[] password;
    private String firstName;
    private String lastName;
    private ZonedDateTime registered;
    private ZonedDateTime lastLogin;
    private int loginFailureCount;
    private ArrayList<UserQuestion> userQuestionList;

    // Constructor
    public User(String login, char[] password, String firstName) {
        this.setLogin(login);
        this.setPassword(password);
        this.setFirstName(firstName);
        this.lastLogin = null;
        this.loginFailureCount = 0;
        this.userQuestionList = new ArrayList<>(3);
    }

    // Accessor methods
    public String getLogin() {
        return login;
    }

    public char[] getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ZonedDateTime getRegistered() {
        return registered;
    }

    public ZonedDateTime getLastLogin() {
        return lastLogin;
    }

    public int getLoginFailureCount() {
        return loginFailureCount;
    }

    // Mutator methods
    public void setLogin(String login) {
        if (login == null || login.isEmpty()) {
            throw new IllegalArgumentException("Login is required");
        }
        this.login = login.toLowerCase();
    }

    public void setPassword(char[] password) {
        if (password == null || password.length == 0) {
            throw new IllegalArgumentException("Password is required");
        }
        this.password = password;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name is required");
        }
        this.firstName = firstName;
    }

    public void setRegistered(ZonedDateTime r) {
        this.registered = r; 

    }

    public void setLastLogin(ZonedDateTime l) {
        this.lastLogin = l; 

    }

    public void setLoginFailureCount(int f) {
        this.loginFailureCount = f;

    }

    // Methods for userQuestionList
    public void addUserQuestion(UserQuestion q) {
        userQuestionList.add(q);
    }

    public UserQuestion fetchUserQuestion(int i) {
        return userQuestionList.get(i);
    }

    public UserQuestion removeUserQuestion(int i) {
        return userQuestionList.remove(i);
    }

    public ArrayList<UserQuestion> getUserQuestionList() {
        return userQuestionList;
    }

    // Override toString method
    @Override
    public String toString() {
        return firstName + " - " + login;
    }
}
