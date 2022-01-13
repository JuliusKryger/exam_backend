package facades;

import dtos.WashingAssistantsDTO;
import entities.Booking;
import entities.WashingAssistant;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;
import java.util.List;

public class CarWashFacade {

    private static EntityManagerFactory emf;
    private static CarWashFacade instance;

    private Booking bk = new Booking();

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

    public WashingAssistant createWashingAssistant (WashingAssistant washingAssistant) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            washingAssistant.setName(washingAssistant.getName());
            washingAssistant.setPrimaryLanguage(washingAssistant.getPrimaryLanguage());
            washingAssistant.setYearsOfExperience(washingAssistant.getYearsOfExperience());
            washingAssistant.setPricePerHour(washingAssistant.getPricePerHour());
            em.persist(washingAssistant);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return washingAssistant;
    }

    public Booking getUsersBookings (String userName) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<Booking> typedQuery = em.createNamedQuery("Booking.info", Booking.class);
            typedQuery.setParameter("userName", userName);
            Booking booking = typedQuery.getSingleResult();
            if (booking != null) {
                bk.setAppointment(booking.getAppointment());
                bk.setDuration(booking.getDuration());
                return bk;
            } else {
                throw new WebApplicationException("User has no bookings", 400);
            }
        } finally {
            em.close();
        }
    }


}
