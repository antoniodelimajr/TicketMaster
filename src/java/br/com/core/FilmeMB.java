package br.com.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FilmeMB {

    public static List<Filme> filmes = new ArrayList<>(
            Arrays.asList(new Filme("A00001", "O Poderoso Chefão", "Ação", ""),
                    new Filme("A00002", "O Mágico de Oz", "Comédia", ""),
                    new Filme("A00003", "Cidadão Kane", "Aventura", ""),
                    new Filme("A00004", "Um Sonho de Liberdade", "Suspense", ""),
                    new Filme("A00005", "Pulp Fiction", "Ação", ""),
                    new Filme("A00006", "Casablanca", "Suspense", ""),
                    new Filme("A00007", "O Poderoso Chefão 2", "Drama", ""),
                    new Filme("A00008", "E.T.", "Aventura", ""),
                    new Filme("A00009", "2001: Uma Odisseia no Espaço", "Aventura", ""),
                    new Filme("A00010", "A Lista de Schindler", "Drama", ""),
                    new Filme("A00011", "Guerra nas Estrelas", "Aventura", ""),
                    new Filme("A00012", "De Volta Para o Futuro", "Aventura", ""),
                    new Filme("A00013", "Os Caçadores da Arca Perdida", "Aventura", ""),
                    new Filme("A00014", "Forrest Gump", "Drama", ""),
                    new Filme("A00015", "… E o Vento Levou", "Suspense", ""),
                    new Filme("A00016", "O Sol é Para Todos", "Drama", ""),
                    new Filme("A00017", "Apocalypse Now", "Aventura", ""),
                    new Filme("A00018", "Noivo Neurótico, Noiva Nervosa", "Drama", ""),
                    new Filme("A00019", "Os Bons Companheiros", "Comédia", ""),
                    new Filme("A00020", "A Felicidade não se Compra", "Suspense", ""),
                    new Filme("A00021", "Chinatown", "Aventura", ""),
                    new Filme("A00022", "O Silêncio dos Inocentes", "Drama", ""),
                    new Filme("A00023", "Lawrence da Arábia", "Ação", ""),
                    new Filme("A00024", "Tubarão", "Ação", ""),
                    new Filme("A00025", "A Noviça Rebelde", "Comédia", ""),
                    new Filme("A00026", "Cantando na Chuva", "Comédia", ""),
                    new Filme("A00027", "Clube dos Cinco", "Ação", ""),
                    new Filme("A00028", "A Primeira Noite de um Homem", "Aventura", ""),
                    new Filme("A00029", "Blade Runner — O Caçador de Androides", "Aventura", ""),
                    new Filme("A00030", "Um Estranho no Ninho", "Drama", ""),
                    new Filme("A00031", "A Princesa Prometida", "Ação", ""),
                    new Filme("A00032", "Star Wars: Episódio V — O Império Contra-Ataca", "Aventura", ""),
                    new Filme("A00033", "Fargo", "Comédia", ""),
                    new Filme("A00034", "Beleza Americana", "Suspense", ""),
                    new Filme("A00035", "Laranja Mecânica", "Ação", ""),
                    new Filme("A00036", "Curtindo a Vida Adoidado", "Aventura", ""),
                    new Filme("A00037", "Dr. Fantástico", "Aventura", ""),
                    new Filme("A00038", "Harry & Sally — Feitos um Para o Outro", "Drama", ""),
                    new Filme("A00039", "O Iluminado", "Suspense", "")));

    private Filme filme;

    public FilmeMB() {
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
        return atualizarFilme();
    }

    public String editarFilme(Filme filme) {
        this.filme = filme;
        return ("/admin/movies/edition?faces-redirect=true");
    }

    public String atualizarFilme() {
        return ("/public/movies/listing?faces-redirect=true");
    }

    public String removerFilme(Filme filme) {
        filmes.remove(filme);
        return atualizarFilme();
    }
}
