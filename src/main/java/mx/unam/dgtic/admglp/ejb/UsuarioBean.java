package mx.unam.dgtic.admglp.ejb;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Map;
import mx.unam.dgtic.admglp.mensajes.MessageBean;
import mx.unam.dgtic.admglp.bd.model.UsuarioModel;
import mx.unam.dgtic.admglp.bd.model.Usuario_rolModel;

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
    private Boolean admin = false;
    @Inject
    private ListaUsuariosBean listaUsuariosBean;
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

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String login() {
        for (UsuarioModel usuario : listaUsuariosBean.getUsuarioModels()) {
            if (usuario.getApodo().equals(apodo) && usuario.getContra().getContra().equals(contra)) {
                if (usuario.getEstatus() == 10) {
                    for (Usuario_rolModel usuario_rolModel : usuario.getUsuario_rolModels()) {
                        if (usuario_rolModel.getRol().getNombre().equals("Administrador")) {
                            admin = true;
                        }
                    }
                    acceso = true;
                    messageBean.setMensajeRespuesta("");
                    System.out.println(this);
                    return "index";
                } else {
                    messageBean.setMensajeRespuesta("El usuario no tiene acceso al sistema");
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
            apodo = null;
            contra = null;
            acceso = false;
            admin = false;
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            String url = ec.getRequestContextPath() + "/index.xhtml?faces-redirect=true";
            ec.redirect(url);
        } catch (Exception e) {
        }

//        return url;
    }

    @Override
    public String toString() {
        return "UsuarioBean{" + "apodo=" + apodo + ", contra=" + contra + ", acceso=" + acceso + '}';
    }

}
