package net.ccts.data;

import java.time.ZonedDateTime;
import java.util.ArrayList;

/**
 * The User class represents a user with a unique login, password, first name, last name, registration time, last login time, login failure count, and a list of user questions.
 */
public class User {
    private String login; // Required variable. Will be an email address and unique per user.
    private char[] password; // Required variable.
    private String firstName; // Required variable.
    private String lastName; // Required variable.
    private ZonedDateTime registered;
    private ZonedDateTime lastLogin;
    private int loginFailureCount;
    private ArrayList<UserQuestion> userQuestionList = new ArrayList<>(3);

    // Constructor for the required member variables
    public User(String login, char[] password, String firstName, String lastName) {
        setLogin(login);
        setPassword(password);
        setFirstName(firstName);
        this.lastName = lastName;
        this.registered = ZonedDateTime.now();
        this.lastLogin = null;
        this.loginFailureCount = 0;
    }

    // Accessor and mutator methods
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login == null || login.isEmpty()) {
            throw new IllegalArgumentException("Login is required");
        }
        this.login = login.toLowerCase();
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        if (password == null || password.length == 0 || password[0] == ' ') {
            throw new IllegalArgumentException("Password is required");
        }
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name is required");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ZonedDateTime getRegistered() {
        return registered;
    }

    public void setRegistered(ZonedDateTime registered) {
        this.registered = registered;
    }

    public ZonedDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(ZonedDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public int getLoginFailureCount() {
        return loginFailureCount;
    }

    public void setLoginFailureCount(int loginFailureCount) {
        this.loginFailureCount = loginFailureCount;
    }

    // Methods for userQuestionList
    public void addUserQuestion(UserQuestion q) {
        userQuestionList.add(q);
    }

    public UserQuestion fetchUserQuestion(int i) {
        return userQuestionList.get(i);
    }

    public void removeUserQuestion(int i) {
        userQuestionList.remove(i);
    }

    public ArrayList<UserQuestion> getUserQuestionList() {
        return userQuestionList;
    }

    @Override
    public String toString() {
        return firstName + " - " + login;
    }
}
