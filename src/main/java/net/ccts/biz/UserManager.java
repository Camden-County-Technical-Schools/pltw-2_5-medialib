package net.ccts.data;

import net.ccts.data.User;
import java.time.ZonedDateTime;
import java.util.HashMap;

/**
 * The UserManager class manages user registration, login, and user retrieval operations.
 */
public class UserManager {
    private static HashMap<String, User> userMap = new HashMap<>();

    /**
     * Registers a new user if the user passes all validation checks.
     * 
     * @param u the User to be registered
     * @return the registered User
     * @throws IllegalArgumentException if the user is invalid or already registered
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
        if (u.getUserQuestionList().size() < 2) {
            throw new IllegalArgumentException("User should have at least two questions");
        }
        
        u.setRegistered(ZonedDateTime.now());
        userMap.put(u.getLogin(), u);
        return u;
    }

    /**
     * Handles user login by checking if the provided login and password match a registered user.
     * 
     * @param login the user's login (email)
     * @param password the user's password
     * @return the User if login is successful, otherwise null
     */
    public static User handleLogin(String login, char[] password) {
        User user = userMap.get(login);
        if (user == null || !java.util.Arrays.equals(user.getPassword(), password)) {
            return null;
        }
        return user;
    }

    /**
     * Finds a user by login.
     * 
     * @param login the user's login (email)
     * @return the User if found, otherwise null
     */
    public static User findUser(String login) {
        if (login == null || login.isEmpty()) {
            return null;
        }
        return userMap.get(login);
    }
}
