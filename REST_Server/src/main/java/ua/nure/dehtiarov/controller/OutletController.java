package ua.nure.dehtiarov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.dehtiarov.entity.Outlet;
import ua.nure.dehtiarov.entity.User;
import ua.nure.dehtiarov.service.OutletService;
import ua.nure.dehtiarov.service.UserService;

/**
 * Created by dehtiarov on 12/19/2015.
 */
@RestController
@RequestMapping("/outlet")
public class OutletController {

    @Autowired
    OutletService outletService;

}
