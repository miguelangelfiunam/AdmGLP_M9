/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.Funciones.Funciones;
import mx.unam.dgtic.admglp.modelo.ArticuloServiceImpl;
import mx.unam.dgtic.admglp.vo.Articulo;

/**
 *
 * @author unam
 */
@Stateless
public class ArticuloEJBLocal implements ArticuloEJB {

    ArticuloServiceImpl es;

    @Override
    public List<Articulo> getArticulos() {
        List<Articulo> articulos = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new ArticuloServiceImpl(em);
            articulos = es.getArticulos();
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ArticuloService: " + e.getMessage() + "</p>";
            if (es.getError() != null) {
                mensaje += "<p>" + "Error en ArticuloEJBLocal -> getArticulos() -> ArticuloService -> getArticulos() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return articulos;
    }

    @Override
    public List<Articulo> getArticulosPorEstatus(Integer estatus) {
        List<Articulo> articulos = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new ArticuloServiceImpl(em);
            articulos = es.getArticulos(estatus);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ArticuloService: " + e.getMessage() + "</p>";
            if (es.getError() != null) {
                mensaje += "<p>" + "Error en ArticuloEJBLocal -> getArticulosPorEstatus() -> ArticuloService -> getArticulosPorEstatus() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return articulos;
    }

    @Override
    public Articulo getArticulo(Integer idArticulo) {
        Articulo articulo = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new ArticuloServiceImpl(em);
            articulo = es.getArticulo(idArticulo);

        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ArticuloServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en ArticuloEJBLocal -> getArticulo() -> ArticuloService -> getArticulo() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return articulo;
    }

    @Override
    public Boolean existeArticulo(Integer idArticulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Articulo insertaArticulo(Articulo articulo) {
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new ArticuloServiceImpl(em);
            articulo = es.insertArticulo(articulo);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ArticuloServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en ArticuloEJBLocal -> insertaArticulo() -> ArticuloService -> insertaArticulo() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return articulo;
    }

    @Override
    public Articulo actualizaArticulo(Articulo articulo) {
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new ArticuloServiceImpl(em);
            articulo = es.updateArticulo(articulo);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ArticuloServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en ArticuloEJBLocal -> insertaArticulo() -> ArticuloService -> actualizaArticulo() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return articulo;
    }

    @Override
    public void eliminaArticulo(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizaEstatusArticulo(Integer id, Integer estatus) {
        Articulo articulo = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new ArticuloServiceImpl(em);
            articulo = es.getArticulo(id);
            if (articulo != null) {
                articulo.setEstatus(estatus);
                es.updateArticulo(articulo);
            }
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ArticuloServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en ArticuloEJBLocal -> getArticulo() -> ArticuloService -> getArticulo() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
    }

}
