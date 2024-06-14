package net.ccts.data;

import java.util.ArrayList;

public class UserQuestion  {
    private String question; 
    private String answer;
    private static final ArrayList<String> questionList;
    static {
        questionList = new ArrayList<String>(5);
        questionList.add("Whats your Favorite Spanish food?");
        questionList.add("What is your favorite color?");
        questionList.add("Where did you go to school?");
        questionList.add("What kind of car do you drive?");
        questionList.add("What is your nickname?");
    }

//constructor
    public UserQuestion(String q, String ans){
    question = q;
    answer = ans;
        }
    //accessor
    public String getQuestion( ){
        return this.question;
        }   
    public String getAnswer(){
        return this.answer;
        }
    //setters
    public void setQuestion(String q){
    this.question = q;
        }

    public void setAnswer(String ans){
        this.answer = ans;
        }
    public static ArrayList<String> getQuestionList(){
        return questionList;
    }
    @Override
    public String toString(){
        return "Q:" + question + "A:" + answer;
    }

    
}