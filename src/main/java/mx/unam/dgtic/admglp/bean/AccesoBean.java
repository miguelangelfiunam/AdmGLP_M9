/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.bean;

import jakarta.enterprise.inject.Model;
import java.io.Serializable;
import javax.naming.InitialContext;
import mx.unam.dgtic.admglp.ejb.AccesoEJBLocal;
import mx.unam.dgtic.admglp.vo.Acceso;

/**
 *
 * @author unam
 */
@Model
public class AccesoBean implements Serializable {
    private static final long serialVersionUID = -1000;
    
    public Acceso cargaAcceso(Integer idAcceso) {
        Acceso usuario = null;
        AccesoEJBLocal service = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (AccesoEJBLocal) ctx.lookup("java:global/admglp/AccesoEJBLocal!mx.unam.dgtic.admglp.ejb.AccesoEJB");
            if (service != null) {
                usuario = service.getAcceso(idAcceso);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usuario;
    }
    
    public Acceso insertaAcceso(Acceso acceso) {
        Acceso usuario = null;
        AccesoEJBLocal service = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (AccesoEJBLocal) ctx.lookup("java:global/admglp/AccesoEJBLocal!mx.unam.dgtic.admglp.ejb.AccesoEJB");
            if (service != null) {
                usuario = service.insertaAcceso(acceso);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usuario;
    }
    
    public Acceso finalizaAcceso(Integer id) {
        Acceso usuario = null;
        AccesoEJBLocal service = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (AccesoEJBLocal) ctx.lookup("java:global/admglp/AccesoEJBLocal!mx.unam.dgtic.admglp.ejb.AccesoEJB");
            if (service != null) {
                usuario = service.finalizaAcceso(id);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usuario;
    }
}
