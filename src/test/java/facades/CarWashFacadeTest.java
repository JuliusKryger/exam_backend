package facades;

import dtos.WashingAssistantsDTO;
import entities.WashingAssistant;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarWashFacadeTest {

    private static EntityManagerFactory emf = EMF_Creator.createEntityManagerFactoryForTest();
    private static EntityManager em = emf.createEntityManager();
    private static final CarWashFacade instance = CarWashFacade.getCarWashFacade(emf);

    @BeforeAll
    static void setup(){
        System.out.println("@BeforeAll executed");
        WashingAssistant wa1 = new WashingAssistant("Jens", "english", 4, 120);
        WashingAssistant wa2 = new WashingAssistant("Anna", "danish", 8, 180);
        WashingAssistant wa3 = new WashingAssistant("Henrik", "polish", 14, 220);
        em.getTransaction().begin();
        em.persist(wa1);
        em.persist(wa2);
        em.persist(wa3);
        em.getTransaction().commit();
    }

    @BeforeEach
    void setupThis(){
        System.out.println("@BeforeEach executed");
    }

    @Test
    void getCarWashFacade() {
        System.out.println("======TEST ONE EXECUTED=======");
    }

    @Test
    void getAllWashingAssistants() {
        System.out.println("======TEST TWO EXECUTED=======");
        try {
            em.getTransaction().begin();
            WashingAssistantsDTO result = instance.getAllWashingAssistants();
            em.getTransaction().commit();
            System.out.println(result);
            assertEquals(3, result.getAll().size());
        } finally {
            em.close();
        }
    }

    @AfterEach
    void tearThis(){
        System.out.println("@AfterEach executed");
    }

    @AfterAll
    static void tear(){
        System.out.println("@AfterAll executed");
    }
}