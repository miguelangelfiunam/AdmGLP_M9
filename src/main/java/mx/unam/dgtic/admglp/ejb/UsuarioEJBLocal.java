/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.Funciones.Funciones;
import mx.unam.dgtic.admglp.modelo.UsuarioServiceImpl;
import mx.unam.dgtic.admglp.vo.Usuario;

/**
 *
 * @author unam
 */
@Stateless
public class UsuarioEJBLocal implements UsuarioEJB {

    UsuarioServiceImpl us;

    @Override
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            us = new UsuarioServiceImpl(em);
            usuarios = us.getUsuarios();
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en UsuarioService: " + e.getMessage() + "</p>";
            if (us.getError() != null) {
                mensaje += "<p>" + "Error en UsuarioEJBLocal -> getUsuarios() -> UsuarioService -> getUsuarios() " + us.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return usuarios;
    }

    @Override
    public List<Usuario> getUsuariosPorEstatus(Integer estatus) {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            us = new UsuarioServiceImpl(em);
            usuarios = us.getUsuarios(estatus);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en UsuarioService: " + e.getMessage() + "</p>";
            if (us.getError() != null) {
                mensaje += "<p>" + "Error en UsuarioEJBLocal -> getUsuarios() -> UsuarioService -> getUsuarios() " + us.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return usuarios;
    }

    @Override
    public Usuario getUsuario(Integer idUsuario) {
        Usuario usuario = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            us = new UsuarioServiceImpl(em);
            usuario = us.getUsuario(idUsuario);

        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en UsuarioServiceImpl: " + e.getMessage() + "</p>";

            if (us.getError() != null) {
                mensaje += "<p>" + "Error en UsuarioEJBLocal -> getUsuario() -> UsuarioService -> getUsuario() " + us.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return usuario;
    }

    @Override
    public Usuario getUsuario(String apodo, String contra, Integer estatus) {
        Usuario usuario = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            us = new UsuarioServiceImpl(em);
            usuario = us.getUsuario(apodo, contra, estatus);

        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en UsuarioServiceImpl: " + e.getMessage() + "</p>";

            if (us.getError() != null) {
                mensaje += "<p>" + "Error en UsuarioEJBLocal -> getUsuario() -> UsuarioService -> getUsuario() " + us.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return usuario;
    }

    @Override
    public Boolean existeUsuario(String apodo, String contra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario insertaUsuario(Usuario usuario) {
        try {
            EntityManager em = Conexion.createEntityManager();
            us = new UsuarioServiceImpl(em);
            usuario = us.insertUsuario(usuario);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en UsuarioServiceImpl: " + e.getMessage() + "</p>";

            if (us.getError() != null) {
                mensaje += "<p>" + "Error en UsuarioEJBLocal -> insertaUsuario() -> UsuarioService -> insertaUsuario() " + us.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return usuario;
    }

    @Override
    public Usuario actualizaUsuario(Usuario usuario) {
        try {
            EntityManager em = Conexion.createEntityManager();
            us = new UsuarioServiceImpl(em);
            usuario = us.updateUsuario(usuario);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en UsuarioServiceImpl: " + e.getMessage() + "</p>";

            if (us.getError() != null) {
                mensaje += "<p>" + "Error en UsuarioEJBLocal -> insertaUsuario() -> UsuarioService -> insertaUsuario() " + us.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return usuario;
    }

    @Override
    public void eliminaUsuario(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizaEstatusUsuario(Integer id, Integer estatus) {
        Usuario usuario = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            us = new UsuarioServiceImpl(em);
            usuario = us.getUsuario(id);
            if (usuario != null) {
                usuario.setEstatus(estatus);
                us.updateUsuario(usuario);
            }
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en UsuarioServiceImpl: " + e.getMessage() + "</p>";

            if (us.getError() != null) {
                mensaje += "<p>" + "Error en UsuarioEJBLocal -> getUsuario() -> UsuarioService -> getUsuario() " + us.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
    }

}
