package net.ccts.biz;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.HashMap;
import net.ccts.data.*;

/**
 * UserManager class manages the registration and login process of users.
 * It maintains a mapping of users using their login as the key.
 */
public class UserManager {

    // A private static HashMap to store users by their login
    private static HashMap<String, User> userMap = new HashMap<>();

    /**
     * Registers a new user.
     * 
     * @param u the user to be registered
     * @return the registered user
     * @throws IllegalArgumentException If the user is null, already registered, login already exists, or missing login/password/questions.
     */
    public static User registerUser(User u) {
        if (u == null) {
            throw new IllegalArgumentException("User is required");
        }
        if (u.getRegistered() != null) {
            throw new IllegalArgumentException("User is already registered");
        }
        if (userMap.containsKey(u.getLogin())) {
            throw new IllegalArgumentException("User with login '" + u.getLogin() + "' already exists, can't add new user");
        }
        if (u.getLogin() == null || u.getPassword() == null) {
            throw new IllegalArgumentException("User should have a login and password");
        }
        if (u.getUserQuestionList() == null || u.getUserQuestionList().size() < 2) {
            throw new IllegalArgumentException("User should have at least two questions");
        }

        u.setRegistered(ZonedDateTime.now());
        userMap.put(u.getLogin(), u);
        return u;
    }

    /**
     * Handles user login.
     * 
     * @param login the user's login
     * @param password the user's password
     * @return the user if login is successful, null if not
     */
    public static User handleLogin(String login, char[] password) {
        User user = userMap.get(login);
        if (user == null || !String.valueOf(password).equals(user.getPassword())) {
            return null;
        }
        return user;
    }

    /**
     * Finds a user by their login.
     * 
     * @param login the user's login
     * @return the user if found, null if not
     */
    public static User findUser(String login) {
        if (login == null || login.isEmpty()) {
            return null;
        }
        return userMap.get(login);
    }
}