package net.ccts.biz;
import net.ccts.data.*;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Arrays;


public class UserManager {

private static HashMap<String, User> userMap = new HashMap<>();
public static User registerUser(User u) {
    if(u == null){
        throw new IllegalArgumentException("User is required");
    }
    if(u.getRegistered() != null){
        throw new IllegalArgumentException("User is already registered");
    }
    if(userMap.get(u.getLogin()) != null){
        throw new IllegalArgumentException("User with " + u.getLogin() + "already exists, can't add new user");
    }
    if(u.getLogin() == null || u.getPassword() == null){
        throw new IllegalArgumentException("User should have a login and password");
    }
    if(u.getUserQuestionList().size() < 2){
        throw new IllegalArgumentException("User should have at least 2 questions");
    }
    u.setRegistered(ZonedDateTime.now());
    userMap.put(u.getLogin(), u);
    return u;
}
public static User handleLogin(String login, char[] password){
    if(userMap.get(login) == null)
        return null;

    User myUser = userMap.get(login);
    char[] myPassword = myUser.getPassword();
    if(!Arrays.equals(myPassword, password))
        return null;
    myUser.setLastLogin(ZonedDateTime.now());
    return myUser;
}
public static User findUser(String login){
    if(login == null)
        return null;
    return userMap.get(login);
}
}




