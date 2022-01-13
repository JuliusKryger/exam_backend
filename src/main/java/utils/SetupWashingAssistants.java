package utils;

import entities.WashingAssistant;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupWashingAssistants {

    public static void main(String[] args) {

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        //String name, String primaryLanguage, int yearsOfExperience, int pricePerHour
        WashingAssistant wa1 = new WashingAssistant("Jens", "english", 4, 120);
        WashingAssistant wa2 = new WashingAssistant("Anna", "danish", 8, 180);
        WashingAssistant wa3 = new WashingAssistant("Henrik", "polish", 14, 220);

        em.getTransaction().begin();
        em.persist(wa1);
        em.persist(wa2);
        em.persist(wa3);
        em.getTransaction().commit();
    }
}
