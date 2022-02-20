/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import mx.unam.dgtic.admglp.mensajes.MessageBean;

/**
 *
 * @author unam
 */
@Named
@SessionScoped
public class UsuarioBean implements Serializable {
    
    private static final long serialVersionUID = -4146681491856848089L;
    private String apodo;
    private String contra;
    private Boolean acceso = false;
    @Inject
    private ListaUsuariosBean listaUsuariosBean;
    @Inject
    private MessageBean messageBean;
    
    public UsuarioBean() {
    }
    
    public UsuarioBean(String apodo, String contra) {
        this.apodo = apodo;
        this.contra = contra;
    }
    
    public String getApodo() {
        return apodo;
    }
    
    public void setApodo(String apodo) {
        this.apodo = apodo;
    }
    
    public String getContra() {
        return contra;
    }
    
    public void setContra(String contra) {
        this.contra = contra;
    }
    
    public Boolean getAcceso() {
        return acceso;
    }
    
    public void setAcceso(Boolean acceso) {
        this.acceso = acceso;
    }
    
    public String login() {
        for (UsuarioBean usuario : listaUsuariosBean.getUsuarios()) {
            if (usuario.getApodo().equals(apodo) && usuario.getContra().equals(contra)) {
                acceso = true;
                break;
            }
        }
        if (acceso) {
            messageBean.setMensajeRespuesta("");
            return "index";
        } else {
            messageBean.setMensajeRespuesta("Usuario y contraseña incorrectos");
            return "login";
        }
    }
    
    public String logout() {
        apodo = null;
        contra = null;
        acceso = false;
        
        return "index";
    }
    
    @Override
    public String toString() {
        return "UsuarioBean{" + "apodo=" + apodo + ", contra=" + contra + ", acceso=" + acceso + '}';
    }
    
}
