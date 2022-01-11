package dtos;

import entities.Animal;

public class AnimalDTO {

    private Integer id;
    private String name;
    private String age;

    public AnimalDTO() {
    }

    public AnimalDTO (String name, String age) {
        this.name = name;
        this.age = age;
    }

    public AnimalDTO (Animal entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.age = entity.getAge();
    }

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

    @Override
    public String toString() {
        return "AnimalDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
