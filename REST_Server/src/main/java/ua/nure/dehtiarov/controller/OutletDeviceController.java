package ua.nure.dehtiarov.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.dehtiarov.entity.Device;
import ua.nure.dehtiarov.entity.Outlet;
import ua.nure.dehtiarov.entity.Status;
import ua.nure.dehtiarov.entity.StatusEnum;
import ua.nure.dehtiarov.repository.OutletDeviceDAO;
import ua.nure.dehtiarov.repository.impl.DefaultOutletDeviceDao;
import ua.nure.dehtiarov.service.DeviceService;
import ua.nure.dehtiarov.service.OutletDeviceService;
import ua.nure.dehtiarov.service.OutletService;
import ua.nure.dehtiarov.service.impl.DefaultDeviceService;

/**
 * Created by dehtiarov on 12/22/2015.
 */
@RestController
@RequestMapping("/outdevactivate")
public class OutletDeviceController {

    @Autowired
    DeviceService deviceService;

    @Autowired
    OutletService outletService;

    /**
     * Controller for stopping and starting out working and
     * checking its status
     * ALSO method should get user from outlet and check
     * if this user has this device or no
     * if not, try to add it to my db
     * Then change outlet status and add outletdevice to my db with current date
     * if this dev just starts working or just change outl status
     *
     * @param outCode
     * @param macaddress !!!! or something else !! or
     *                   macadr and check if user has this dev
     */
    @RequestMapping("/do")
    public void activationOutletWorkingProcess(@RequestParam(value = "outCode") String outCode,
                                               @RequestParam(value = "macaddress") String macaddress) {

        //todo: HERE MUST BE all LOGIC!!!
        //may be should create status service for changing status of my outl
        //or find how i can solve this problem
        Outlet outlet = outletService.findOutletByCode(outCode);

        System.out.println("outlet:" + outlet);

        try {
            Device device = new Device("name", macaddress, outlet.getUser());
            System.out.println(device);
            deviceService.add(device);

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }

        Status status = new Status();
        if (outlet.getStatus().getId().equals(1l)) {
            status.setId(2L);
        } else {
            status.setId(1L);
        }
        outlet.setStatus(status);
        outletService.update(outlet);

    }

}
