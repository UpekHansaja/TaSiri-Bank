package lk.jiat.bank.model;

public class User {

    private String username;
    private String password;
    private String role;
    private String accNo;

    public User(String username, String password, String role, String accNo) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.accNo = accNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }
}
