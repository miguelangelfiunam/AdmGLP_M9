package mx.unam.dgtic.admglp.bean.model;

import jakarta.enterprise.inject.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.ejb.EstadoEJBLocal;
import mx.unam.dgtic.admglp.vo.Estado;

/**
 * Modelo para metodos de estados
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/04/2022 - 26/04/2022
 *
 */
@Model
public class EstadoModel implements Serializable {

    private static final long serialVersionUID = -1000003;

    public List<Estado> cargaEstados() {
        List<Estado> estados = null;
        EstadoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (EstadoEJBLocal) ctx.lookup("java:global/admglp/EstadoEJBLocal!mx.unam.dgtic.admglp.ejb.EstadoEJB");
            if (service != null) {
                estados = service.getEstados();
            } else {
                estados = new ArrayList<Estado>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return estados;
    }
    
    public List<Estado> cargaEstados(Integer estatus) {
        List<Estado> estados = null;
        EstadoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (EstadoEJBLocal) ctx.lookup("java:global/admglp/EstadoEJBLocal!mx.unam.dgtic.admglp.ejb.EstadoEJB");
            if (service != null) {
                estados = service.getEstadosPorEstatus(estatus);
            } else {
                estados = new ArrayList<Estado>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return estados;
    }

    public Estado cargaEstado(Integer idestado) {
        Estado estado = null;
        EstadoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (EstadoEJBLocal) ctx.lookup("java:global/admglp/EstadoEJBLocal!mx.unam.dgtic.admglp.ejb.EstadoEJB");
            if (service != null) {
                estado = service.getEstado(idestado);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return estado;
    }

    public Estado actualizaEstado(Estado estado) {
        EstadoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (EstadoEJBLocal) ctx.lookup("java:global/admglp/EstadoEJBLocal!mx.unam.dgtic.admglp.ejb.EstadoEJB");
            if (service != null) {
                estado = service.actualizaEstado(estado);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return estado;
    }

    public void actualizaEstatusEstado(Integer idEmp, Integer estatus) {
        EstadoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (EstadoEJBLocal) ctx.lookup("java:global/admglp/EstadoEJBLocal!mx.unam.dgtic.admglp.ejb.EstadoEJB");
            if (service != null) {
                service.actualizaEstatusEstado(idEmp, estatus);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Estado insertaEstado(Estado estado) {
        EstadoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (EstadoEJBLocal) ctx.lookup("java:global/admglp/EstadoEJBLocal!mx.unam.dgtic.admglp.ejb.EstadoEJB");
            if (service != null) {
                estado = service.insertaEstado(estado);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return estado;
    }
}
