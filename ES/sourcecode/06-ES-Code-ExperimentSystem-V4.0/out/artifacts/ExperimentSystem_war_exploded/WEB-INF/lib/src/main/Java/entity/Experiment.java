package main.Java.entity;

public class Experiment {
    private int id;
    private String ex_name;
    private String ex_teacher_id;
    private String ex_teacher_name;
    private String ex_content;
    private String deadline;
    private String room;
    private int year;
    private int term;
    private String upload;

    @Override
    public String toString() {
        return "Experiment{" +
                "id=" + id +
                ", ex_name='" + ex_name + '\'' +
                ", ex_teacher_id='" + ex_teacher_id + '\'' +
                ", ex_teacher_name='" + ex_teacher_name + '\'' +
                ", ex_content='" + ex_content + '\'' +
                ", deadline='" + deadline + '\'' +
                ", room='" + room + '\'' +
                ", year=" + year +
                ", term=" + term +
                ", upload='" + upload + '\'' +
                '}';
    }

    public Experiment(int id, String ex_name, String ex_teacher_id, String ex_teacher_name, String ex_content, String deadline, String room, int year, int term, String upload) {
        this.id = id;
        this.ex_name = ex_name;
        this.ex_teacher_id = ex_teacher_id;
        this.ex_teacher_name = ex_teacher_name;
        this.ex_content = ex_content;
        this.deadline = deadline;
        this.room = room;
        this.year = year;
        this.term = term;
        this.upload = upload;
    }

    public Experiment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEx_name() {
        return ex_name;
    }

    public void setEx_name(String ex_name) {
        this.ex_name = ex_name;
    }

    public String getEx_teacher_id() {
        return ex_teacher_id;
    }

    public void setEx_teacher_id(String ex_teacher_id) {
        this.ex_teacher_id = ex_teacher_id;
    }

    public String getEx_teacher_name() {
        return ex_teacher_name;
    }

    public void setEx_teacher_name(String ex_teacher_name) {
        this.ex_teacher_name = ex_teacher_name;
    }

    public String getEx_content() {
        return ex_content;
    }

    public void setEx_content(String ex_content) {
        this.ex_content = ex_content;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
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

    public String getUpload() {
        return upload;
    }

    public void setUpload(String upload) {
        this.upload = upload;
    }
}

