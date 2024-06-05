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
        // Defines routes for the resource "users"
        // router.attach("/users", UsersResource.class);
        router.attach("/users/{" + UserResource.USER_LOGIN_PARAM + "}", UserResource.class);

        return router;
    }


}
