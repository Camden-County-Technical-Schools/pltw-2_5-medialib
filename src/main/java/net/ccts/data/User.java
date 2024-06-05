package net.ccts.data;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class User {
    private String login;
    private char[] password;
    private String firstName;
    private String lastName;
    private ZonedDateTime registered;
    private ZonedDateTime lastLogin;
    private int loginFailureCount;
    private ArrayList<UserQuestion> userQuestionList;
/** This gets the username and passowrd of the user */
    public User(String login, char[] password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.userQuestionList = new ArrayList<>(); 
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) { 
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
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
        return new ArrayList<>(this.userQuestionList);
    }

    public String toString() {
        return firstName + "-" + login;
    }
}
