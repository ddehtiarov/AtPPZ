package ua.nure.dehtiarov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.dehtiarov.dao.DeviceDAO;
import ua.nure.dehtiarov.entity.Device;
import ua.nure.dehtiarov.service.DeviceService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by dehtiarov on 12/19/2015.
 */
@Service
@Transactional
public class DefaultDeviceService implements DeviceService {

    @Autowired
    private DeviceDAO deviceDAO;

    @Override
    public void add(Device device) {
        deviceDAO.save(device);
    }

    @Override
    public void update(Device device) {
        deviceDAO.save(device);
    }

    @Override
    public void delete(Device device) {
        deviceDAO.remove(device);
    }

    @Override
    public Device findDeviceById(Long id) {
        return deviceDAO.find(id);
    }

    @Override
    public List<Device> getAllDevicesByUser(Long id) {
        return deviceDAO.findAll();
    }
}
