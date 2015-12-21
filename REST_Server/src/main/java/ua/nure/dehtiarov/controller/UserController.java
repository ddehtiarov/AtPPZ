package ua.nure.dehtiarov.controller;

import org.apache.log4j.Logger;
import ua.nure.dehtiarov.entity.Outlet;
import ua.nure.dehtiarov.entity.OutletDevice;
import ua.nure.dehtiarov.entity.User;
import ua.nure.dehtiarov.service.OutletService;
import ua.nure.dehtiarov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private OutletService outletService;

    @RequestMapping("/get")
    public User get(@RequestParam(value = "email") String email) {
        LOGGER.info("email -> " + email);
        return userService.findByEmail(email);
    }

    @RequestMapping("/auth")
    public boolean authenticate(@RequestParam(value = "email") String email,
                                @RequestParam(value = "password") String password) {
        System.out.println("Tyring to login user with email: " + email);
        return userService.authenticate(email, password);
    }

    @RequestMapping("/add")
    public User addUser(@RequestParam(value = "name") String name,
                        @RequestParam(value = "email") String email,
                        @RequestParam(value = "password") String password) {
        User user = new User(name, email, password);
        System.out.println("Tyring to add user with email: " + email + "name: " + name);
        userService.add(user);

        return user;
    }


    @RequestMapping("/outlet/add")
    public Outlet addOutlet(@RequestParam(value = "name") String name,
                            @RequestParam(value = "userId") Long id,
                            @RequestParam(value = "location") String location,
                            @RequestParam(value = "code") String serialCode) {

        User user = userService.findUserById(id);
        Outlet outlet = new Outlet(user, location, name, serialCode);

        outletService.add(outlet);

        return outlet;
    }
}
