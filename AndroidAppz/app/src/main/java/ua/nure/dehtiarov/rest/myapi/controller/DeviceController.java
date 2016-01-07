package ua.nure.dehtiarov.rest.myapi.controller;

import java.util.List;

import ua.nure.dehtiarov.rest.myapi.entity.Device;
import ua.nure.dehtiarov.rest.myapi.entity.User;

/**
 * Created by dehtiarov on 12/24/2015.
 */
public interface DeviceController {

    List<Device> getAllUsersDevices(User user);

}
