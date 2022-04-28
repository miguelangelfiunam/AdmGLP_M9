package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.Funciones.Funciones;
import mx.unam.dgtic.admglp.modelo.PedidoServiceImpl;
import mx.unam.dgtic.admglp.vo.Pedido;

/**
 *
 * @author unam
 */
@Stateless
public class PedidoEJBLocal implements PedidoEJB {

    PedidoServiceImpl ps;

    @Override
    public List<Pedido> cargaPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            ps = new PedidoServiceImpl(em);
            pedidos = ps.getPedidos();
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en PedidoService: " + e.getMessage() + "</p>";
            if (ps.getError() != null) {
                mensaje += "<p>" + "Error en PedidoEJBLocal -> getPedidos() -> PedidoService -> getPedidos() " + ps.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return pedidos;
    }

    @Override
    public List<Pedido> cargaPedidos(Integer estatus) {
        List<Pedido> pedidos = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            ps = new PedidoServiceImpl(em);
            pedidos = ps.getPedidos(estatus);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en PedidoService: " + e.getMessage() + "</p>";
            if (ps.getError() != null) {
                mensaje += "<p>" + "Error en PedidoEJBLocal -> getPedidos() -> PedidoService -> getPedidos() " + ps.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return pedidos;
    }

    @Override
    public List<Pedido> cargaPedidosCriteria(Integer estatus, Integer idCliente, Integer idEmpleado, Integer idDireccion, Date f_ped_ini, Date f_ped_fin, Double total) {
        List<Pedido> pedidos = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            ps = new PedidoServiceImpl(em);
            pedidos = ps.getPedidosCriteria(estatus, idCliente, idEmpleado, idDireccion, f_ped_ini, f_ped_fin, total);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en PedidoService: " + e.getMessage() + "</p>";
            if (ps.getError() != null) {
                mensaje += "<p>" + "Error en PedidoEJBLocal -> getPedidos() -> PedidoService -> getPedidos() " + ps.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return pedidos;
    }

    @Override
    public Pedido actualizaPedido(Pedido pedido) {
        try {
            EntityManager em = Conexion.createEntityManager();
            ps = new PedidoServiceImpl(em);
            pedido = ps.updatePedido(pedido);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en PedidoServiceImpl: " + e.getMessage() + "</p>";

            if (ps.getError() != null) {
                mensaje += "<p>" + "Error en PedidoEJBLocal -> insertaPedido() -> PedidoService -> insertaPedido() " + ps.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return pedido;
    }

    @Override
    public Pedido actualizaEstatusPedido(Integer idPedido, Integer estatus) {
        Pedido pedido = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            ps = new PedidoServiceImpl(em);
            pedido = ps.getPedido(idPedido);
            if (pedido != null) {
                pedido.setEstatus(estatus);
                ps.updatePedido(pedido);
            }
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en PedidoServiceImpl: " + e.getMessage() + "</p>";

            if (ps.getError() != null) {
                mensaje += "<p>" + "Error en PedidoEJBLocal -> getPedido() -> PedidoService -> getPedido() " + ps.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return pedido;
    }

    @Override
    public Pedido insertaPedido(Pedido pedido) {
        try {
            EntityManager em = Conexion.createEntityManager();
            ps = new PedidoServiceImpl(em);
            pedido = ps.insertPedido(pedido);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en PedidoServiceImpl: " + e.getMessage() + "</p>";

            if (ps.getError() != null) {
                mensaje += "<p>" + "Error en PedidoEJBLocal -> insertaPedido() -> PedidoService -> insertaPedido() " + ps.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return pedido;
    }

    @Override
    public Pedido cargaPedido(Integer idPedido) {
        Pedido pedido = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            ps = new PedidoServiceImpl(em);
            pedido = ps.getPedido(idPedido);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en PedidoServiceImpl: " + e.getMessage() + "</p>";

            if (ps.getError() != null) {
                mensaje += "<p>" + "Error en PedidoEJBLocal -> getPedido() -> PedidoService -> getPedido() " + ps.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return pedido;
    }

    @Override
    public Pedido eliminaPedido(Integer idPedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
