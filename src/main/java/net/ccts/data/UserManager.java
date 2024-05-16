package net.ccts.data;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.HashMap;


/**
 * A public class that manages user registration, finding the user, and handling user logins
 * using implementations from the User class
 * @author AkiotheChaoticPan
 */
public class UserManager {

    private static HashMap<String, User> userMap = new HashMap<>();

    // methods

    /**
     * a method that registers user, first checking if a user is provided, then checks if the user is 
     * already registered, if the login name already exists, if there is no user login or password, and
     * if the userQuestionList contains at least 2 questions
     * @param u - a parameter containing all details in the User class
     * @return u - created user
     */
    public static User registerUser(User u) {

        if (u == null) throw new IllegalArgumentException("User is required.");

        else if (u.getRegistered() != null) throw new IllegalArgumentException("User is already registered.");

        // login specific statements

        else if (userMap.containsKey(u.getLogin())) throw new IllegalArgumentException(
            "User with login " + u.getLogin() + " already exists, can't add new user."
        );
        else if (u.getLogin() == null || u.getPassword() == null) throw new IllegalArgumentException(
            "User needs login and password."
        );
        else if (u.getUserQuestionList().size() < 2) throw new IllegalArgumentException(
            "User should have at least two questions."
        );
        else {
            u.setRegistered(ZonedDateTime.now());
            userMap.put(u.getLogin(), u);
        }
        return u;
        
    }

    /**
     * check if the userMap contains the login or password, return null if the login does not exist or 
     * if the password does not fit the login
     * @return temp - the login with the working password, return null if there is no matching passwords or if the login does not exist
     */
    public static User handleLogin(String login, char[] password) {
        User temp = userMap.get(login);

        if (temp == null) return temp;
        
        char[] t= temp.getPassword();
        if (!(Arrays.equals(password, t))) return null;
        
        return temp;
    }

    /**
     * look up the login and see if it exists
     * @param login - provided user login
     * @return userMap.get(login) - return the user found with the provided input, return null if empty
     */
    public static User findUser(String login) {
        if (login == null) return null;
        return userMap.get(login);
    }
    
}
