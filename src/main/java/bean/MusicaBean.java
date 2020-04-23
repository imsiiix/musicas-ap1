package bean;

import dao.Dao;
import entity.Musica;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "bean")
public class MusicaBean {

    private Musica musica = new Musica();
    private Dao dao = new Dao();
    private List musicas = new ArrayList<>();

    public void salvar() {
        dao.create(musica);
        this.musica = new Musica();
    }

    public String atualizar() {
        dao.update(musica);
        return "listar.xhtml?faces-redirect=true";
    }

    public String editar() {
        return "editar.xhtml";
    }

    public String criarNovo() {
        this.musica = new Musica();
        return "criar.xhtml?faces-redirect=true";
    }

    public String deletar(Musica musica) {
        dao.delete(musica);
        return "listar.xhtml?faces-redirect=true";
    }

    @PostConstruct
    public void listarTodas() {
        musicas = dao.listAll();
    }

    public Musica getMusica() {
        return musica;
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
    }

    public List getMusicas() {
        return musicas;
    }

    public void setMusicas(List musicas) {
        this.musicas = musicas;
    }
}
