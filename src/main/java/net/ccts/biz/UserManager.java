package net.ccts.biz;


import java.time.ZonedDateTime;
import java.util.*;

import net.ccts.data.User;
import net.ccts.data.UserQuestion;


/**
 * A public class that manages user registration, finding the user, and handling user logins
 * using implementations from the User class
 * @author AkiotheChaoticPan
 */
public class UserManager {

    private static final HashMap<String, User> userMap = new HashMap<>();
    static {
        User tester = new User("0@test.com", new char[]{'t','e','s','t'}, "Test");
        tester.setLastName("User");
        tester.setRegistered(ZonedDateTime.now());
        tester.addUserQuestion(new UserQuestion(UserQuestion.getQuestionList().get(0), "1"));
        tester.addUserQuestion(new UserQuestion(UserQuestion.getQuestionList().get(1), "2"));
        userMap.put(tester.getLogin(), tester);
    }

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

    public static User removeUser(User u) {
        if (u != null) {
            User user = userMap.remove(u.getLogin());
            user.setRegistered(null);
            return user;
        }
        return null;
    }

    public static User updateUser(User u) {
        userMap.put(u.getLogin(), u);
        return u;
    }

    public static List<User> getUserList() {
        ArrayList<User> userList = new ArrayList<>(userMap.values());
        Collections.sort(userList);
        return userList;
    }
}
