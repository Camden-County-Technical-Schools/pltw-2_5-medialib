package net.ccts.data;

import java.time.ZonedDateTime;
import java.util.ArrayList;

/**
 * The User class represents a user with login credentials, 
 * personal information, and a list of security questions.
 */
public class User {

    private String login;
    private char[] password;
    private String firstName;
    private String lastName;
    private ZonedDateTime registered;
    private ZonedDateTime lastLogin;
    private int loginFailureCount;
    private ArrayList<UserQuestion> userQuestionList;

    // Constructor for the User class.
    public User(String login, char[] password, String firstName) {
        setLogin(login);
        setPassword(password);
        setFirstName(firstName);
        this.userQuestionList = new ArrayList<>(3);
    }

    // Accessors (getters)
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

    public ArrayList<UserQuestion> getUserQuestionList() {
        return userQuestionList;
    }

    // Mutators (setters)
    public void setLogin(String login) {
        if (login == null || login.isEmpty()) {
            throw new IllegalArgumentException("Login is required");
        }
        this.login = login.toLowerCase();
    }

    public void setPassword(char[] password) {
        if (password == null || password.length == 0 || password[0] == ' ') {
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRegistered(ZonedDateTime registered) {
        this.registered = registered;
    }

    public void setLastLogin(ZonedDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setLoginFailureCount(int loginFailureCount) {
        this.loginFailureCount = loginFailureCount;
    }

    // Methods for userQuestionList
    public void addUserQuestion(UserQuestion q) {
        this.userQuestionList.add(q);
    }

    public UserQuestion fetchUserQuestion(int i) {
        if (i < 0 || i >= this.userQuestionList.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return this.userQuestionList.get(i);
    }

    public void removeUserQuestion(int i) {
        if (i < 0 || i >= this.userQuestionList.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        this.userQuestionList.remove(i);
    }

    @Override
    public String toString() {
        return firstName + " - " + login;
    }
}
