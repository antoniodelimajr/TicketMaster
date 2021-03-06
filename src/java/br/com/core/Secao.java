package br.com.core;

import java.util.Date;
import java.util.Objects;

public class Secao {

    private String codigo;
    private Date horario;
    private Sala sala;
    private Filme filme;

    public Secao() {
    }

    public Secao(String codigo, Date horario, Sala sala, Filme filme) {
        this.codigo = codigo;
        this.horario = horario;
        this.sala = sala;
        this.filme = filme;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
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
        final Secao other = (Secao) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        if (!Objects.equals(this.sala, other.sala)) {
            return false;
        }
        if (!Objects.equals(this.filme, other.filme)) {
            return false;
        }
        return true;
    }     
}
