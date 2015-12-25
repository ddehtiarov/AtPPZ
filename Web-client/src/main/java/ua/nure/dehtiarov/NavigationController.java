package ua.nure.dehtiarov;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.nure.dehtiarov.rest.myapi.RestServer;
import ua.nure.dehtiarov.rest.myapi.controller.DeviceController;
import ua.nure.dehtiarov.rest.myapi.controller.OutletController;
import ua.nure.dehtiarov.rest.myapi.entity.Outlet;
import ua.nure.dehtiarov.rest.myapi.entity.User;
import ua.nure.dehtiarov.rest.myapi.impl.DefaultRestServer;

import javax.servlet.http.HttpSession;

/**
 * Created by dehtiarov on 12/20/2015.
 */
@Controller
@RequestMapping("/admin")
public class NavigationController {

    RestServer restServer = new DefaultRestServer();

    @RequestMapping(method = RequestMethod.GET)
    public String goAdmin(ModelMap model) {
        return "admin";
    }

    @RequestMapping("/status")
    public String goStatisticPage(ModelMap model, HttpSession httpSession) {

        User user = (User) httpSession.getAttribute("user");

        OutletController outletController = restServer.getOutletController();
        httpSession.setAttribute("outlets", outletController.getAllUsersOutlets(user));

        return "status";
    }

    @RequestMapping("/charts")
    public String goChartsPage(ModelMap model) {
        return "charts";
    }

    @RequestMapping("/device")
    public String goDevicePage(ModelMap model, HttpSession httpSession) {

        User user = (User) httpSession.getAttribute("user");

        DeviceController deviceController = restServer.getDeviceController();
        httpSession.setAttribute("devices", deviceController.getAllUsersDevices(user));

        return "devices";
    }

    @RequestMapping("/device/edit")
    public String goEditDevicePage(ModelMap model) {
        return "edit_device";
    }

    @RequestMapping("/outlet/add/do")
    public String goAddOutletPage(ModelMap model,HttpSession httpSession,
                                  @RequestParam(value = "code") String code,
                                  @RequestParam(value = "name") String name,
                                  @RequestParam(value = "location") String location) {
        Outlet outlet = new Outlet((User)httpSession.getAttribute("user"), location, name, code);

        restServer.getOutletController().addNewOutlet((User)httpSession.getAttribute("user"), outlet);

        return "add_outlet";
    }

    @RequestMapping("/outlet/add")
    public String goAddOutletPage2(ModelMap model,HttpSession httpSession) {
        return "add_outlet";
    }

}
