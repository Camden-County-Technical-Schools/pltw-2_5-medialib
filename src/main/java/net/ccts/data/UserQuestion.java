package net.ccts.data;

import java.util.ArrayList;
public class UserQuestion{

    private String question;
    private String answer;

    public static final ArrayList<String> questionList = new ArrayList<>();
    static {
        questionList.add("What is your favorite Spanish food?");
        questionList.add("What is your favorite color?");
        questionList.add("Where did you go to school?");
        questionList.add("What kind of car do you drive?");
        questionList.add("What is your nickname?");
    } 

    public UserQuestion(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String q) {
        this.question = q;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String a) {
        this.answer = a;
    }
    public static ArrayList<String> getQuestionList(){
        return questionList;
    }
    @Override
    public String toString() {
        return "Q: " + question + " - A: " + answer;
    }
}


    



