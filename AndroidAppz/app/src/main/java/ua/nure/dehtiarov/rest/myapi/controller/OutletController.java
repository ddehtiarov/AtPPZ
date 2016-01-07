package ua.nure.dehtiarov.rest.myapi.controller;

import java.util.List;

import ua.nure.dehtiarov.rest.myapi.entity.Outlet;
import ua.nure.dehtiarov.rest.myapi.entity.User;

/**
 * Created by dehtiarov on 12/24/2015.
 */
public interface OutletController {

    List<Outlet> getAllUsersOutlets(User user);

    boolean addNewOutlet(User user, Outlet outlet);

}
