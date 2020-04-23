package dao;

import entity.Musica;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class Dao {

    private Musica m = new Musica();

    public void create(Musica musica) {
        EntityManager em = JPAUtil.createEntityManager();
        em.getTransaction().begin();
        em.persist(musica);
        em.getTransaction().commit();
        em.close();
    }

    public void update(Musica musica) {
        EntityManager em = JPAUtil.createEntityManager();
        em.getTransaction().begin();
        em.merge(musica);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Musica musica) {
        EntityManager em = JPAUtil.createEntityManager();
        em.getTransaction().begin();
        m = em.find(Musica.class, musica.getId());
        em.remove(m);
        em.getTransaction().commit();
        em.close();
    }

    public List listAll() {
        EntityManager em = JPAUtil.createEntityManager();
        Query q = em.createQuery("select m from Musica m");
        return q.getResultList();
    }
}
