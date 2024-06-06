package net.ccts.data;
import java.util.ArrayList;
import java.time.ZonedDateTime;
/*
 * Activity 2.5.7
 *
 * A User class for the MediaLibrary program
 */
public class User{
    private String login;
    private char[] password;
    private String firstName;
    private String lastName;
    private ZonedDateTime registered;
    private ZonedDateTime lastLogin;
    private int loginFailureCount;
    private final ArrayList<UserQuestion> userQuestionList = new ArrayList<UserQuestion>(3);
public User(String l, char[] p, String f)
  {
    this.login = l;
    this.firstName = f;
    this.password = p;
  }
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
public void setLogin(String l) {
    if (l == null || l == ""){
        throw new IllegalArgumentException("Login is required");
    }
    login = l.toLowerCase();
  }
public void setPassword(char[] p) {
    if (p == null || p[0] == ' '){
        throw new IllegalArgumentException("Password is required");
    }
    password = p;
  }
public void setFirstName(String f) {
    if (f == null || f == ""){
        throw new IllegalArgumentException("First name is required");
    }
    firstName = f;
  }
public void setLastName(String l) {
    lastName = l;
  }
public void setRegistered(ZonedDateTime r) {
    registered = r;
  }
public void setLastLogin(ZonedDateTime l) {
    lastLogin = l;
  }
public void setLoginFailureCount(int f) {
    loginFailureCount = f;
  }
public UserQuestion fetchUserQuestion(int i){
  if (i < 0 || i >= userQuestionList.size()){
    throw new IllegalArgumentException("Index is out of bounds");
  }
  return userQuestionList.get(i);
  }
public void addUserQuestion(UserQuestion q){
    userQuestionList.add(q);
    }
public void removeUserQuestion(int i){
   if (i < 0 || i >= userQuestionList.size()){
    throw new IllegalArgumentException("Index is out of bounds");
  }
  UserQuestion q = userQuestionList.get(i);
  userQuestionList.remove(i);
}
@Override
public String toString() {
  String info = firstName + " - " + login;
  return info;
}
}