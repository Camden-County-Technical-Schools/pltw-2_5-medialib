package net.ccts.data;
import java.util.ArrayList;
import java.time.ZonedDateTime;
public class User{
    private String login;
    private char[] password;
    private String firstName;
    private String lastName;
    private java.time.ZonedDateTime registered;
    private java.time.ZonedDateTime lastLogin;
    private java.util.ArrayList<UserQuestion> userQuestionList = new ArrayList <UserQuestion> (3);
    private int loginFailureCount;

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
public char[] getPassword(){
    return password;
}
public String getLastName(){
    return lastName;
}
public int getLoginFailureCount(){
    return loginFailureCount;
}
public ZonedDateTime getRegistered (){
    return registered;
}
public ZonedDateTime getLastLogin(){
    return lastLogin;
}
public ArrayList<UserQuestion> getUserQuestionList(){
    return userQuestionList;
}
public void setRegistered(ZonedDateTime r){
registered = r;
}
public void setLastLogin(ZonedDateTime lL){
    lastLogin = lL;
}
public void setLastName(String lN){
    lastName = lN;
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

}
