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
import mx.unam.dgtic.admglp.ejb.DireccionEJBLocal;
import mx.unam.dgtic.admglp.vo.Direccion;

/**
 *
 * @author unam
 */
@Model
public class DireccionModel implements Serializable {

    private static final long serialVersionUID = -1000003;

    public List<Direccion> cargaDirecciones() {
        List<Direccion> direccions = null;
        DireccionEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (DireccionEJBLocal) ctx.lookup("java:global/admglp/DireccionEJBLocal!mx.unam.dgtic.admglp.ejb.DireccionEJB");
            if (service != null) {
                direccions = service.getDirecciones();
            } else {
                direccions = new ArrayList<Direccion>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return direccions;
    }

    public Direccion cargaDireccion(Integer iddireccion) {
        Direccion direccion = null;
        DireccionEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (DireccionEJBLocal) ctx.lookup("java:global/admglp/DireccionEJBLocal!mx.unam.dgtic.admglp.ejb.DireccionEJB");
            if (service != null) {
                direccion = service.getDireccion(iddireccion);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return direccion;
    }

    public Direccion actualizaDireccion(Direccion direccion) {
        DireccionEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (DireccionEJBLocal) ctx.lookup("java:global/admglp/DireccionEJBLocal!mx.unam.dgtic.admglp.ejb.DireccionEJB");
            if (service != null) {
                direccion = service.actualizaDireccion(direccion);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return direccion;
    }

    public void actualizaEstatusDireccion(Integer idDir, Integer estatus) {
        DireccionEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (DireccionEJBLocal) ctx.lookup("java:global/admglp/DireccionEJBLocal!mx.unam.dgtic.admglp.ejb.DireccionEJB");
            if (service != null) {
                service.actualizaEstatusDireccion(idDir, estatus);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Direccion insertaDireccion(Direccion direccion) {
        DireccionEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (DireccionEJBLocal) ctx.lookup("java:global/admglp/DireccionEJBLocal!mx.unam.dgtic.admglp.ejb.DireccionEJB");
            if (service != null) {
                direccion = service.insertaDireccion(direccion);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return direccion;
    }

    public List<Direccion> cargaDireccionPorIdEstado(Integer idAsentamiento, Integer estatus_direccion) {
        List<Direccion> direccions = null;
        DireccionEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (DireccionEJBLocal) ctx.lookup("java:global/admglp/DireccionEJBLocal!mx.unam.dgtic.admglp.ejb.DireccionEJB");
            if (service != null) {
                direccions = service.getDireccionesPorIdAsentamiento(idAsentamiento, estatus_direccion);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return direccions;
    }
}
