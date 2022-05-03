package mx.unam.dgtic.admglp.bean.model;

import jakarta.enterprise.inject.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.ejb.EstatusEJBLocal;
import mx.unam.dgtic.admglp.vo.Estatus;

/**
 * Modelo para metodos de estatus
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/04/2022 - 26/04/2022
 *
 */
@Model
public class EstatusModel implements Serializable {

    private static final long serialVersionUID = -1000003;

    public List<Estatus> cargaEstatus() {
        List<Estatus> estatus = null;
        EstatusEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (EstatusEJBLocal) ctx.lookup("java:global/admglp/EstatusEJBLocal!mx.unam.dgtic.admglp.ejb.EstatusEJB");
            if (service != null) {
                estatus = service.getEstatusLista();
            } else {
                estatus = new ArrayList<Estatus>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return estatus;
    }
    
     public Estatus cargaEstatus(String tabla, Integer numEstatus, Integer activo) {
        Estatus estatus = null;
        EstatusEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (EstatusEJBLocal) ctx.lookup("java:global/admglp/EstatusEJBLocal!mx.unam.dgtic.admglp.ejb.EstatusEJB");
            if (service != null) {
                estatus = service.getEstatusObjeto(tabla, numEstatus, activo);
            } 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return estatus;
    }

    public List<Estatus> cargaEstatusPorTabla(String tabla, Integer activo) {
        List<Estatus> estatus = null;
        EstatusEJBLocal service = null;
        String tablaBD = null;
        try {
            switch (tabla) {
            case "Usuarios":
                tablaBD = "t_usuario";
                break;
            case "Roles":
                tablaBD = "c_rol";
                break;
            case "Empleados":
                tablaBD = "c_empleado";
                break;
            case "Clientes":
                tablaBD = "c_cliente";
                break;
            case "Articulos":
                tablaBD = "c_articulo";
                break;
            case "Transportes":
                tablaBD = "c_transporte";
                break;
            case "Accesos":
                tablaBD = "t_acceso";
                break;
            case "Turnos":
                tablaBD = "t_turno";
                break;
            case "Contras":
                tablaBD = "t_contra";
                break;
            case "Pedidos":
                tablaBD = "t_pedido";
                break;
            default:
                tablaBD = null;
                break;
        }
            InitialContext ctx = Conexion.createInitialContext();
            service = (EstatusEJBLocal) ctx.lookup("java:global/admglp/EstatusEJBLocal!mx.unam.dgtic.admglp.ejb.EstatusEJB");
            if (service != null) {
                estatus = service.getEstatusLista(tablaBD, activo);
            } else {
                estatus = new ArrayList<Estatus>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return estatus;
    }

    public List<Estatus> cargaEstatusPorActivo(Integer activo) {
        List<Estatus> estatus = null;
        EstatusEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (EstatusEJBLocal) ctx.lookup("java:global/admglp/EstatusEJBLocal!mx.unam.dgtic.admglp.ejb.EstatusEJB");
            if (service != null) {
                estatus = service.getEstatusListaPorActivo(activo);
            } else {
                estatus = new ArrayList<Estatus>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return estatus;
    }

    public Estatus cargaEstatus(Integer idEstatus) {
        Estatus estatus = null;
        EstatusEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (EstatusEJBLocal) ctx.lookup("java:global/admglp/EstatusEJBLocal!mx.unam.dgtic.admglp.ejb.EstatusEJB");
            if (service != null) {
                estatus = service.getEstatusObjeto(idEstatus);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return estatus;
    }

    public Estatus actualizaEstatus(Estatus estatus) {
        EstatusEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (EstatusEJBLocal) ctx.lookup("java:global/admglp/EstatusEJBLocal!mx.unam.dgtic.admglp.ejb.EstatusEJB");
            if (service != null) {
                estatus = service.actualizaEstatusObjeto(estatus);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return estatus;
    }

    public void actualizaActivoEstatus(Integer idEmp, Integer activo) {
        EstatusEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (EstatusEJBLocal) ctx.lookup("java:global/admglp/EstatusEJBLocal!mx.unam.dgtic.admglp.ejb.EstatusEJB");
            if (service != null) {
                service.actualizaActivoEstatus(idEmp, activo);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Estatus insertaEstatus(Estatus estatus) {
        EstatusEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (EstatusEJBLocal) ctx.lookup("java:global/admglp/EstatusEJBLocal!mx.unam.dgtic.admglp.ejb.EstatusEJB");
            if (service != null) {
                estatus = service.insertaEstatusObjeto(estatus);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return estatus;
    }
}
