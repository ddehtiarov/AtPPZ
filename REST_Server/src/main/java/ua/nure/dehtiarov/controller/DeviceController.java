package ua.nure.dehtiarov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.dehtiarov.entity.Device;
import ua.nure.dehtiarov.service.DeviceService;
import ua.nure.dehtiarov.service.UserService;

import java.util.List;

/**
 * Created by dehtiarov on 12/22/2015.
 */
@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @Autowired
    UserService userService;

    @RequestMapping("/edit")
    public Device editDevice(@RequestParam(value = "devId") Long deviceId,
                             @RequestParam(value = "name") String name) {

        Device device = deviceService.findDeviceById(deviceId);
        device.setName(name);
        System.out.println("device: " + device);
        return device;
    }

    @RequestMapping("/getAll")
    public List<Device> getAllDevices(@RequestParam(value = "userId") Long userId) {
        List<Device> devices = deviceService.getAllDevicesByUser(userId);
        System.out.println("devices: " + devices);
        return devices;
    }

    @RequestMapping("/get")
    public Device getDevice(@RequestParam(value = "devId") Long devId) {
        Device device = deviceService.findDeviceById(devId);
        System.out.println("device: " + device);
        return device;
    }

}
