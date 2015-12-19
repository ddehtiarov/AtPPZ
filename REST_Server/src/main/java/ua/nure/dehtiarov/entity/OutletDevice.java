package ua.nure.dehtiarov.entity;

import javax.persistence.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by dehtiarov on 12/12/2015.
 */
@Entity
@Table(name = "outlet_device")
public class OutletDevice {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    private Long outletid;

    private Long statusid;

    private String devicemacaddress;

    public OutletDevice() {

    }

    public OutletDevice(Long outletid, Long statusid, String devicemacaddress) {
        this.outletid = outletid;
        this.statusid = statusid;
        this.devicemacaddress = devicemacaddress;

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(() -> {
        }, 24, TimeUnit.HOURS);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOutletid() {
        return outletid;
    }

    public void setOutletid(Long outletid) {
        this.outletid = outletid;
    }

    public Long getStatusid() {
        return statusid;
    }

    public void setStatusid(Long statusid) {
        this.statusid = statusid;
    }

    public String getDevicemacaddress() {
        return devicemacaddress;
    }

    public void setDevicemacaddress(String devicemacaddress) {
        this.devicemacaddress = devicemacaddress;
    }
}
