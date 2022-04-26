/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.bean;

import jakarta.enterprise.inject.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.ejb.MunicipioEJBLocal;
import mx.unam.dgtic.admglp.vo.Municipio;

/**
 *
 * @author unam
 */
@Model
public class MunicipioModel implements Serializable {

    private static final long serialVersionUID = -1000003;

    public List<Municipio> cargaMunicipios() {
        List<Municipio> municipios = null;
        MunicipioEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (MunicipioEJBLocal) ctx.lookup("java:global/admglp/MunicipioEJBLocal!mx.unam.dgtic.admglp.ejb.MunicipioEJB");
            if (service != null) {
                municipios = service.getMunicipios();
            } else {
                municipios = new ArrayList<Municipio>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return municipios;
    }

    public Municipio cargaMunicipio(Integer idmunicipio) {
        Municipio municipio = null;
        MunicipioEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (MunicipioEJBLocal) ctx.lookup("java:global/admglp/MunicipioEJBLocal!mx.unam.dgtic.admglp.ejb.MunicipioEJB");
            if (service != null) {
                municipio = service.getMunicipio(idmunicipio);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return municipio;
    }

    public Municipio actualizaMunicipio(Municipio municipio) {
        MunicipioEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (MunicipioEJBLocal) ctx.lookup("java:global/admglp/MunicipioEJBLocal!mx.unam.dgtic.admglp.ejb.MunicipioEJB");
            if (service != null) {
                municipio = service.actualizaMunicipio(municipio);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return municipio;
    }

    public void actualizaEstatusMunicipio(Integer idEmp, Integer estatus) {
        MunicipioEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (MunicipioEJBLocal) ctx.lookup("java:global/admglp/MunicipioEJBLocal!mx.unam.dgtic.admglp.ejb.MunicipioEJB");
            if (service != null) {
                service.actualizaEstatusMunicipio(idEmp, estatus);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Municipio insertaMunicipio(Municipio municipio) {
        MunicipioEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (MunicipioEJBLocal) ctx.lookup("java:global/admglp/MunicipioEJBLocal!mx.unam.dgtic.admglp.ejb.MunicipioEJB");
            if (service != null) {
                municipio = service.insertaMunicipio(municipio);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return municipio;
    }

    public List<Municipio> cargaMunicipioPorIdEstado(Integer idEstado, Integer estatus_municipio) {
        List<Municipio> municipios = null;
        MunicipioEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (MunicipioEJBLocal) ctx.lookup("java:global/admglp/MunicipioEJBLocal!mx.unam.dgtic.admglp.ejb.MunicipioEJB");
            if (service != null) {
                municipios = service.getMunicipiosPorIdEstado(idEstado, estatus_municipio);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return municipios;
    }
}
