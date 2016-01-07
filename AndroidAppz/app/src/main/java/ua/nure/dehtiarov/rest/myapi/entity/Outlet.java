package ua.nure.dehtiarov.rest.myapi.entity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by dehtiarov on 12/12/2015.
 */
public class Outlet implements Serializable {

    private Long id;

    private User user;

    private Status status;

    private String location;

    private String name;

    private String serialCode;

    public Outlet() {
    }

    public Outlet(User user, String location, String name, String serialCode) {
        this.user = user;
        this.location = location;
        this.name = name;
        this.serialCode = serialCode;
        Status status = new Status();
        status.setId(1L);
        this.status = status;

    }

    public Outlet(JSONObject jsonObject) {
        try {
            this.user = new User(jsonObject.getJSONObject("user"));
            this.location = jsonObject.get("location").toString();
            this.name = jsonObject.get("name").toString();
            this.serialCode = jsonObject.get("serialCode").toString();
            Status status = new Status(jsonObject.getJSONObject("status"));
            this.status = status;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialCode() {
        return serialCode;
    }

    public void setSerialCode(String serialCode) {
        this.serialCode = serialCode;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatusid(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Outlet{" +
                "id=" + id +
                ", user=" + user +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                ", serialCode='" + serialCode + '\'' +
                '}';
    }
}
