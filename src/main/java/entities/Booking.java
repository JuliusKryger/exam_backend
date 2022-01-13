package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "booking")
@NamedQueries({
        @NamedQuery(name = "Booking.info", query = "SELECT b from Booking b where b.user.userName = :userName")
})
public class Booking implements Serializable {
    private static final long serialVersionUID = -1210755182239996033L;

    //Variables

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "appointment", nullable = false)
    private String appointment;

    @Column(name = "duration", nullable = false)
    private int duration;

    @ManyToOne
    private User user;

    //Constructor

    public Booking() {
    }

    public Booking(String appointment, int duration, User user) {
        this.appointment = appointment;
        this.duration = duration;
        this.user = user;
    }

    public Booking(String appointment, int duration) {
        this.appointment = appointment;
        this.duration = duration;
    }

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //toString


    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", appointment='" + appointment + '\'' +
                ", duration=" + duration +
                ", user=" + user +
                '}';
    }
}