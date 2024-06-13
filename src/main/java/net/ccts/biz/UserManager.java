package net.ccts.biz;
import net.ccts.data.User;
import java.time.ZonedDateTime;
import java.util.HashMap;

public class UserManager {
    private static HashMap<String, User> userMap = new HashMap<>();

    public static User registerUser(User u) {
        if (u == null) {
            throw new IllegalArgumentException("User is required");
        }
        if (u.getRegistered() != null) {
            throw new IllegalArgumentException("User is already registered");
        }
        String login = u.getLogin();
        if (login == null || login.isEmpty() || u.getPassword() == null) {
            throw new IllegalArgumentException("User should have a login and password");
        }
        if (userMap.containsKey(login)) {
            throw new IllegalArgumentException("User with login '" + login + "' already exists, can't add new user");
        }
        if (u.getUserQuestionList().size() < 2) {
            throw new IllegalArgumentException("User should have at least two questions");
        }
        u.setRegistered(ZonedDateTime.now());
        userMap.put(login, u);
        return u;
    }

    public static User handleLogin(String login, char[] password) {
        User user = userMap.get(login);
        if (user == null || !isEqualPassword(user.getPassword(), password)) {
            return null;
        }
        return user;
    }

    private static boolean isEqualPassword(char[] storedPassword, char[] inputPassword) {
        if (storedPassword.length != inputPassword.length) {
            return false;
        }
        for (int i = 0; i < storedPassword.length; i++) {
            if (storedPassword[i] != inputPassword[i]) {
                return false;
            }
        }
        return true;
    }

    public static User findUser(String login) {
        if (login == null || login.isEmpty()) {
            return null;
        }
        return userMap.get(login);
    }
}
