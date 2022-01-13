package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "washing_assistant")
@NamedQueries({
        @NamedQuery(name = "WashingAssistant.getAllRows", query = "SELECT w from WashingAssistant w")
})
public class WashingAssistant implements Serializable {
    private static final long serialVersionUID = 5994110863150984796L;

    //Variables

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "primaryLanguage", nullable = false)
    private String primaryLanguage;

    @Column(name = "yearsOfExperience", nullable = false)
    private int yearsOfExperience;

    @Column(name = "pricePerHour", nullable = false)
    private int pricePerHour;

    //Constructors

    public WashingAssistant() {
    }

    public WashingAssistant(String name, String primaryLanguage, int yearsOfExperience, int pricePerHour) {
        this.name = name;
        this.primaryLanguage = primaryLanguage;
        this.yearsOfExperience = yearsOfExperience;
        this.pricePerHour = pricePerHour;
    }

    public WashingAssistant(Long id, String name, String primaryLanguage, int yearsOfExperience, int pricePerHour) {
        this.id = id;
        this.name = name;
        this.primaryLanguage = primaryLanguage;
        this.yearsOfExperience = yearsOfExperience;
        this.pricePerHour = pricePerHour;
    }

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryLanguage() {
        return primaryLanguage;
    }

    public void setPrimaryLanguage(String primaryLanguage) {
        this.primaryLanguage = primaryLanguage;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    //toString

    @Override
    public String toString() {
        return "WashingAssistant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", primaryLanguage='" + primaryLanguage + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                ", pricePerHour=" + pricePerHour +
                '}';
    }
}