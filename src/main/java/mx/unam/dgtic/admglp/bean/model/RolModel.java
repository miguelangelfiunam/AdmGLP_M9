package mx.unam.dgtic.admglp.bean.model;

import jakarta.enterprise.inject.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.ejb.RolEJBLocal;
import mx.unam.dgtic.admglp.vo.Rol;

/**
 *
 * @author unam
 */
@Model
public class RolModel implements Serializable {
    
    private static final long serialVersionUID = -1000001;
    
    public List<Rol> cargaRoles() {
        List<Rol> roles = null;
        RolEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (RolEJBLocal) ctx.lookup("java:global/admglp/RolEJBLocal!mx.unam.dgtic.admglp.ejb.RolEJB");
            if (service != null) {
                roles = service.getRoles();
            } else {
                roles = new ArrayList<Rol>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return roles;
    }
    
    public Rol cargaRol(Integer idrol) {
        Rol rol = null;
        RolEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (RolEJBLocal) ctx.lookup("java:global/admglp/RolEJBLocal!mx.unam.dgtic.admglp.ejb.RolEJB");
            if (service != null) {
                rol = service.getRol(idrol);
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rol;
    }
}
