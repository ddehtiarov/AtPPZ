package ua.nure.dehtiarov.rest.myapi.constant;

/**
 * Created by dehtiarov on 12/20/2015.
 */
public class PathConstant {

    private static final String IP = "http://159.224.66.191";

    private static final String LH = "http://localhost";

    private static final String SERVER_HOST = LH;
    private static final String SERVER_PORT = ":8080";
    private static final String SERVER = SERVER_HOST + SERVER_PORT;

    public static final String USER = SERVER + "/user/";

    public static final String OUTLET = SERVER + "/outlet/";

    public static final String ADDING = "add?";

    public static final String OUT_CODE = "serialCode=";

    public static final String OUT_NAME = SERVER + "name=";

    public static final String OUT_LOCATION = "location=";

    public static final String OUT_USER_ID = "userId=";

    public static final String AUTH = USER + "auth?";

    public static final String USER_EMAIL = "email=";

    public static final String USER_NAME = "name=";

    public static final String AMPERSAND = "&";

    public static final String USER_PASS = "password=";

    public static final String USER_ID = "id=";

    public static final String GETUSER = USER + "get?" + USER_EMAIL;

    public static final String ADD_USER = USER + "add?";

    public static final String VALID_USER = USER + "login?" + USER_EMAIL;


}
