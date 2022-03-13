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
import mx.unam.dgtic.admglp.bd.repository.ContraRepositoryImpl;
import mx.unam.dgtic.admglp.bd.repository.RolRepositoryImpl;
import mx.unam.dgtic.admglp.bd.repository.UsuarioRepositoryImpl;
import mx.unam.dgtic.admglp.bd.repository.Usuario_rolRepositoryImpl;

/**
 *
 * @author unam
 */
public class UsuarioServiceImpl implements UsuarioService {

    UsuarioRepositoryImpl usuarioRepositoryImpl;
    ContraRepositoryImpl contraRepositoryImpl;
    RolRepositoryImpl rolRepositoryImpl;
    Usuario_rolRepositoryImpl usuario_rolRepositoryImpl;

    @Override
    public List<UsuarioModel> getUsuarios() {
        Connection cnn = null;
        List<UsuarioModel> usuarios = new ArrayList<>();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream input = classLoader.getResourceAsStream("db.properties");;
            Properties properties = new Properties();
            properties.load(input);
            String db = properties.getProperty("db.url");
            String db_user = properties.getProperty("db.user");
            String db_user_pass = properties.getProperty("db.password");
            cnn = DriverManager.getConnection(db, db_user, db_user_pass);

            usuarioRepositoryImpl = new UsuarioRepositoryImpl(cnn);
            contraRepositoryImpl = new ContraRepositoryImpl(cnn);
            rolRepositoryImpl = new RolRepositoryImpl(cnn);
            usuario_rolRepositoryImpl = new Usuario_rolRepositoryImpl(cnn);
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

        } finally {
            if (cnn != null) {
                try {
                    cnn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
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
