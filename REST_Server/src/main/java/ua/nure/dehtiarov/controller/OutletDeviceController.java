package ua.nure.dehtiarov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.dehtiarov.entity.Outlet;
import ua.nure.dehtiarov.entity.StatusEnum;
import ua.nure.dehtiarov.service.DeviceService;
import ua.nure.dehtiarov.service.OutletDeviceService;
import ua.nure.dehtiarov.service.OutletService;

/**
 * Created by dehtiarov on 12/22/2015.
 */
@RestController
@RequestMapping("/otdevactivate")
public class OutletDeviceController {

    @Autowired
    OutletDeviceService outletDeviceService;

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
     * @param outId
     * @param macaddress !!!! or something else !! or
     *                   macadr and check if user has this dev
     */
    @RequestMapping("/getAll")
    public void activationOutletWorkingProcess(@RequestParam(value = "outId") Long outId,
                                               @RequestParam(value = "macaddress") String macaddress) {

        //todo: HERE MUST BE all LOGIC!!!
        //may be should create status service for changing status of my outl
        //or find how i can solve this problem
        Outlet outlet = outletService.findOutletById(outId);
        StatusEnum statusEnum = StatusEnum.valueOf(outlet.getStatus().getValue().toUpperCase());

    }

}
