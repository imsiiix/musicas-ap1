package bean;

import dao.Dao;
import entity.Musica;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@ManagedBean
public class MusicaBean {

    private Musica musica = new Musica();
    private List<Musica> musicas = new ArrayList<>();

    public String criar() {
        Dao.criar(musica);
        musica = new Musica();
        return null;
    }

    public String atualizar() {
        Dao.atualizar(musica);
        musica = new Musica();
        return "listar.xhtml";
    }

    public void deletar() {
        Dao.deletar(this.musica);
    }

    public String listar() {
        musicas = Dao.listarTodos();
        return "listar.xhtml";
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
