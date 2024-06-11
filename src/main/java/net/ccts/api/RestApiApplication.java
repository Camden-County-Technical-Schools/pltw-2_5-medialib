package net.ccts.api;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class RestApiApplication extends Application {

    /**
     * Creates a root Restlet that will receive all incoming calls.
     */
    @Override
    public Restlet createInboundRoot() {
        // Create a router Restlet that defines routes.
        Router router = new Router(getContext());
        router.attach("/users", UsersResource.class);
        router.attach("/users/{" + UserResource.USER_LOGIN_PARAM + "}", UserResource.class);
        router.attach("/login", SessionResource.class);
        router.attach("/session/{" + SessionResource.SESSION_ID_PARAM + "}", SessionResource.class);
        return router;
    }


}
