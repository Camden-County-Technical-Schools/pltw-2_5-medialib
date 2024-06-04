package net.ccts.biz;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Import the User class from net.ccts.data package
import net.ccts.data.User;

/**
  UserManager is responsible for managing the registration and login of users.
  It maintains a mapping of user logins to User objects and provides methods
  to register a new user, handle user login, and find users by login.
 */
public class UserManager {
    
    // Static HashMap to store users by their login
    private static Map<String, User> userMap = new HashMap<>();

    /**
     * Registers a new user.
     * 
     * @param u the user to register
     * @return the registered user
     * @throws IllegalArgumentException if any validation fails
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

        // Set the registered time to now
        u.setRegistered(ZonedDateTime.now());
        // Add the user to the map
        userMap.put(u.getLogin(), u);
        return u;
    }

    /**
     * Handles user login.
     * 
     * @param login the user's login
     * @param password the user's password
     * @return the User if login is successful, otherwise null
     */
    public static User handleLogin(String login, char[] password) {
        User user = userMap.get(login);
        if (user == null || !Arrays.equals(password, user.getPassword())) {
            return null;
        }
        return user;
    }

    /**
     * Finds a user by their login.
     * 
     * @param login the user's login
     * @return the User if found, otherwise null
     */
    public static User findUser(String login) {
        if (login == null || login.isEmpty()) {
            return null;
        }
        return userMap.get(login);
    }
}
