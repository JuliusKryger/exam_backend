package facades;

import dtos.UsersDTO;
import entities.Role;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import security.errorhandling.AuthenticationException;

import java.util.List;

public class UserFacade {

    private static EntityManagerFactory emf;
    private static UserFacade instance;

    private UserFacade() {
        /** Maybe we can check if username is already taken, and would be fun to check password "Strongness" as well for added security. **/
    }

    public static UserFacade getUserFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new UserFacade();
        }
        return instance;
    }

    public User getVeryfiedUser(String username, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        User user;
        try {
            user = em.find(User.class, username);
            if (user == null || !user.verifyPassword(password)) {
                throw new AuthenticationException("Invalid user name or password");
            }
        } finally {
            em.close();
        }
        return user;
    }

    public User CreateNewUser(User user) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();

        try {
            Role userRole = new Role("user");
            em.getTransaction().begin();

            user.setUserName(user.getUserName());
            user.addRole(userRole);
            //user.setUserPass(user.getUserPass());
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return user;
    }

    public UsersDTO getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<User> query = em.createNamedQuery("User.getAllRows", User.class);
            List<User> result = query.getResultList();
            UsersDTO dto = new UsersDTO(result);
            em.getTransaction().commit();
            return dto;
        } finally {
            em.close();
        }
    }
}
