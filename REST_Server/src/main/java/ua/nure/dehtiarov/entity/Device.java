package ua.nure.dehtiarov.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by dehtiarov on 12/12/2015.
 */
@Entity
@Table(name = "device", uniqueConstraints = @UniqueConstraint(columnNames = "macaddress"))
public class Device implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    private String macaddress;

    private String name;

    private Timestamp lastActivityTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Device() {
        this.macaddress = UUID.randomUUID().toString();
    }

    public Device(String name) {
        this.name = name;
        this.macaddress = UUID.randomUUID().toString();

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(() -> {
        }, 24, TimeUnit.HOURS);

    }

    public Device(String name, String mac, User user) {
        this.name = name;
        this.macaddress = mac;
        this.user = user;

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(() -> {
        }, 24, TimeUnit.HOURS);

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

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", macaddress='" + macaddress + '\'' +
                ", name='" + name + '\'' +
                ", lastActivityTime=" + lastActivityTime +
                ", user=" + user +
                '}';
    }
}
