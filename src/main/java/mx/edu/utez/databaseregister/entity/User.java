package mx.edu.utez.databaseregister.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@NamedStoredProcedureQuery(name = "User.registerLogin",
procedureName = "registrar_login", parameters = {
    @StoredProcedureParameter(mode = ParameterMode.IN, name = "idUser", type = Long.class)
})
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")//
    private String username;

    @Column(name = "pass")//
    private String pass;

    @Column(name = "last_date_login")
    private Date lastDateLogin;

    @Column(name = "last_hour_login")
    private Time lastHourLogin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Date getLastDateLogin() {
        return lastDateLogin;
    }

    public void setLastDateLogin(Date lastDateLogin) {
        this.lastDateLogin = lastDateLogin;
    }

    public Time getLastHourLogin() {
        return lastHourLogin;
    }

    public void setLastHourLogin(Time lastHourLogin) {
        this.lastHourLogin = lastHourLogin;
    }

}
