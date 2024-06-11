package net.ccts.api;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = ErrorApiData.NODE_NAME)
public class ErrorApiData {
    public static final String NODE_NAME = "error";
    public static final String MESSAGE_NODE = "message";

    private String message;

    public ErrorApiData(String message) {
        this.message = message;
    }

    @JsonGetter(MESSAGE_NODE)
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
