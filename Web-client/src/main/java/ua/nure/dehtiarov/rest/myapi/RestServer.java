package ua.nure.dehtiarov.rest.myapi;

import ua.nure.dehtiarov.rest.myapi.controller.UserAccountController;

/**
 * Created by dehtiarov on 12/20/2015.
 */
public interface RestServer {

    UserAccountController getUserController();

}
