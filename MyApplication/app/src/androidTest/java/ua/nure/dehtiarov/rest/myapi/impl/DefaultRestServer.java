package ua.nure.dehtiarov.rest.myapi.impl;

import ua.nure.dehtiarov.rest.myapi.RestServer;
import ua.nure.dehtiarov.rest.myapi.controller.DeviceController;
import ua.nure.dehtiarov.rest.myapi.controller.OutletController;
import ua.nure.dehtiarov.rest.myapi.controller.UserAccountController;
import ua.nure.dehtiarov.rest.myapi.controller.impl.DefaultDeviceController;
import ua.nure.dehtiarov.rest.myapi.controller.impl.DefaultOutletController;
import ua.nure.dehtiarov.rest.myapi.controller.impl.DefaultUserAccountController;

/**
 * Created by dehtiarov on 12/20/2015.
 */
public class DefaultRestServer implements RestServer{

    @Override
    public UserAccountController getUserController() {
        return new DefaultUserAccountController();
    }

    @Override
    public OutletController getOutletController() {
        return new DefaultOutletController();
    }

    @Override
    public DeviceController getDeviceController() {
        return new DefaultDeviceController();
    }
}
