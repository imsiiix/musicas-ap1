package dao;

import entity.Musica;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class Dao {

    public void criar(Musica m) {
        EntityManager em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
            em.close();
    }

    public Musica buscarPorId(Musica musica) {
        EntityManager em = JPAUtil.createEntityManager();
        Musica m;
        em.getTransaction().begin();
        m = em.find(Musica.class, musica.getId());
        em.getTransaction().commit();
        em.close();
        System.out.println(m.toString());
        return m;
    }

    public void atualizar(Musica musica) {
        EntityManager em = JPAUtil.createEntityManager();
        em.getTransaction().begin();
        em.merge(musica);
        em.getTransaction().commit();
        em.close();
    }

    public void deletar(Musica musica) {
        EntityManager em = JPAUtil.createEntityManager();
        Musica m;
        em.getTransaction().begin();
        m = em.find(Musica.class, musica.getId());
        em.remove(m);
        em.getTransaction().commit();
        em.close();
    }

    public List listarTodos() {
        EntityManager em = JPAUtil.createEntityManager();
        Query q = em.createQuery("select m from Musica m");
        return q.getResultList();
    }
}
