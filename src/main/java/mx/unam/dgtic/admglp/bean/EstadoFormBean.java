package mx.unam.dgtic.admglp.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import mx.unam.dgtic.admglp.mensajes.MessageBean;
import mx.unam.dgtic.admglp.vo.Estado;

/**
 * Bean con la informacion del estado a mostrar en la vista
 *
 * @author unam
 */
@Named
@SessionScoped
public class EstadoFormBean implements Serializable {

    private static final long serialVersionUID = -4146681491856848089L;
    private Integer idestado;
    private String clave;
    private String nombre;

    @Inject
    private EstadoModel estadoModel;

    @Inject
    private MessageBean messageBean;

    public String formularioEstado() {
        idestado = null;
        clave = null;
        nombre = null;
        return "/estado/estadoForm?faces-redirect=true";
    }

    public String formularioEstadoID(Integer idEst) {
        Estado estado = estadoModel.cargaEstado(idEst);
        if (estado != null) {
            this.idestado = idEst;
            this.clave = estado.getClave();
            this.nombre = estado.getNombre();
        }
        return "/estado/estadoForm?faces-redirect=true";
    }

    public String actualizarEstatusEstado(Integer id, Integer estatus) {
        estadoModel.actualizaEstatusEstado(id, estatus);
        return "/estado/lista?faces-redirect=true";
    }

    public String actualizar() {
        //Obtiene estado y despues reemplaza
        Estado estadoBD = null;
        try {
            if (estadoModel != null) {
                estadoBD = estadoModel.cargaEstado(this.idestado);
                if (estadoBD != null) {
                    //Buscar Asentamiento por id
                    estadoBD.setNombre(nombre);
                    estadoBD.setClave(clave);
                    estadoBD = estadoModel.actualizaEstado(estadoBD);
                }
            } else {
                throw new IllegalStateException("No existe el estado para actualizar");
            }
            messageBean.setMensajeRespuesta("Se actualiza estado");
        } catch (Exception ex) {
            messageBean.setMensajeRespuesta(ex.getMessage());
        }

        //Obtiene roles y despues reemplaza
        return "/estado/estadoForm?faces-redirect=true";
    }

    public String insertar() {
        //Preparar estado
        Estado estado = null;
        try {
            if (estadoModel != null) {
                estado = new Estado(clave, nombre, new Date(), null, 10);
                estado = estadoModel.insertaEstado(estado);
                idestado = estado.getId();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "/estado/estadoForm?faces-redirect=true";
    }

    public void limpiaCampos() {
        idestado = null;
        clave = null;
        nombre = null;
    }

    public Integer getIdestado() {
        return idestado;
    }

    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
