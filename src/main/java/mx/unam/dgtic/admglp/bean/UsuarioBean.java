package mx.unam.dgtic.admglp.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import mx.unam.dgtic.admglp.mensajes.MessageBean;
import mx.unam.dgtic.admglp.vo.Acceso;
import mx.unam.dgtic.admglp.vo.Rol;
import mx.unam.dgtic.admglp.vo.Usuario;

/**
 * Bean con la informacion del usuario a mostrar en la vista
 *
 * @author unam
 */
@Named
@SessionScoped
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = -4146681491856848089L;
    private Integer id;
    private String apodo;
    private String contra;
    private Integer estatus;
    private Boolean acceso = false;
    private Integer idacceso;
    private String rol;
    @Inject
    private ListasBean listaUsuariosBean;
    @Inject
    private AccesoBean accesoBean;
    @Inject
    private MessageBean messageBean;

    public UsuarioBean() {
    }

    public UsuarioBean(Integer id, String apodo, String contra, Integer estatus) {
        this.id = id;
        this.apodo = apodo;
        this.contra = contra;
        this.estatus = estatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public Boolean getAcceso() {
        return acceso;
    }

    public void setAcceso(Boolean acceso) {
        this.acceso = acceso;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getIdacceso() {
        return idacceso;
    }

    public void setIdacceso(Integer idacceso) {
        this.idacceso = idacceso;
    }

    public String login() {
        Usuario usuario = listaUsuariosBean.cargaUsuario(apodo, contra, 10);
        if (usuario != null) {
            if (usuario.getApodo().equals(apodo) && usuario.getContra().getContra().equals(contra)) {
                if (usuario.getEstatus() == 10) {
                    //Registro de acceso
                    Acceso accesoBD = new Acceso(usuario, new Date(), null, "Inicio de sesion", new Date(), null, 10);
                    accesoBD = accesoBean.insertaAcceso(accesoBD);
                    if (accesoBD.getId() != null) {
                        idacceso = accesoBD.getId();
                    }

                    for (Rol rolBD : usuario.getRoles()) {
                        switch (rolBD.getNombre()) {
                            case "Administrador":
                                this.rol = rolBD.getNombre();
                                id = usuario.getIdusuario();
                                acceso = true;
                                messageBean.setMensajeRespuesta("");
                                System.out.println(this);
                                return "/usuario/lista";
                            case "Empleado":
                                this.rol = rolBD.getNombre();
                                id = usuario.getIdusuario();
                                acceso = true;
                                messageBean.setMensajeRespuesta("");
                                System.out.println(this);
                                return "/empleado/empleado";
                            case "Cliente":
                                this.rol = rolBD.getNombre();
                                id = usuario.getIdusuario();
                                acceso = true;
                                messageBean.setMensajeRespuesta("");
                                System.out.println(this);
                                return "/cliente/cliente";
                            default:
                                break;
                        }
                    }
                } else {
                    //Registro de acceso fallido
                    Acceso accesoBD = new Acceso(usuario, new Date(), null, "Estatus del trabajador diferente de 10", new Date(), null, 20);
                    accesoBean.insertaAcceso(accesoBD);

                    messageBean.setMensajeRespuesta("El usuario no tiene acceso al sistema estatus inactivo");
                    System.out.println(this);
                    return "login";
                }
            }
        }

        messageBean.setMensajeRespuesta("Usuario y contraseña incorrectos");
        System.out.println(this);
        return "login";
    }

    public void logout() {
        try {
            id = null;
            apodo = null;
            contra = null;
            acceso = false;
            if(idacceso != null){
                accesoBean.finalizaAcceso(idacceso);
            }
            idacceso = null;
            rol = null;
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            String url = ec.getRequestContextPath() + "/index.xhtml?faces-redirect=true";
            
            ec.redirect(url);
        } catch (Exception e) {
        }
    }

    @Override
    public String toString() {
        return "UsuarioBean{" + "apodo=" + apodo + ", contra=" + contra + ", acceso=" + acceso + '}';
    }

}
