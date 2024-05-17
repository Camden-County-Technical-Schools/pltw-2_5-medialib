package net.ccts.data;



import java.util.ArrayList;
import java.time.ZonedDateTime;
/* A UserClass that asks for personal things from the User like: Their address, etc...*/



public class User{

    private String login;
    private char[] password;
    private String firstName;
    private String lastName;
    private ZonedDateTime registered;
    private ZonedDateTime lastLogin;
    private int loginFailureCount;
    private ArrayList<UserQuestion> userQuestionList = new ArrayList<>(3);

    public User(String f, String l, char[] p){
        this.firstName = f;
        this.login = l;
        this.password = p;
    }

    public String getLogin(){
        return this.login;
    }

    public char[] getPassword(){
        return this.password;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public ZonedDateTime getRegistered(){
        return this.registered;
    }

    public ZonedDateTime getLastLogin(){
        return this.lastLogin;
    }

    public int getLoginFailureCount(){
        return this.loginFailureCount;
    }

    public void setLogin(String l){
        if ((l.equals(null)) || (l.equals("")) ){
            throw new IllegalArgumentException("Login is required");
        }
        this.login = l;
    }

    public void setPassword(char[] p){
        if ((p == null) || (p[0] == ' ')){
            throw new IllegalArgumentException("Password is required");
        }
        this.password = p;
    }

    public void setFirstName(String f){
        if((f.equals(null)) || (f.equals(""))){
            throw new IllegalArgumentException("First name is required");
        }
        this.firstName = f;
    }

    public void setLastName(String n){
        this.lastName = n;
    }

    public void setRegistered(ZonedDateTime r){
        this.registered = r;
    }

    public void setLastLogin(ZonedDateTime h){
        this.lastLogin = h;
    }

    public void setLoginFailureCount(int c){
        this.loginFailureCount = c;
    }

    public UserQuestion fetchUserQuestion(int i){
        return userQuestionList.get(i);
    }

    public ArrayList<UserQuestion> getUserQuestionList(){
        return userQuestionList;
    }

    public void addUserQuestion(UserQuestion q){
        this.userQuestionList.add(q);
    }

    public void removeUserQuestion(int i){
        this.userQuestionList.remove(i);
    }

     @Override
    public String toString() {
        return "First name: " + this.firstName + " Login: " + this.login;
    }

}