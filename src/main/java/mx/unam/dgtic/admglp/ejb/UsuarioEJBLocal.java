/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import mx.unam.dgtic.admglp.Funciones.Funciones;
import mx.unam.dgtic.admglp.bd.model.RolModel;
import mx.unam.dgtic.admglp.bd.model.UsuarioModel;
import mx.unam.dgtic.admglp.bd.model.Usuario_rolModel;
import mx.unam.dgtic.admglp.bd.repository.ContraDAOJDBC;
import mx.unam.dgtic.admglp.bd.repository.RolDAOJDBC;
import mx.unam.dgtic.admglp.bd.repository.UsuarioDAOJDBC;
import mx.unam.dgtic.admglp.bd.repository.Usuario_rolDAOJDBC;

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
    public UsuarioModel getUsuario(String apodo, String contra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
