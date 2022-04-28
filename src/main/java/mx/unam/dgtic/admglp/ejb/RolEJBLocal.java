package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.Funciones.Funciones;
import mx.unam.dgtic.admglp.modelo.RolServiceImpl;
import mx.unam.dgtic.admglp.vo.Rol;

/**
 *
 * @author unam
 */
@Stateless
public class RolEJBLocal implements RolEJB {

    RolServiceImpl rs;

    @Override
    public List<Rol> getRoles() {
        List<Rol> roles = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            rs = new RolServiceImpl(em);
            roles = rs.getRoles();
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en RolService: " + e.getMessage() + "</p>";
            if (rs.getError() != null) {
                mensaje += "<p>" + "Error en RolEJBLocal -> getRols() -> RolService -> getRols() " + rs.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return roles;
    }

    @Override
    public List<Rol> getRolesPorEstatus(Integer estatus) {
        List<Rol> rols = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            rs = new RolServiceImpl(em);
            rols = rs.getRoles(estatus);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en RolService: " + e.getMessage() + "</p>";
            if (rs.getError() != null) {
                mensaje += "<p>" + "Error en RolEJBLocal -> getRolsPorEstatus() -> RolService -> getRolsPorEstatus() " + rs.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return rols;
    }

    @Override
    public Rol getRol(Integer idRol) {
        Rol rol = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            rs = new RolServiceImpl(em);
            rol = rs.getRol(idRol);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en RolServiceImpl: " + e.getMessage() + "</p>";

            if (rs.getError() != null) {
                mensaje += "<p>" + "Error en RolEJBLocal -> getRol() -> RolService -> getRol() " + rs.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return rol;
    }

    @Override
    public Rol insertaRol(Rol rol) {
        try {
            EntityManager em = Conexion.createEntityManager();
            rs = new RolServiceImpl(em);
            rol = rs.insertRol(rol);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en RolServiceImpl: " + e.getMessage() + "</p>";

            if (rs.getError() != null) {
                mensaje += "<p>" + "Error en RolEJBLocal -> insertaRol() -> RolService -> insertaRol() " + rs.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return rol;
    }

    @Override
    public Rol actualizaRol(Rol rol) {
        try {
            EntityManager em = Conexion.createEntityManager();
            rs = new RolServiceImpl(em);
            rol = rs.updateRol(rol);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en RolServiceImpl: " + e.getMessage() + "</p>";

            if (rs.getError() != null) {
                mensaje += "<p>" + "Error en RolEJBLocal -> insertaRol() -> RolService -> insertaRol() " + rs.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return rol;
    }

    @Override
    public void eliminaRol(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizaEstatusRol(Integer idRol, Integer estatus) {
        Rol rol = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            rs = new RolServiceImpl(em);
            rol = rs.getRol(idRol);
            if (rol != null) {
                rol.setEstatus(estatus);
                rs.updateRol(rol);
            }
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en RolServiceImpl: " + e.getMessage() + "</p>";

            if (rs.getError() != null) {
                mensaje += "<p>" + "Error en RolEJBLocal -> getRol() -> RolService -> getRol() " + rs.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
    }

}
