package dtos;

import entities.User;
import entities.WashingAssistant;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDTO {

    //Variables

    private Long id;
    private String appointment;
    private int duration;
    private User user;
    private List<WashingAssistant> washingAssistantList = new ArrayList<>();

    //Constructor

    public BookingDTO(Long id, String appointment, int duration, User user, List<WashingAssistant> washingAssistantList) {
        this.id = id;
        this.appointment = appointment;
        this.duration = duration;
        this.user = user;
        this.washingAssistantList = washingAssistantList;
    }

    public BookingDTO(String appointment, int duration, User user, List<WashingAssistant> washingAssistantList) {
        this.appointment = appointment;
        this.duration = duration;
        this.user = user;
        this.washingAssistantList = washingAssistantList;
    }


    //Getters And Setters


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

    public List<WashingAssistant> getWashingAssistantList() {
        return washingAssistantList;
    }

    public void setWashingAssistantList(List<WashingAssistant> washingAssistantList) {
        this.washingAssistantList = washingAssistantList;
    }

    //toString

    @Override
    public String toString() {
        return "BookingDTO{" +
                "id=" + id +
                ", appointment='" + appointment + '\'' +
                ", duration=" + duration +
                ", user=" + user +
                ", washingAssistantList=" + washingAssistantList +
                '}';
    }
}
