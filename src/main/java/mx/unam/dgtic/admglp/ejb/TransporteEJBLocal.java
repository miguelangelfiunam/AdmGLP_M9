package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.Funciones.Funciones;
import mx.unam.dgtic.admglp.modelo.TransporteServiceImpl;
import mx.unam.dgtic.admglp.vo.Transporte;
import mx.unam.dgtic.admglp.vo.TransporteMarca;

/**
 *
 * @author unam
 */
@Stateless
public class TransporteEJBLocal implements TransporteEJB {

    TransporteServiceImpl es;

    @Override
    public List<Transporte> getTransportes() {
        List<Transporte> transportes = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new TransporteServiceImpl(em);
            transportes = es.getTransportes();
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en TransporteService: " + e.getMessage() + "</p>";
            if (es.getError() != null) {
                mensaje += "<p>" + "Error en TransporteEJBLocal -> getTransportes() -> TransporteService -> getTransportes() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return transportes;
    }

    @Override
    public List<Transporte> getTransportesPorEstatus(Integer estatus) {
        List<Transporte> transportes = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new TransporteServiceImpl(em);
            transportes = es.getTransportes(estatus);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en TransporteService: " + e.getMessage() + "</p>";
            if (es.getError() != null) {
                mensaje += "<p>" + "Error en TransporteEJBLocal -> getTransportesPorEstatus() -> TransporteService -> getTransportesPorEstatus() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return transportes;
    }

    @Override
    public Transporte getTransporte(Integer idTransporte) {
        Transporte transporte = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new TransporteServiceImpl(em);
            transporte = es.getTransporte(idTransporte);

        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en TransporteServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en TransporteEJBLocal -> getTransporte() -> TransporteService -> getTransporte() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return transporte;
    }

    @Override
    public Boolean existeTransporte(Integer idTransporte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Transporte insertaTransporte(Transporte transporte) {
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new TransporteServiceImpl(em);
            transporte = es.insertTransporte(transporte);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en TransporteServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en TransporteEJBLocal -> insertaTransporte() -> TransporteService -> insertaTransporte() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return transporte;
    }

    @Override
    public Transporte actualizaTransporte(Transporte transporte) {
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new TransporteServiceImpl(em);
            transporte = es.updateTransporte(transporte);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en TransporteServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en TransporteEJBLocal -> insertaTransporte() -> TransporteService -> insertaTransporte() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return transporte;
    }

    @Override
    public void eliminaTransporte(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizaEstatusTransporte(Integer id, Integer estatus) {
        Transporte transporte = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new TransporteServiceImpl(em);
            transporte = es.getTransporte(id);
            if (transporte != null) {
                transporte.setEstatus(estatus);
                es.updateTransporte(transporte);
            }
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en TransporteServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en TransporteEJBLocal -> getTransporte() -> TransporteService -> getTransporte() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
    }

    @Override
    public List<TransporteMarca> getMarcasTransportes() {
        List<TransporteMarca> marcas = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new TransporteServiceImpl(em);
            marcas = es.getMarcasTransportes();
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en TransporteService: " + e.getMessage() + "</p>";
            if (es.getError() != null) {
                mensaje += "<p>" + "Error en TransporteEJBLocal -> getMarcasTransportes() -> TransporteService -> getMarcasTransportes() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return marcas;
    }

}
