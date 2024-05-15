package net.ccts.data;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The UserQuestion class represents a user's question and answer.
 * It also maintains a static list of common questions.
 */
public class UserQuestion {

    // Internal member variables
    private String question;
    private String answer;
    public static final ArrayList<String> questionList = new ArrayList<>(Arrays.asList(
        "What is your favorite Spanish food?",
        "What is your favorite color?",
        "Where did you go to school?",
        "What kind of car do you drive?",
        "What is your nickname?"
    ));

    // Constructor
    public UserQuestion(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    // Accessor methods
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    // Static method to return the question list
    public static ArrayList<String> getQuestionList() {
        return questionList;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Q: " + question + " - A: " + answer;
    }
}
