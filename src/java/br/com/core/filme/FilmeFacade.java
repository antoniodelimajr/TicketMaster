package br.com.core.filme;

import br.com.core.persistenceUtil.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FilmeFacade extends AbstractFacade<Filme> {
    @PersistenceContext(unitName = "TicketMasterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FilmeFacade() {
        super(Filme.class);
    } 
}
