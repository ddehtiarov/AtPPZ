package ua.nure.dehtiarov.rest.myapi.entity;

import java.io.Serializable;

/**
 * Created by dehtiarov on 12/12/2015.
 */
public class Device implements Serializable {

    private String macaddress;

    private String name;

    public Device() {
    }

    public Device(String name) {
        this.name = name;
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
}
