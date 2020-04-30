package sg.edu.rp.c346.p02_holidays;

public class holiday {

    private String holidays;
    private String date;

    public holiday(String holidays, String date) {
        this.holidays = holidays;
        this.date = date;
    }

    public String getHolidays() {
        return holidays;
    }

    public void setHolidays(String holidays) {
        this.holidays = holidays;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
