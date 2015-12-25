package ua.nure.dehtiarov.rest.myapi.controller.impl;

import java.util.List;

import ua.nure.dehtiarov.rest.myapi.constant.PathConstant;
import ua.nure.dehtiarov.rest.myapi.controller.OutletController;
import ua.nure.dehtiarov.rest.myapi.controller.query.CommonQuerySender;
import ua.nure.dehtiarov.rest.myapi.controller.query.OutletQuerySender;
import ua.nure.dehtiarov.rest.myapi.entity.Outlet;
import ua.nure.dehtiarov.rest.myapi.entity.User;

/**
 * Created by dehtiarov on 12/24/2015.
 */
public class DefaultOutletController implements OutletController {

    CommonQuerySender commonQuerySender = new CommonQuerySender();
    OutletQuerySender outletQuerySender = new OutletQuerySender();

    @Override
    public List<Outlet> getAllUsersOutlets(User user) {
        String query = PathConstant.OUTLET + "getAll?" + PathConstant.OUT_USER_ID +
                +user.getId();
        System.out.println("query: " + query);

        List<Outlet> result = outletQuerySender.executeGetAllOutlets(query);

        System.out.println("result " + result);

        return result;
    }

    @Override
    public boolean addNewOutlet(User user, Outlet outlet) {

        String query = PathConstant.OUTLET + PathConstant.ADDING + PathConstant.OUT_USER_ID +
                +user.getId() + PathConstant.AMPERSAND + PathConstant.OUT_CODE +
                outlet.getSerialCode() + PathConstant.AMPERSAND +
                PathConstant.OUT_LOCATION + outlet.getLocation() +
                PathConstant.AMPERSAND + PathConstant.OUT_NAME + outlet.getName();

        System.out.println("query: " + query);

        boolean result = commonQuerySender.executeBooleanQueryThURL(query);

        System.out.println("result " + result);

        return result;
    }
}
