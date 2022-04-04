/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.bd.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mx.unam.dgtic.admglp.bd.DBConnection;
import mx.unam.dgtic.admglp.bd.JDBCUtil;
import mx.unam.dgtic.admglp.vo.Contra;
import mx.unam.dgtic.admglp.vo.Usuario;

/**
 *
 * @author unam
 */
public class UsuarioDAOJDBC implements UsuarioDAO {

    private static UsuarioDAOJDBC instance;

    private UsuarioDAOJDBC() {
    }

    public static UsuarioDAOJDBC getInstance() {
        if (instance == null) {
            instance = new UsuarioDAOJDBC();
        }
        return instance;
    }

    Exception error;

    public Exception getError() {
        return error;
    }

    @Override
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarioModels = new ArrayList<>();
        try {
            DBConnection db = JDBCUtil.getInstance();
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
                        Usuario usuarioModel = new Usuario();
                        usuarioModel.setIdusuario(rs.getInt("id_usuario"));
                        usuarioModel.setContra(new Contra(rs.getInt("id_contra")));
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
    public List<Usuario> getUsuariosPorEstatus(Integer estatus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario getUsuario(Integer idUsuario) {
        Usuario usuarioModel = null;
        try {
            DBConnection db = JDBCUtil.getInstance();
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
                    + "	t_usuario AS tu "
                    + "WHERE "
                    + " tu.id_usuario = ?";
            try ( Connection conn = db.getConnection();  PreparedStatement st = conn.prepareStatement(sqlSelect)) {
                st.setInt(1, idUsuario);
                try ( ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        usuarioModel = new Usuario();
                        usuarioModel.setIdusuario(rs.getInt("id_usuario"));
                        usuarioModel.setContra(new Contra(rs.getInt("id_contra")));
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
                    }
                }
            }
        } catch (Exception e) {
            this.error = e;
            throw new IllegalStateException("Error al obtener a los usuarios");
        }
        return usuarioModel;
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
        try {
            DBConnection db = JDBCUtil.getInstance();

            String sSqlUpdate = "UPDATE t_usuario SET "
                    + "  usuario_vc_apodo = ?, "
                    + "  usuario_vc_correo1 = ?, "
                    + "  usuario_vc_correo2 = ?, "
                    + "  usuario_vc_nombre = ?, "
                    + "  usuario_vc_apellido1 = ?, "
                    + "  usuario_vc_apellido2 = ?, "
                    + "  usuario_ti_edad = ?, "
                    + "  usuario_d_fec_nacimiento = ?, "
                    + "  usuario_vc_telefono1 = ?, "
                    + "  usuario_vc_telefono2 = ?, "
                    + "  usuario_dt_fecha_actualizacion = now(), "
                    + "  usuario_si_estatus = ? "
                    + " WHERE id_usuario = ? ";
            try ( Connection conn = db.getConnection();  PreparedStatement stUpdate = conn.prepareStatement(sSqlUpdate)) {
                int i = 1;
                stUpdate.setString(i++, usuarioModel.getApodo());
                stUpdate.setString(i++, usuarioModel.getCorreo1());
                stUpdate.setString(i++, usuarioModel.getCorreo2());
                stUpdate.setString(i++, usuarioModel.getNombre());
                stUpdate.setString(i++, usuarioModel.getApellido1());
                stUpdate.setString(i++, usuarioModel.getApellido2());
                stUpdate.setInt(i++, usuarioModel.getEdad());
                stUpdate.setDate(i++, new java.sql.Date(usuarioModel.getFnac().getTime()));
                stUpdate.setString(i++, usuarioModel.getTelefono1());
                stUpdate.setString(i++, usuarioModel.getTelefono2());
                stUpdate.setInt(i++, usuarioModel.getEstatus());
                stUpdate.setInt(i++, usuarioModel.getIdusuario());

                stUpdate.executeUpdate();
            }
        } catch (Exception e) {
            error = e;
            throw new IllegalStateException("Error al modifcar usuario");
        }
    }

    @Override
    public void eliminaUsuario(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
