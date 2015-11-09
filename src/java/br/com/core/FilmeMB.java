package br.com.core;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FilmeMB {

    public static List<Filme> filmes;
    private Filme filme;

    public FilmeMB() {

        if (filmes == null || filmes.size() == 0) {
            filmes = new ArrayList<>();
            filmes.add(new Filme("A00001", "O Poderoso Chefão", "Ação", ""));
            filmes.add(new Filme("A00002", "O Mágico de Oz", "Comédia", ""));
            filmes.add(new Filme("A00003", "Cidadão Kane", "Aventura", ""));
            filmes.add(new Filme("A00004", "Um Sonho de Liberdade", "Suspense", ""));
            filmes.add(new Filme("A00005", "Pulp Fiction", "Ação", ""));
            filmes.add(new Filme("A00006", "Casablanca", "Suspense", ""));
            filmes.add(new Filme("A00007", "O Poderoso Chefão 2", "Drama", ""));
            filmes.add(new Filme("A00008", "E.T.", "Aventura", ""));
            filmes.add(new Filme("A00009", "2001: Uma Odisseia no Espaço", "Aventura", ""));
            filmes.add(new Filme("A00010", "A Lista de Schindler", "Drama", ""));
            filmes.add(new Filme("A00011", "Guerra nas Estrelas", "Aventura", ""));
            filmes.add(new Filme("A00012", "De Volta Para o Futuro", "Aventura", ""));
            filmes.add(new Filme("A00013", "Os Caçadores da Arca Perdida", "Aventura", ""));
            filmes.add(new Filme("A00014", "Forrest Gump", "Drama", ""));
            filmes.add(new Filme("A00015", "… E o Vento Levou", "Suspense", ""));
            filmes.add(new Filme("A00016", "O Sol é Para Todos", "Drama", ""));
            filmes.add(new Filme("A00017", "Apocalypse Now", "Aventura", ""));
            filmes.add(new Filme("A00018", "Noivo Neurótico, Noiva Nervosa", "Drama", ""));
            filmes.add(new Filme("A00019", "Os Bons Companheiros", "Comédia", ""));
            filmes.add(new Filme("A00020", "A Felicidade não se Compra", "Suspense", ""));
            filmes.add(new Filme("A00021", "Chinatown", "Aventura", ""));
            filmes.add(new Filme("A00022", "O Silêncio dos Inocentes", "Drama", ""));
            filmes.add(new Filme("A00023", "Lawrence da Arábia", "Ação", ""));
            filmes.add(new Filme("A00024", "Tubarão", "Ação", ""));
            filmes.add(new Filme("A00025", "A Noviça Rebelde", "Comédia", ""));
            filmes.add(new Filme("A00026", "Cantando na Chuva", "Comédia", ""));
            filmes.add(new Filme("A00027", "Clube dos Cinco", "Ação", ""));
            filmes.add(new Filme("A00028", "A Primeira Noite de um Homem", "Aventura", ""));
            filmes.add(new Filme("A00029", "Blade Runner — O Caçador de Androides", "Aventura", ""));
            filmes.add(new Filme("A00030", "Um Estranho no Ninho", "Drama", ""));
            filmes.add(new Filme("A00031", "A Princesa Prometida", "Ação", ""));
            filmes.add(new Filme("A00032", "Star Wars: Episódio V — O Império Contra-Ataca", "Aventura", ""));
            filmes.add(new Filme("A00033", "Fargo", "Comédia", ""));
            filmes.add(new Filme("A00034", "Beleza Americana", "Suspense", ""));
            filmes.add(new Filme("A00035", "Laranja Mecânica", "Ação", ""));
            filmes.add(new Filme("A00036", "Curtindo a Vida Adoidado", "Aventura", ""));
            filmes.add(new Filme("A00037", "Dr. Fantástico", "Aventura", ""));
            filmes.add(new Filme("A00038", "Harry & Sally — Feitos um Para o Outro", "Drama", ""));
            filmes.add(new Filme("A00039", "O Iluminado", "Suspense", ""));
        }
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

    public String novoFilme() {
        filme = new Filme();
        return ("/admin/movies/register?faces-redirect=true");
    }

    public String salvarFilme() {
        filmes.add(filme);
        return ("/admin/movies/listing?faces-redirect=true");
    }

    public String editarFilme(Filme filme) {
        this.filme = filme;
        return ("/admin/movies/edition?faces-redirect=true");
    }

    public String atualizarUsuario() {
        return ("/admin/movies/listing?faces-redirect=true");
    }

    public void removerFilme(Filme filme) {
        filmes.remove(filme);
    }
}
