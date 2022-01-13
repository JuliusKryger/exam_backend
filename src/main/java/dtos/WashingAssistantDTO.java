package dtos;

import entities.WashingAssistant;

public class WashingAssistantDTO {

    //Variables

    private Long id;
    private String name;
    private String primaryLanguage;
    private int yearsOfExperience;
    private int pricePerHour;

    //Constructor

    public WashingAssistantDTO(Long id, String name, String primaryLanguage, int yearsOfExperience, int pricePerHour) {
        this.id = id;
        this.name = name;
        this.primaryLanguage = primaryLanguage;
        this.yearsOfExperience = yearsOfExperience;
        this.pricePerHour = pricePerHour;
    }

    public WashingAssistantDTO(String name, String primaryLanguage, int yearsOfExperience, int pricePerHour) {
        this.name = name;
        this.primaryLanguage = primaryLanguage;
        this.yearsOfExperience = yearsOfExperience;
        this.pricePerHour = pricePerHour;
    }

    public WashingAssistantDTO(WashingAssistant entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.primaryLanguage = entity.getPrimaryLanguage();
        this.yearsOfExperience = entity.getYearsOfExperience();
        this.pricePerHour = entity.getPricePerHour();
    }

    //getters and setters

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
        return "WashingAssistantDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", primaryLanguage='" + primaryLanguage + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                ", pricePerHour=" + pricePerHour +
                '}';
    }
}
