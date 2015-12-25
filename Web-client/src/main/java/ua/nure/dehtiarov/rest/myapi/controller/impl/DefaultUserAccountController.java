package ua.nure.dehtiarov.rest.myapi.controller.impl;

import org.apache.log4j.Logger;
import ua.nure.dehtiarov.rest.myapi.constant.PathConstant;
import ua.nure.dehtiarov.rest.myapi.controller.UserAccountController;
import ua.nure.dehtiarov.rest.myapi.controller.query.CommonQuerySender;
import ua.nure.dehtiarov.rest.myapi.controller.query.UserQuerySender;
import ua.nure.dehtiarov.rest.myapi.entity.User;

/**
 * Created by dehtiarov on 12/20/2015.
 */
public class DefaultUserAccountController implements UserAccountController {

    private static final Logger LOGGER = Logger.getLogger(DefaultUserAccountController.class);

    UserQuerySender querySender = new UserQuerySender();
    CommonQuerySender commonQuerySender = new CommonQuerySender();

    @Override
    public boolean loginUser(User user) {

        String query = PathConstant.AUTH + PathConstant.USER_EMAIL
                + user.getEmail() + PathConstant.AMPERSAND + PathConstant.USER_PASS
                + user.getPassword();

        LOGGER.info("query: " + query);
        System.out.println("query: " + query);

        boolean result = commonQuerySender.executeBooleanQueryThURL(query);

        System.out.println("result " + result);

        return result;
    }

    @Override
    public User getUserByUserModel(User user) {

        String query = PathConstant.USER + "get?" + PathConstant.USER_EMAIL
                + user.getEmail();

        LOGGER.info("query: " + query);
        System.out.println("query: " + query);

        User resultUser = querySender.executeUser(query);

        return resultUser;
    }

    @Override
    public boolean registerNewUser(User user) {

        String query = PathConstant.ADD_USER + PathConstant.USER_EMAIL
                + user.getEmail() + PathConstant.AMPERSAND + PathConstant.USER_PASS
                + user.getPassword() + PathConstant.AMPERSAND + PathConstant.USER_NAME + user.getName();

        LOGGER.info("query: " + query);
        System.out.println("query: " + query);

        User resultUser = querySender.executeUser(query);

        if (resultUser.getId() > -1) {
            return true;
        }

        return false;
    }
}
