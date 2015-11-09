package br.com.core;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped    
public class LoginMB {
    
    private Login login;
    
    public LoginMB() {
        login = new Login();
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    public String logar(){    
        if (this.verificaUsuario()){
            return "public/ultra/principal.jsf?faces-redirect=true";           
        } else {
            FacesContext.getCurrentInstance().addMessage(
                null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO:", "Senha incorreta!"));
            return "login.jsf";
        }        
    }
        
    public boolean verificaUsuario(){
        return (login.getEmail().equals("teste@teste.com") && login.getSenha().equals("1234") ? true : false);
    }
}
