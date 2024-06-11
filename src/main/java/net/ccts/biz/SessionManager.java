package net.ccts.biz;

import net.ccts.api.SessionApiData;
import net.ccts.data.User;

import java.util.concurrent.ConcurrentHashMap;

public class SessionManager {
    private static final ConcurrentHashMap<String, User> sessionMap = new ConcurrentHashMap<>();

    public static SessionApiData createSession(User user) {
        SessionApiData apiData = new SessionApiData(user);
        sessionMap.put(apiData.getSessionId(), user);
        return apiData;
    }

    public static User findUserBySession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public static User removeSession(String sessionId) {
        return sessionMap.remove(sessionId);
    }
}
