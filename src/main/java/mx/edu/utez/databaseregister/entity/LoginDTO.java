package mx.edu.utez.databaseregister.entity;

public class LoginDTO {
    private String username;
    private String pass;
    
    public String getUserName() {
        return username;
    }
    public void setUserName(String username) {
        this.username = username;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

    
}
