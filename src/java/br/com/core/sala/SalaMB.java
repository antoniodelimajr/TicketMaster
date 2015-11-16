package br.com.core.sala;

import br.com.core.util.JsfUtil;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SalaMB {

    @EJB
    private SalaFacade ejbFacade;
    private Sala sala;
    public List<Sala> salas;

    public SalaMB() {
    }

    public SalaFacade getFacade() {
        return ejbFacade;
    }

    public List<Sala> getSalas() {
        salas = getFacade().findAll();
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Sala findSalaByNumero(String numero) {
        for (Sala e : salas) {
            if (e.getNumero().equals(numero)) {
                return (e);
            }
        }
        return null;
    }

    public List<Sala> findAll() {
        salas = getFacade().findAll();
        if (salas.isEmpty()) {
            initializateDB();
            salas = getFacade().findAll();
        }
        return salas;
    }

    public String novoSala() {
        sala = new Sala();
        return ("/admin/rooms/register?faces-redirect=true");
    }

    public String salvarSala() {
        getFacade().create(sala);
        salas.add(sala);
        return atualizarSala();
    }

    public String editarSala(Sala sala) {
        this.sala = sala;
        return ("/admin/rooms/edition?faces-redirect=true");
    }

    public String alterarSala() {
        getFacade().edit(sala);
        return atualizarSala();
    }

    public String removerSala(Sala sala) {
        getFacade().remove(sala);
        salas.remove(sala);
        return atualizarSala();
    }

    public String atualizarSala() {
        salas = getFacade().findAll();
        return ("/public/rooms/listing?faces-redirect=true");
    }

    public void initializateDB() {
        getFacade().create(new Sala("Sala 01", 35, 0));
        getFacade().create(new Sala("Sala 02", 12, 0));
        getFacade().create(new Sala("Sala 03", 18, 0));
    }
}
