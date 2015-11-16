package br.com.core.venda;

import br.com.core.sala.SalaFacade;
import br.com.core.secao.SecaoFacade;
import br.com.core.secao.Secao;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class VendaMB {

    private List<Venda> vendas;
    private List<Secao> secoes;

    @EJB
    private VendaFacade ejbFacade;

    @EJB
    private SecaoFacade ejbSecaoFacade;

    @EJB
    private SalaFacade ejbSalaFacade;

    private Venda venda;

    public VendaMB() {
        if (vendas == null || vendas.isEmpty()) {
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

    public VendaFacade getFacade() {
        return ejbFacade;
    }

    public SecaoFacade getSecaoFacade() {
        return ejbSecaoFacade;
    }

    public SalaFacade getSalaFacade() {
        return ejbSalaFacade;
    }

    public List<Venda> findAll() {
        vendas = getFacade().findAll();
        secoes = getSecaoFacade().findAll();
        return vendas;
    }

    public String novoVenda() {
        venda = new Venda();
        return ("/admin/sales/register?faces-redirect=true");
    }

    public String salvarVenda() {
        if (venda.getQtdAssentos() <= (venda.getSecao().getSala().getAssentos() - venda.getSecao().getSala().getReservados())) {
            venda.getSecao().getSala().setReservados(venda.getSecao().getSala().getReservados() + venda.getQtdAssentos());
            ejbSalaFacade.edit(venda.getSecao().getSala());
            getFacade().create(venda);
            vendas.add(venda);
            venda = new Venda();
            return atualizarVenda();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO:", "A venda não poderá ser feita pois não existem assentos disponíveis para esta seção!"));
            return null;
        }
    }

    public String editarVenda(Venda venda) {
        this.venda = venda;
        return ("/admin/sales/edition?faces-redirect=true");
    }

    public String alterarVenda() {
        getFacade().edit(venda);
        return atualizarVenda();
    }

    public String removerVenda(Venda venda) {
        venda.getSecao().getSala().setReservados(venda.getSecao().getSala().getReservados() - venda.getQtdAssentos());
        ejbSalaFacade.edit(venda.getSecao().getSala());
        getFacade().remove(venda);
        vendas.remove(venda);
        return atualizarVenda();
    }

    public String atualizarVenda() {
        vendas = getFacade().findAll();
        return ("/public/sales/listing?faces-redirect=true");
    }
}
