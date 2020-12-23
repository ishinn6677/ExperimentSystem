package entity;

public class Login {
    private String name;
    private String id;
    private String identify;
    private String pwd;

    public Login(){

    }

    public Login(String name, String id, String identify, String pwd) {
        this.name = name;
        this.id = id;
        this.identify = identify;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Login{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", identify='" + identify + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
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
}
