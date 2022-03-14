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
import mx.unam.dgtic.admglp.bd.model.ContraModel;
import mx.unam.dgtic.admglp.bd.model.UsuarioModel;
import mx.unam.dgtic.admglp.db.DBConnection;
import mx.unam.dgtic.admglp.db.JDBCUtil;

/**
 *
 * @author unam
 */
public class UsuarioDAOJDBCImpl implements UsuarioDAOJDBC {

    Exception error;

    public Exception getError() {
        return error;
    }

    @Override
    public List<UsuarioModel> getUsuarios() {
        DBConnection db = JDBCUtil.getInstance();
        List<UsuarioModel> usuarioModels = new ArrayList<>();
        try {
            String sqlSelect = "SELECT "
                    + "	tu.id_usuario, "
                    + "	tu.id_contra, "
                    + "	tu.usuario_vc_apodo, "
                    + "	tu.usuario_vc_correo1, "
                    + "	tu.usuario_vc_correo2, "
                    + "	tu.usuario_vc_nombre, "
                    + "	tu.usuario_vc_apellido1, "
                    + "	tu.usuario_vc_apellido2, "
                    + "	tu.usuario_ti_edad, "
                    + "	tu.usuario_d_fec_nacimiento, "
                    + "	tu.usuario_vc_telefono1, "
                    + "	tu.usuario_vc_telefono2, "
                    + "	tu.usuario_dt_fecha_registro, "
                    + "	tu.usuario_dt_fecha_actualizacion, "
                    + "	tu.usuario_si_estatus "
                    + "FROM "
                    + "	t_usuario AS tu";
            try ( Connection conn = db.getConnection();  PreparedStatement st = conn.prepareStatement(sqlSelect)) {
                try ( ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        UsuarioModel usuarioModel = new UsuarioModel();
                        usuarioModel.setIdusuario(rs.getInt("id_usuario"));
                        usuarioModel.setContra(new ContraModel(rs.getInt("id_contra")));
                        usuarioModel.setApodo(rs.getString("usuario_vc_apodo"));
                        usuarioModel.setCorreo1(rs.getString("usuario_vc_correo1"));
                        usuarioModel.setCorreo2(rs.getString("usuario_vc_correo2"));
                        usuarioModel.setNombre(rs.getString("usuario_vc_nombre"));
                        usuarioModel.setApellido1(rs.getString("usuario_vc_apellido1"));
                        usuarioModel.setApellido2(rs.getString("usuario_vc_apellido2"));
                        usuarioModel.setEdad(rs.getInt("usuario_ti_edad"));
                        usuarioModel.setFnac(rs.getDate("usuario_d_fec_nacimiento"));
                        usuarioModel.setTelefono1(rs.getString("usuario_vc_telefono1"));
                        usuarioModel.setTelefono2(rs.getString("usuario_vc_telefono2"));
                        usuarioModel.setFecreg(rs.getDate("usuario_dt_fecha_registro"));
                        usuarioModel.setFecact(rs.getDate("usuario_dt_fecha_actualizacion"));
                        usuarioModel.setEstatus(rs.getInt("usuario_si_estatus"));
                        usuarioModels.add(usuarioModel);
                    }
                }
            }
        } catch (Exception e) {
            this.error = e;
            throw new IllegalStateException("Error al obtener a los usuarios");
        }
        return usuarioModels;
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

}
