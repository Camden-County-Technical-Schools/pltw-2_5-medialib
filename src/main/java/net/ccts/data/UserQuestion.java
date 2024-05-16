package net.ccts.data;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A class containing questions for the user, can be considered potential security questions.
 * @author AkiotheChaoticPan
 */
public class UserQuestion {

    private String question;
    private String answer;

    private static final ArrayList<String> questionList = new ArrayList<>(Arrays.asList(
        "What is your favorite Spanish food?",
        "What is your favorite color?",
        "Where did you go to school?",
        "What kind of car do you drive?",
        "What is your nickname?"
    ));

    /**
    * Static Initilizing of questionList
    * 
    * private static final ArrayList<String> questionList;
    * static {
    *   questionList = new ArrayList<>(5);
    *   questionList.add("question");
    * }
    */

    /**
     * A public constructor taking in 'user input' and setting the question and the answer
     * @param q - the question that the user inputs
     * @param a - the answer to the provided question
     */
    public UserQuestion(String q, String a) {

        this.question = q;
        this.answer = a;

    }

    // methods
    /**
     * change the format of the recieved question and answer
     * return a - return the new formatted Question-Answer
     */
    @Override
    public String toString() {

        String a = "Q: " + question + " - A: " + answer;
        return a;
        
    }

    // accessor methods
    
    /**
     * retrieve all questions inside of the ArrayList
     * @return questionList - return all questions in the ArrayList
     */
    public static ArrayList<String> getQuestionList() {
        return UserQuestion.questionList;
    }

    /**
     * retrieve the question set in the constructor, or reset in the mutator method
     * @return question - return the question variable
     */
    public String getQuestion() {
        return this.question;
    }

    /**
     * retrieve the answer set in the constrictor, or reset in the mutator method
     * @return answer - return the answer variable
     */
    public String getAnswer() {
        return this.answer;
    }

    // mutator methods

    /**
     * set the question from the user
     * @param q - the question provided by the user
     */
    public void setQuestion(String q) {
        this.question = q;
    }

    /**
     * set the answer provided from the user
     * @param a - the answer provided by the user
     */
    public void setAnswer(String a) {
        this.answer = a;
    }
}
