package br.com.core;

import java.util.Objects;

public class Sala {

    private String numero;
    private Integer assentos;

    public Sala() {
    }

    public Sala(String numero, Integer assentos) {
        this.numero = numero;
        this.assentos = assentos;
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

    @Override
    public int hashCode() {
        int hash = 3;
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
        return true;
    }

}
