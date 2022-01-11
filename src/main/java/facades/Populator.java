package facades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entities.Animal;
import entities.Zoo;
import utils.EMF_Creator;

public class Populator {

    private static EntityManagerFactory emf;
    private static ZooFacade facade;

    private static Zoo z1 = new Zoo (1, "København Zoo");
    private static Zoo z2 = new Zoo (2, "Odense Zoo");
    private static Zoo z3 = new Zoo (3, "Aarhus Zoo");
    private static Zoo z4 = new Zoo (4, "Oslo Zoo");

    private static Animal a1 = new Animal("Giraf", "21");
    private static Animal a2 = new Animal("Løve", "9");
    private static Animal a3 = new Animal("Gorilla", "2");
    private static Animal a4 = new Animal("Gorilla", "12");

    public static void populate() {
        emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        ZooFacade zooFacade = ZooFacade.getZooFacade(emf);
        try {
            em.getTransaction().begin();
            //Creating our animal Array for Zoo 1.
            z1.addAnimal(a1);
            z1.addAnimal(a3);
            z1.addAnimal(a4);

            //Zoo 1
            em.persist(z1);
            em.merge(z1);

            //Creating our animal Array for Zoo 2.
            z2.addAnimal(a2);
            z2.addAnimal(a3);
            z2.addAnimal(a4);

            //Zoo 2
            em.persist(z2);
            em.merge(z2);

            //Creating our animal Array for Zoo 3.
            z3.addAnimal(a4);
            z3.addAnimal(a2);
            z3.addAnimal(a1);

            //Zoo 3
            em.persist(z3);
            em.merge(z3);

            //Creating our animal Array for Zoo 4.
            z4.addAnimal(a1);
            z4.addAnimal(a2);
            z4.addAnimal(a3);

            //Zoo 4
            em.persist(z4);
            em.merge(z4);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        populate();
    }
}
