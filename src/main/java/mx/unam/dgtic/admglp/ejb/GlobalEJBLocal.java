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
import mx.unam.dgtic.admglp.modelo.GlobalServiceImpl;
import mx.unam.dgtic.admglp.vo.Global;

/**
 *
 * @author unam
 */
@Stateless
public class GlobalEJBLocal implements GlobalEJB {

    GlobalServiceImpl gs;

    @Override
    public List<Global> getGlobales() {
        List<Global> globales = new ArrayList<>();
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
            gs = new GlobalServiceImpl(em);
            globales = gs.getGlobales();
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en GlobalService: " + e.getMessage() + "</p>";
            if (gs.getError() != null) {
                mensaje += "<p>" + "Error en GlobalEJBLocal -> getGlobales() -> GlobalService -> getGlobals() " + gs.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return globales;
    }

    @Override
    public Global getGlobal(String nomGlobal) {
        Global global = null;
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
            gs = new GlobalServiceImpl(em);
            global = gs.getGlobal(nomGlobal);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en GlobalService: " + e.getMessage() + "</p>";
            if (gs.getError() != null) {
                mensaje += "<p>" + "Error en GlobalEJBLocal -> getGlobal() -> GlobalService -> getGlobals() " + gs.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return global;
    }

}
