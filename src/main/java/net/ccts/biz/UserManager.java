package net.ccts.biz;

import net.ccts.data.*;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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

    private static final ConcurrentHashMap<String, User> sessionMap = new ConcurrentHashMap<>();

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


    public static User findUserBySession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public static User removeSession(String sessionId) {
        return sessionMap.remove(sessionId);
    }
}
