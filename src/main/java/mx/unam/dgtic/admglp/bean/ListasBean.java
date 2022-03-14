package mx.unam.dgtic.admglp.bean;

import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import mx.unam.dgtic.admglp.bd.model.RolModel;
import mx.unam.dgtic.admglp.bd.model.UsuarioModel;
import mx.unam.dgtic.admglp.ejb.UsuarioEJBLocal;

@Model
public class ListasBean implements Serializable {

    private static final long serialVersionUID = -10;

    @Inject
    ListaContrasBean listaContrasBean;

    @Produces
    @Model
    public List<UsuarioModel> cargaUsuarios() {
        List<UsuarioModel> usuarios = null;
        UsuarioEJBLocal service = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (UsuarioEJBLocal) ctx.lookup("java:global/admglp/UsuarioEJBLocal!mx.unam.dgtic.admglp.ejb.UsuarioEJB");
            if (service != null) {
                usuarios = service.getUsuarios();
            } else {
                usuarios = new ArrayList();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usuarios;
    }
    
    @Produces
    @Model
    public List<RolModel> cargaRoles() {
        List<RolModel> roles = null;
        UsuarioEJBLocal service = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (UsuarioEJBLocal) ctx.lookup("java:global/admglp/UsuarioEJBLocal!mx.unam.dgtic.admglp.ejb.UsuarioEJB");
            if (service != null) {
                roles = service.getRoles();
            } else {
                roles = new ArrayList();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return roles;
    }

}
