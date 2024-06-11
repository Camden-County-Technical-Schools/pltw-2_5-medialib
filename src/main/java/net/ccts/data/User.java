package net.ccts.data;
import java.time.ZonedDateTime;
import java.util.ArrayList;

//Get's user information to sign them in

public class User {

    private String login;
    private char[] password;
    private String firstName;
    private String lastName;
    private ZonedDateTime registered;
    private ZonedDateTime lastLogin;
    private int loginFailureCount;

private ArrayList<UserQuestion> userQuestionList = new ArrayList<>(3);

public User(String l, char[] c, String f) {
    
    login = l;
    password = c;
    firstName = f;

}

//setters
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

//mutators

public void setLogin(String l) { 
    if(l == null || l == "") {
        throw new IllegalArgumentException("Login is required");
    }
    login = l.toLowerCase();
}

public void setPassword(char[] p) {
     if(p == null || p[0] == ' ') {
        throw new IllegalArgumentException("Password is required");
    }
    password = p;
}

public void setFirstName(String f) {
     if(f == null || f == "") {
        throw new IllegalArgumentException("First name  is required");
    }
    firstName = f;
}

public void setLastName(String ln) {
    lastName = ln;
}

public void setRegistered(ZonedDateTime r) {
    registered = r;
}

public void setLastLogin(ZonedDateTime ll) {
    lastLogin = ll;
}

public void setLoginFailureCount(int lfc) {
    loginFailureCount = lfc;
}

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




