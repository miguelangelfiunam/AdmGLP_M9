package mx.unam.dgtic.admglp.bean.form;

import mx.unam.dgtic.admglp.bean.model.EstatusModel;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import mx.unam.dgtic.admglp.mensajes.MessageBean;
import mx.unam.dgtic.admglp.vo.Estatus;

/**
 * Bean con la informacion del estatus a mostrar en la vista
 *
 * @author unam
 */
@Named
@SessionScoped
public class EstatusFormBean implements Serializable {

    private static final long serialVersionUID = -4146681491856848089L;
    private Integer idestatus;
    private Integer numero;
    private String tabla;
    private String nombre;
    private String descripcion;

    @Inject
    private EstatusModel estatusModel;

    @Inject
    private MessageBean messageBean;

    public String formularioEstatus() {
        idestatus = null;
        numero = null;
        tabla = null;
        nombre = null;
        descripcion = null;
        return "/estatus/estatusForm?faces-redirect=true";
    }

    public String formularioEstatusID(Integer idEst) {
        Estatus estatus = estatusModel.cargaEstatus(idEst);
        if (estatus != null) {
            this.idestatus = idEst;
            this.numero = estatus.getNumero();
            this.tabla = estatus.getTabla();
            this.nombre = estatus.getNombre();
            this.descripcion = estatus.getDescripcion();
        }
        return "/estatus/estatusForm?faces-redirect=true";
    }

    public String actualizarActivoEstatus(Integer id, Integer estatus) {
        estatusModel.actualizaActivoEstatus(id, estatus);
        return "/estatus/lista?faces-redirect=true";
    }

    public String actualizar() {
        //Obtiene estatus y despues reemplaza
        Estatus estatusBD = null;
        try {
            if (estatusModel != null) {
                estatusBD = estatusModel.cargaEstatus(this.idestatus);
                if (estatusBD != null) {
                    //Buscar Estatus por id
                    estatusBD.setNumero(numero);
                    estatusBD.setTabla(tabla);
                    estatusBD.setNombre(nombre);
                    estatusBD.setDescripcion(descripcion);
                    estatusBD = estatusModel.actualizaEstatus(estatusBD);
                }
            } else {
                throw new IllegalStateException("No existe el estatus para actualizar");
            }
            messageBean.setMensajeRespuesta("Se actualiza estatus");
        } catch (Exception ex) {
            messageBean.setMensajeRespuesta(ex.getMessage());
        }

        //Obtiene roles y despues reemplaza
        return "/estatus/estatusForm?faces-redirect=true";
    }

    public String insertar() {
        //Preparar estatus
        Estatus estatus = null;
        try {
            if (estatusModel != null) {
                estatus = new Estatus(numero, tabla, nombre, descripcion, new Date(), null, 10);
                estatus = estatusModel.insertaEstatus(estatus);
                idestatus = estatus.getId();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "/estatus/estatusForm?faces-redirect=true";
    }

    public void limpiaCampos() {
        idestatus = null;
        numero = null;
        tabla = null;
        nombre = null;
        descripcion = null;
    }

    public Integer getIdestatus() {
        return idestatus;
    }

    public void setIdestatus(Integer idestatus) {
        this.idestatus = idestatus;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
