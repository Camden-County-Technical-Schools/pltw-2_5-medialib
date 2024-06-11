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

    public static User registerUser(User u) {
        userMap.put(u.getLogin(), u);
        return u;
    }

    public static User handleLogin(String login, char[] password) {
        //TODO - validate password for login
        User user = findUser(login);
        if (user != null) {

        }
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

}
