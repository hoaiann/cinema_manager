package vnu.uet.cinema_manager.model;

public enum TimeCalendar {

    CASE_1("7:30 AM - 9:30 AM"),
    CASE_2("10:30 AM - 12:30 AM"),
    CASE_3("1:30 PM - 3:30 PM"),
    CASE_4("4:30 PM - 5:30 PM"),
    CASE_5("6:30 PM - 8:30 PM"),
    CASE_6("9:30 PM - 11:30 PM");
    
    private String s;

    TimeCalendar(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    public static String getString(TimeCalendar TimeCalendar) {
        for (TimeCalendar s : TimeCalendar.values()) {
            if (s.equals(TimeCalendar)) {
                return s.getS();
            }
        }
        return CASE_1.getS();
    }

    public static TimeCalendar convertToEnum(String str) {
        for (TimeCalendar s : TimeCalendar.values()) {
            if (str.equals(s.toString())) {
                return s;
            }
        }
        return CASE_1;
    }
}
