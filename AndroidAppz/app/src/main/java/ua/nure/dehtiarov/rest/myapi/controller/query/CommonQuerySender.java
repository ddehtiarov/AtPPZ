package ua.nure.dehtiarov.rest.myapi.controller.query;

import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.BasicResponseHandler;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

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
            Thread.sleep(100);

            result = response;

        } catch (Throwable t) {
            throwable = t;
        }
        System.out.println(result);
        return Boolean.valueOf(result);
    }

}
