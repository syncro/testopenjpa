package net.techminded.domain;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class UserTest {

    @Test
    void testUser() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Q4161012-test");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User user = new User();
        user.setName("John Doe");
        em.persist(user);
        em.flush();
        List<User> users = (List<User>) em.createQuery("select u from User u").getResultList();
        assertEquals(users.size(), 1);
    }
}
