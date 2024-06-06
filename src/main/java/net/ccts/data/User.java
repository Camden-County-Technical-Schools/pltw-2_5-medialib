package net.ccts.data;

import java.util.ArrayList;
import java.time.ZonedDateTime;

public class User{

    private String login;
    private char[] password;
    private String firstName;
    private String lastName;
    private ZonedDateTime registered;
    private ZonedDateTime lastLogin;
    private int loginFailureCount;
    private ArrayList<UserQuestion> userQuestionList;

    public User(String login, char[] password, String firstName, String lastName) {
        setLogin(login);
        setPassword(password);
        setFirstName(firstName);
        this.lastName = lastName;
        this.registered = ZonedDateTime.now();
        this.lastLogin = null;
        this.loginFailureCount = 0;
        this.userQuestionList = new ArrayList<>(3);
    }
    public ZonedDateTime getLastLogin() {
    return lastLogin;
    }
    public void setLastLogin(ZonedDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
    public String getLogin(){
        return login;
    }
    
    public void setLogin(String login){
        if (login == null || login.isEmpty()) throw new IllegalArgumentException("Login is required");
        this.login = login.toLowerCase();
    }
    public char[] getPassword(){
        return password;
    }

    public void setPassword(char[] password){
        if (password == null || password.length == 0) throw new IllegalArgumentException("Password is required");
        this.password = password;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        if (firstName == null || firstName.isEmpty()) 
        {throw new IllegalArgumentException("First name is required");}
        this.firstName = firstName;
    }
    public void addUserQuestion(UserQuestion q) {
        userQuestionList.add(q);
    }
      public UserQuestion fetchUserQuestion(int i) {
        return userQuestionList.get(i);
    }
    public ZonedDateTime getRegistered() {
        return registered;
    }

    public void setRegistered(ZonedDateTime registered) {
        this.registered = registered;
    }

    public void removeUserQuestion(int i) {
        userQuestionList.remove(i);
    }

    public ArrayList<UserQuestion> getUserQuestionList() {
        return userQuestionList;
    }

    // toString method override
    @Override
    public String toString() {
        return firstName + " - " + login;
    }
}