package net.ccts.biz;

import net.ccts.data.User;
import java.time.ZonedDateTime;
import java.util.HashMap;

/**
 * user registration and login functions
 */
public class UserManager {

    private static HashMap<String, User> userMap = new HashMap<>();

    /**
     * Registers a new user if the provided user is valid and not already registered.
     * 
     * @param u the user to be registered
     * @return the registered user
     * @throws IllegalArgumentException if the user is null, etc 
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
     * user login by checking the provided login pw 
     * 
     * @param login the login of the user
     * @param password the password of the user
     * @return the user if the login and password match if not then its nulw
     */
    public static User handleLogin(String login, char[] password) {
        User user = userMap.get(login);
        if (user == null || !java.util.Arrays.equals(user.getPassword(), password)) {
            return null;
        }
        return user;
    }

    /**
     * Finds a user by the login 
     * 
     * @param login the login of the user
     * @return the user if found, otherwise null
     */
    public static User findUser(String login) {
        if (login == null || login.trim().isEmpty()) {
            return null;
        }
        return userMap.get(login);
    }
}
