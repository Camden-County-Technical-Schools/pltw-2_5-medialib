package net.ccts.api;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import net.ccts.data.User;
import net.ccts.data.UserQuestion;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.time.ZonedDateTime;
import java.util.ArrayList;

@JsonRootName(value = UserApiData.NODE_NAME)
public class UserApiData {
    public static final String NODE_NAME = "user";
    public static final String LIST_NAME = "users";
    public static final String LOGIN_NODE = "login";
    public static final String PASSWORD_NODE = "password";
    public static final String FIRSTNAME_NODE = "firstName";
    public static final String LASTNAME_NODE = "lastName";
    public static final String REGISTERED_NODE = "registered";
    public static final String LAST_LOGIN_NODE = "lastLogin";
    public static final String LOGIN_FAILURE_COUNT_NODE = "loginFailureCount";
    public static final String USER_QUESTION_LIST_NODE = "userQuestionList";

    private User user;

    public UserApiData(User user) {
        this.user = user;
    }

    @JsonGetter(LOGIN_NODE)
    public String getLogin() {
        return this.user.getLogin();
    }

    @JsonSetter(PASSWORD_NODE)
    public char[] getPassword() {
        return this.user.getPassword();
    }

    @JsonGetter(FIRSTNAME_NODE)
    public String getFirstName() {
        return this.user.getFirstName();
    }

    @JsonGetter(LASTNAME_NODE)
    public String getLastName() {
        return this.user.getLastName();
    }

    @JsonGetter(REGISTERED_NODE)
    public ZonedDateTime getRegistered() {
        return this.user.getRegistered();
    }

    @JsonGetter(LAST_LOGIN_NODE)
    public ZonedDateTime getLastLogin() {
        return this.user.getLastLogin();
    }

    @JsonGetter(LOGIN_FAILURE_COUNT_NODE)
    public int getLoginFailureCount() {
        return this.user.getLoginFailureCount();
    }

    @JsonGetter(USER_QUESTION_LIST_NODE)
    public ArrayList<UserQuestionApiData> getUserQuestionList() {
        ArrayList<UserQuestionApiData> userQuestionList = null;
        ArrayList<UserQuestion> userQuestions = this.user.getUserQuestionList();
        if (userQuestions == null || userQuestions.isEmpty()) {
            return userQuestionList;
        }
        userQuestionList = new ArrayList<>(userQuestions.size());
        for (UserQuestion userQuestion : userQuestions) {
            userQuestionList.add(new UserQuestionApiData(userQuestion));
        }
        return userQuestionList;
    }

    public void appendUser(Element element) {
        Document doc = element.getOwnerDocument();
        Element elmUser = doc.createElement(NODE_NAME);
        element.appendChild(elmUser);

        Element elmLogin = doc.createElement(LOGIN_NODE);
        elmLogin.appendChild(doc.createTextNode(this.getLogin()));
        elmUser.appendChild(elmLogin);

        Element elmFirstName = doc.createElement(FIRSTNAME_NODE);
        elmFirstName.appendChild(doc.createTextNode(this.getFirstName()));
        elmUser.appendChild(elmFirstName);

        if (this.getLastName() != null) {
            Element elmLastName = doc.createElement(LASTNAME_NODE);
            elmLastName.appendChild(doc.createTextNode(this.getLastName()));
            elmUser.appendChild(elmLastName);
        }

        if (this.getRegistered() != null) {
            Element elmRegistered = doc.createElement(REGISTERED_NODE);
            elmRegistered.appendChild(doc.createTextNode(this.getRegistered().toString()));
            elmUser.appendChild(elmRegistered);
        }

        if (this.getLastLogin() != null) {
            Element elmLL = doc.createElement(LAST_LOGIN_NODE);
            elmLL.appendChild(doc.createTextNode(this.getLastLogin().toString()));
            elmUser.appendChild(elmLL);
        }


        Element elmLFC = doc.createElement(LOGIN_FAILURE_COUNT_NODE);
        elmLFC.appendChild(doc.createTextNode(String.valueOf(this.getLoginFailureCount())));
        elmUser.appendChild(elmLFC);

        if (this.getUserQuestionList() != null) {
            Element elmUQList = doc.createElement(USER_QUESTION_LIST_NODE);
            for (UserQuestionApiData userQuestion : this.getUserQuestionList()) {
                userQuestion.appendUserQuestion(elmUQList);
            }
        }
    }

}
