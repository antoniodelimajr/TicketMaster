package br.com.core;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SecaoMB{

    private List<Secao> secoes;
    
    private List<Sala> salas;
    private List<Filme> filmes;
    
    private Secao secao;
    
    public SecaoMB() {       

        this.salas = SalaMB.salas;
        this.filmes = FilmeMB.filmes;
        
        if (secoes == null || secoes.size() == 0) {
            secoes = new ArrayList<>();
        }
    }

    public List<Secao> getSecoes() {
        return secoes;
    }

    public void setSecoes(List<Secao> secoes) {
        this.secoes = secoes;
    }

    public Secao getSecao() {
        return secao;
    }

    public void setSecao(Secao secao) {
        this.secao = secao;
    }
    
     public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }
    
    public void removerSalas(Sala sala){
        salas.remove(sala);
    }
    
    public void removerSecao(Secao secao) {
        secoes.remove(secao);
    }
    
    public String novoSecao(){
        secao = new Secao();
        return("/admin/sections/register?faces-redirect=true");
    }
    
    public String salvarSecao(){         
        secoes.add(secao);
        secao = new Secao();
        return("/admin/sections/listing?faces-redirect=true");
    }

    public String editarSecao(Secao secao){
        this.secao = secao;
        return("/admin/sections/edition?faces-redirect=true");
    }
    
    public String atualizarSecao(){
        return("/admin/sections/listing?faces-redirect=true");
    }
}
