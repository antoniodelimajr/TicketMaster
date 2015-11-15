package br.com.core;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SecaoMB{

    private Secao secao;
    private List<Sala> salas;
    private List<Filme> filmes;
    public List<Secao> secoes;
    
    @EJB
    private SecaoFacade ejbFacade;   
    
    @EJB
    private SalaFacade ejbSalaFacade;   
    
    @EJB
    private FilmeFacade ejbFilmeFacade;  
       
    public SecaoMB() {       
        if (secoes == null || secoes.isEmpty()) {
            secoes = new ArrayList<>();
        }
    }

    public SecaoFacade getEjbFacade() {
        return ejbFacade;
    }

    public SalaFacade getSalaFacade() {
        return ejbSalaFacade;
    }

    public FilmeFacade getFilmeFacade() {
        return ejbFilmeFacade;
    }
       
    public SecaoFacade getFacade() {
        return ejbFacade;
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
    
    public Secao findSecaoByCodigo(String codigo) {
        for (Secao e : secoes) {
            if (e.getCodigo().equals(codigo)) {
                return (e);
            }
        }
        return null;
    }
     
    public List<Secao> findAll() {       
        secoes = getFacade().findAll();       
        salas = getSalaFacade().findAll();
        filmes = getFilmeFacade().findAll();
        return secoes;
    }
    
    public String novoSecao(){
        secao = new Secao();
        return("/admin/sections/register?faces-redirect=true");
    }
    
    public String salvarSecao(){    
        getFacade().create(secao);
        secoes.add(secao);
        secao = new Secao();
        return atualizarSecao();
    }

    public String editarSecao(Secao secao){
        this.secao = secao;
        return("/admin/sections/edition?faces-redirect=true");
    }
    
    public String alterarSecao() {
        getFacade().edit(secao);
        return atualizarSecao();
    }
    
    public String removerSecao(Secao secao) {
        getFacade().remove(secao);
        secoes.remove(secao);
        return atualizarSecao(); 
    }
     
    public String atualizarSecao(){
        secoes = getFacade().findAll();
        return("/public/sections/listing?faces-redirect=true");
    }
}
