package net.ccts.api;

import net.ccts.biz.UserManager;
import net.ccts.data.User;
import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.ext.xml.DomRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersResource extends ApiResource {

    private String validateClientRequest() {
        if (sessionToken == null || sessionToken.isEmpty())
            return "Request invalid: no session token provided";

        return null;
    }

    @Override
    @Get("xml")
    public Representation getXmlRepresentation() throws IOException {
        List<User> userList = UserManager.getUserList();
        String validationMessage = this.validateClientRequest();
        if (validationMessage != null) {
            setStatus(Status.valueOf(400));
            return getErrorAsXML(validationMessage);
        }

        DomRepresentation representation = new DomRepresentation(
                MediaType.TEXT_XML);
        Document d = representation.getDocument();
        Element apiElement = d.createElement(ApiResource.DOCUMENT_ELEMENT_NODE_NAME);
        d.appendChild(apiElement);

        Element userListElement = d.createElement(UserApiData.LIST_NAME);
        apiElement.appendChild(userListElement);
        for (User user : userList) {
            UserApiData data = new UserApiData(user);
            data.appendUser(userListElement);
        }

        d.normalizeDocument();
        setStatus(Status.valueOf(200));
        // Returns the XML representation of this document.
        return representation;
    }

    @Override
    @Get("json")
    public Representation getJsonRepresentation() {
        List<User> userList = UserManager.getUserList();
        ArrayList<UserApiData> dataList = new ArrayList<>(userList.size());
        for (User user : userList) {
            dataList.add(new UserApiData(user));
        }
        setStatus(Status.valueOf(200));
        return new JacksonRepresentation<>(dataList);
    }

//    @Post
//    public Representation createUser(Representation entity) {
//        Representation result = null;
//        // Parse the given representation and retrieve pairs of
//        // "name=value" tokens.
//        Form form = new Form(entity);
//        String itemName = form.getFirstValue("name");
//
//        return result;
//    }
}
