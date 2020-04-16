package bean;

import dao.Dao;
import entity.Musica;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

@ManagedBean(name = "musica")
@ViewScoped
public class MusicaBean implements Serializable {

    private static final long serialVersionUID = -5967975213833000396L;
    private Musica musica = new Musica();
    private List<Musica> musicas = new ArrayList<Musica>();

    @PostConstruct
    public void init() {
        musica = new Musica();
        musicas = new ArrayList<Musica>();
    }

    public String reinit() {
        musica = new Musica();
        return null;
    }

    public void criar(Musica musica) {
        Dao.criar(musica);
        musica = new Musica();
    }

    public String atualizar(Musica musica) {
        Dao.atualizar(musica);
        return "index.xhtml";
    }

    public void deletar(Musica musica) {
        Dao.deletar(musica);
    }

    public List<Musica> listarTodos() {
        return musicas = Dao.listarTodos();
    }

    public Musica getMusica() {
        return musica;
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }
}
