/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.bd.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mx.unam.dgtic.admglp.bd.model.RolModel;
import mx.unam.dgtic.admglp.bd.model.Usuario_rolModel;

/**
 *
 * @author unam
 */
public class Usuario_rolRepositoryImpl implements Usuario_rolRepository {

    Connection cnn;

    Exception error;

    public Exception getError() {
        return error;
    }

    public Usuario_rolRepositoryImpl(Connection cnn) {
        this.cnn = cnn;
    }

    @Override
    public List<Usuario_rolModel> getRolesUsu(Integer idUsuario) {
        List<Usuario_rolModel> usuario_rolModels = new ArrayList<>();
        try {
            String sqlSelect = "SELECT "
                    + "	id_usuario_rol, "
                    + "id_rol, "
                    + "id_usuario, "
                    + "usu_rol_dt_fecha_registro, "
                    + "usu_rol_dt_fecha_actualizacion, "
                    + "usu_rol_si_estatus "
                    + "FROM "
                    + "	tr_usuario_rol AS trur "
                    + "WHERE "
                    + "	trur.id_usuario_rol = ?";
            try ( PreparedStatement st = cnn.prepareStatement(sqlSelect)) {
                st.setInt(1, idUsuario);
                try ( ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        Usuario_rolModel usuario_rolModel = new Usuario_rolModel();
                        usuario_rolModel.setIdusuariorol(rs.getInt("id_usuario_rol"));
                        usuario_rolModel.setRol(new RolModel(rs.getInt("id_rol")));
                        usuario_rolModel.setFecreg(rs.getDate("usu_rol_dt_fecha_registro"));
                        usuario_rolModel.setFecact(rs.getDate("usu_rol_dt_fecha_actualizacion"));
                        usuario_rolModel.setEstatus(rs.getInt("usu_rol_si_estatus"));
                        usuario_rolModels.add(usuario_rolModel);
                    }
                }
            }
        } catch (Exception e) {
            this.error = e;
            throw new IllegalStateException("Error al obtener relaciones usuario - rol");
        }
        return usuario_rolModels;
    }

    @Override
    public Usuario_rolModel getRol(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer insertaRol(Usuario_rolModel usuario_rolModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizaRol(Usuario_rolModel usuario_rolModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminaRol(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
