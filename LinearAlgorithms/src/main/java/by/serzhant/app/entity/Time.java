package by.serzhant.app.entity;

public class Time {
    private Numeral hour;
    private Numeral minute;
    private Numeral second;

    public Time() {
    }
    public Time(Numeral hour, Numeral minute, Numeral second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Numeral getHour() {
        return hour;
    }

    public Numeral getMinute() {
        return minute;
    }

    public Numeral getSecond() {
        return second;
    }

    public void setHour(Numeral hour) {
        this.hour = hour;
    }

    public void setMinute(Numeral minute) {
        this.minute = minute;
    }

    public void setSecond(Numeral second) {
        this.second = second;
    }
}
