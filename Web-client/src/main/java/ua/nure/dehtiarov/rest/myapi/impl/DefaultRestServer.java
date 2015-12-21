package ua.nure.dehtiarov.rest.myapi.impl;

import ua.nure.dehtiarov.rest.myapi.RestServer;
import ua.nure.dehtiarov.rest.myapi.controller.UserAccountController;
import ua.nure.dehtiarov.rest.myapi.controller.impl.DefaultUserAccountController;

/**
 * Created by dehtiarov on 12/20/2015.
 */
public class DefaultRestServer implements RestServer{

    @Override
    public UserAccountController getUserController() {
        return new DefaultUserAccountController();
    }
}
