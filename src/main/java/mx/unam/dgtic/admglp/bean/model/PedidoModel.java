package mx.unam.dgtic.admglp.bean.model;

import jakarta.enterprise.inject.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.InitialContext;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.ejb.PedidoEJBLocal;
import mx.unam.dgtic.admglp.vo.Pedido;

/**
 * Modelo para metodos de pedidos
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/04/2022 - 26/04/2022
 *
 */
@Model
public class PedidoModel implements Serializable {

    private static final long serialVersionUID = -1000003;

    public List<Pedido> cargaPedidos() {
        List<Pedido> pedidos = null;
        PedidoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (PedidoEJBLocal) ctx.lookup("java:global/admglp/PedidoEJBLocal!mx.unam.dgtic.admglp.ejb.PedidoEJB");
            if (service != null) {
                pedidos = service.cargaPedidos();
            } else {
                pedidos = new ArrayList<Pedido>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return pedidos;
    }

    public List<Pedido> cargaPedidos(Integer status) {
        List<Pedido> pedidos = null;
        PedidoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (PedidoEJBLocal) ctx.lookup("java:global/admglp/PedidoEJBLocal!mx.unam.dgtic.admglp.ejb.PedidoEJB");
            if (service != null) {
                pedidos = service.cargaPedidos(status);
            } else {
                pedidos = new ArrayList<Pedido>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return pedidos;
    }

    public List<Pedido> cargaPedidosCriteria(Integer estatus, Integer idCliente,
            Integer idEmpleado, Integer idDireccion,
            Date f_ped_ini, Date f_ped_fin, Double total, List<Integer> listaEstatus) {
        List<Pedido> pedidos = null;
        PedidoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (PedidoEJBLocal) ctx.lookup("java:global/admglp/PedidoEJBLocal!mx.unam.dgtic.admglp.ejb.PedidoEJB");
            if (service != null) {
                pedidos = service.cargaPedidosCriteria(estatus, idCliente, idEmpleado, idDireccion, f_ped_ini, f_ped_fin, total, listaEstatus);
            } else {
                pedidos = new ArrayList<Pedido>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return pedidos;
    }

    public Pedido cargaPedido(Integer idPedido) {
        Pedido pedido = null;
        PedidoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (PedidoEJBLocal) ctx.lookup("java:global/admglp/PedidoEJBLocal!mx.unam.dgtic.admglp.ejb.PedidoEJB");
            if (service != null) {
                pedido = service.cargaPedido(idPedido);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return pedido;
    }

    public Pedido actualizaPedido(Pedido pedido) {
        PedidoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (PedidoEJBLocal) ctx.lookup("java:global/admglp/PedidoEJBLocal!mx.unam.dgtic.admglp.ejb.PedidoEJB");
            if (service != null) {
                pedido = service.actualizaPedido(pedido);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return pedido;
    }

    public void actualizaEstatusPedido(Integer idPed, Integer estatus) {
        PedidoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (PedidoEJBLocal) ctx.lookup("java:global/admglp/PedidoEJBLocal!mx.unam.dgtic.admglp.ejb.PedidoEJB");
            if (service != null) {
                service.actualizaEstatusPedido(idPed, estatus);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Pedido insertaPedido(Pedido pedido) {
        PedidoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (PedidoEJBLocal) ctx.lookup("java:global/admglp/PedidoEJBLocal!mx.unam.dgtic.admglp.ejb.PedidoEJB");
            if (service != null) {
                pedido = service.insertaPedido(pedido);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return pedido;
    }
}
