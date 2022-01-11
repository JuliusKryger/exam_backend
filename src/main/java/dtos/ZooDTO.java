package dtos;

import entities.Animal;
import entities.Zoo;

import java.util.ArrayList;
import java.util.List;

public class ZooDTO {

    /** This is my variables **/

    private Integer id;
    private String zoo;
    private List<AnimalDTO> animals;

    /** This is the constructor **/

    public ZooDTO(String zoo, List<AnimalDTO> animals) {
        this.zoo = zoo;
        this.animals = animals;
    }

    public ZooDTO(Zoo entity) {
        this.id = entity.getId();
        this.zoo = entity.getZoo();
        this.animals = entity.getAnimals() != null ? entity.getAnimalDTOList(entity.getAnimals()) : new ArrayList<>();
    }

    /** GETTERS AND SETTERS **/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZoo() {
        return zoo;
    }

    public void setZoo(String zoo) {
        this.zoo = zoo;
    }

    public List<AnimalDTO> getAnimals() {
        return animals;
    }

    public void setAnimals(List<AnimalDTO> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "ZooDTO{" +
                "id=" + id +
                ", zoo='" + zoo + '\'' +
                ", animals=" + animals +
                '}';
    }
}
