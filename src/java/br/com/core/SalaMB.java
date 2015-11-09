package br.com.core;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SalaMB {

    public static List<Sala> salas;
    private Sala sala;

    public SalaMB() {

        if (salas == null || salas.size() == 0) {
            salas = new ArrayList<>();
            salas.add(new Sala("Sala 01", 30));
            salas.add(new Sala("Sala 02", 35));
            salas.add(new Sala("Sala 03", 40));
            salas.add(new Sala("Sala 04", 40));
            salas.add(new Sala("Sala 05", 30));
        }
    }

    public List<Sala> getSalas() {
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

    public void removerSala(Sala sala) {
        salas.remove(sala);
    }

    public Sala findSalaByNumero(String numero) {
        for (Sala e : salas) {
            if (e.getNumero().equals(numero)) {
                return (e);
            }
        }
        return null;
    }

    public String novoSala() {
        sala = new Sala();
        return ("/admin/rooms/register?faces-redirect=true");
    }

    public String salvarSala() {
        salas.add(sala);
        return ("/admin/rooms/listing?faces-redirect=true");
    }

    public String editarSala(Sala sala) {
        this.sala = sala;
        return ("/admin/rooms/edition?faces-redirect=true");
    }

    public String atualizarSala() {
        return ("/admin/rooms/listing?faces-redirect=true");
    }
}
