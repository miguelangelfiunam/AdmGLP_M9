/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import mx.unam.dgtic.admglp.Funciones.Funciones;
import mx.unam.dgtic.admglp.bd.repository.ContraDAOJDBC;
import mx.unam.dgtic.admglp.bd.repository.RolDAOJDBC;
import mx.unam.dgtic.admglp.bd.repository.UsuarioDAOJDBC;
import mx.unam.dgtic.admglp.bd.repository.Usuario_rolDAOJDBC;
import mx.unam.dgtic.admglp.vo.RolModel;
import mx.unam.dgtic.admglp.vo.UsuarioModel;
import mx.unam.dgtic.admglp.vo.Usuario_rolModel;

/**
 *
 * @author unam
 */
@Stateless
public class UsuarioEJBLocal implements UsuarioEJB {

    UsuarioDAOJDBC usuarioDAOJDBC;
    ContraDAOJDBC contraDAOJDBC;
    RolDAOJDBC rolDAOJDBC;
    Usuario_rolDAOJDBC usuario_rolDAOJDBC;

    @Override
    public List<UsuarioModel> getUsuarios() {
        List<UsuarioModel> usuarios = new ArrayList<>();
        try {
            usuarioDAOJDBC = UsuarioDAOJDBC.getInstance();
            contraDAOJDBC = ContraDAOJDBC.getInstance();
            rolDAOJDBC = RolDAOJDBC.getInstance();
            usuario_rolDAOJDBC = Usuario_rolDAOJDBC.getInstance();
            usuarios = usuarioDAOJDBC.getUsuarios();
            for (UsuarioModel usuario : usuarios) {
                usuario.setContra(contraDAOJDBC.getContra(usuario.getContra().getId()));
                List<Usuario_rolModel> usuario_rolModels = usuario_rolDAOJDBC.getRolesUsu(usuario.getIdusuario());
                for (Usuario_rolModel usuario_rolModel : usuario_rolModels) {
                    usuario_rolModel.setRol(rolDAOJDBC.getRol(usuario_rolModel.getRol().getIdrol()));
                    usuario_rolModel.setUsuarioModel(usuario);
                }
                usuario.setUsuario_rolModels(usuario_rolModels);
            }
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en UsuarioServiceImpl: " + e.getMessage() + "</p>";

            if (usuarioDAOJDBC.getError() != null) {
                mensaje += "<p>" + "Error en UsuarioServiceImpl -> getUsuarios() -> usuarioDAOJDBC -> getUsuarios() " + usuarioDAOJDBC.getError().getMessage() + "</p>";
            }
            if (contraDAOJDBC.getError() != null) {
                mensaje += "<p>" + "Error en UsuarioServiceImpl -> getUsuarios() -> contraDAOJDBC -> getUsuarios() " + contraDAOJDBC.getError().getMessage() + "</p>";
            }
            if (rolDAOJDBC.getError() != null) {
                mensaje += "<p>" + "Error en UsuarioServiceImpl -> getUsuarios() -> rolDAOJDBC -> getUsuarios() " + rolDAOJDBC.getError().getMessage() + "</p>";
            }
            if (usuario_rolDAOJDBC.getError() != null) {
                mensaje += "<p>" + "Error en UsuarioServiceImpl -> getUsuarios() -> usuario_rolDAOJDBC -> getUsuarios() " + usuario_rolDAOJDBC.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return usuarios;
    }

    @Override
    public List<UsuarioModel> getUsuariosPorEstatus(Integer estatus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioModel getUsuario(Integer idUsuario) {
        UsuarioModel usuario = null;
        try {
            usuarioDAOJDBC = UsuarioDAOJDBC.getInstance();
            contraDAOJDBC = ContraDAOJDBC.getInstance();
            rolDAOJDBC = RolDAOJDBC.getInstance();
            usuario_rolDAOJDBC = Usuario_rolDAOJDBC.getInstance();
            usuario = usuarioDAOJDBC.getUsuario(idUsuario);
            usuario.setContra(contraDAOJDBC.getContra(usuario.getContra().getId()));
            List<Usuario_rolModel> usuario_rolModels = usuario_rolDAOJDBC.getRolesUsu(usuario.getIdusuario());
            for (Usuario_rolModel usuario_rolModel : usuario_rolModels) {
                usuario_rolModel.setRol(rolDAOJDBC.getRol(usuario_rolModel.getRol().getIdrol()));
                usuario_rolModel.setUsuarioModel(usuario);
            }
            usuario.setUsuario_rolModels(usuario_rolModels);

        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en UsuarioServiceImpl: " + e.getMessage() + "</p>";

            if (usuarioDAOJDBC.getError() != null) {
                mensaje += "<p>" + "Error en UsuarioServiceImpl -> getUsuario() -> usuarioDAOJDBC -> getUsuarios() " + usuarioDAOJDBC.getError().getMessage() + "</p>";
            }
            if (contraDAOJDBC.getError() != null) {
                mensaje += "<p>" + "Error en UsuarioServiceImpl -> getUsuario() -> contraDAOJDBC -> getUsuarios() " + contraDAOJDBC.getError().getMessage() + "</p>";
            }
            if (rolDAOJDBC.getError() != null) {
                mensaje += "<p>" + "Error en UsuarioServiceImpl -> getUsuario() -> rolDAOJDBC -> getUsuarios() " + rolDAOJDBC.getError().getMessage() + "</p>";
            }
            if (usuario_rolDAOJDBC.getError() != null) {
                mensaje += "<p>" + "Error en UsuarioServiceImpl -> getUsuario() -> usuario_rolDAOJDBC -> getUsuarios() " + usuario_rolDAOJDBC.getError().getMessage() + "</p>";
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
    public Integer insertaUsuario(UsuarioModel usuarioModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizaUsuario(UsuarioModel usuarioModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminaUsuario(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RolModel> getRoles() {
        rolDAOJDBC = RolDAOJDBC.getInstance();
        return rolDAOJDBC.getRoles();
    }

}
