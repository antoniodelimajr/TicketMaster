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
                    new Usuario("Ciclano", "ciclano@teste.com", "ciclano", false)));
    
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
        return ("/admin/users/listing?faces-redirect=true");
    }

    public String editarUsuario(Usuario usuario) {
        this.usuario = usuario;
        return ("/admin/users/edition?faces-redirect=true");
    }

    public String atualizarUsuario() {
        return ("/admin/users/listing?faces-redirect=true");
    }

    public void removerUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }
}