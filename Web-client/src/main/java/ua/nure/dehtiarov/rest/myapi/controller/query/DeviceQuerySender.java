package ua.nure.dehtiarov.rest.myapi.controller.query;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import ua.nure.dehtiarov.rest.myapi.entity.Device;
import ua.nure.dehtiarov.rest.myapi.entity.Outlet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dehtiarov on 12/24/2015.
 */
public class DeviceQuerySender extends QuerySender {


    public List<Device> executeGetAllDevices(String query) {
        List<Device> devices = new ArrayList<Device>();
        try {
            String url = query;

            DefaultHttpClient httpClient = new DefaultHttpClient();
            ResponseHandler<String> res = new BasicResponseHandler();

            HttpGet get = new HttpGet(url);

            String response = httpClient.execute(get, res);
            JSONArray result = new JSONArray(response);

            for(int i=0;i < result.length();i++){
                devices.add(new Device(result.getJSONObject(i)));
            }

        } catch (Throwable t) {
            throwable = t;
        }

        return devices;
    }
}
