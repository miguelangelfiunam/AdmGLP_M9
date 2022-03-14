/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.bd.service;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.unam.dgtic.admglp.Funciones.Funciones;
import mx.unam.dgtic.admglp.bd.model.UsuarioModel;
import mx.unam.dgtic.admglp.bd.model.Usuario_rolModel;
import mx.unam.dgtic.admglp.bd.repository.ContraDAOJDBCImpl;
import mx.unam.dgtic.admglp.bd.repository.RolDAOJDBCImpl;
import mx.unam.dgtic.admglp.bd.repository.UsuarioDAOJDBCImpl;
import mx.unam.dgtic.admglp.bd.repository.Usuario_rolDAOJDBCImpl;

/**
 *
 * @author unam
 */
public class UsuarioServiceImpl implements UsuarioService {

    UsuarioDAOJDBCImpl usuarioRepositoryImpl;
    ContraDAOJDBCImpl contraRepositoryImpl;
    RolDAOJDBCImpl rolRepositoryImpl;
    Usuario_rolDAOJDBCImpl usuario_rolRepositoryImpl;

    @Override
    public List<UsuarioModel> getUsuarios() {
        List<UsuarioModel> usuarios = new ArrayList<>();
        try {
            usuarioRepositoryImpl = new UsuarioDAOJDBCImpl();
            contraRepositoryImpl = new ContraDAOJDBCImpl();
            rolRepositoryImpl = new RolDAOJDBCImpl();
            usuario_rolRepositoryImpl = new Usuario_rolDAOJDBCImpl();
            usuarios = usuarioRepositoryImpl.getUsuarios();
            for (UsuarioModel usuario : usuarios) {
                usuario.setContra(contraRepositoryImpl.getContra(usuario.getContra().getId()));
                List<Usuario_rolModel> usuario_rolModels = usuario_rolRepositoryImpl.getRolesUsu(usuario.getIdusuario());
                for (Usuario_rolModel usuario_rolModel : usuario_rolModels) {
                    usuario_rolModel.setRol(rolRepositoryImpl.getRol(usuario_rolModel.getRol().getIdrol()));
                    usuario_rolModel.setUsuarioModel(usuario);
                }
                usuario.setUsuario_rolModels(usuario_rolModels);
            }
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en UsuarioServiceImpl: " + e.getMessage() + "</p>";

            if (usuarioRepositoryImpl.getError() != null) {
                mensaje += "<p>" + "Error en UsuarioServiceImpl -> getUsuarios() -> usuarioRepositoryImpl -> getUsuarios() " + usuarioRepositoryImpl.getError().getMessage() + "</p>";
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

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
