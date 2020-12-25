package main.Java.entity;

public class Login {
    private String name;
    private String id;
    private String identify;
    private String pwd;
    private String birthday;
    private String address;
    private String sex;

    @Override
    public String toString() {
        return "Login{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", identify='" + identify + '\'' +
                ", pwd='" + pwd + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Login() {
    }

    public Login(String name, String id, String identify, String pwd, String birthday, String address, String sex) {
        this.name = name;
        this.id = id;
        this.identify = identify;
        this.pwd = pwd;
        this.birthday = birthday;
        this.address = address;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
