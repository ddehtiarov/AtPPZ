package ua.nure.dehtiarov.rest.myapi.controller.query;

//import org.apache.http.client.ResponseHandler;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.BasicResponseHandler;
//import org.apache.http.impl.client.DefaultHttpClient;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.BasicResponseHandler;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import ua.nure.dehtiarov.rest.myapi.entity.Outlet;

/**
 * Created by dehtiarov on 12/24/2015.
 */
public class OutletQuerySender extends QuerySender {

    public List<Outlet> executeGetAllOutlets(String... params) {
        List<Outlet> outlets = new ArrayList<Outlet>();
        try {
            String url = params[0];

            DefaultHttpClient httpClient = new DefaultHttpClient();
            ResponseHandler<String> res = new BasicResponseHandler();

            HttpGet get = new HttpGet(url);

            String response = httpClient.execute(get, res);
            JSONArray result = new JSONArray(response);

            for(int i=0;i < result.length();i++){
                outlets.add(new Outlet(result.getJSONObject(i)));
            }

            //outlets = new User(result);

        } catch (Throwable t) {
            throwable = t;
        }
        return outlets;
    }
}
