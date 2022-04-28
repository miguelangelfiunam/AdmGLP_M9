package mx.unam.dgtic.admglp.bean.model;

import jakarta.enterprise.inject.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.ejb.OrdenEJBLocal;
import mx.unam.dgtic.admglp.vo.Orden;

/**
 * Modelo para metodos de ordenes
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/04/2022 - 26/04/2022
 *
 */
@Model
public class OrdenModel implements Serializable {

    private static final long serialVersionUID = -1000003;

    public List<Orden> cargaOrdenes() {
        List<Orden> ordenes = null;
        OrdenEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (OrdenEJBLocal) ctx.lookup("java:global/admglp/OrdenEJBLocal!mx.unam.dgtic.admglp.ejb.OrdenEJB");
            if (service != null) {
                ordenes = service.getOrdenes();
            } else {
                ordenes = new ArrayList<Orden>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ordenes;
    }

    public List<Orden> cargaOrdenesPorIdEstatus(Integer estatus_orden) {
        List<Orden> ordenes = null;
        OrdenEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (OrdenEJBLocal) ctx.lookup("java:global/admglp/OrdenEJBLocal!mx.unam.dgtic.admglp.ejb.OrdenEJB");
            if (service != null) {
                ordenes = service.getOrdenesPorEstatus(estatus_orden);
            } else {
                ordenes = new ArrayList<Orden>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ordenes;
    }

    public Orden cargaOrden(Integer idorden) {
        Orden orden = null;
        OrdenEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (OrdenEJBLocal) ctx.lookup("java:global/admglp/OrdenEJBLocal!mx.unam.dgtic.admglp.ejb.OrdenEJB");
            if (service != null) {
                orden = service.getOrden(idorden);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return orden;
    }

    public List<Orden> cargaOrdenesPorIdPedido(Integer idPedido, Integer estatus_orden) {
        List<Orden> ordenes = null;
        OrdenEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (OrdenEJBLocal) ctx.lookup("java:global/admglp/OrdenEJBLocal!mx.unam.dgtic.admglp.ejb.OrdenEJB");
            if (service != null) {
                ordenes = service.getOrdenesPorIdPedido(idPedido, estatus_orden);
            } else {
                ordenes = new ArrayList<Orden>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ordenes;
    }

    public Orden insertaOrden(Orden orden) {
        OrdenEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (OrdenEJBLocal) ctx.lookup("java:global/admglp/OrdenEJBLocal!mx.unam.dgtic.admglp.ejb.OrdenEJB");
            if (service != null) {
                orden = service.insertaOrden(orden);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return orden;
    }

    public Orden actualizaOrden(Orden orden) {
        OrdenEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (OrdenEJBLocal) ctx.lookup("java:global/admglp/OrdenEJBLocal!mx.unam.dgtic.admglp.ejb.OrdenEJB");
            if (service != null) {
                orden = service.actualizaOrden(orden);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return orden;
    }

    public void actualizaEstatusOrden(Integer idEmp, Integer estatus) {
        OrdenEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (OrdenEJBLocal) ctx.lookup("java:global/admglp/OrdenEJBLocal!mx.unam.dgtic.admglp.ejb.OrdenEJB");
            if (service != null) {
                service.actualizaEstatusOrden(idEmp, estatus);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
