package mx.unam.dgtic.admglp.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionContext;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.InitialContext;
import mx.unam.dgtic.admglp.ejb.ContraEJBLocal;
import mx.unam.dgtic.admglp.ejb.RolEJBLocal;
import mx.unam.dgtic.admglp.ejb.UsuarioEJBLocal;
import mx.unam.dgtic.admglp.mensajes.MessageBean;
import mx.unam.dgtic.admglp.vo.Contra;
import mx.unam.dgtic.admglp.vo.Rol;
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
    private List<Integer> roles = new ArrayList<>();
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

    public List<Integer> getRoles() {
        return roles;
    }

    public void setRoles(List<Integer> roles) {
        this.roles = roles;
    }

    public String formularioUsuario() {
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
        roles = new ArrayList<>();
        return "/usuario/usuarioForm?faces-redirect=true";
    }

    public String formularioUsuarioID(Integer idUsu) {
        Usuario usuario = listaUsuariosBean.cargaUsuario(idUsu);
        if (usuario != null) {
            this.idusuario = idUsu;
            this.contra = usuario.getContra().getContra();
            this.apodo = usuario.getApodo();
            this.correo1 = usuario.getCorreo1();
            this.correo2 = usuario.getCorreo2();
            this.nombre = usuario.getNombre();
            this.apellido1 = usuario.getApellido1();
            this.apellido2 = usuario.getApellido2();
            this.edad = usuario.getEdad();
            for (Rol rol : usuario.getRoles()) {
                this.roles.add(rol.getIdrol());
            }

            String pattern = "dd/MM/yyyy";
            DateFormat df = new SimpleDateFormat(pattern);
            this.fnac = df.format(usuario.getFnac());

            this.telefono1 = usuario.getTelefono1();
            this.telefono2 = usuario.getTelefono2();
        }
        return "/usuario/usuarioForm?faces-redirect=true";
    }

    public String actualizarEstatusUsuario(Integer id, Integer estatus) {
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

    public String actualizar() {
        UsuarioEJBLocal service_usu = null;
        ContraEJBLocal service_contra = null;
        RolEJBLocal service_rol = null;
        try {
            InitialContext ctx = new InitialContext();
            service_rol = (RolEJBLocal) ctx.lookup("java:global/admglp/RolEJBLocal!mx.unam.dgtic.admglp.ejb.RolEJB");
            service_usu = (UsuarioEJBLocal) ctx.lookup("java:global/admglp/UsuarioEJBLocal!mx.unam.dgtic.admglp.ejb.UsuarioEJB");
            service_contra = (ContraEJBLocal) ctx.lookup("java:global/admglp/ContraEJBLocal!mx.unam.dgtic.admglp.ejb.ContraEJB");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Preparar roles
        List<Rol> rolesBD = new ArrayList<>();
        for (Integer idrol : roles) {
            try {
                if (service_rol != null) {
                    Rol rol = service_rol.getRol(idrol);
                    if (rol != null) {
                        rolesBD.add(rol);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        //Obtiene usuario y despues reemplaza
        Usuario usuarioBD = null;
        Contra contraBD = null;
        try {
            if (service_usu != null && service_contra != null) {
                Date date_fnac = new SimpleDateFormat("dd/MM/yyyy").parse(fnac);
                usuarioBD = service_usu.getUsuario(this.idusuario);
                if (usuarioBD != null) {
                    usuarioBD.setRoles(rolesBD);
                    usuarioBD.setApodo(apodo);
                    usuarioBD.setCorreo1(correo1);
                    usuarioBD.setCorreo2(correo2);
                    usuarioBD.setNombre(nombre);
                    usuarioBD.setApellido1(apellido1);
                    usuarioBD.setApellido2(apellido2);
                    usuarioBD.setEdad(edad);
                    usuarioBD.setFnac(date_fnac);
                    usuarioBD.setTelefono1(telefono1);
                    usuarioBD.setTelefono2(telefono2);
                    usuarioBD = service_usu.actualizaUsuario(usuarioBD);
                    
                    contraBD = usuarioBD.getContra();
                    contraBD.setContra(contra);
                    contraBD = service_contra.actualizaContra(contraBD);
                    usuarioBD.setContra(contraBD);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Obtiene roles y despues reemplaza
        return "/usuario/lista?faces-redirect=true";
    }

    public String insertar() {
        UsuarioEJBLocal service_usu = null;
        RolEJBLocal service_rol = null;
        ContraEJBLocal service_contra = null;
        try {
            InitialContext ctx = new InitialContext();
            service_rol = (RolEJBLocal) ctx.lookup("java:global/admglp/RolEJBLocal!mx.unam.dgtic.admglp.ejb.RolEJB");
            service_contra = (ContraEJBLocal) ctx.lookup("java:global/admglp/ContraEJBLocal!mx.unam.dgtic.admglp.ejb.ContraEJB");
            service_usu = (UsuarioEJBLocal) ctx.lookup("java:global/admglp/UsuarioEJBLocal!mx.unam.dgtic.admglp.ejb.UsuarioEJB");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //Preparar roles
        List<Rol> rolesBD = new ArrayList<>();
        for (Integer idrol : roles) {
            try {
                if (service_rol != null) {
                    Rol rol = service_rol.getRol(idrol);
                    if (rol != null) {
                        rolesBD.add(rol);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        //Prepara contra
        Contra contraBD = null;
        try {
            if (service_contra != null) {
                contraBD = new Contra(contra, new Date(), null, 10);
                contraBD = service_contra.insertaContra(contraBD);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //Preparar usuario
        Usuario usuario = null;
        try {
            if (service_usu != null) {
                Date date_fnac = new SimpleDateFormat("dd/MM/yyyy").parse(fnac);
                usuario = new Usuario(contraBD, apodo, correo1, correo2, nombre, apellido1, apellido2, edad, date_fnac, telefono1, telefono2, new Date(), null, 10, rolesBD);
                usuario = service_usu.insertaUsuario(usuario);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
        roles = new ArrayList<>();
    }

}
