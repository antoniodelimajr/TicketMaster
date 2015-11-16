package br.com.core.sala;

import br.com.core.persistenceUtil.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SalaFacade extends AbstractFacade<Sala> {
    @PersistenceContext(unitName = "TicketMasterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SalaFacade() {
        super(Sala.class);
    } 
}
