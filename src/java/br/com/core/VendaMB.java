package br.com.core;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class VendaMB {

    private List<Venda> vendas;
    private List<Secao> secoes;
    private Venda venda;

    public VendaMB() {
        
        secoes = SecaoMB.secoes;
        
        if (vendas == null || vendas.size() == 0) {
            vendas = new ArrayList<>();
        }
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public List<Secao> getSecoes() {
        return secoes;
    }

    public void setSecoes(List<Secao> secoes) {
        this.secoes = secoes;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    
    public void removerVenda(Venda venda){
        vendas.remove(venda);
    }
        
    public String novoVenda(){
        venda = new Venda();
        return("/admin/sales/register?faces-redirect=true");
    }
    
    public String salvarVenda(){         
        vendas.add(venda);
        venda = new Venda();
        return("/admin/sales/listing?faces-redirect=true");
    }

    public String editarVenda(Venda venda){
        this.venda = venda;
        return("/admin/sales/edition?faces-redirect=true");
    }
    
    public String atualizarVenda(){
        return("/admin/sales/listing?faces-redirect=true");
    }
}
