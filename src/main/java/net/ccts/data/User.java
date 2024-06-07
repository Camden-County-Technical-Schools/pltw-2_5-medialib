package net.ccts.data;
import java.util.ArrayList;
public class User(){
    private String login;
    private char[] password;
    private String firstName;
    private java.time.ZonedDateTime Regestered;
    private java.time.ZonedDateTime lastLogin;
    private java.util.ArrayList<UserQuestion> UserQuestionList = new ArrayList <UserQuestion> (3);
}
public User(String l, String fN, char[] p){
    login = l;
    firstName = fN;
    password = p;       
}

public String getLogin(){
    return login;
}
public String getFirstName(){
    return firstName;
}
public String getPassWord(){
    return password;
}
public void setLogin(String l){
    if(l == null||l.length() == 0){
      throw new IllegalArgumentException ("Login is required");
    }
    login = l;
}
public void setFirstName(String fN){
     if(fN == null || fN.length() == 0){
      throw new IllegalArgumentException ("Login is required");
    }
    firstName = fN;
}
public void setPassword(char[] p){
     if( p == null || p.length == 0){
      throw new IllegalArgumentException ("password is required");
    }
    password = p;
}

