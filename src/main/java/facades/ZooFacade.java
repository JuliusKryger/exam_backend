package facades;

import dtos.AnimalDTO;
import dtos.ZooDTO;
import dtos.ZoosDTO;
import entities.Animal;
import entities.Zoo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class ZooFacade {

    /**
     * Full CRUD checklist ...
     * Create Zoo ...    done !
     * Get Zoo By ID ... done !
     * Get all Zoo's ... done !
     * Update Zoo ...    done !
     * Delete Zoo ...    done !
     **/

    private static EntityManagerFactory emf;
    private static ZooFacade instance;

    public ZooFacade() {
    }

    public static ZooFacade getZooFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new ZooFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public synchronized ZooDTO createZoo(ZooDTO zooDTO) {
        Zoo zoo = null;
        List<AnimalDTO> animals = zooDTO.getAnimals();
        List<AnimalDTO> a2 = new ArrayList<>();
        zooDTO.setAnimals(a2);
        EntityManager em = emf.createEntityManager();
        try {
            zoo = new Zoo(zooDTO);
            em.getTransaction().begin();
            em.persist(zoo);
            if (zoo.getAnimals() != null) {
                for (AnimalDTO a : animals) {
                    AnimalDTO animal = createAnimal(a.getName(), a.getAge());
                    em.find(Animal.class, animal.getId());
                    Animal entity = new Animal(animal);
                    zoo.addAnimal(entity);
                    em.merge(zoo);
                }
            }
            em.merge(zoo);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new ZooDTO(zoo);
    }

    public ZooDTO getZooById(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Zoo zoo = em.find(Zoo.class, id);
        em.getTransaction().commit();
        em.close();
        if (zoo != null) {
            zoo.setId(id);
            return new ZooDTO(zoo);
        } else {
            return null;
        }
    }

    public ZoosDTO getAllZoos() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<Zoo> typedQuery = em.createNamedQuery("Zoo.getAllRows", Zoo.class);
            List<Zoo> zooList = typedQuery.getResultList();
            ZoosDTO zoosDTO = new ZoosDTO(zooList);
            em.getTransaction().commit();
            return zoosDTO;
        } finally {
            em.close();
        }
    }

    public synchronized ZooDTO updateZooName(ZooDTO zooDTO) {
        EntityManager em = emf.createEntityManager();
        Zoo updated = em.find(Zoo.class, zooDTO.getId());
        try {
            em.getTransaction().begin();
            updated.setZoo(zooDTO.getZoo());
            em.merge(updated);
            em.getTransaction().commit();
            return new ZooDTO(updated);
        } finally {
            em.close();
        }
    }

    public boolean deleteZooById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createQuery("DELETE FROM Zoo z WHERE z.id = :id").setParameter("id", id).executeUpdate();
            em.createNamedQuery("Zoo.deleteZooById").setParameter("id", id).executeUpdate();
            em.getTransaction().commit();
            return true;
        } finally {
            em.close();
        }
    }

    /** Extra **/

    public AnimalDTO createAnimal(String name, String age) {
        EntityManager em = emf.createEntityManager();
        Animal animal = new Animal();

        try {
            em.getTransaction().begin();
            animal.setName(name);
            animal.setAge(age);
            em.persist(animal);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new AnimalDTO(animal);
    }


}
