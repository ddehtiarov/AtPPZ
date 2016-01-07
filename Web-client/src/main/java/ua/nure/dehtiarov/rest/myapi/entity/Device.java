package ua.nure.dehtiarov.rest.myapi.entity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by dehtiarov on 12/12/2015.
 */
public class Device implements Serializable {

    private long id;

    private String macaddress;

    private String name;

    private Timestamp lastActivityTime;

    private User user;

    public Device() {
    }

    public Device(String name) {
        this.name = name;
    }

    public Device(JSONObject jsonObject) {
        try {
            this.user = new User(jsonObject.getJSONObject("user"));
            this.name = jsonObject.get("name").toString();
            this.macaddress = jsonObject.get("macaddress").toString();
            this.lastActivityTime = new Timestamp(Long.valueOf(jsonObject.get("lastActivityTime").toString()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMacaddress() {
        return macaddress;
    }

    public void setMacaddress(String macaddress) {
        this.macaddress = macaddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getLastActivityTime() {
        return lastActivityTime;
    }

    public void setLastActivityTime(Timestamp lastActivityTime) {
        this.lastActivityTime = lastActivityTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
