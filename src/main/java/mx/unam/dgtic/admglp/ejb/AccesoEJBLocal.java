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
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.Funciones.Funciones;
import mx.unam.dgtic.admglp.modelo.AccesoServiceImpl;
import mx.unam.dgtic.admglp.vo.Acceso;

/**
 *
 * @author unam
 */
@Stateless
public class AccesoEJBLocal implements AccesoEJB {

    AccesoServiceImpl as;

    @Override
    public List<Acceso> getAccesos() {
        List<Acceso> accesos = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            as = new AccesoServiceImpl(em);
            accesos = as.getAccesos();
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en AccesoService: " + e.getMessage() + "</p>";
            if (as.getError() != null) {
                mensaje += "<p>" + "Error en AccesoEJBLocal -> getAccesos() -> AccesoService -> getAccesos() " + as.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return accesos;
    }

    @Override
    public List<Acceso> getAccesosPorEstatus(Integer estatrs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Acceso getAcceso(Integer idAcceso) {
        Acceso acceso = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            as = new AccesoServiceImpl(em);
            acceso = as.getAcceso(idAcceso);

        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en AccesoServiceImpl: " + e.getMessage() + "</p>";

            if (as.getError() != null) {
                mensaje += "<p>" + "Error en AccesoEJBLocal -> getAcceso() -> AccesoService -> getAcceso() " + as.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return acceso;
    }

    @Override
    public Acceso insertaAcceso(Acceso acceso) {
        try {
            EntityManager em = Conexion.createEntityManager();
            as = new AccesoServiceImpl(em);
            acceso = as.insertAcceso(acceso);

        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en AccesoServiceImpl: " + e.getMessage() + "</p>";

            if (as.getError() != null) {
                mensaje += "<p>" + "Error en AccesoEJBLocal -> insertaAcceso() -> AccesoService -> insertaAcceso() " + as.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return acceso;
    }

    @Override
    public Acceso actualizaAcceso(Acceso acceso) {
        try {
            EntityManager em = Conexion.createEntityManager();
            as = new AccesoServiceImpl(em);
            acceso = as.updateAcceso(acceso);

        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en AccesoServiceImpl: " + e.getMessage() + "</p>";

            if (as.getError() != null) {
                mensaje += "<p>" + "Error en AccesoEJBLocal -> insertaAcceso() -> AccesoService -> insertaAcceso() " + as.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return acceso;
    }

    @Override
    public Acceso eliminaAcceso(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Acceso finalizaAcceso(Integer id) {
        Acceso acceso = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            as = new AccesoServiceImpl(em);
            acceso = as.getAcceso(id);
            if(acceso != null){
                acceso.setFecfin(new Date());
                acceso.setDescripcion("Se finaliza sesión");
                as.updateAcceso(acceso);
            }
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en AccesoServiceImpl: " + e.getMessage() + "</p>";

            if (as.getError() != null) {
                mensaje += "<p>" + "Error en AccesoEJBLocal -> getAcceso() -> AccesoService -> getAcceso() " + as.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return acceso;
    }

}
