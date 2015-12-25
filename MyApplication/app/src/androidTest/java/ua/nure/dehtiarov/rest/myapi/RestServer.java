package ua.nure.dehtiarov.rest.myapi;

import ua.nure.dehtiarov.rest.myapi.controller.DeviceController;
import ua.nure.dehtiarov.rest.myapi.controller.OutletController;
import ua.nure.dehtiarov.rest.myapi.controller.UserAccountController;

/**
 * Created by dehtiarov on 12/20/2015.
 */
public interface RestServer {

    UserAccountController getUserController();

    OutletController getOutletController();

    DeviceController getDeviceController();

}
