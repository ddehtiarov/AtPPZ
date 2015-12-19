package ua.nure.dehtiarov.service;

import ua.nure.dehtiarov.entity.Device;

import java.util.List;

/**
 * Created by dehtiarov on 12/19/2015.
 */
public interface DeviceService {

    void add(Device device);

    void update(Device device);

    void delete(Device device);

    Device findDeviceByMacAddress(String macaddress);

    List<Device> getAllDevices();

}
