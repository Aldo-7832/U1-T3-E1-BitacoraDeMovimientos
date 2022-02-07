package mx.edu.utez.databaseregister.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "last_login")
@NamedStoredProcedureQuery(name = "LastLogin.procedureEntity",
     procedureName = "registrar_login", parameters = {
     @StoredProcedureParameter(mode = ParameterMode.IN, name = "idUser", type = Integer.class)
 })
public class LastLogin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date_login")//
    private Date date;

    @Column(name = "hour_login")//
    private Time hour;

    @OneToOne()
    @JoinColumn(name = "user_id")//
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getHour() {
        return hour;
    }

    public void setHour(Time hour) {
        this.hour = hour;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   
}
