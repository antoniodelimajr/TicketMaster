package br.com.core;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped    
public class LoginMB {
    
    private Login login;
    private Boolean isLogged = false;
    private Boolean isAdmin = false;
    
    public LoginMB() {
        login = new Login();
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

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
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
        
        for(Usuario usuario : UsuarioMB.usuarios){
            if(usuario.getEmail().equals(login.getEmail()) &&
                    usuario.getSenha().equals(login.getSenha())){
                isAdmin = usuario.getIsAdmin();
                return true;
            } 
        }
        isAdmin = false;
        return false;
    }
}
