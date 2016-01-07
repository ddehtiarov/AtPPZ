package ua.nure.dehtiarov;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.dehtiarov.rest.myapi.RestServer;
import ua.nure.dehtiarov.rest.myapi.controller.UserAccountController;
import ua.nure.dehtiarov.rest.myapi.entity.User;
import ua.nure.dehtiarov.rest.myapi.impl.DefaultRestServer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by dehtiarov on 12/20/2015.
 */
@Controller
@RequestMapping("/login")
public class AuthController {

    private final RestServer restServer = new DefaultRestServer();

    @RequestMapping(method = RequestMethod.POST)
    public String loginUser(ModelMap model, HttpSession httpSession,
                            @RequestParam(value = "email") String email,
                                  @RequestParam(value = "password") String password) {

        UserAccountController userAccountController = restServer.getUserController();
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        if (userAccountController.loginUser(user)) {
            httpSession.setAttribute("user", userAccountController.getUserByUserModel(user));
            return "admin";
        }

        model.addAttribute("user", user);
        model.addAttribute("error", "Sorry, user with this email/pass does not exist");
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String loginAccount(ModelMap model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping("/andr")
    public String loginAccountFromAndroid(ModelMap model, HttpSession httpSession,
                                          @RequestParam(value = "email") String email) {
        User user = new User();
        user.setEmail(email);
        UserAccountController userAccountController = restServer.getUserController();

        httpSession.setAttribute("user", userAccountController.getUserByUserModel(user));

        return "admin";
    }
}
