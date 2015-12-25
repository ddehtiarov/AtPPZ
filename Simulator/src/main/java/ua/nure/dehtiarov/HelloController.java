package ua.nure.dehtiarov;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class HelloController {
    @RequestMapping("/")
    public String printWelcome(ModelMap model) {
        return "hello";
    }

    @RequestMapping("/process")
    public String process(ModelMap model,
                          @RequestParam(value = "code") String code,
                          @RequestParam(value = "macaddress") String macaddress) {

        String query = "http://localhost:8080/outdevactivate/do?outCode=" + code + "&macaddress=" + macaddress;

        DefaultHttpClient httpClient = new DefaultHttpClient();
        ResponseHandler<String> res = new BasicResponseHandler();

        HttpGet get = new HttpGet(query);

        try {
            httpClient.execute(get, res);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("query:" + query);

        return "hello";
    }
}