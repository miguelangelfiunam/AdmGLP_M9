/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Clases/Clas.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.Funciones.Funciones;
import mx.unam.dgtic.admglp.modelo.EstatusServiceImpl;
import mx.unam.dgtic.admglp.vo.Estatus;

/**
 *
 * @author unam
 */
@Stateless
public class EstatusEJBLocal implements EstatusEJB {

    EstatusServiceImpl es;

    @Override
    public List<Estatus> getEstatusLista() {
        List<Estatus> estatus = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new EstatusServiceImpl(em);
            estatus = es.getEstatusLista();
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en EstatusService: " + e.getMessage() + "</p>";
            if (es.getError() != null) {
                mensaje += "<p>" + "Error en EstatusEJBLocal -> getEstatusLista() -> EstatusService -> getEstatusLista() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return estatus;
    }

    @Override
    public List<Estatus> getEstatusListaPorActivo(Integer activo) {
        List<Estatus> estatus = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new EstatusServiceImpl(em);
            estatus = es.getEstatusLista(activo);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en EstatusService: " + e.getMessage() + "</p>";
            if (es.getError() != null) {
                mensaje += "<p>" + "Error en EstatusEJBLocal -> getEstatusListaPorActivo() -> EstatusService -> getEstatusLista() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return estatus;
    }

    @Override
    public List<Estatus> getEstatusLista(String tabla, Integer activo) {
        List<Estatus> estatus = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new EstatusServiceImpl(em);
            estatus = es.getEstatusLista(tabla, activo);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en EstatusService: " + e.getMessage() + "</p>";
            if (es.getError() != null) {
                mensaje += "<p>" + "Error en EstatusEJBLocal -> getEstatusLista() -> EstatusService -> getEstatusLista() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return estatus;
    }

    @Override
    public Estatus getEstatusObjeto(Integer idEstatus) {
        Estatus estatus = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new EstatusServiceImpl(em);
            estatus = es.getEstatusObjeto(idEstatus);

        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en EstatusServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en EstatusEJBLocal -> getEstatusObjeto() -> EstatusService -> getEstatusObjeto() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return estatus;
    }

    @Override
    public Boolean existeEstatusObjeto(Integer idEstatus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estatus insertaEstatusObjeto(Estatus estatus) {
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new EstatusServiceImpl(em);
            estatus = es.insertEstatusObjeto(estatus);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en EstatusServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en EstatusEJBLocal -> insertaEstatusObjeto() -> EstatusService -> insertEstatusObjeto() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return estatus;
    }

    @Override
    public Estatus actualizaEstatusObjeto(Estatus estatus) {
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new EstatusServiceImpl(em);
            estatus = es.updateEstatusObjeto(estatus);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en EstatusServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en EstatusEJBLocal -> actualizaEstatusObjeto() -> EstatusService -> updateEstatusObjeto() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return estatus;
    }

    @Override
    public void eliminaEstatusObjeto(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizaActivoEstatus(Integer id, Integer activo) {
        Estatus estatus = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new EstatusServiceImpl(em);
            estatus = es.getEstatusObjeto(id);
            if (estatus != null) {
                estatus.setActivo(activo);
                es.updateEstatusObjeto(estatus);
            }
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en EstatusServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en EstatusEJBLocal -> actualizaActivoEstatus() -> EstatusService -> updateEstatusObjeto() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
    }

}
