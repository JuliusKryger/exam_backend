package facades;

import dtos.BookingDTO;
import dtos.BookingsDTO;
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

    public Booking createBooking (Booking booking) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            booking.setAppointment(booking.getAppointment());
            booking.setDuration(booking.getDuration());
            booking.setWashingAssistantList(booking.getWashingAssistantList());
            booking.setUser(booking.getUser());
            em.persist(booking);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return booking;
    }

    public BookingDTO getUsersBookings (String userName) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<Booking> typedQuery = em.createNamedQuery("Booking.info", Booking.class);
            typedQuery.setParameter("userName", userName);
            Booking result = typedQuery.getSingleResult();
            BookingDTO booking = new BookingDTO(result);
            return booking;
        } finally {
            em.close();
        }
    }


}
