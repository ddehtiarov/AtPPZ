package ua.nure.dehtiarov.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by dehtiarov on 12/12/2015.
 */
@Entity
@Table(name = "statistic")
public class Statistic {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "outletDevice_id", nullable = false)
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

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(() -> {
        }, 24, TimeUnit.HOURS);
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
