/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import mx.unam.dgtic.admglp.Funciones.Funciones;
import mx.unam.dgtic.admglp.modelo.RolService;
import mx.unam.dgtic.admglp.modelo.UsuarioServiceImpl;
import mx.unam.dgtic.admglp.vo.Rol;
import mx.unam.dgtic.admglp.vo.Usuario;

/**
 *
 * @author unam
 */
@Stateless
public class UsuarioEJBLocal implements UsuarioEJB {

    UsuarioServiceImpl us;
    RolService rs;

    @Override
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario getUsuario(Integer idUsuario) {
        Usuario usuario = new Usuario();
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
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
    public Boolean existeUsuario(String apodo, String contra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer insertaUsuario(Usuario usuarioModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizaUsuario(Usuario usuarioModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminaUsuario(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rol> getRoles() {
        List<Rol> roles = new ArrayList<>();
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
            rs = new RolService(em);
            roles = rs.getRoles();
        } catch (Exception e) {
        }
        return roles;
    }

}
