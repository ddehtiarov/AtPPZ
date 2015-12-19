package ua.nure.dehtiarov.entity;

/**
 * Created by dehtiarov on 12/19/2015.
 */
public enum StatusEnum {

    PAUSE(1), ONLINE(2), OFFLINE(3);

    public int getStatusId() {
        return statusId;
    }

    private int statusId;

    StatusEnum(int i) {
        statusId = i;
    }

}
