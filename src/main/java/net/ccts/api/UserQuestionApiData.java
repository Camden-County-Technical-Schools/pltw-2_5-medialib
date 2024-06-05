package net.ccts.api;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import net.ccts.data.User;
import net.ccts.data.UserQuestion;

import java.time.ZonedDateTime;
import java.util.ArrayList;

@JsonRootName(value = UserQuestionApiData.NODE_NAME)
public class UserQuestionApiData {
    public static final String NODE_NAME = "userQuestion";
    public static final String QUESTION_NODE = "question";
    public static final String ANSWER_NODE = "answer";


    private UserQuestion userQuestion;

    public UserQuestionApiData(UserQuestion userQuestion) {
        this.userQuestion = userQuestion;
    }

    @JsonGetter(QUESTION_NODE)
    public String getQuestion() {
        return this.userQuestion.getQuestion();
    }

    @JsonGetter(ANSWER_NODE)
    public String getAnswer() {
        return this.userQuestion.getAnswer();
    }

}
