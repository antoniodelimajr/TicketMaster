package br.com.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UsuarioMB {

    @EJB
    private UsuarioFacade ejbFacade;
    private Usuario usuario;
    public List<Usuario> usuarios;

    public UsuarioFacade getFacade() {
        return ejbFacade;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> findAll() {
        usuarios = getFacade().findAll();
        if (usuarios.isEmpty()) {
            initializateDB();
            usuarios = getFacade().findAll();
        }
        return usuarios;
    }

    public String novoUsuario() {
        usuario = new Usuario();
        return ("/admin/users/register?faces-redirect=true");
    }

    public String salvarUsuario() {
        getFacade().create(usuario);
        usuarios.add(usuario);
        return atualizarUsuario();
    }

    public String editarUsuario(Usuario usuario) {
        this.usuario = usuario;
        return ("/admin/users/edition?faces-redirect=true");
    }

    public String alterarUsuario() {
        getFacade().edit(usuario);
        return atualizarUsuario();
    }

    public String removerUsuario(Usuario usuario) {
        getFacade().remove(usuario);
        usuarios.remove(usuario);
        return atualizarUsuario();
    }

    public String atualizarUsuario() {
        usuarios = getFacade().findAll();
        return ("/public/users/listing?faces-redirect=true");
    }

    public void initializateDB() {
        getFacade().create(new Usuario("Fulano", "fulano@teste.com", "fulano", false));
        getFacade().create(new Usuario("Beltrano", "beltrano@teste.com", "beltrano", true));
        getFacade().create(new Usuario("Usuario", "user", "123", false));
        getFacade().create(new Usuario("Administrador", "admin", "123", true));
    }
}
