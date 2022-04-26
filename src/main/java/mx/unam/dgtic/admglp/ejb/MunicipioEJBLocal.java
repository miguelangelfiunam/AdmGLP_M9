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
import mx.unam.dgtic.admglp.modelo.MunicipioServiceImpl;
import mx.unam.dgtic.admglp.vo.Municipio;

/**
 *
 * @author unam
 */
@Stateless
public class MunicipioEJBLocal implements MunicipioEJB {

    MunicipioServiceImpl es;

    @Override
    public List<Municipio> getMunicipios() {
        List<Municipio> municipios = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new MunicipioServiceImpl(em);
            municipios = es.getMunicipios();
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en MunicipioService: " + e.getMessage() + "</p>";
            if (es.getError() != null) {
                mensaje += "<p>" + "Error en MunicipioEJBLocal -> getMunicipios() -> MunicipioService -> getMunicipios() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return municipios;
    }

    @Override
    public List<Municipio> getMunicipiosPorEstatus(Integer estatus) {
        List<Municipio> municipios = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new MunicipioServiceImpl(em);
            municipios = es.getMunicipios(estatus);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en MunicipioService: " + e.getMessage() + "</p>";
            if (es.getError() != null) {
                mensaje += "<p>" + "Error en MunicipioEJBLocal -> getMunicipiosPorEstatus() -> MunicipioService -> getMunicipios() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return municipios;
    }

    @Override
    public Municipio getMunicipio(Integer idMunicipio) {
        Municipio municipio = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new MunicipioServiceImpl(em);
            municipio = es.getMunicipio(idMunicipio);

        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en MunicipioServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en MunicipioEJBLocal -> getMunicipio() -> MunicipioService -> getMunicipio() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return municipio;
    }

    @Override
    public Boolean existeMunicipio(Integer idMunicipio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Municipio insertaMunicipio(Municipio municipio) {
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new MunicipioServiceImpl(em);
            municipio = es.insertMunicipio(municipio);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en MunicipioServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en MunicipioEJBLocal -> insertaMunicipio() -> MunicipioService -> insertaMunicipio() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return municipio;
    }

    @Override
    public Municipio actualizaMunicipio(Municipio municipio) {
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new MunicipioServiceImpl(em);
            municipio = es.updateMunicipio(municipio);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en MunicipioServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en MunicipioEJBLocal -> insertaMunicipio() -> MunicipioService -> insertaMunicipio() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return municipio;
    }

    @Override
    public void eliminaMunicipio(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizaEstatusMunicipio(Integer id, Integer estatus) {
        Municipio municipio = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new MunicipioServiceImpl(em);
            municipio = es.getMunicipio(id);
            if (municipio != null) {
                municipio.setEstatus(estatus);
                es.updateMunicipio(municipio);
            }
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en MunicipioServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en MunicipioEJBLocal -> getMunicipio() -> MunicipioService -> getMunicipio() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
    }

    @Override
    public List<Municipio> getMunicipiosPorIdEstado(Integer idEstado, Integer estatus_municipio){
        List<Municipio> municipios = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new MunicipioServiceImpl(em);
            municipios = es.getMunicipiosPorIdEstado(idEstado, estatus_municipio);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en MunicipioServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en MunicipioEJBLocal -> getMunicipio() -> MunicipioService -> getMunicipioPorIdUsuario() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return municipios;
    }

}
