package net.ccts.biz;

import java.time.ZonedDateTime;

import java.util.HashMap;

import net.ccts.data.User;

import java.util.Arrays;




public class UserManager{

    private static HashMap <String, User> userMap = new HashMap<>();

    public static User registeredUser(User u){
        if (u == null){
            throw new IllegalArgumentException("User is required");
        }

        if (u.getRegistered() != null){
            throw new IllegalArgumentException("User is already registered");
        }

        if (userMap.containsKey(u.getLogin())){
            throw new IllegalArgumentException("User with login ‘{login}’ already exists, can’t add new user");

        }

        if (u.getLogin() == null || u.getPassword() == null){
            throw new IllegalArgumentException("User shdould have a login and password");
        }

        if (u.getUserQuestionList().size() < 2){
            throw new IllegalArgumentException("The User should have at least two questions");
        } 
    
        u.setRegistered(ZonedDateTime.now());
        userMap.put(u.getLogin(), u);
    

        return u;

    }

    public static User handleLogin(String login, char[ ] password){
        User s = userMap.get(login);
        
        if (s == null){
            return null;
        }

        char[] f = s.getPassword();

        if (!(Arrays.equals(password, f))){
            return null;
        }

        return s;

    }


    public static User findUser(String login){
        if (login == null || login == ""){
            return null;

        }

        return userMap.get(login);
    }


}