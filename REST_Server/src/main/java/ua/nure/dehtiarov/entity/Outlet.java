package ua.nure.dehtiarov.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by dehtiarov on 12/12/2015.
 */
@Entity
@Table(name = "outlet", uniqueConstraints = @UniqueConstraint(columnNames = "serialCode"))
public class Outlet implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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
}
