package br.com.core;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="venda")
public class Venda implements Serializable {

    @Id
    @NotNull
    @Column(name="venda_id")  
    private String codigo;
    @Column
    private Integer qtdAssentos;
    @OneToOne
    private Secao secao;

    public Venda() {
    }

    public Venda(String codigo, Integer qtdAssentos, Secao secao) {
        this.codigo = codigo;
        this.qtdAssentos = qtdAssentos;
        this.secao = secao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getQtdAssentos() {
        return qtdAssentos;
    }

    public void setQtdAssentos(Integer qtdAssentos) {
        this.qtdAssentos = qtdAssentos;
    }

    public Secao getSecao() {
        return secao;
    }

    public void setSecao(Secao secao) {
        this.secao = secao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.qtdAssentos, other.qtdAssentos)) {
            return false;
        }
        if (!Objects.equals(this.secao, other.secao)) {
            return false;
        }
        return true;
    }
}
