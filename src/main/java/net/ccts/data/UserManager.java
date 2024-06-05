package net.ccts.data;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Arrays;

public class UserManager {
    private static HashMap<String, User> userMap = new HashMap<>();
/** This is so you can get the login for the user and print to them the requirements  */
    public static User registerUser(User u) {
        if (u == null) {
            throw new IllegalArgumentException("User is required");
        }
        if (u.getRegistered() != null) {
            throw new IllegalArgumentException("User is already registered");
        }
        if (userMap.containsKey(u.getLogin())) {
            throw new IllegalArgumentException("User with login " + u.getLogin() + " already exists, can't add new user");
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

    public static User handleLogin(String login, char[] password) {
        User user = userMap.get(login);
        if (user == null || !Arrays.equals(user.getPassword(), password)) {
            return null;
        }
        return user;
    }

    public static User findUser(String login) {
        if (login == null || login.isEmpty()) {
            return null;
        }
        return userMap.get(login);
    }
}
