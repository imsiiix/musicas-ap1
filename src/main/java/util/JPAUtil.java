package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("musicas");

    public static EntityManager createEntityManager(){
        return emf.createEntityManager();
    }
}
