package net.ccts.data;

import org.junit.Before;
import org.junit.Test;

import java.time.ZonedDateTime;

import static org.junit.Assert.assertEquals;

public class UserTest {

    private String testLogin = "test@mail.com";
    private char[] testPassword = new char[] {'p','a','s','s'};
    private String testFirstName="First";
    private String testLastName="Last";
    private ZonedDateTime testRegistered = ZonedDateTime.now();
    private ZonedDateTime testLastLogin = ZonedDateTime.now();
    private User testUser;

    @Before
    public void setUp() {
        testUser = new User(testLogin, testPassword, testFirstName);
    }

    @Test
    public void testCtor() {
        String login = "login@mail.com";
        char[] password = new char[] {'1','2','3','4'};
        String firstName = "f";
        User u1 = new User(login, password, firstName);
        assertEquals(login, u1.getLogin());
        assertEquals(password, u1.getPassword());
        assertEquals(firstName, u1.getFirstName());
    }

    @Test
    public void testLogin() {
        String login = "L";
        testUser.setLogin(login);
        assertEquals(login.toLowerCase(), testUser.getLogin());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoginNull() {
        testUser.setLogin(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoginEmpty() {
        testUser.setLogin("");
    }

    @Test
    public void testFirstName() {
        String firstName = "FIRST";
        testUser.setFirstName(firstName);
        assertEquals(firstName, testUser.getFirstName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFirstNameNull() {
        testUser.setFirstName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFirstNameEmpty() {
        testUser.setFirstName("");
    }

    @Test
    public void testLastName() {
        testUser.setLastName(testLastName);
        assertEquals(testLastName, testUser.getLastName());
    }

    @Test
    public void testRegistered() {
        testUser.setRegistered(testRegistered);
        assertEquals(testRegistered, testUser.getRegistered());
    }

    @Test
    public void testLastLogin() {
        testUser.setLastLogin(testLastLogin);
        assertEquals(testLastLogin, testUser.getLastLogin());
    }

    @Test
    public void testPassword() {
        char[] pass = new char[] {'4','3','2','1'};
        testUser.setPassword(pass);
        assertEquals(pass, testUser.getPassword());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPasswordNull() {
        char[] pass = null;
        testUser.setPassword(pass);
        assertEquals(pass, testUser.getPassword());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPasswordEmptyChar() {
        char[] pass = new char[]{' '};
        testUser.setPassword(pass);
        assertEquals(pass, testUser.getPassword());
    }

    @Test
    public void testLoginFailureCount() {
        testUser.setLoginFailureCount(0);
        testUser.setLoginFailureCount(testUser.getLoginFailureCount() + 1);
        assertEquals(1, testUser.getLoginFailureCount());
    }

    @Test
    public void testAddUserQuestion() {
        UserQuestion uq1 = new UserQuestion("q1", "a1");
        UserQuestion uq2 = new UserQuestion("q2", "a2");
        testUser.addUserQuestion(uq1);
        testUser.addUserQuestion(uq2);
        assertEquals(2, testUser.getUserQuestionList().size());
    }

    @Test
    public void testFetchUserQuestion() {
        UserQuestion uq1 = new UserQuestion("q1", "a1");
        UserQuestion uq2 = new UserQuestion("q2", "a2");
        testUser.addUserQuestion(uq1);
        testUser.addUserQuestion(uq2);
        assertEquals(uq2, testUser.fetchUserQuestion(1));
    }

    @Test
    public void testRemoveUserQuestion() {
        UserQuestion uq1 = new UserQuestion("q1", "a1");
        UserQuestion uq2 = new UserQuestion("q2", "a2");
        testUser.addUserQuestion(uq1);
        testUser.addUserQuestion(uq2);
        testUser.removeUserQuestion(0);
        assertEquals(1, testUser.getUserQuestionList().size());
    }

    @Test
    public void testToString() {
        String expected = testFirstName + " - " + testLogin;
        assertEquals(expected, testUser.toString());
    }
}

