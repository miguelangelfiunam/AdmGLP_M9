package mx.unam.dgtic.admglp.bean.model;

import jakarta.enterprise.inject.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.ejb.TransporteEJBLocal;
import mx.unam.dgtic.admglp.vo.Transporte;
import mx.unam.dgtic.admglp.vo.TransporteMarca;

/**
 *
 * @author unam
 */
@Model
public class TransporteModel implements Serializable {

    private static final long serialVersionUID = -1000003;

    public List<Transporte> cargaTransportes() {
        List<Transporte> transportes = null;
        TransporteEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (TransporteEJBLocal) ctx.lookup("java:global/admglp/TransporteEJBLocal!mx.unam.dgtic.admglp.ejb.TransporteEJB");
            if (service != null) {
                transportes = service.getTransportes();
            } else {
                transportes = new ArrayList<Transporte>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return transportes;
    }
    
    public List<TransporteMarca> cargaMarcasTransportes() {
        List<TransporteMarca> marcas = null;
        TransporteEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (TransporteEJBLocal) ctx.lookup("java:global/admglp/TransporteEJBLocal!mx.unam.dgtic.admglp.ejb.TransporteEJB");
            if (service != null) {
                marcas = service.getMarcasTransportes();
            } else {
                marcas = new ArrayList<TransporteMarca>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return marcas;
    }

    public List<Transporte> cargaTransportes(Integer estatus) {
        List<Transporte> transportes = null;
        TransporteEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (TransporteEJBLocal) ctx.lookup("java:global/admglp/TransporteEJBLocal!mx.unam.dgtic.admglp.ejb.TransporteEJB");
            if (service != null) {
                transportes = service.getTransportesPorEstatus(estatus);
            } else {
                transportes = new ArrayList<Transporte>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return transportes;
    }

    public Transporte cargaTransporte(Integer idtransporte) {
        Transporte transporte = null;
        TransporteEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (TransporteEJBLocal) ctx.lookup("java:global/admglp/TransporteEJBLocal!mx.unam.dgtic.admglp.ejb.TransporteEJB");
            if (service != null) {
                transporte = service.getTransporte(idtransporte);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return transporte;
    }

    public Transporte actualizaTransporte(Transporte transporte) {
        TransporteEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (TransporteEJBLocal) ctx.lookup("java:global/admglp/TransporteEJBLocal!mx.unam.dgtic.admglp.ejb.TransporteEJB");
            if (service != null) {
                transporte = service.actualizaTransporte(transporte);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return transporte;
    }

    public void actualizaEstatusTransporte(Integer idEmp, Integer estatus) {
        TransporteEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (TransporteEJBLocal) ctx.lookup("java:global/admglp/TransporteEJBLocal!mx.unam.dgtic.admglp.ejb.TransporteEJB");
            if (service != null) {
                service.actualizaEstatusTransporte(idEmp, estatus);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Transporte insertaTransporte(Transporte transporte) {
        TransporteEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (TransporteEJBLocal) ctx.lookup("java:global/admglp/TransporteEJBLocal!mx.unam.dgtic.admglp.ejb.TransporteEJB");
            if (service != null) {
                transporte = service.insertaTransporte(transporte);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return transporte;
    }
}
