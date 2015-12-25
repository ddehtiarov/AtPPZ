package ua.nure.dehtiarov.rest.myapi.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by dehtiarov on 12/12/2015.
 */
public class Statistic implements Serializable {

    private Long id;

    private User user;

    private OutletDevice outletDevice;

    private Timestamp begintime;

    private Timestamp endtime;

    public Statistic() {
    }

    public Statistic(Timestamp endtime, Timestamp begintime, OutletDevice outletdevice, User user) {
        this.endtime = endtime;
        this.begintime = begintime;
        this.outletDevice = outletdevice;
        this.user = user;
    }

    public Timestamp getEndtime() {
        return endtime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OutletDevice getOutletDevice() {
        return outletDevice;
    }

    public void setOutletDevice(OutletDevice outletDevice) {
        this.outletDevice = outletDevice;
    }

    public Timestamp getBegintime() {
        return begintime;
    }

    public void setBegintime(Timestamp begintime) {
        this.begintime = begintime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
