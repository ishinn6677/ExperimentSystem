package main.Java.entity;

public class Time {
    private int year;   //年
    private int term;   //学期
    private int weekth; //周
    private int dayth;  //天
    private int courseth;//大节
    private String room;//机房

    @Override
    public String toString() {
        return "Time{" +
                "year=" + year +
                ", term=" + term +
                ", weekth=" + weekth +
                ", dayth=" + dayth +
                ", courseth=" + courseth +
                ", room='" + room + '\'' +
                '}';
    }

    public Time() {
    }

    public Time(int year, int term, int weekth, int dayth, int courseth, String room) {
        this.year = year;
        this.term = term;
        this.weekth = weekth;
        this.dayth = dayth;
        this.courseth = courseth;
        this.room = room;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getWeekth() {
        return weekth;
    }

    public void setWeekth(int weekth) {
        this.weekth = weekth;
    }

    public int getDayth() {
        return dayth;
    }

    public void setDayth(int dayth) {
        this.dayth = dayth;
    }

    public int getCourseth() {
        return courseth;
    }

    public void setCourseth(int courseth) {
        this.courseth = courseth;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
