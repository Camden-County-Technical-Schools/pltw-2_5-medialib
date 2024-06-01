package net.ccts.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserQuestionTest {
    private UserQuestion testUserQuestion;
    private String testQuestion = "What is your name?";
    private String testAnswer = "Answer";

    @Before
    public void setUp() throws Exception {
        testUserQuestion = new UserQuestion(testQuestion, testAnswer);
    }

    @Test
    public void testCtor() {
        String question = "q";
        String answer = "a";
        UserQuestion uq = new UserQuestion(question, answer);
        assertEquals(question, uq.getQuestion());
        assertEquals(answer, uq.getAnswer());
    }

    @Test
    public void testQuestion() {
        String question = "A question?";
        testUserQuestion.setQuestion(question);
        assertEquals(question, testUserQuestion.getQuestion());
    }

    @Test
    public void testAnswer() {
        String answer = "An Answer";
        testUserQuestion.setAnswer(answer);
        assertEquals(answer, testUserQuestion.getAnswer());
    }

    @Test
    public void testQuestionListSize() {
        assertEquals(5, UserQuestion.getQuestionList().size());
    }

    @Test
    public void testQuestionList1() {
        assertEquals("What is your favorite Spanish food?", UserQuestion.getQuestionList().get(0));
    }

    @Test
    public void testQuestionList2() {
        assertEquals("What is your favorite color?", UserQuestion.getQuestionList().get(1));
    }

    @Test
    public void testQuestionList3() {
        assertEquals("Where did you go to school?", UserQuestion.getQuestionList().get(2));
    }

    @Test
    public void testQuestionList4() {
        assertEquals("What kind of car do you drive?", UserQuestion.getQuestionList().get(3));
    }

    @Test
    public void testQuestionList5() {
        assertEquals("What is your nickname?", UserQuestion.getQuestionList().get(4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testQuestionList6() {
        UserQuestion.getQuestionList().get(6);
    }

    @Test
    public void testToString() {
        String expected = "Q: " + testQuestion + " - A: " + testAnswer;;
        assertEquals(expected, testUserQuestion.toString());
    }
}
