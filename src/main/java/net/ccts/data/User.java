package net.ccts.data;

import java.time.ZonedDateTime;
import java.util.ArrayList;

/**
 * A class that manages basic user needs such as login info and attempts along with security questions
 * using implementations from the UserQuestion class
 * @author AkiotheChaoticPan
 */
public class User {
    
    private ZonedDateTime registered;
    private ZonedDateTime lastLogin;

    private int loginFailureCount;

    private ArrayList<UserQuestion> userQuestionList = new ArrayList<>(3);

    private char[] password;

    private String login;
    private String firstName;
    private String lastName;

    /**
     * A public constructor that initializes the login, password, and firstname of the user
     * @param l - login string of the user
     * @param f - first name string of the user
     * @param p - password character array of the user
     */
    public User(String l, String f, char[] p) {

        this.login = l;
        this.firstName = f;
        this.password = p;

    }

    // methods  

    /**
     * changes the format of how the first name and login information outputted
     * @return a - the first name and login of the user
     */
    @Override
    public String toString() {

        String a = this.firstName + "-" + this.login;
        return a;

    }

    /**
     * add another question ot the userQuestionList which can assumed to be the user
     * chosen security questions
     * @param q - a new question provided by the user that is from the UserQuestion class
     */
    public void addUserQuestion(UserQuestion q) {
        this.userQuestionList.add(q);
    }

    /**
     * remove a question from the list of potential security questions using a user provided
     * index
     * @param i - the index of the question the user wants to be removed
     */
    public void removeUserQuestion(int i) {
        this.userQuestionList.remove(i);
    }
    

    /**
     * fetch or get a user question that is in the ArrayList based on the index provided
     * @param i - the index of the question the user wants to fetch
     * @return userQuestionList.get(i) - get the question value from the index and return it
     */
    public UserQuestion fetchUserQuestion(int i) {
        return this.userQuestionList.get(i);
    }

    /**
     * get the entire array list and return it
     * @return userQuestionList - return all of the questions from the user
     */
    public ArrayList<UserQuestion> getUserQuestionList() {
        return this.userQuestionList;
    }

    // accessor methods
    
    /**
     * retrieve the login information of the user
     * @return login - stored login information
     */
    public String getLogin() {
        return this.login;
    }

    /**
     * retrieve the first name of the user
     * @return firstName - stored first name information
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * retrieve the last name of the user
     * @return lastName - stored last name information
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * retrieve the registration date of the user
     * @return registered - stored registration date information
     */
    public ZonedDateTime getRegistered() {
        return this.registered;
    }

    /**
     * retrieve the last login date of the user
     * @return lastLogin - stored previous login date of the user
     */
    public ZonedDateTime getLastLogin() {
        return this.lastLogin;
    }

    /**
     * retrieve the password of the user
     * @return password - stored password of the user
     */
    public char[] getPassword() {
        return this.password;
    }

    /**
     * retrieve amount of invalid login attempts from the user
     * @return loginFailureCount - stored failed attenpts of logging in
     */
    public int getLoginFailureCount() {
        return this.loginFailureCount;
    }

    // mutator methods

    /**
     * set login to inputted string unless parameter is an empty string or is null
     * @param log - login information provided by user
     */ 
    public void setLogin(String log) {
        if (log == null || log.equals("")) throw new IllegalArgumentException("Login is required.");
        else this.login = log.toLowerCase();
    }

    /**
     * set the first name of the user unless parameter is an empty string or is null
     * @param f - first name provided by the user
     */
    public void setFirstName(String f) {
        if (f == null || f.equals("")) throw new IllegalArgumentException("First name is required.");
        else this.firstName = f;
    }

    /**
     * set the last name of the user
     * @param l - last name provided by the user(optional)
     */
    public void setLastName(String l) {
        this.lastName = l;
    }

    /**
     * set the registration date of the user
     * @param r - date of registration provided by system
     */
    public void setRegistered(ZonedDateTime r) {
        this.registered = r;
    }

    /**
     * set the last login attempt of the user
     * @param last - date of previous login attempt
     */
    public void setLastLogin(ZonedDateTime last) {
    }

    /**
     * set the password of the user, unless parameter is null or the first index is empty
     * @param p - provided user password
     */
    public void setPassword(char[] p) {
        if (p == null || p[0] == ' ') throw new IllegalArgumentException("Password is required.");
        else this.password = p;
    }

    /**
     * set the login falure attempts
     * @param fail - amount of user login failures
     */
    public void setLoginFailureCount(int fail) {
        this.loginFailureCount = fail;
    }
}
