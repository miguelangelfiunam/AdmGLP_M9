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
import mx.unam.dgtic.admglp.modelo.ContraServiceImpl;
import mx.unam.dgtic.admglp.vo.Contra;

/**
 *
 * @author unam
 */
@Stateless
public class ContraEJBLocal implements ContraEJB {

    ContraServiceImpl cs;

    @Override
    public List<Contra> getContras() {
        List<Contra> contras = new ArrayList<>();
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
            cs = new ContraServiceImpl(em);
            contras = cs.getContras();
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ContraService: " + e.getMessage() + "</p>";
            if (cs.getError() != null) {
                mensaje += "<p>" + "Error en ContraEJBLocal -> getContras() -> ContraService -> getContras() " + cs.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return contras;
    }

    @Override
    public List<Contra> getContrasPorEstatus(Integer estatus) {
       List<Contra> contras = new ArrayList<>();
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
            cs = new ContraServiceImpl(em);
            contras = cs.getContras(estatus);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ContraService: " + e.getMessage() + "</p>";
            if (cs.getError() != null) {
                mensaje += "<p>" + "Error en ContraEJBLocal -> getContras() -> ContraService -> getContras() " + cs.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return contras;
    }

    @Override
    public Contra getContra(Integer idContra) {
        Contra contra = null;
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
            cs = new ContraServiceImpl(em);
            contra = cs.getContra(idContra);

        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ContraServiceImpl: " + e.getMessage() + "</p>";

            if (cs.getError() != null) {
                mensaje += "<p>" + "Error en ContraEJBLocal -> getContra() -> ContraService -> getContra() " + cs.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return contra;
    }

    @Override
    public Contra insertaContra(Contra contra) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
            cs = new ContraServiceImpl(em);
            contra = cs.insertContra(contra);

        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ContraServiceImpl: " + e.getMessage() + "</p>";

            if (cs.getError() != null) {
                mensaje += "<p>" + "Error en ContraEJBLocal -> insertaContra() -> ContraService -> insertaContra() " + cs.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return contra;
    }

    @Override
    public Contra actualizaContra(Contra contra) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
            cs = new ContraServiceImpl(em);
            contra = cs.updateContra(contra);

        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ContraServiceImpl: " + e.getMessage() + "</p>";

            if (cs.getError() != null) {
                mensaje += "<p>" + "Error en ContraEJBLocal -> insertaContra() -> ContraService -> insertaContra() " + cs.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return contra;
    }

    @Override
    public void eliminaContra(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
