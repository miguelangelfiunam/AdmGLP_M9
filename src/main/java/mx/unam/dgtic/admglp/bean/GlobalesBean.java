package mx.unam.dgtic.admglp.bean;

import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import mx.unam.dgtic.admglp.ejb.GlobalEJBLocal;
import mx.unam.dgtic.admglp.vo.Global;

@Model
public class GlobalesBean implements Serializable {

    private static final long serialVersionUID = -10;

    @Produces
    @Model
    public List<Global> cargaGlobales() {
        List<Global> globales = null;
        GlobalEJBLocal service = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (GlobalEJBLocal) ctx.lookup("java:global/admglp/GlobalEJBLocal!mx.unam.dgtic.admglp.ejb.GlobalEJB");
            if (service != null) {
                globales = service.getGlobales();
            } else {
                globales = new ArrayList<Global>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return globales;
    }

    @Model
    public String cargaGlobal(String nomGlobal) {
        Global global = null;
        GlobalEJBLocal service = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (GlobalEJBLocal) ctx.lookup("java:global/admglp/GlobalEJBLocal!mx.unam.dgtic.admglp.ejb.GlobalEJB");
            if (service != null) {
                global = service.getGlobal(nomGlobal);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (global != null) {
            return global.getValor();
        } else {
            return "Sin valor";
        }

    }

}
