package bean;

import dao.Dao;
import entity.Musica;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class MusicaBean {

    private Long id;
    private String nome;
    private String banda;
    private String compositor;

    private Musica musica = new Musica();
    private Dao dao = new Dao();
    private List<Musica> musicas = new ArrayList<>();

    @PostConstruct
    public void init() {
        musica = new Musica();
        musicas = new ArrayList<>();
    }

    public String criar() {
        dao.criar(musica);
        return "/criar.xhtml?faces-redirect=true";
    }

    public String editar(Musica musica) {
        musica = dao.buscarPorId(musica);
        System.out.println("Metodo editar - BEAN - " + musica.toString());
        return "/editar.xhtml?faces-redirect=true";
    }

    public String atualizar(Musica musica) {
        dao.atualizar(musica);
        System.out.println("Método atualizar - BEAN - " + musica.toString());
        return "/listar.xhtml?faces-redirect=true";
    }

    public void deletar(Musica musica) {
        dao.deletar(musica);
    }

    public List musicasDb() {
        return dao.listarTodos();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    public Musica getMusica() {
        return musica;
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
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
