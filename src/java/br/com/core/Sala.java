package br.com.core;

import java.util.Objects;

public class Sala {

    private String numero;
    private Integer assentos;
    private static Integer reservados;

    public Sala() {
    }

    public Sala(String numero, Integer assentos) {
        this.numero = numero;
        this.assentos = assentos;
        this.reservados = 0;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getAssentos() {
        return assentos;
    }

    public void setAssentos(Integer assentos) {
        this.assentos = assentos;
    }

    public Integer getReservados() {
        return reservados;
    }

    public void setReservados(Integer reservados) {
        this.reservados = reservados;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sala other = (Sala) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.assentos, other.assentos)) {
            return false;
        }
        if (!Objects.equals(this.reservados, other.reservados)) {
            return false;
        }
        return true;
    }

    

}
