package net.ccts.data;
import java.util.ArrayList;

/*
 * Activity 2.5.7
 *
 * A User Question class for the MediaLibrary program
 */
public class UserQuestion{
    private String question;
    private String answer;
    private static final ArrayList<String> questionList = new ArrayList<String>();
    static {
      questionList.add("What is your favorite Spanish food?");
      questionList.add("What is your favorite color?");
      questionList.add("Where did you go to school?");
      questionList.add("What kind of car do you drive?");
      questionList.add("What is your nickname?");
    }
public UserQuestion(String q, String a){
    question = q;
    answer = a;
    }
public String getQuestion() {
    return question;
  }
  public String getAnswer() {
    return answer;
  }
  public static ArrayList<String> getQuestionList() {
    return questionList;
  }
  public void setQuestion(String q) {
    question = q;
  }
  public void setAnswer(String a) {
    answer = a;
  }
@Override
public String toString() {
  String info = "Q: " + question + " - A: " + answer;
  return info;
}


}