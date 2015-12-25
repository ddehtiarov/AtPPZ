package ua.nure.dehtiarov.rest.myapi.controller.query;

import org.json.JSONObject;

import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.BasicResponseHandler;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import ua.nure.dehtiarov.rest.myapi.entity.User;

/**
 * Created by dehtiarov on 12/20/2015.
 */
public class UserQuerySender extends QuerySender {

    public User executeUser(String... params) {
        User user;
        try {
            String url = params[0];

            DefaultHttpClient httpClient = new DefaultHttpClient();
            ResponseHandler<String> res = new BasicResponseHandler();

            HttpGet get = new HttpGet(url);

            String response = httpClient.execute(get, res);
            JSONObject result = new JSONObject(response);

            user = new User(result);

        } catch (Throwable t) {
            user = new User();
            user.setId(-1L);
            throwable = t;
        }
        return user;
    }
}
