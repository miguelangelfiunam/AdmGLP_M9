/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.bd.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import mx.unam.dgtic.admglp.bd.DBConnection;
import mx.unam.dgtic.admglp.bd.JDBCUtil;
import mx.unam.dgtic.admglp.vo.Contra;

/**
 *
 * @author unam
 */
public class ContraDAOJDBC implements ContraDAO {
    
    private static ContraDAOJDBC instance;

    private ContraDAOJDBC() {
    }

    public static ContraDAOJDBC getInstance() {
        if (instance == null) {
            instance = new ContraDAOJDBC();
        }
        return instance;
    }
    
    Exception error;

    public Exception getError() {
        return error;
    }

    @Override
    public List<Contra> getContras() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contra> getContrasPorEstatus(Integer estatus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Contra getContra(Integer idcontra) {
        DBConnection db = JDBCUtil.getInstance();
        Contra contraModel = null;
        try {
            String sqlSelect = "SELECT "
                    + "	tc.id_contra, "
                    + "	tc.contra_vc_contra_cifrado, "
                    + "	tc.contra_dt_fecha_registro, "
                    + "	tc.contra_dt_fecha_actualizacion, "
                    + "	tc.contra_si_estatus "
                    + "FROM "
                    + "	t_contra AS tc "
                    + "WHERE "
                    + "	tc.id_contra = ?";
            try ( Connection conn = db.getConnection(); PreparedStatement st = conn.prepareStatement(sqlSelect)) {
                st.setInt(1, idcontra);
                try ( ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        contraModel = new Contra();
                        contraModel.setId(rs.getInt("id_contra"));
                        contraModel.setContra(rs.getString("contra_vc_contra_cifrado"));
                        contraModel.setFecreg(rs.getDate("contra_dt_fecha_registro"));
                        contraModel.setFecact(rs.getDate("contra_dt_fecha_actualizacion"));
                        contraModel.setEstatus(rs.getInt("contra_si_estatus"));
                    }
                }
            }
        } catch (Exception e) {
            this.error = e;
            throw new IllegalStateException("Error al obtener la contraseña " + idcontra);
        }
        return contraModel;
    }

    @Override
    public Boolean existeContra(String apodo, String contra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer insertaContra(Contra contraModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizaContra(Contra contraModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminaContra(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
