package ua.nure.dehtiarov.controller;

import ua.nure.dehtiarov.entity.User;
import ua.nure.dehtiarov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/get")
    public User get(@RequestParam(value = "email") String name) {
        System.out.println("name -> " + name);
        return userService.findByEmail(name);
    }

    @RequestMapping("/auth")
    public boolean authenticate(@RequestParam(value = "email") String email,
                                @RequestParam(value = "password") String password) {

        return userService.authenticate(email, password);
    }

    @RequestMapping("/add")
    public User addUser(@RequestParam(value = "name") String name,
                        @RequestParam(value = "email") String email,
                        @RequestParam(value = "password") String password) {

        User user = new User(name, email, password);

        userService.add(user);

        return user;
    }
}
