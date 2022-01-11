package entities;

import dtos.AnimalDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "animal")
@Entity
public class Animal implements Serializable {

    /** This is my variables **/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 175, nullable = false)
    private String name;

    @Column(name = "age", length = 175, nullable = false)
    private String age;

    @ManyToMany
    private List<Zoo> zoos;

    private static final long serialVersionUID = 1L;


    /** This is the constructor **/

    public Animal() {
    }

    public Animal(Integer id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.zoos = new ArrayList<>();
    }

    public Animal(String name, String age) {
        this.name = name;
        this.age = age;
        this.zoos = new ArrayList<>();
    }

    public Animal(AnimalDTO dto) {
        this.name = dto.getName();
        this.age = dto.getAge();
        this.zoos = new ArrayList<>();
    }

    /** GETTERS AND SETTERS **/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<Zoo> getZoos() {
        return zoos;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}