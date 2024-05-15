package net.ccts.data;
import java.util.ArrayList;
import java.util.Arrays;

public class UserQuestion {

private String question;
private String answer;
public static final ArrayList<String> questionList = new ArrayList<>(Arrays.asList(
    "What is your favorite Spanish food?",
    "What is your favorite color?",
    "Where did you go to school?",
    "What kind of car do you drive?",
    "What is your nickname?"
));

public UserQuestion(String question, String answer) {
    this.question = question;
    this.answer = answer;

}

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

public static ArrayList<String> getQuestionList() {
    return questionList;
}

@Override
public String toString() {
    return "Q: {" + question + "}" + "A: {" + answer + "}";
    }
}