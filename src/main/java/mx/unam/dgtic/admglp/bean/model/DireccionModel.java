package mx.unam.dgtic.admglp.bean.model;

import jakarta.enterprise.inject.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.ejb.DireccionEJBLocal;
import mx.unam.dgtic.admglp.vo.Direccion;

/**
 * Modelo para metodos de direcciones
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/04/2022 - 26/04/2022
 *
 */
@Model
public class DireccionModel implements Serializable {

    private static final long serialVersionUID = -1000003;

    public List<Direccion> cargaDirecciones() {
        List<Direccion> direcciones = null;
        DireccionEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (DireccionEJBLocal) ctx.lookup("java:global/admglp/DireccionEJBLocal!mx.unam.dgtic.admglp.ejb.DireccionEJB");
            if (service != null) {
                direcciones = service.getDirecciones();
            } else {
                direcciones = new ArrayList<Direccion>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return direcciones;
    }
    
    public List<Direccion> cargaDirecciones(Integer estatus) {
        List<Direccion> direcciones = null;
        DireccionEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (DireccionEJBLocal) ctx.lookup("java:global/admglp/DireccionEJBLocal!mx.unam.dgtic.admglp.ejb.DireccionEJB");
            if (service != null) {
                direcciones = service.getDireccionesPorEstatus(estatus);
            } else {
                direcciones = new ArrayList<Direccion>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return direcciones;
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

    public List<Direccion> cargaDireccionesPorIdCliente(Integer idcliente, Integer estatus_direccion) {
        List<Direccion> direcciones = null;
        DireccionEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (DireccionEJBLocal) ctx.lookup("java:global/admglp/DireccionEJBLocal!mx.unam.dgtic.admglp.ejb.DireccionEJB");
            if (service != null) {
                direcciones = service.getDireccionesPorCliente(idcliente, estatus_direccion);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return direcciones;
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
        List<Direccion> direcciones = null;
        DireccionEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (DireccionEJBLocal) ctx.lookup("java:global/admglp/DireccionEJBLocal!mx.unam.dgtic.admglp.ejb.DireccionEJB");
            if (service != null) {
                direcciones = service.getDireccionesPorIdAsentamiento(idAsentamiento, estatus_direccion);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return direcciones;
    }
}
