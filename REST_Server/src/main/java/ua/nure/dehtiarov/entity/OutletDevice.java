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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "outlet_id", nullable = false)
    private Outlet outlet;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "device_macaddress", nullable = false)
    private Device device;

    public OutletDevice() {

    }

    public OutletDevice(Outlet outlet, Status status, Device device) {
        this.outlet = outlet;
        this.status = status;
        this.device = device;

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
