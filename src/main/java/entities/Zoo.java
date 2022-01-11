package entities;

import dtos.AnimalDTO;
import dtos.ZooDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zoo")
@NamedQueries({
        @NamedQuery(name = "Zoo.deleteAllRows", query = "DELETE from Zoo"),
        @NamedQuery(name = "Zoo.getAllRows", query = "SELECT z from Zoo z"),
        @NamedQuery(name = "Zoo.getZoo", query = "SELECT z from Zoo z WHERE z.id = :id"),
        @NamedQuery(name = "Zoo.deleteZooById", query = "DELETE FROM Zoo z WHERE z.id = :id")
})

public class Zoo implements Serializable {

    /**
     * This is my variables
     **/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "zoo", length = 175, nullable = false)
    private String zoo;

    @ManyToMany (mappedBy = "zoos", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Animal> animals;

    private static final long serialVersionUID = -1L;

    /**
     * This is my constructor
     **/

    public Zoo() {
    }

    public Zoo(Integer id, String zoo) {
        this.id = id;
        this.zoo = zoo;
        this.animals = new ArrayList<>();
    }

    public Zoo(Integer id, String zoo, List<Animal> animals) {
        this.id = id;
        this.zoo = zoo;
        this.animals = animals;
    }

    public Zoo(ZooDTO dto) {
        this.id = dto.getId();
        this.zoo = dto.getZoo();
        this.animals = dto.getAnimals() != null ? getAnimalList(dto.getAnimals()) : new ArrayList<>();
    }

    /**
     * GETTERS AND SETTERS
     **/

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

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    /**
     * This is where all my methods go
     **/

    public void addAnimal(Animal animal) {
        if (animal != null) {
            this.animals.add(animal);
            animal.getZoos().add(this);
        }
    }

    public void removeAnimal(Animal animal) {
        if (animal != null) {
            this.animals.remove(animal);
            animal.getZoos().remove(this);
        }
    }

    public List<Animal> getAnimalList(List<AnimalDTO> animalDTOS) {
        ArrayList<Animal> list = new ArrayList<>();
        for (AnimalDTO a : animalDTOS) {
            list.add(new Animal(a.getName(), a.getAge()));
        }
        return list;
    }

    public List<AnimalDTO> getAnimalDTOList(List<Animal> animal) {
        ArrayList<AnimalDTO> list = new ArrayList<>();
        for (Animal a : animal) {
            list.add(new AnimalDTO(a));
        }
        return list;
    }

    public void replaceAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "id=" + id +
                ", zoo='" + zoo + '\'' +
                ", animals=" + animals +
                '}';
    }
}