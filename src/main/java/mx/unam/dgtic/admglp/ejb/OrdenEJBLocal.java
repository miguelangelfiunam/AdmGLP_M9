package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.Funciones.Funciones;
import mx.unam.dgtic.admglp.modelo.OrdenServiceImpl;
import mx.unam.dgtic.admglp.vo.Orden;

/**
 *
 * @author unam
 */
@Stateless
public class OrdenEJBLocal implements OrdenEJB {

    OrdenServiceImpl es;

    @Override
    public List<Orden> getOrdenes() {
        List<Orden> ordenes = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new OrdenServiceImpl(em);
            ordenes = es.getOrdenes();
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en OrdenService: " + e.getMessage() + "</p>";
            if (es.getError() != null) {
                mensaje += "<p>" + "Error en OrdenEJBLocal -> getOrdenes() -> OrdenService -> getOrdenes() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return ordenes;
    }

    @Override
    public List<Orden> getOrdenesPorEstatus(Integer estatus) {
        List<Orden> ordenes = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new OrdenServiceImpl(em);
            ordenes = es.getOrdenes(estatus);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en OrdenService: " + e.getMessage() + "</p>";
            if (es.getError() != null) {
                mensaje += "<p>" + "Error en OrdenEJBLocal -> getOrdenesPorEstatus() -> OrdenService -> getOrdenes() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return ordenes;
    }

    @Override
    public Orden getOrden(Integer idOrden) {
        Orden orden = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new OrdenServiceImpl(em);
            orden = es.getOrden(idOrden);

        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en OrdenServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en OrdenEJBLocal -> getOrden() -> OrdenService -> getOrden() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return orden;
    }

    @Override
    public Boolean existeOrden(Integer idOrden) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Orden insertaOrden(Orden orden) {
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new OrdenServiceImpl(em);
            orden = es.insertOrden(orden);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en OrdenServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en OrdenEJBLocal -> insertaOrden() -> OrdenService -> insertaOrden() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return orden;
    }

    @Override
    public Orden actualizaOrden(Orden orden) {
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new OrdenServiceImpl(em);
            orden = es.updateOrden(orden);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en OrdenServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en OrdenEJBLocal -> insertaOrden() -> OrdenService -> insertaOrden() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return orden;
    }

    @Override
    public void eliminaOrden(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizaEstatusOrden(Integer id, Integer estatus) {
        Orden orden = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new OrdenServiceImpl(em);
            orden = es.getOrden(id);
            if (orden != null) {
                orden.setEstatus(estatus);
                es.updateOrden(orden);
            }
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en OrdenServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en OrdenEJBLocal -> getOrden() -> OrdenService -> getOrden() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
    }

    @Override
    public List<Orden> getOrdenesPorIdPedido(Integer idPedido, Integer estatus_orden) {
        List<Orden> ordenes = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new OrdenServiceImpl(em);
            ordenes = es.getOrdenesPorIdPedido(idPedido, estatus_orden);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en OrdenServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en OrdenEJBLocal -> getOrden() -> OrdenService -> getOrdenPorIdUsuario() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return ordenes;
    }

}
