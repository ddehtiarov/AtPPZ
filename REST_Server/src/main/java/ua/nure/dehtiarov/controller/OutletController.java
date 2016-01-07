package ua.nure.dehtiarov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.dehtiarov.entity.Outlet;
import ua.nure.dehtiarov.entity.OutletDevice;
import ua.nure.dehtiarov.entity.User;
import ua.nure.dehtiarov.service.OutletDeviceService;
import ua.nure.dehtiarov.service.OutletService;
import ua.nure.dehtiarov.service.UserService;

import java.util.List;

/**
 * Created by dehtiarov on 12/19/2015.
 */
@RestController
@RequestMapping("/outlet")
public class OutletController {

    @Autowired
    OutletService outletService;

    @Autowired
    UserService userService;

    @RequestMapping("/add")
    public boolean addOutlet(@RequestParam(value = "name") String name,
                           @RequestParam(value = "location") String location,
                           @RequestParam(value = "serialCode") String serialCode,
                           @RequestParam(value = "userId") Long userId) {

        User user = userService.findUserById(userId);
        Outlet outlet = new Outlet(user, location, name, serialCode);
        System.out.println("outlet: " + outlet);
        boolean result = true;
        try {
            outletService.add(outlet);
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    @RequestMapping("/getAll")
    public List<Outlet> getAllOutlets(@RequestParam(value = "userId") Long userId) {
        List<Outlet> outlets = outletService.getAllOutletsByUserId(userId);
        System.out.println("outlets: " + outlets);
        return outlets;
    }

}
