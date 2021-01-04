package main.Java.entity;

public class MyExperiment {
    private int ex_id;
    private String ex_name;
    private String ex_teacher;
    private String room;
    private int year;
    private int term;
    private String deadline;
    private int grade;

    public MyExperiment() {
    }

    @Override
    public String toString() {
        return "MyExperiment{" +
                "ex_id=" + ex_id +
                ", ex_name='" + ex_name + '\'' +
                ", ex_teacher='" + ex_teacher + '\'' +
                ", room='" + room + '\'' +
                ", year=" + year +
                ", term=" + term +
                ", deadline='" + deadline + '\'' +
                ", grade=" + grade +
                '}';
    }

    public MyExperiment(int ex_id, String ex_name, String ex_teacher, String room, int year, int term, String deadline, int grade) {
        this.ex_id = ex_id;
        this.ex_name = ex_name;
        this.ex_teacher = ex_teacher;
        this.room = room;
        this.year = year;
        this.term = term;
        this.deadline = deadline;
        this.grade = grade;
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

    public String getEx_teacher() {
        return ex_teacher;
    }

    public void setEx_teacher(String ex_teacher) {
        this.ex_teacher = ex_teacher;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
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

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
