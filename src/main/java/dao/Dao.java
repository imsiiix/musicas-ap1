package dao;

import entity.Musica;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class Dao {

    public static void criar(Musica m) {
        EntityManager em = JPAUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void atualizar(Musica m) {
        EntityManager em = JPAUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            Musica musica = em.find(Musica.class, m.getId());
            em.merge(musica);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void deletar(Musica m) {
        EntityManager em = JPAUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            Musica musica = em.find(Musica.class, m.getId());
            em.remove(musica);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static List<Musica> listarTodos() {
        EntityManager em = JPAUtil.createEntityManager();
        Query q = em.createQuery("select m from Musica m");
        return q.getResultList();
    }
}
