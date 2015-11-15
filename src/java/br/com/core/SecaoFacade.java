package br.com.core;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SecaoFacade extends AbstractFacade<Secao> {
    @PersistenceContext(unitName = "TicketMasterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SecaoFacade() {
        super(Secao.class);
    } 
}