package ua.nure.dehtiarov.rest.myapi.controller.query;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
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
