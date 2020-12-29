package main.Java.entity;

public class Sign {
    private int id;
    private String Ex_name;
    private int Ex_id;
    private String Sign_time;
    private String Stu_id;
    private String Stu_name;

    @Override
    public String toString() {
        return "Sign{" +
                "id=" + id +
                ", Ex_name='" + Ex_name + '\'' +
                ", Ex_id=" + Ex_id +
                ", Sign_time='" + Sign_time + '\'' +
                ", Stu_id='" + Stu_id + '\'' +
                ", Stu_name='" + Stu_name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEx_name() {
        return Ex_name;
    }

    public void setEx_name(String ex_name) {
        Ex_name = ex_name;
    }

    public int getEx_id() {
        return Ex_id;
    }

    public void setEx_id(int ex_id) {
        Ex_id = ex_id;
    }

    public String getSign_time() {
        return Sign_time;
    }

    public void setSign_time(String sign_time) {
        Sign_time = sign_time;
    }

    public String getStu_id() {
        return Stu_id;
    }

    public void setStu_id(String stu_id) {
        Stu_id = stu_id;
    }

    public String getStu_name() {
        return Stu_name;
    }

    public void setStu_name(String stu_name) {
        Stu_name = stu_name;
    }
}
