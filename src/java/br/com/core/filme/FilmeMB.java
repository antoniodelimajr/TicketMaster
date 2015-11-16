package br.com.core.filme;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FilmeMB {

    @EJB
    private FilmeFacade ejbFacade;
    private Filme filme;
    public List<Filme> filmes;

    public FilmeMB() {}

    public FilmeFacade getFacade() {
        return ejbFacade;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Filme findFilmeByCodigo(String codigo) {
        for (Filme e : filmes) {
            if (e.getCodigo().equals(codigo)) {
                return (e);
            }
        }
        return null;
    }

    public List<Filme> findAll() {
        filmes = getFacade().findAll();
        if (filmes.isEmpty()) {
            initializateDB();
            filmes = getFacade().findAll();
        }
        return filmes;
    }

    public String novoFilme() {
        filme = new Filme();
        return ("/admin/movies/register?faces-redirect=true");
    }

    public String salvarFilme() {
        getFacade().create(filme);
        filmes.add(filme);
        return atualizarFilme();
    }

    public String editarFilme(Filme filme) {
        this.filme = filme;
        return ("/admin/movies/edition?faces-redirect=true");
    }

    public String alterarFilme() {
        getFacade().edit(filme);
        return atualizarFilme();
    }

    public String removerFilme(Filme filme) {
        getFacade().remove(filme);
        filmes.remove(filme);
        return atualizarFilme();
    }

    public String atualizarFilme() {
        filmes = getFacade().findAll();
        return ("/public/movies/listing?faces-redirect=true");
    }

    public void initializateDB() {
        getFacade().create(new Filme("A00001", "O Poderoso Chefão", "acao", ""));
        getFacade().create(new Filme("A00002", "O Mágico de Oz", "comedia", ""));
        getFacade().create(new Filme("A00003", "Cidadão Kane", "aventura", ""));
        getFacade().create(new Filme("A00004", "Um Sonho de Liberdade", "suspense", ""));
        getFacade().create(new Filme("A00005", "Pulp Fiction", "acao", ""));
        getFacade().create(new Filme("A00006", "Casablanca", "suspense", ""));
        getFacade().create(new Filme("A00007", "O Poderoso Chefão 2", "drama", ""));
        getFacade().create(new Filme("A00008", "E.T.", "aventura", ""));
        getFacade().create(new Filme("A00009", "2001: Uma Odisseia no Espaço", "aventura", ""));
        getFacade().create(new Filme("A00010", "A Lista de Schindler", "drama", ""));
        getFacade().create(new Filme("A00011", "Guerra nas Estrelas", "aventura", ""));
        getFacade().create(new Filme("A00012", "De Volta Para o Futuro", "aventura", ""));
        getFacade().create(new Filme("A00013", "Os Caçadores da Arca Perdida", "aventura", ""));
        getFacade().create(new Filme("A00014", "Forrest Gump", "drama", ""));
        getFacade().create(new Filme("A00015", "… E o Vento Levou", "suspense", ""));
        getFacade().create(new Filme("A00016", "O Sol é Para Todos", "drama", ""));
        getFacade().create(new Filme("A00017", "Apocalypse Now", "aventura", ""));
        getFacade().create(new Filme("A00018", "Noivo Neurótico, Noiva Nervosa", "drama", ""));
        getFacade().create(new Filme("A00019", "Os Bons Companheiros", "comedia", ""));
        getFacade().create(new Filme("A00020", "A Felicidade não se Compra", "suspense", ""));
        getFacade().create(new Filme("A00021", "Chinatown", "aventura", ""));
        getFacade().create(new Filme("A00022", "O Silêncio dos Inocentes", "drama", ""));
        getFacade().create(new Filme("A00023", "Lawrence da Arábia", "acao", ""));
        getFacade().create(new Filme("A00024", "Tubarão", "acao", ""));
        getFacade().create(new Filme("A00025", "A Noviça Rebelde", "comedia", ""));
        getFacade().create(new Filme("A00026", "Cantando na Chuva", "comedia", ""));
        getFacade().create(new Filme("A00027", "Clube dos Cinco", "acao", ""));
        getFacade().create(new Filme("A00028", "A Primeira Noite de um Homem", "aventura", ""));
        getFacade().create(new Filme("A00029", "Blade Runner — O Caçador de Androides", "aventura", ""));
        getFacade().create(new Filme("A00030", "Um Estranho no Ninho", "drama", ""));
        getFacade().create(new Filme("A00031", "A Princesa Prometida", "acao", ""));
        getFacade().create(new Filme("A00032", "Star Wars: Episódio V — O Império Contra-Ataca", "aventura", ""));
        getFacade().create(new Filme("A00033", "Fargo", "comedia", ""));
        getFacade().create(new Filme("A00034", "Beleza Americana", "suspense", ""));
        getFacade().create(new Filme("A00035", "Laranja Mecânica", "acao", ""));
        getFacade().create(new Filme("A00036", "Curtindo a Vida Adoidado", "aventura", ""));
        getFacade().create(new Filme("A00037", "Dr. Fantástico", "aventura", ""));
        getFacade().create(new Filme("A00038", "Harry & Sally — Feitos um Para o Outro", "drama", ""));
        getFacade().create(new Filme("A00039", "O Iluminado", "suspense", ""));
    }
}
