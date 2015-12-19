package ua.nure.dehtiarov.service;

import ua.nure.dehtiarov.entity.Outlet;
import ua.nure.dehtiarov.entity.OutletDevice;

import java.util.List;

/**
 * Created by dehtiarov on 12/19/2015.
 */
public interface OutletDeviceService {

    void add(OutletDevice outletDevice);

    void update(OutletDevice outletDevice);

    void delete(OutletDevice outletDevice);

    OutletDevice findOutletDeviceById(Long id);

    List<OutletDevice> getAllOutletsByOutletId(Long id);

}
