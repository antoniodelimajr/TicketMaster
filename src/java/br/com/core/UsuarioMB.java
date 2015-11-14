package br.com.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UsuarioMB {

    public static List<Usuario> usuarios = new ArrayList<>(
            Arrays.asList(
                    new Usuario("Fulano", "fulano@teste.com", "fulano", false),
                    new Usuario("Beltrano", "beltrano@teste.com", "beltrano", true),
                    new Usuario("Usuario", "user", "123", false),
                    new Usuario("Administrador", "admin", "123", true)));
    
    private Usuario usuario;

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        UsuarioMB.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String novoUsuario() {
        usuario = new Usuario();
        return ("/admin/users/register?faces-redirect=true");
    }

    public String salvarUsuario() {
        usuarios.add(usuario);
        return atualizarUsuario();
    }

    public String editarUsuario(Usuario usuario) {
        this.usuario = usuario;
        return ("/admin/users/edition?faces-redirect=true");
    }

    public String atualizarUsuario() {
        return ("/public/users/listing?faces-redirect=true");
    }

    public String removerUsuario(Usuario usuario) {
        usuarios.remove(usuario);
        return atualizarUsuario();
    }
}