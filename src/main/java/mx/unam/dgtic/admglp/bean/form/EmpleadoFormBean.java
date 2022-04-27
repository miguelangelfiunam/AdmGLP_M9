package mx.unam.dgtic.admglp.bean.form;

import mx.unam.dgtic.admglp.bean.model.UsuarioModel;
import mx.unam.dgtic.admglp.bean.model.EmpleadoModel;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import mx.unam.dgtic.admglp.mensajes.MessageBean;
import mx.unam.dgtic.admglp.vo.Empleado;
import mx.unam.dgtic.admglp.vo.Usuario;

/**
 * Bean con la informacion del empleado a mostrar en la vista
 *
 * @author unam
 */
@Named
@SessionScoped
public class EmpleadoFormBean implements Serializable {

    private static final long serialVersionUID = -4146681491856848089L;
    private Integer idusuario; // Identificador de usuario
    private Integer idempleado; // Identificador de empleado
    private Integer numEmp; // Identificador de empleado
    private String numss; // Identificador de empleado
    private String rfc; // Identificador de empleado

    @Inject
    private EmpleadoModel empleadoModel;

    @Inject
    private UsuarioModel usuarioModel;

    @Inject
    private MessageBean messageBean;

    public String formularioEmpleado() {
        idusuario = null;
        idempleado = null;
        numEmp = null;
        numss = null;
        rfc = null;
        return "/empleado/empleadoForm?faces-redirect=true";
    }

    public String formularioEmpleadoID(Integer idusuario, Integer idEmp) {
        Empleado empleado = empleadoModel.cargaEmpleado(idEmp);
        if (empleado != null) {
            this.idusuario = idusuario;
            this.idempleado = idEmp;
            this.numEmp = empleado.getNumtrab();
            this.numss = empleado.getNumss();
            this.rfc = empleado.getRfc();
        }
        return "/empleado/empleadoForm?faces-redirect=true";
    }

    public String actualizarEstatusEmpleado(Integer id, Integer estatus) {
        try {
            if (empleadoModel != null) {
                empleadoModel.actualizaEstatusEmpleado(id, estatus);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "/empleado/lista?faces-redirect=true";
    }

    public String actualizar() {
        //Obtiene empleado y despues reemplaza
        Empleado empleadoBD = null;
        try {
            if (empleadoModel != null) {
                empleadoBD = empleadoModel.cargaEmpleado(this.idempleado);
                if (empleadoBD != null) {
                    empleadoBD.setNumtrab(numEmp);
                    empleadoBD.setNumss(numss);
                    empleadoBD.setRfc(rfc);
                    empleadoBD = empleadoModel.actualizaEmpleado(empleadoBD);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Obtiene roles y despues reemplaza
        return "/empleado/lista?faces-redirect=true";
    }

    public String insertar() {
        //Preparar empleado
        Empleado empleado = null;
        Usuario usuario = null;
        try {
            if (usuarioModel != null) {
                if (idusuario != null) {
                    usuario = usuarioModel.cargaUsuario(idusuario);
                }
            }
            if (empleadoModel != null) {
                if (usuario != null) {
                    empleado = new Empleado(usuario, numEmp, numss, rfc, new Date(), null, 10);
                    empleado = empleadoModel.insertaEmpleado(empleado);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "/empleado/lista?faces-redirect=true";
    }

    public void limpiaCampos() {
        idusuario = null;
        idempleado = null;
        numEmp = null;
        numss = null;
        rfc = null;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

    public Integer getNumEmp() {
        return numEmp;
    }

    public void setNumEmp(Integer numEmp) {
        this.numEmp = numEmp;
    }

    public String getNumss() {
        return numss;
    }

    public void setNumss(String numss) {
        this.numss = numss;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public EmpleadoModel getEmpleadoModel() {
        return empleadoModel;
    }

    public void setEmpleadoModel(EmpleadoModel empleadoModel) {
        this.empleadoModel = empleadoModel;
    }

    public MessageBean getMessageBean() {
        return messageBean;
    }

    public void setMessageBean(MessageBean messageBean) {
        this.messageBean = messageBean;
    }

}
