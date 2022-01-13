package utils;

import entities.Booking;
import entities.Role;
import entities.User;
import entities.WashingAssistant;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupWashingAssistants {

    public static void main(String[] args) {

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        User user = new User("user", "test1");

        Role userRole = new Role("user");

        //String name, String primaryLanguage, int yearsOfExperience, int pricePerHour
        WashingAssistant wa1 = new WashingAssistant("Jens", "english", 4, 120);
        WashingAssistant wa2 = new WashingAssistant("Anna", "danish", 8, 180);
        WashingAssistant wa3 = new WashingAssistant("Henrik", "polish", 14, 220);

        //String appointment, int duration, User user
        Booking b1 = new Booking("12-01-2022 12:30", 30, user);

        em.getTransaction().begin();
        em.persist(wa1);
        em.persist(wa2);
        em.persist(wa3);

        user.addRole(userRole);
        em.persist(userRole);
        em.persist(user);

        em.persist(b1);
        em.getTransaction().commit();
    }
}
