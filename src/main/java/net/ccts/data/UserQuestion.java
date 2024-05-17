package net.ccts.data;

import java.util.ArrayList;
import java.util.Arrays;

// Userquestion is for the users question and answer

public class UserQuestion {
    private String question;
    private String answer;
    public static final ArrayList<String> questionList = new ArrayList<>(Arrays.asList(
        "what is your favorite Spanish food?",
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

    //Accessor Methods
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }
    public void setAnswer() {
        this.answer = answer;
    }

    // Static method to return list
    public static ArrayList<String> getQuestionList() {
        return questionList;
    }

    @Override
    public String toString() {
        return "Q: " + question + " - A: " + answer;
    }
}