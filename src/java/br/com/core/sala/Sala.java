package br.com.core.sala;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="sala")
public class Sala implements Serializable{

    @Id
    @NotNull
    @Column(name="sala_id")  
    private String numero;
    @Column 
    private Integer assentos;
    @Column
    private Integer reservados;

    public Sala() {
    }

    public Sala(String numero, Integer assentos, Integer reservados) {
        this.numero = numero;
        this.assentos = assentos;
        this.reservados = reservados;
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
        return reservados == null ? 0 : reservados;
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