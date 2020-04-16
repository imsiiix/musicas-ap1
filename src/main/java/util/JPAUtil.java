package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;

public class JPAUtil implements Serializable {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("musicas");

    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    public static void close(EntityManager em) {
        em.close();
    }
}
