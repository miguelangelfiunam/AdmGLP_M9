/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.Funciones.Funciones;
import mx.unam.dgtic.admglp.modelo.AsentamientoServiceImpl;
import mx.unam.dgtic.admglp.vo.Asentamiento;

/**
 *
 * @author unam
 */
@Stateless
public class AsentamientoEJBLocal implements AsentamientoEJB {

    AsentamientoServiceImpl es;

    @Override
    public List<Asentamiento> getAsentamientos() {
        List<Asentamiento> asentamientos = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new AsentamientoServiceImpl(em);
            asentamientos = es.getAsentamientos();
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en AsentamientoService: " + e.getMessage() + "</p>";
            if (es.getError() != null) {
                mensaje += "<p>" + "Error en AsentamientoEJBLocal -> getAsentamientos() -> AsentamientoService -> getAsentamientos() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return asentamientos;
    }

    @Override
    public List<Asentamiento> getAsentamientosPorEstatus(Integer estatus) {
        List<Asentamiento> asentamientos = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new AsentamientoServiceImpl(em);
            asentamientos = es.getAsentamientos(estatus);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en AsentamientoService: " + e.getMessage() + "</p>";
            if (es.getError() != null) {
                mensaje += "<p>" + "Error en AsentamientoEJBLocal -> getAsentamientosPorEstatus() -> AsentamientoService -> getAsentamientos() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return asentamientos;
    }

    @Override
    public Asentamiento getAsentamiento(Integer idAsentamiento) {
        Asentamiento asentamiento = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new AsentamientoServiceImpl(em);
            asentamiento = es.getAsentamiento(idAsentamiento);

        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en AsentamientoServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en AsentamientoEJBLocal -> getAsentamiento() -> AsentamientoService -> getAsentamiento() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return asentamiento;
    }

    @Override
    public Boolean existeAsentamiento(Integer idAsentamiento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Asentamiento insertaAsentamiento(Asentamiento asentamiento) {
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new AsentamientoServiceImpl(em);
            asentamiento = es.insertAsentamiento(asentamiento);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en AsentamientoServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en AsentamientoEJBLocal -> insertaAsentamiento() -> AsentamientoService -> insertaAsentamiento() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return asentamiento;
    }

    @Override
    public Asentamiento actualizaAsentamiento(Asentamiento asentamiento) {
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new AsentamientoServiceImpl(em);
            asentamiento = es.updateAsentamiento(asentamiento);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en AsentamientoServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en AsentamientoEJBLocal -> insertaAsentamiento() -> AsentamientoService -> insertaAsentamiento() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return asentamiento;
    }

    @Override
    public void eliminaAsentamiento(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizaEstatusAsentamiento(Integer id, Integer estatus) {
        Asentamiento asentamiento = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new AsentamientoServiceImpl(em);
            asentamiento = es.getAsentamiento(id);
            if (asentamiento != null) {
                asentamiento.setEstatus(estatus);
                es.updateAsentamiento(asentamiento);
            }
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en AsentamientoServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en AsentamientoEJBLocal -> getAsentamiento() -> AsentamientoService -> getAsentamiento() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
    }

    @Override
    public List<Asentamiento> getAsentamientosPorIdMunicipio(Integer idMunicipio, Integer estatus_asentamiento) {
        List<Asentamiento> asentamientos = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new AsentamientoServiceImpl(em);
            asentamientos = es.getAsentamientosPorIdMunicipio(idMunicipio, estatus_asentamiento);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en AsentamientoServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en AsentamientoEJBLocal -> getAsentamiento() -> AsentamientoService -> getAsentamientoPorIdUsuario() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return asentamientos;
    }

}
