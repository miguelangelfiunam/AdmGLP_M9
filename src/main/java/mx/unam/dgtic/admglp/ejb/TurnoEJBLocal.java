/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.Funciones.Funciones;
import mx.unam.dgtic.admglp.modelo.TurnoServiceImpl;
import mx.unam.dgtic.admglp.vo.Turno;

/**
 *
 * @author unam
 */
@Stateless
public class TurnoEJBLocal implements TurnoEJB {

    TurnoServiceImpl ts;

    @Override
    public List<Turno> getTurnos() {
        List<Turno> turnos = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            ts = new TurnoServiceImpl(em);
            turnos = ts.getTurnos();
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en TurnoService: " + e.getMessage() + "</p>";
            if (ts.getError() != null) {
                mensaje += "<p>" + "Error en TurnoEJBLocal -> getTurnos() -> TurnoService -> getTurnos() " + ts.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return turnos;
    }

    @Override
    public Turno getTurnoActual(Date inicio_turno) {
        Turno turno = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            ts = new TurnoServiceImpl(em);
            turno = ts.getTurnoActual(inicio_turno);

        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en TurnoServiceImpl: " + e.getMessage() + "</p>";

            if (ts.getError() != null) {
                mensaje += "<p>" + "Error en TurnoEJBLocal -> getTurnoActual() -> TurnoService -> getTurnoActual() " + ts.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return turno;
    }

    @Override
    public List<Turno> getTurnosPorEstatus(Integer estatus) {
        List<Turno> turnos = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            ts = new TurnoServiceImpl(em);
            turnos = ts.getTurnos(estatus);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en TurnoService: " + e.getMessage() + "</p>";
            if (ts.getError() != null) {
                mensaje += "<p>" + "Error en TurnoEJBLocal -> getTurnos() -> TurnoService -> getTurnos() " + ts.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return turnos;
    }

    @Override
    public Turno getTurno(Integer idTurno) {
        Turno turno = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            ts = new TurnoServiceImpl(em);
            turno = ts.getTurno(idTurno);

        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en TurnoServiceImpl: " + e.getMessage() + "</p>";

            if (ts.getError() != null) {
                mensaje += "<p>" + "Error en TurnoEJBLocal -> getTurnoActual() -> TurnoService -> getTurnoActual() " + ts.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return turno;
    }

    @Override
    public Turno insertaTurno(Turno turno) {
        try {
            EntityManager em = Conexion.createEntityManager();
            ts = new TurnoServiceImpl(em);
            turno = ts.insertTurno(turno);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en TurnoServiceImpl: " + e.getMessage() + "</p>";

            if (ts.getError() != null) {
                mensaje += "<p>" + "Error en TurnoEJBLocal -> insertaTurno() -> TurnoService -> insertaTurno() " + ts.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return turno;
    }

    @Override
    public Turno actualizaTurno(Turno turno) {
        try {
            EntityManager em = Conexion.createEntityManager();
            ts = new TurnoServiceImpl(em);
            turno = ts.updateTurno(turno);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en TurnoServiceImpl: " + e.getMessage() + "</p>";

            if (ts.getError() != null) {
                mensaje += "<p>" + "Error en TurnoEJBLocal -> actualizaTurno() -> TurnoService -> updateTurno() " + ts.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return turno;
    }

    @Override
    public void actualizaEstatusTurno(Integer id, Integer estatus) {
        Turno usuario = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            ts = new TurnoServiceImpl(em);
            usuario = ts.getTurno(id);
            if (usuario != null) {
                usuario.setEstatus(estatus);
                ts.updateTurno(usuario);
            }
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en TurnoServiceImpl: " + e.getMessage() + "</p>";

            if (ts.getError() != null) {
                mensaje += "<p>" + "Error en TurnoEJBLocal -> getTurno() -> TurnoService -> getTurno() " + ts.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
    }

    @Override
    public Turno eliminaTurno(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
