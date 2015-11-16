package br.com.core.login;

import br.com.core.usuario.Usuario;
import br.com.core.usuario.UsuarioFacade;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped    
public class LoginMB {
    
    private Login login;
    private Boolean isLogged = false;
    
    @EJB
    private UsuarioFacade ejbUsuarioFacade;
    
    public LoginMB() {
        login = new Login();
    }

    public UsuarioFacade getUsuarioFacade() {
        return ejbUsuarioFacade;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Boolean getIsLogged() {
        return isLogged;
    }

    public void setIsLogged(Boolean isLogged) {
        this.isLogged = isLogged;
    }
    
    public String logar(){    
        
        this.isLogged = this.verificaUsuario();

        if (this.isLogged){
            return "public/ultra/principal.jsf?faces-redirect=true";           
        } else {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO:", "Senha incorreta!"));
            return "login.jsf";
        }        
    }
    
     public String logout(){    
        this.isLogged = false;
        return "/login.jsf?faces-redirect=true";
    }
        
    public boolean verificaUsuario(){
        
        for(Usuario usuario : getUsuarioFacade().findAll()){
            if(usuario.getEmail().equals(login.getEmail()) && 
                    usuario.getSenha().equals(login.getSenha())){
                
                login.setEmail(usuario.getEmail());
                login.setIsAdmin(usuario.getIsAdmin());
                login.setNome(usuario.getNome());
                login.setSenha(usuario.getSenha());
                return true;
            } 
        }
        return false;
    }
}
