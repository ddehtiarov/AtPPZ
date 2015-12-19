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

    private Long userid;

    private Long outletdeviceid;

    private Timestamp begintime;

    private Timestamp endtime;

    public Statistic() {
    }

    public Statistic(Timestamp endtime, Timestamp begintime, Long outletdeviceid, Long userid) {
        this.endtime = endtime;
        this.begintime = begintime;
        this.outletdeviceid = outletdeviceid;
        this.userid = userid;

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

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getOutletdeviceid() {
        return outletdeviceid;
    }

    public void setOutletdeviceid(Long outletdeviceid) {
        this.outletdeviceid = outletdeviceid;
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
