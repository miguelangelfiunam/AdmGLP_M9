package mx.unam.dgtic.admglp.bean.model;

import jakarta.enterprise.inject.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.ejb.UsuarioEJBLocal;
import mx.unam.dgtic.admglp.vo.Usuario;

/**
 * Modelo para metodos de usuarios
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/04/2022 - 26/04/2022
 *
 */
@Model
public class UsuarioModel implements Serializable {

    private static final long serialVersionUID = -100000;

    public List<Usuario> cargaUsuarios() {
        List<Usuario> usuarios = null;
        UsuarioEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
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
            InitialContext ctx = Conexion.createInitialContext();
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
            InitialContext ctx = Conexion.createInitialContext();
            service = (UsuarioEJBLocal) ctx.lookup("java:global/admglp/UsuarioEJBLocal!mx.unam.dgtic.admglp.ejb.UsuarioEJB");
            if (service != null) {
                usuario = service.getUsuario(apodo, contra, estatus);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usuario;
    }

    public void actualizaEstatusPorUsuario(Integer id, Integer estatus) {
        UsuarioEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (UsuarioEJBLocal) ctx.lookup("java:global/admglp/UsuarioEJBLocal!mx.unam.dgtic.admglp.ejb.UsuarioEJB");
            if (service != null) {
                service.actualizaEstatusUsuario(id, estatus);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Usuario actualizaUsuario(Usuario usuario) {
        UsuarioEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (UsuarioEJBLocal) ctx.lookup("java:global/admglp/UsuarioEJBLocal!mx.unam.dgtic.admglp.ejb.UsuarioEJB");
            if (service != null) {
                usuario = service.actualizaUsuario(usuario);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usuario;
    }

    public Usuario insertaUsuario(Usuario usuario) {
        UsuarioEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (UsuarioEJBLocal) ctx.lookup("java:global/admglp/UsuarioEJBLocal!mx.unam.dgtic.admglp.ejb.UsuarioEJB");
            if (service != null) {
                usuario = service.insertaUsuario(usuario);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usuario;
    }
}
