package mx.unam.dgtic.admglp.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.naming.InitialContext;
import mx.unam.dgtic.admglp.ejb.UsuarioEJBLocal;
import mx.unam.dgtic.admglp.mensajes.MessageBean;
import mx.unam.dgtic.admglp.vo.Usuario;

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
    private ListasBean listaUsuariosBean;
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

    public String actualizaEstatusUsuario(Integer id, Integer estatus) {
        UsuarioEJBLocal service = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (UsuarioEJBLocal) ctx.lookup("java:global/admglp/UsuarioEJBLocal!mx.unam.dgtic.admglp.ejb.UsuarioEJB");
            if (service != null) {
                service.actualizaEstatusUsuario(id, estatus);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "/usuario/lista?faces-redirect=true";
    }

    public String actualizaUsuario(Integer idUsu) {
        Usuario usuarioModel = listaUsuariosBean.cargaUsuario(idUsu);
        if (usuarioModel != null) {
            this.idusuario = idUsu;
            this.contra = usuarioModel.getContra().getContra();
            this.apodo = usuarioModel.getApodo();
            this.correo1 = usuarioModel.getCorreo1();
            this.correo2 = usuarioModel.getCorreo2();
            this.nombre = usuarioModel.getNombre();
            this.apellido1 = usuarioModel.getApellido1();
            this.apellido2 = usuarioModel.getApellido2();
            this.edad = usuarioModel.getEdad();

            String pattern = "dd/MM/yyyy";
            DateFormat df = new SimpleDateFormat(pattern);
            this.fnac = df.format(usuarioModel.getFnac());

            this.telefono1 = usuarioModel.getTelefono1();
            this.telefono2 = usuarioModel.getTelefono2();
        }
        return "/usuario/usuarioForm?faces-redirect=true";
    }

    public String actualizar() {
        int i = 0;
        int j = 0;

        return "/usuario/lista?faces-redirect=true";
    }

    public String registrar() {

        return "/usuario/lista?faces-redirect=true";
    }

    public void limpiaCampos() {
        idusuario = null;
        contra = null;
        apodo = null;
        correo1 = null;
        correo2 = null;
        nombre = null;
        apellido1 = null;
        apellido2 = null;
        edad = null;
        fnac = null;
        telefono1 = null;
        telefono2 = null;
        roles = null;
    }

}
