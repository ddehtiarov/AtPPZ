package ua.nure.dehtiarov.rest.myapi.entity;

import java.io.Serializable;

/**
 * Created by dehtiarov on 12/12/2015.
 */
public class OutletDevice implements Serializable {

    private Long id;

    private Outlet outlet;

    private Status status;

    private Device device;

    public OutletDevice() {

    }

    public OutletDevice(Outlet outlet, Status status, Device device) {
        this.outlet = outlet;
        this.status = status;
        this.device = device;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Outlet getOutletid() {
        return outlet;
    }

    public void setOutletid(Outlet outlet) {
        this.outlet = outlet;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatusid(Status status) {
        this.status = status;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
