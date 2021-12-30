package vnu.uet.cinema_manager.model;

public enum Size {

    S, M, L;

    public static Size convertToEnum(String str) {
        for (Size d : Size.values()) {
            if (str.equals(d.toString())) {
                return d;
            }
        }
        return S;
    }
}
