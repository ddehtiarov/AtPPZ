package ua.nure.dehtiarov.rest.myapi.controller.query;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created by dehtiarov on 12/24/2015.
 */
public class CommonQuerySender extends QuerySender {

    public Boolean executeBooleanQueryThURL(String... params) {
        String result = "false";

        try {
            String url = params[0];

            DefaultHttpClient httpClient = new DefaultHttpClient();
            ResponseHandler<String> res = new BasicResponseHandler();

            HttpGet get = new HttpGet(url);

            String response = httpClient.execute(get, res);

            result = response;

        } catch (Throwable t) {
            throwable = t;
        }
        System.out.println(result);
        return Boolean.valueOf(result);
    }

}
