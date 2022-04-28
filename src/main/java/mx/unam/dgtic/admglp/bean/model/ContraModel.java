package mx.unam.dgtic.admglp.bean.model;

import jakarta.enterprise.inject.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.ejb.ContraEJBLocal;
import mx.unam.dgtic.admglp.vo.Contra;

/**
 * Modelo para metodos de contras
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/04/2022 - 26/04/2022
 *
 */
@Model
public class ContraModel implements Serializable{
    private static final long serialVersionUID = -1000002;
    
    public List<Contra> cargaContraes() {
        List<Contra> contras = null;
        ContraEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ContraEJBLocal) ctx.lookup("java:global/admglp/ContraEJBLocal!mx.unam.dgtic.admglp.ejb.ContraEJB");
            if (service != null) {
                contras = service.getContras();
            } else {
                contras = new ArrayList<Contra>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return contras;
    }
    
    public Contra cargaContra(Integer idcontra) {
        Contra contra = null;
        ContraEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ContraEJBLocal) ctx.lookup("java:global/admglp/ContraEJBLocal!mx.unam.dgtic.admglp.ejb.ContraEJB");
            if (service != null) {
                contra = service.getContra(idcontra);
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return contra;
    }
    
    public Contra actualizaContra(Contra contra){
        ContraEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ContraEJBLocal) ctx.lookup("java:global/admglp/ContraEJBLocal!mx.unam.dgtic.admglp.ejb.ContraEJB");
            if (service != null) {
                contra = service.actualizaContra(contra);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return contra;
    }
    
    public Contra insertaContra(Contra contra){
        ContraEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ContraEJBLocal) ctx.lookup("java:global/admglp/ContraEJBLocal!mx.unam.dgtic.admglp.ejb.ContraEJB");
            if (service != null) {
                contra = service.insertaContra(contra);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return contra;
    }
}
