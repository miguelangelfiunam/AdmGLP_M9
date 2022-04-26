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
import mx.unam.dgtic.admglp.modelo.EstadoServiceImpl;
import mx.unam.dgtic.admglp.vo.Estado;

/**
 *
 * @author unam
 */
@Stateless
public class EstadoEJBLocal implements EstadoEJB {

    EstadoServiceImpl es;

    @Override
    public List<Estado> getEstados() {
        List<Estado> estados = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new EstadoServiceImpl(em);
            estados = es.getEstados();
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en EstadoService: " + e.getMessage() + "</p>";
            if (es.getError() != null) {
                mensaje += "<p>" + "Error en EstadoEJBLocal -> getEstados() -> EstadoService -> getEstados() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return estados;
    }

    @Override
    public List<Estado> getEstadosPorEstatus(Integer estatus) {
        List<Estado> estados = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new EstadoServiceImpl(em);
            estados = es.getEstados(estatus);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en EstadoService: " + e.getMessage() + "</p>";
            if (es.getError() != null) {
                mensaje += "<p>" + "Error en EstadoEJBLocal -> getEstadosPorEstatus() -> EstadoService -> getEstados() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return estados;
    }

    @Override
    public Estado getEstado(Integer idEstado) {
        Estado estado = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new EstadoServiceImpl(em);
            estado = es.getEstado(idEstado);

        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en EstadoServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en EstadoEJBLocal -> getEstado() -> EstadoService -> getEstado() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return estado;
    }

    @Override
    public Boolean existeEstado(Integer idEstado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estado insertaEstado(Estado estado) {
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new EstadoServiceImpl(em);
            estado = es.insertEstado(estado);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en EstadoServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en EstadoEJBLocal -> insertaEstado() -> EstadoService -> insertaEstado() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return estado;
    }

    @Override
    public Estado actualizaEstado(Estado estado) {
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new EstadoServiceImpl(em);
            estado = es.updateEstado(estado);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en EstadoServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en EstadoEJBLocal -> insertaEstado() -> EstadoService -> insertaEstado() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return estado;
    }

    @Override
    public void eliminaEstado(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizaEstatusEstado(Integer id, Integer estatus) {
        Estado estado = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new EstadoServiceImpl(em);
            estado = es.getEstado(id);
            if (estado != null) {
                estado.setEstatus(estatus);
                es.updateEstado(estado);
            }
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en EstadoServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en EstadoEJBLocal -> getEstado() -> EstadoService -> getEstado() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
    }

}
