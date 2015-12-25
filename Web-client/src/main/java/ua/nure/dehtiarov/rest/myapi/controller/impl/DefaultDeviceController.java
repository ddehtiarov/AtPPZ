package ua.nure.dehtiarov.rest.myapi.controller.impl;

import org.apache.log4j.Logger;
import ua.nure.dehtiarov.rest.myapi.constant.PathConstant;
import ua.nure.dehtiarov.rest.myapi.controller.DeviceController;
import ua.nure.dehtiarov.rest.myapi.controller.query.CommonQuerySender;
import ua.nure.dehtiarov.rest.myapi.controller.query.DeviceQuerySender;
import ua.nure.dehtiarov.rest.myapi.entity.Device;
import ua.nure.dehtiarov.rest.myapi.entity.User;

import java.util.List;

/**
 * Created by dehtiarov on 12/24/2015.
 */
public class DefaultDeviceController implements DeviceController {

    private static final Logger LOGGER = Logger.getLogger(DefaultDeviceController.class);

    DeviceQuerySender deviceQuerySender = new DeviceQuerySender();

    @Override
    public List<Device> getAllUsersDevices(User user) {
        String query = PathConstant.OUTLET + "getAll?" + PathConstant.OUT_USER_ID +
                +user.getId();
        LOGGER.info("query: " + query);
        System.out.println("query: " + query);

        List<Device> result = deviceQuerySender.executeGetAllDevices(query);

        System.out.println("result " + result);

        return result;
    }
}
