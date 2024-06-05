package net.ccts.biz;

import net.ccts.data.*;
import java.util.HashMap;

public class UserManager {
    private static HashMap<String, User> userMap = new HashMap<>();

    public static User registerUser(User u) {
        userMap.put(u.getLogin(), u);
        return u;
    }

    public static User handleLogin(String login, char[] password) {
        return findUser(login);
    }

    public static User findUser(String login) {
        if (login == null || login.isEmpty()) {
            return null;
        }
        return userMap.get(login);
    }
}
