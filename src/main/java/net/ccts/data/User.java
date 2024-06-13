package net.ccts.data;

import java.time.ZonedDateTime;
import java.util.ArrayList;

/**
 * This class represents a User with login credentials and personal details.
 */
public class User {

    private String login;  // Required variable, email address, unique per user
    private char[] password;  // Required variable
    private String firstName;  // Required variable
    private String lastName;
    private ZonedDateTime registered;
    private ZonedDateTime lastLogin;
    private int loginFailureCount;
    private ArrayList<UserQuestion> userQuestionList;  // Initialize to a new ArrayList with size of 3

    // Constructor that accepts parameters for the required member variables
    public User(String login, char[] password, String firstName) {
        setLogin(login);
        setPassword(password);
        setFirstName(firstName);
        this.userQuestionList = new ArrayList<>(3);
    }

    // Accessors (getters) and mutators (setters)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login == null || login.trim().isEmpty()) {
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
        if (firstName == null || firstName.trim().isEmpty()) {
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
        this.userQuestionList.add(q);
    }

    public UserQuestion fetchUserQuestion(int i) {
        return this.userQuestionList.get(i);
    }

    public void removeUserQuestion(int i) {
        this.userQuestionList.remove(i);
    }

    public ArrayList<UserQuestion> getUserQuestionList() {
        return userQuestionList;
    }

    @Override
    public String toString() {
        return firstName + " - " + login;
    }
}
