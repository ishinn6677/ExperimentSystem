package main.Java.entity;

public class Appoint {
    private int id;
    private String ex_teacher_id;
    private String appoint_room;
    private int appoint_cpt;
    private int course_th;
    private int day_th;
    private int week_th;
    private int ex_id;
    private String ex_name;
    private String stu_id;
    private String stu_name;

    @Override
    public String toString() {
        return "Appoint{" +
                "id=" + id +
                ", ex_teacher_id='" + ex_teacher_id + '\'' +
                ", appoint_room='" + appoint_room + '\'' +
                ", appoint_cpt=" + appoint_cpt +
                ", course_th=" + course_th +
                ", day_th=" + day_th +
                ", week_th=" + week_th +
                ", ex_id=" + ex_id +
                ", ex_name='" + ex_name + '\'' +
                ", stu_id='" + stu_id + '\'' +
                ", stu_name='" + stu_name + '\'' +
                '}';
    }

    public Appoint() {
    }

    public Appoint(int id, String ex_teacher_id, String appoint_room, int appoint_cpt, int course_th, int day_th, int week_th, int ex_id, String ex_name, String stu_id, String stu_name) {
        this.id = id;
        this.ex_teacher_id = ex_teacher_id;
        this.appoint_room = appoint_room;
        this.appoint_cpt = appoint_cpt;
        this.course_th = course_th;
        this.day_th = day_th;
        this.week_th = week_th;
        this.ex_id = ex_id;
        this.ex_name = ex_name;
        this.stu_id = stu_id;
        this.stu_name = stu_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEx_teacher_id() {
        return ex_teacher_id;
    }

    public void setEx_teacher_id(String ex_teacher_id) {
        this.ex_teacher_id = ex_teacher_id;
    }

    public String getAppoint_room() {
        return appoint_room;
    }

    public void setAppoint_room(String appoint_room) {
        this.appoint_room = appoint_room;
    }

    public int getAppoint_cpt() {
        return appoint_cpt;
    }

    public void setAppoint_cpt(int appoint_cpt) {
        this.appoint_cpt = appoint_cpt;
    }

    public int getCourse_th() {
        return course_th;
    }

    public void setCourse_th(int course_th) {
        this.course_th = course_th;
    }

    public int getDay_th() {
        return day_th;
    }

    public void setDay_th(int day_th) {
        this.day_th = day_th;
    }

    public int getWeek_th() {
        return week_th;
    }

    public void setWeek_th(int week_th) {
        this.week_th = week_th;
    }

    public int getEx_id() {
        return ex_id;
    }

    public void setEx_id(int ex_id) {
        this.ex_id = ex_id;
    }

    public String getEx_name() {
        return ex_name;
    }

    public void setEx_name(String ex_name) {
        this.ex_name = ex_name;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }
}
