package vnu.uet.cinema_manager.model;

public enum Status {

    ACTIVE, DEACTIVATE;

    public static Status convertToEnum(String str) {
        for (Status d : Status.values()) {
            if (str.equals(d.toString())) {
                return d;
            }
        }
        return ACTIVE;
    }
}
