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
import mx.unam.dgtic.admglp.modelo.DireccionServiceImpl;
import mx.unam.dgtic.admglp.vo.Direccion;

/**
 *
 * @author unam
 */
@Stateless
public class DireccionEJBLocal implements DireccionEJB {

    DireccionServiceImpl ds;

    @Override
    public List<Direccion> getDirecciones() {
        List<Direccion> direcciones = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            ds = new DireccionServiceImpl(em);
            direcciones = ds.getDirecciones();
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en DireccionService: " + e.getMessage() + "</p>";
            if (ds.getError() != null) {
                mensaje += "<p>" + "Error en DireccionEJBLocal -> getDirecciones() -> DireccionService -> getDireccions() " + ds.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return direcciones;
    }

    @Override
    public List<Direccion> getDireccionesPorEstatus(Integer estatus) {
        List<Direccion> direcciones = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            ds = new DireccionServiceImpl(em);
            direcciones = ds.getDirecciones(estatus);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en DireccionService: " + e.getMessage() + "</p>";
            if (ds.getError() != null) {
                mensaje += "<p>" + "Error en DireccionEJBLocal -> getDirecciones() -> DireccionService -> getDireccions() " + ds.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return direcciones;
    }

    @Override
    public Direccion getDireccion(Integer idDireccion) {
        Direccion direccion = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            ds = new DireccionServiceImpl(em);
            direccion = ds.getDireccion(idDireccion);

        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en DireccionServiceImpl: " + e.getMessage() + "</p>";

            if (ds.getError() != null) {
                mensaje += "<p>" + "Error en DireccionEJBLocal -> getDireccion() -> DireccionService -> getDireccion() " + ds.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return direccion;
    }

    @Override
    public Direccion insertaDireccion(Direccion direccion) {
        try {
            EntityManager em = Conexion.createEntityManager();
            ds = new DireccionServiceImpl(em);
            direccion = ds.insertDireccion(direccion);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en DireccionServiceImpl: " + e.getMessage() + "</p>";

            if (ds.getError() != null) {
                mensaje += "<p>" + "Error en DireccionEJBLocal -> insertaDireccion() -> DireccionService -> insertaDireccion() " + ds.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return direccion;
    }

    @Override
    public Direccion actualizaDireccion(Direccion direccion) {
        try {
            EntityManager em = Conexion.createEntityManager();
            ds = new DireccionServiceImpl(em);
            direccion = ds.updateDireccion(direccion);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en DireccionServiceImpl: " + e.getMessage() + "</p>";

            if (ds.getError() != null) {
                mensaje += "<p>" + "Error en DireccionEJBLocal -> actualizaDireccion() -> DireccionService -> updateDireccion() " + ds.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return direccion;
    }

    @Override
    public void eliminaDireccion(Integer id) {
         try {
            EntityManager em = Conexion.createEntityManager();
            ds = new DireccionServiceImpl(em);
            ds.deleteDireccion(id);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en DireccionServiceImpl: " + e.getMessage() + "</p>";
            if (ds.getError() != null) {
                mensaje += "<p>" + "Error en DireccionEJBLocal -> eliminaDireccion() -> DireccionService -> deleteDireccion() " + ds.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
    }

    @Override
    public List<Direccion> getDireccionesPorIdAsentamiento(Integer idAsentamiento, Integer estatus_direccion) {
        List<Direccion> direcciones = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            ds = new DireccionServiceImpl(em);
            direcciones = ds.getDireccionesPorIdAsentamiento(idAsentamiento, estatus_direccion);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en DireccionService: " + e.getMessage() + "</p>";
            if (ds.getError() != null) {
                mensaje += "<p>" + "Error en DireccionEJBLocal -> getDirecciones() -> DireccionService -> getDireccionesPorIdAsentamiento() " + ds.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return direcciones;
    }

    @Override
    public void actualizaEstatusDireccion(Integer idDireccion, Integer estatus) {
        Direccion direccion = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            ds = new DireccionServiceImpl(em);
            direccion = ds.getDireccion(idDireccion);
            if (direccion != null) {
                direccion.setEstatus(estatus);
                ds.updateDireccion(direccion);
            }
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en DireccionServiceImpl: " + e.getMessage() + "</p>";

            if (ds.getError() != null) {
                mensaje += "<p>" + "Error en DireccionEJBLocal -> getDireccion() -> DireccionService -> getDireccion() " + ds.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
    }

    @Override
    public List<Direccion> getDireccionesPorCliente(Integer idCliente, Integer estatus_direccion) {
        List<Direccion> direcciones = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            ds = new DireccionServiceImpl(em);
            direcciones = ds.getDireccionesPorIdCliente(idCliente, estatus_direccion);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en DireccionService: " + e.getMessage() + "</p>";
            if (ds.getError() != null) {
                mensaje += "<p>" + "Error en DireccionEJBLocal -> getDireccionesPorIdCliente() -> DireccionService -> getDireccionesPorIdCliente() " + ds.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return direcciones;
    }

}
