package main.Java.entity;

public class Course {
    private int id;
    private int course_year;
    private int course_term;
    private int course_week_st;
    private int course_week_ed;
    private int course_weekday;
    private int course_th;
    private String course_name;
    private String teacher_name;
    private String room;

    public Course() {
    }

    public Course(int id, int course_year, int course_term, int course_week_st, int course_week_ed, int course_weekday, int course_th, String course_name, String teacher_name, String room) {
        this.id = id;
        this.course_year = course_year;
        this.course_term = course_term;
        this.course_week_st = course_week_st;
        this.course_week_ed = course_week_ed;
        this.course_weekday = course_weekday;
        this.course_th = course_th;
        this.course_name = course_name;
        this.teacher_name = teacher_name;
        this.room = room;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", course_year=" + course_year +
                ", course_term=" + course_term +
                ", course_week_st=" + course_week_st +
                ", course_week_ed=" + course_week_ed +
                ", course_weekday=" + course_weekday +
                ", course_th=" + course_th +
                ", course_name='" + course_name + '\'' +
                ", teacher_name='" + teacher_name + '\'' +
                ", room='" + room + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse_year() {
        return course_year;
    }

    public void setCourse_year(int course_year) {
        this.course_year = course_year;
    }

    public int getCourse_term() {
        return course_term;
    }

    public void setCourse_term(int course_term) {
        this.course_term = course_term;
    }

    public int getCourse_week_st() {
        return course_week_st;
    }

    public void setCourse_week_st(int course_week_st) {
        this.course_week_st = course_week_st;
    }

    public int getCourse_week_ed() {
        return course_week_ed;
    }

    public void setCourse_week_ed(int course_week_ed) {
        this.course_week_ed = course_week_ed;
    }

    public int getCourse_weekday() {
        return course_weekday;
    }

    public void setCourse_weekday(int course_weekday) {
        this.course_weekday = course_weekday;
    }

    public int getCourse_th() {
        return course_th;
    }

    public void setCourse_th(int course_th) {
        this.course_th = course_th;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}

