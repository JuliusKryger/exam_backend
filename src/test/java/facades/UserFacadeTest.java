/*
package facades;

import entities.Role;
import entities.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import security.errorhandling.AuthenticationException;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.jupiter.api.Assertions.*;

class UserFacadeTest {

    private static EntityManagerFactory emf = EMF_Creator.createEntityManagerFactoryForTest();
    private static EntityManager em = emf.createEntityManager();
    private static UserFacade facade;

    private static User user = new User("user", "test1");
    private static User admin = new User("admin", "test2");
    private static User both = new User("user_admin", "test3");



    @BeforeAll
    static void setUp() {
        facade = UserFacade.getUserFacade(emf);
        em.getTransaction().begin();
        Role userRole = new Role("user");
        Role adminRole = new Role("admin");
        user.addRole(userRole);
        admin.addRole(adminRole);
        both.addRole(userRole);
        both.addRole(adminRole);
        em.persist(userRole);
        em.persist(adminRole);
        em.persist(user);
        em.persist(admin);
        em.persist(both);
        em.getTransaction().commit();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUserFacade() {
    }


    @Test
    void getVeryfiedUser() throws AuthenticationException {
        String username = user.getUserName();
        String password = user.getUserPass();

        System.out.println("verified user");

        EntityManagerFactory _emf = null;
        UserFacade instance = UserFacade.getUserFacade(_emf);
        System.out.println("This is the test person" + user);

        User result = instance.getVeryfiedUser(username, password);
        System.out.println("did it get the person?");
        assertEquals(result.getUserPass(), password);


    }

}
 */