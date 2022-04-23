package mx.unam.dgtic.admglp.bean;

import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import mx.unam.dgtic.admglp.ejb.RolEJBLocal;

import mx.unam.dgtic.admglp.ejb.UsuarioEJBLocal;
import mx.unam.dgtic.admglp.vo.Rol;
import mx.unam.dgtic.admglp.vo.Usuario;

@Model
public class ListasBean implements Serializable {

    private static final long serialVersionUID = -10;

    @Produces
    @Model
    public List<Usuario> cargaUsuarios() {
        List<Usuario> usuarios = null;
        UsuarioEJBLocal service = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (UsuarioEJBLocal) ctx.lookup("java:global/admglp/UsuarioEJBLocal!mx.unam.dgtic.admglp.ejb.UsuarioEJB");
            if (service != null) {
                usuarios = service.getUsuarios();
            } else {
                usuarios = new ArrayList<Usuario>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usuarios;
    }

    public Usuario cargaUsuario(Integer idUsuario) {
        Usuario usuario = null;
        UsuarioEJBLocal service = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (UsuarioEJBLocal) ctx.lookup("java:global/admglp/UsuarioEJBLocal!mx.unam.dgtic.admglp.ejb.UsuarioEJB");
            if (service != null) {
                usuario = service.getUsuario(idUsuario);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usuario;
    }
    
    public Usuario cargaUsuario(String apodo, String contra, Integer estatus) {
        Usuario usuario = null;
        UsuarioEJBLocal service = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (UsuarioEJBLocal) ctx.lookup("java:global/admglp/UsuarioEJBLocal!mx.unam.dgtic.admglp.ejb.UsuarioEJB");
            if (service != null) {
                usuario = service.getUsuario(apodo, contra, estatus);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usuario;
    }

    @Produces
    @Model
    public List<Rol> cargaRoles() {
        List<Rol> roles = null;
        RolEJBLocal service = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (RolEJBLocal) ctx.lookup("java:global/admglp/RolEJBLocal!mx.unam.dgtic.admglp.ejb.RolEJB");
            if (service != null) {
                roles = service.getRoles();
            } else {
                roles = new ArrayList<Rol>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return roles;
    }

}
