package ua.nure.dehtiarov;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.nure.dehtiarov.rest.myapi.RestServer;
import ua.nure.dehtiarov.rest.myapi.controller.UserAccountController;
import ua.nure.dehtiarov.rest.myapi.entity.User;
import ua.nure.dehtiarov.rest.myapi.impl.DefaultRestServer;

/**
 * Created by dehtiarov on 12/20/2015.
 */
@Controller
@RequestMapping("/login")
public class AuthController {

    private final RestServer restServer = new DefaultRestServer();

    @RequestMapping(method = RequestMethod.POST)
    public String loginUser(ModelMap model, @RequestParam(value = "email") String email,
                          @RequestParam(value = "password") String password) {
        UserAccountController userAccountController = restServer.getUserController();
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        model.addAttribute("user", user);
        if (userAccountController.loginUser(user)) {
            return "admin";
        }
        model.addAttribute("error", "Sorry, user with this email/pass does not exist");
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String loginAccount(ModelMap model) {
        model.addAttribute("user", new User());
        return "login";
    }
}
