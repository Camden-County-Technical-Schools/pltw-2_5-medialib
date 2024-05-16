package net.ccts.data;
/**
 * class for the user question and
 *  what the questions are 
 */

import java.util.ArrayList; 

public class UserQuestion {

/**
 * these are the internal 
 * member variables needed 
 * to be tracked
 */

    private String question;
    private String answer; 
    private static final ArrayList<String> questionList; 
    static {
        questionList = new ArrayList<String>(5);
        questionList.add("What is your favorite Spanish food?");
        questionList.add("What is your favorite color?");
        questionList.add("Where did you go to school?");
        questionList.add("What kind of car do you drive?");
        questionList.add("What is your nickname?");
    } 

    public UserQuestion(String q, String a) {
        question = q; 
        answer = a; 
    }
/**
 * implemented accessors and mutoators for the member variables
 */
    public String getQuestion() {
        return question; 
    }

    public String getAnswer() {
        return answer; 
    }

    public void setQuestion(String q) {
        this.question = q; 
    }

    public void setAnswer(String a) {
        this.answer = a; 
    }

/**
 * returns the question List 
 */
    public static ArrayList<String> getQuestionList() {
        return questionList; 
    }

/**
 * override the toString method so it returns Q and A
 */
    @Override 
    public String toString() {
        String info = "Q";
        info = info + question; 
        info = info + "A";
        info = info + answer;
        return info;  
    }
    
}