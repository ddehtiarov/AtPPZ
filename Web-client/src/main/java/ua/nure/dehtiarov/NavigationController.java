package ua.nure.dehtiarov;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dehtiarov on 12/20/2015.
 */
@Controller
@RequestMapping("/admin")
public class NavigationController {

    @RequestMapping(method = RequestMethod.GET)
    public String goAdmin(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "admin";
    }

    @RequestMapping("/status")
    public String goStatisticPage(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "status";
    }

}
