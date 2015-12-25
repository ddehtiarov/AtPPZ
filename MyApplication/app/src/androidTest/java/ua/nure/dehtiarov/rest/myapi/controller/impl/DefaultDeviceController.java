package ua.nure.dehtiarov.rest.myapi.controller.impl;

import java.util.List;

import ua.nure.dehtiarov.rest.myapi.constant.PathConstant;
import ua.nure.dehtiarov.rest.myapi.controller.DeviceController;
import ua.nure.dehtiarov.rest.myapi.controller.query.DeviceQuerySender;
import ua.nure.dehtiarov.rest.myapi.entity.Device;
import ua.nure.dehtiarov.rest.myapi.entity.User;

/**
 * Created by dehtiarov on 12/24/2015.
 */
public class DefaultDeviceController implements DeviceController {

    DeviceQuerySender deviceQuerySender = new DeviceQuerySender();

    @Override
    public List<Device> getAllUsersDevices(User user) {
        String query = PathConstant.OUTLET + "getAll?" + PathConstant.OUT_USER_ID +
                +user.getId();
        System.out.println("query: " + query);

        List<Device> result = deviceQuerySender.executeGetAllDevices(query);

        System.out.println("result " + result);

        return result;
    }
}
