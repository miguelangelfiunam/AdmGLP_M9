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

/**
 *
 * @author unam
 */
public class RolRepositoryImpl implements RolRepository {

    Connection cnn;

    Exception error;

    public Exception getError() {
        return error;
    }

    public RolRepositoryImpl(Connection cnn) {
        this.cnn = cnn;
    }

    @Override
    public List<RolModel> getRoles() {
        List<RolModel> rolModels = new ArrayList<>();
        try {
            String sqlSelect = "SELECT "
                    + "	cr.id_rol, "
                    + "	cr.rol_vc_nombre, "
                    + "	cr.rol_c_tipo_rol, "
                    + "	cr.rol_dt_fecha_registro, "
                    + "	cr.rol_dt_fecha_actualizacion, "
                    + "	cr.rol_si_estatus "
                    + "FROM "
                    + "	c_rol AS cr"
                    + "WHERE "
                    + "	cr.rol_si_estatus = 10;";
            try ( PreparedStatement st = cnn.prepareStatement(sqlSelect)) {
                try ( ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        RolModel rolModel = new RolModel();
                        rolModel.setIdrol(rs.getInt("id_rol"));
                        rolModel.setNombre(rs.getString("rol_vc_nombre"));
                        rolModel.setTipo(rs.getString("rol_c_tipo_rol"));
                        rolModel.setFecreg(rs.getDate("rol_dt_fecha_registro"));
                        rolModel.setFecact(rs.getDate("rol_dt_fecha_actualizacion"));
                        rolModel.setEstatus(rs.getInt("rol_si_estatus"));
                        rolModels.add(rolModel);
                    }
                }
            }
        } catch (Exception e) {
            this.error = e;
            throw new IllegalStateException("Error al obtener los roles");
        }
        return rolModels;
    }

    @Override
    public List<RolModel> getRolesPorEstatus(Integer estatus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RolModel getRol(Integer id) {
        RolModel rolModel = null;
        try {
            String sqlSelect = "SELECT "
                    + "	cr.id_rol, "
                    + "	cr.rol_vc_nombre, "
                    + "	cr.rol_c_tipo_rol, "
                    + "	cr.rol_dt_fecha_registro, "
                    + "	cr.rol_dt_fecha_actualizacion, "
                    + "	cr.rol_si_estatus "
                    + "FROM "
                    + "	c_rol AS cr "
                    + "WHERE "
                    + "	cr.id_rol = ?;";
            try ( PreparedStatement st = cnn.prepareStatement(sqlSelect)) {
                st.setInt(1, id);
                try ( ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        rolModel = new RolModel();
                        rolModel.setIdrol(rs.getInt("id_rol"));
                        rolModel.setNombre(rs.getString("rol_vc_nombre"));
                        rolModel.setTipo(rs.getString("rol_c_tipo_rol"));
                        rolModel.setFecreg(rs.getDate("rol_dt_fecha_registro"));
                        rolModel.setFecact(rs.getDate("rol_dt_fecha_actualizacion"));
                        rolModel.setEstatus(rs.getInt("rol_si_estatus"));
                    }
                }
            }
        } catch (Exception e) {
            this.error = e;
            throw new IllegalStateException("Error al obtener el rol " + id);
        }
        return rolModel;
    }

    @Override
    public Boolean existeRol(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer insertaRol(RolModel contraModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizaRol(RolModel contraModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminaRol(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
