package mx.unam.dgtic.admglp.ejb;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import mx.unam.dgtic.admglp.mensajes.MessageBean;
import mx.unam.dgtic.admglp.model.UsuarioModel;

/**
 * Bean con la informacion del usuario a mostrar en la vista
 *
 * @author unam
 */
@Named
@SessionScoped
public class UsuarioFormBean implements Serializable {

    private static final long serialVersionUID = -4146681491856848089L;
    private Integer idusuario; // Identificador de usuario
    private String contra;
    private String apodo; // Seudonimo del usuario en la aplicacion
    private String correo1; // Correo electronico
    private String correo2; // Correo electronico
    private String nombre; // Nombre de la persona 100
    private String apellido1; // Primer apellido 100
    private String apellido2; // Segundo apellido 100
    private Integer edad;// Edad de la persona
    private String fnac; // Fecha de nacimiento
    private String telefono1; // Telefono del usuario
    private String telefono2; // Segundo telefono de contacto
    private String roles;
    @Inject
    private ListaUsuariosBean listaUsuariosBean;
    @Inject
    private ListaRolesBean listaRolesBean;
    @Inject
    private MessageBean messageBean;

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getCorreo1() {
        return correo1;
    }

    public void setCorreo1(String correo1) {
        this.correo1 = correo1;
    }

    public String getCorreo2() {
        return correo2;
    }

    public void setCorreo2(String correo2) {
        this.correo2 = correo2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getFnac() {
        return fnac;
    }

    public void setFnac(String fnac) {
        this.fnac = fnac;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String agregaUsuario() {
        return "/usuario/usuarioForm?faces-redirect=true";
    }

    public String borraUsuario(Integer id) {
        UsuarioModel usuarioModel_aux = null;
        for (UsuarioModel usuarioModel : listaUsuariosBean.getUsuarioModels()) {
            if (usuarioModel.getIdusuario() == id) {
               usuarioModel_aux = usuarioModel;
               break;
            }
        }
        if(usuarioModel_aux != null){
            listaUsuariosBean.getUsuarioModels().remove(usuarioModel_aux);
        }
        return "/usuario/lista?faces-redirect=true";
    }

    public String actualizaUsuario(Integer idUsu) {
        for (UsuarioModel usuarioModel : listaUsuariosBean.getUsuarioModels()) {
            if (usuarioModel.getIdusuario() == idUsu) {
                this.idusuario = idUsu;
                this.nombre = usuarioModel.getNombre();
            }
        }
        return "/usuario/usuarioForm?faces-redirect=true";
    }
    
    public String actualizar() {
        
        return "/usuario/lista?faces-redirect=true";
    }
    
    public String agregar() {
        
        return "/usuario/lista?faces-redirect=true";
    }

}