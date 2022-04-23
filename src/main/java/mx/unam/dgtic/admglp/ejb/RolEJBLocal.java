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
import mx.unam.dgtic.admglp.modelo.RolServiceImpl;
import mx.unam.dgtic.admglp.vo.Rol;

/**
 *
 * @author unam
 */
@Stateless
public class RolEJBLocal implements RolEJB {

    RolServiceImpl rs;

    @Override
    public List<Rol> getRoles() {
        List<Rol> roles = new ArrayList<>();
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
            rs = new RolServiceImpl(em);
            roles = rs.getRoles();
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en RolService: " + e.getMessage() + "</p>";
            if (rs.getError() != null) {
                mensaje += "<p>" + "Error en RolEJBLocal -> getRols() -> RolService -> getRols() " + rs.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return roles;
    }

    @Override
    public List<Rol> getRolesPorEstatus(Integer estatrs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rol getRol(Integer idRol) {
        Rol rol = null;
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
            rs = new RolServiceImpl(em);
            rol = rs.getRol(idRol);

        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en RolServiceImpl: " + e.getMessage() + "</p>";

            if (rs.getError() != null) {
                mensaje += "<p>" + "Error en RolEJBLocal -> getRol() -> RolService -> getRol() " + rs.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return rol;
    }

    @Override
    public Integer insertaRol(Rol rolModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizaRol(Rol rolModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminaRol(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
