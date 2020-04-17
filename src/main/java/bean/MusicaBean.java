package bean;

import dao.Dao;
import entity.Musica;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "musicaBean")
@SessionScoped
public class MusicaBean {

    private Musica musica = new Musica();
    private Musica musicaId = new Musica();
    private Dao dao = new Dao();
    private List<Musica> musicas = new ArrayList<>();

    @PostConstruct
    public void init() {
        musica = new Musica();
        musicaId = new Musica();
        musicas = new ArrayList<>();
    }

    public void criar() {
        dao.criar(musica);
        this.musica = new Musica();
//        return "/criar.xhtml?faces-redirect=true";
    }

    public String editar() {
        this.musicaId = dao.buscarPorId(musica);
        return "/editar.xhtml?faces-redirect=true";
    }

    public String atualizar() {
        dao.atualizar(musicaId);
        return "/listar.xhtml?faces-redirect=true";
    }

    public void deletar(Musica musica) {
        dao.deletar(musica);
    }

    public List musicasDb() {
        return dao.listarTodos();
    }

    public Musica getMusica() {
        return musica;
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
    }

    public Musica getMusicaId() {
        return musicaId;
    }

    public void setMusicaId(Musica musicaId) {
        this.musicaId = musicaId;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }
}
