package facades;

import dtos.WashingAssistantsDTO;
import entities.WashingAssistant;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class CarWashFacade {

    private static EntityManagerFactory emf;
    private static CarWashFacade instance;

    public CarWashFacade() {
    }

    public static CarWashFacade getCarWashFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CarWashFacade();
        }
        return instance;
    }

    public WashingAssistantsDTO getAllWashingAssistants () {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<WashingAssistant> query = em.createNamedQuery("WashingAssistant.getAllRows", WashingAssistant.class);
            List<WashingAssistant> result = query.getResultList();
            WashingAssistantsDTO dto = new WashingAssistantsDTO(result);
            em.getTransaction().commit();
            return dto;
        }  finally {
            em.close();
        }
    }


}
