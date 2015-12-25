package ua.nure.dehtiarov.entity;

/**
 * Created by dehtiarov on 12/19/2015.
 */
public enum StatusEnum {

    PAUSE(3) {
        @Override
        public StatusEnum changeStatus() {
            return OFFLINE;
        }
    }, ONLINE(2) {
        @Override
        public StatusEnum changeStatus() {
            return OFFLINE;
        }
    }, OFFLINE(1) {
        @Override
        public StatusEnum changeStatus() {
            return ONLINE;
        }
    };

    public int getStatusId() {
        return statusId;
    }

    private int statusId;

    StatusEnum(int i) {
        statusId = i;
    }

    public abstract StatusEnum changeStatus();

}
