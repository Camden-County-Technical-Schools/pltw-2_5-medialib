package net.ccts.data;

import java.util.ArrayList;
/* A UserQuestion class that lists questions for the User.*/

public class UserQuestion{

    private String question;
    private String answer;

    public static final ArrayList<String> questionList = new ArrayList<>(5);
    static 
    {
        questionList.add("What is your favorite Spanish food?");
        questionList.add("What is your favorite color?");
        questionList.add("Where did you go to school?");
        questionList.add("What kind of car do you drive?");
        questionList.add("What is your nickname?");

    }

    public UserQuestion(String q, String a){
        this.question = q;
        this.answer = a;
    }

    public String getQuestion(){
        return this.question;
    }

    public String getAnswer(){
        return this.answer;
    }

    public void setQuestion(String q){
        this.question = q;
    }

    public void setAnswer(String a){
        this.answer = a;
    }

    public static ArrayList<String> getQuestionList(){
        return questionList;
    }

    @Override
    public String toString() {
        return "Q: " + this.question + " - A: " + this.answer;
    }



    
    


}