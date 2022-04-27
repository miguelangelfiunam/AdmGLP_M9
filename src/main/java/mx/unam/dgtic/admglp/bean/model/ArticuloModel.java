package mx.unam.dgtic.admglp.bean.model;

import jakarta.enterprise.inject.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.ejb.ArticuloEJBLocal;
import mx.unam.dgtic.admglp.vo.Articulo;

/**
 *
 * @author unam
 */
@Model
public class ArticuloModel implements Serializable {

    private static final long serialVersionUID = -1000003;

    public List<Articulo> cargaArticulos() {
        List<Articulo> articulos = null;
        ArticuloEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ArticuloEJBLocal) ctx.lookup("java:global/admglp/ArticuloEJBLocal!mx.unam.dgtic.admglp.ejb.ArticuloEJB");
            if (service != null) {
                articulos = service.getArticulos();
            } else {
                articulos = new ArrayList<Articulo>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return articulos;
    }

    public List<Articulo> cargaArticulos(Integer estatus) {
        List<Articulo> articulos = null;
        ArticuloEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ArticuloEJBLocal) ctx.lookup("java:global/admglp/ArticuloEJBLocal!mx.unam.dgtic.admglp.ejb.ArticuloEJB");
            if (service != null) {
                articulos = service.getArticulosPorEstatus(estatus);
            } else {
                articulos = new ArrayList<Articulo>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return articulos;
    }

    public Articulo cargaArticulo(Integer idarticulo) {
        Articulo articulo = null;
        ArticuloEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ArticuloEJBLocal) ctx.lookup("java:global/admglp/ArticuloEJBLocal!mx.unam.dgtic.admglp.ejb.ArticuloEJB");
            if (service != null) {
                articulo = service.getArticulo(idarticulo);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return articulo;
    }

    public Articulo actualizaArticulo(Articulo articulo) {
        ArticuloEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ArticuloEJBLocal) ctx.lookup("java:global/admglp/ArticuloEJBLocal!mx.unam.dgtic.admglp.ejb.ArticuloEJB");
            if (service != null) {
                articulo = service.actualizaArticulo(articulo);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return articulo;
    }

    public void actualizaEstatusArticulo(Integer idEmp, Integer estatus) {
        ArticuloEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ArticuloEJBLocal) ctx.lookup("java:global/admglp/ArticuloEJBLocal!mx.unam.dgtic.admglp.ejb.ArticuloEJB");
            if (service != null) {
                service.actualizaEstatusArticulo(idEmp, estatus);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Articulo insertaArticulo(Articulo articulo) {
        ArticuloEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ArticuloEJBLocal) ctx.lookup("java:global/admglp/ArticuloEJBLocal!mx.unam.dgtic.admglp.ejb.ArticuloEJB");
            if (service != null) {
                articulo = service.insertaArticulo(articulo);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return articulo;
    }
}
