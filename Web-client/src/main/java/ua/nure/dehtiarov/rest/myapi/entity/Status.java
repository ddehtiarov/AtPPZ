package ua.nure.dehtiarov.rest.myapi.entity;

import java.io.Serializable;

/**
 * Created by dehtiarov on 12/12/2015.
 */
public class Status implements Serializable {

    private Long id;

    private String value;

    public Status() {
    }

    public Status(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
