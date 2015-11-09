package br.com.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SalaMB {

    public static List<Sala> salas = new ArrayList<>(
            Arrays.asList(new Sala("Sala 01", 35),
                    new Sala("Sala 02", 35),
                    new Sala("Sala 03", 35)));
    
    private Sala sala;

    public SalaMB() {
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
