package ua.nure.dehtiarov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.dehtiarov.entity.OutletDevice;
import ua.nure.dehtiarov.repository.OutletDeviceDAO;
import ua.nure.dehtiarov.service.OutletDeviceService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by dehtiarov on 12/19/2015.
 */
public class DefaultOutletDeviceService implements OutletDeviceService{

    @Autowired
    OutletDeviceDAO outletDeviceDAO;

    @Override
    public void add(OutletDevice outletDevice) {
        outletDeviceDAO.save(outletDevice);
    }

    @Override
    public void update(OutletDevice outletDevice) {
        outletDeviceDAO.save(outletDevice);
    }

    @Override
    public void delete(OutletDevice outletDevice) {
        outletDeviceDAO.remove(outletDevice);
    }

    @Override
    public OutletDevice findOutletDeviceById(Long id) {
        return outletDeviceDAO.find(id);
    }

    @Override
    public List<OutletDevice> getAllOutletsByOutletId(Long id) {
        return outletDeviceDAO.getAllOutletsByOutletId(id);
    }
}
