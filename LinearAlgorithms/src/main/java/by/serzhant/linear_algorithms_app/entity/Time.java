package by.serzhant.linear_algorithms_app.entity;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return Objects.equals(hour, time.hour) &&
                Objects.equals(minute, time.minute) &&
                Objects.equals(second, time.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute, second);
    }

    @Override
    public String toString() {
        return "Time{" +
                "hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                '}';
    }
}
