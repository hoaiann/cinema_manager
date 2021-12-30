package vnu.uet.cinema_manager.model;

public enum LangFilm {

    VIET_SUB, THUYET_MINH;

    public static LangFilm convertToEnum(String str) {
        for (LangFilm d : LangFilm.values()) {
            if (str.equals(d.toString())) {
                return d;
            }
        }
        return VIET_SUB;
    }
}
