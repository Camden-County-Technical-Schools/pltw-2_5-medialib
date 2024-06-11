package net.ccts.api;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRootName;
import net.ccts.data.UserQuestion;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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

    public void append(Element element) {
        Document doc = element.getOwnerDocument();
        Element elmUQ = doc.createElement(NODE_NAME);
        element.appendChild(elmUQ);

        Element elmQ = doc.createElement(QUESTION_NODE);
        elmQ.appendChild(doc.createTextNode(this.userQuestion.getQuestion()));
        elmUQ.appendChild(elmQ);

        Element elmA = doc.createElement(ANSWER_NODE);
        elmA.appendChild(doc.createTextNode(this.userQuestion.getAnswer()));
        elmUQ.appendChild(elmA);
    }
}
