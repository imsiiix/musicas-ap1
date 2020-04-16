package bean;

import dao.Dao;
import entity.Musica;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@ManagedBean
public class MusicaBean {

    private Musica musica;
    private List<Musica> musicas;

    @PostConstruct
    public void init(){
        musica = new Musica();
        musicas = new ArrayList<Musica>();
    }

    public String criar() {
        Dao.criar(musica);
        Musica musica = new Musica();
        return "/index.xhtml";
    }

    public String atualizar() {
        Dao.atualizar(musica);
        Musica musica = new Musica();
        return "listar.xhtml";
    }

    public void deletar() {
        Dao.deletar(musica);
    }

    public String listar() {
        musicas = Dao.listarTodos();
        return "listar.xhtml";
    }

    public List musicasDb(){
        return Dao.listarTodos();
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
