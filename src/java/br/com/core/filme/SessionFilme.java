package br.com.core.filme;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SessionFilme {

  @EJB
  private FilmeFacade ejbFacade;

  public FilmeFacade getFacade() {
    return ejbFacade;
  }

  public List<Filme> findAll() {
    return getFacade().findAll();
  }

  public Filme findById(String codigo) {
    for (Filme filme : getFacade().findAll()) {
      if (filme.getCodigo().equals(codigo)) {
        return filme;
      }
    }
    return null;
  }

  public void remover(Filme filme) {
    getFacade().remove(filme);
  }

  public void alterar(Filme filme) {
    getFacade().edit(filme);
  }
}
