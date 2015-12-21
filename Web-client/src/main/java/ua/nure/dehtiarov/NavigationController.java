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
        return "admin";
    }

    @RequestMapping("/status")
    public String goStatisticPage(ModelMap model) {
        return "status";
    }

    @RequestMapping("/charts")
    public String goChartsPage(ModelMap model) {
        return "charts";
    }

    @RequestMapping("/device")
    public String goDevicePage(ModelMap model) {
        return "devices";
    }

    @RequestMapping("/device/edit")
    public String goEditDevicePage(ModelMap model) {
        return "edit_device";
    }

    @RequestMapping("/outlet/add")
    public String goAddOutletPage(ModelMap model) {
        return "add_outlet";
    }

}
