package util;

import dao.Dao;
import entity.Musica;

import java.util.List;

public class PopulaBanco {
    public static void main(String[] args) {

        Musica m1 = new Musica();
        m1.setNome("M1");
        m1.setCompositor("Compositor1");
        m1.setBanda("Banda1");

        Musica m2 = new Musica();
        m2.setNome("M2");
        m2.setCompositor("Compositor2");
        m2.setBanda("Banda2");

        Musica m3 = new Musica();
        m3.setNome("M3");
        m3.setCompositor("Compositor3");
        m3.setBanda("Banda3");

        Musica m4 = new Musica();
        m4.setNome("M4");
        m4.setCompositor("Compositor4");
        m4.setBanda("Banda4");

        Musica m5 = new Musica();
        m5.setNome("M5");
        m5.setCompositor("Compositor5");
        m5.setBanda("Banda5");

        Musica m6 = new Musica();
        m6.setNome("M6");
        m6.setCompositor("Compositor6");
        m6.setBanda("Banda6");

        Musica m7 = new Musica();
        m7.setNome("M7");
        m7.setCompositor("Compositor7");
        m7.setBanda("Banda7");

        Musica m8 = new Musica();
        m8.setNome("M8");
        m8.setCompositor("Compositor8");
        m8.setBanda("Banda8");

        Dao.criar(m1);
        Dao.criar(m2);
        Dao.criar(m3);
        Dao.criar(m4);
        Dao.criar(m5);
        Dao.criar(m6);
        Dao.criar(m7);
        Dao.criar(m8);

//        new Dao().remover((long) 4);

        List<Musica> lista = Dao.listarTodos();

        for (Musica l : lista) {
            System.out.println(l.toString());
        }
    }
}