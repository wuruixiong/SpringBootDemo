package wrx.spbdemo;

public class User {

    private Integer uid;

    private String name;

    private String password;

    private String email;

    public User() {
    }

    public User(String name, String password, String email) {
        setName(name);
        setPassword(password);
        setEmail(email);
    }

    public User(Integer id, String name, String password, String email) {
        setUid(id);
        setName(name);
        setPassword(password);
        setEmail(email);
    }


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}