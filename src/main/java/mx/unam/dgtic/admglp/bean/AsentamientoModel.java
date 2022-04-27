/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.bean;

import jakarta.enterprise.inject.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.ejb.AsentamientoEJBLocal;
import mx.unam.dgtic.admglp.vo.Asentamiento;

/**
 *
 * @author unam
 */
@Model
public class AsentamientoModel implements Serializable {

    private static final long serialVersionUID = -1000003;

    public List<Asentamiento> cargaAsentamientos() {
        List<Asentamiento> asentamientos = null;
        AsentamientoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (AsentamientoEJBLocal) ctx.lookup("java:global/admglp/AsentamientoEJBLocal!mx.unam.dgtic.admglp.ejb.AsentamientoEJB");
            if (service != null) {
                asentamientos = service.getAsentamientos();
            } else {
                asentamientos = new ArrayList<Asentamiento>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return asentamientos;
    }
    
    public List<Asentamiento> cargaAsentamientosPorIdMunicipio(Integer idMunicipio, Integer estatus_asentamiento) {
        List<Asentamiento> asentamientos = null;
        AsentamientoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (AsentamientoEJBLocal) ctx.lookup("java:global/admglp/AsentamientoEJBLocal!mx.unam.dgtic.admglp.ejb.AsentamientoEJB");
            if (service != null) {
                asentamientos = service.getAsentamientosPorIdMunicipio(idMunicipio, estatus_asentamiento);
            } else {
                asentamientos = new ArrayList<Asentamiento>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return asentamientos;
    }

    public Asentamiento cargaAsentamiento(Integer idasentamiento) {
        Asentamiento asentamiento = null;
        AsentamientoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (AsentamientoEJBLocal) ctx.lookup("java:global/admglp/AsentamientoEJBLocal!mx.unam.dgtic.admglp.ejb.AsentamientoEJB");
            if (service != null) {
                asentamiento = service.getAsentamiento(idasentamiento);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return asentamiento;
    }

    public Asentamiento actualizaAsentamiento(Asentamiento asentamiento) {
        AsentamientoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (AsentamientoEJBLocal) ctx.lookup("java:global/admglp/AsentamientoEJBLocal!mx.unam.dgtic.admglp.ejb.AsentamientoEJB");
            if (service != null) {
                asentamiento = service.actualizaAsentamiento(asentamiento);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return asentamiento;
    }

    public void actualizaEstatusAsentamiento(Integer idEmp, Integer estatus) {
        AsentamientoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (AsentamientoEJBLocal) ctx.lookup("java:global/admglp/AsentamientoEJBLocal!mx.unam.dgtic.admglp.ejb.AsentamientoEJB");
            if (service != null) {
                service.actualizaEstatusAsentamiento(idEmp, estatus);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Asentamiento insertaAsentamiento(Asentamiento asentamiento) {
        AsentamientoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (AsentamientoEJBLocal) ctx.lookup("java:global/admglp/AsentamientoEJBLocal!mx.unam.dgtic.admglp.ejb.AsentamientoEJB");
            if (service != null) {
                asentamiento = service.insertaAsentamiento(asentamiento);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return asentamiento;
    }

    public List<Asentamiento> cargaAsentamientoPorIdAsentamiento(Integer idMunicipio, Integer estatus_asentamiento) {
        List<Asentamiento> asentamientos = null;
        AsentamientoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (AsentamientoEJBLocal) ctx.lookup("java:global/admglp/AsentamientoEJBLocal!mx.unam.dgtic.admglp.ejb.AsentamientoEJB");
            if (service != null) {
                asentamientos = service.getAsentamientosPorIdMunicipio(idMunicipio, estatus_asentamiento);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return asentamientos;
    }
}
