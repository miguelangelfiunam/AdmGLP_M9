package mx.unam.dgtic.admglp.bean.form;

import mx.unam.dgtic.admglp.bean.model.DireccionModel;
import mx.unam.dgtic.admglp.bean.model.AsentamientoModel;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import mx.unam.dgtic.admglp.mensajes.MessageBean;
import mx.unam.dgtic.admglp.vo.Asentamiento;
import mx.unam.dgtic.admglp.vo.Direccion;

/**
 * Bean con la informacion del direccion a mostrar en la vista
 *
 * @author unam
 */
@Named
@SessionScoped
public class DireccionFormBean implements Serializable {

    private static final long serialVersionUID = -4146681491856848089L;
    private Integer idestado;
    private Integer idmunicipio;
    private Integer idasentamiento;
    private Integer iddireccion;
    private String nombre;
    private String referencias;
    @Inject
    private AsentamientoModel asentamientoModel;
    @Inject
    private DireccionModel direccionModel;

    @Inject
    private MessageBean messageBean;

    public String formularioDireccion() {
        idestado = null;
        idmunicipio = null;
        idasentamiento = null;
        iddireccion = null;
        nombre = null;
        referencias = null;
        return "/direccion/direccionForm?faces-redirect=true";
    }

    public String formularioDireccionID(Integer idDir) {
        Direccion direccion = direccionModel.cargaDireccion(idDir);
        if (direccion != null) {
            this.idestado = direccion.getAsentamiento().getMunicipio().getEstado().getId();
            this.idmunicipio = direccion.getAsentamiento().getMunicipio().getId();
            this.idasentamiento = direccion.getAsentamiento().getId();
            this.iddireccion = idDir;
            this.nombre = direccion.getNombre();
            this.referencias = direccion.getReferencias();
        }
        return "/direccion/direccionForm?faces-redirect=true";
    }

    public String actualizarEstatusDireccion(Integer id, Integer estatus) {
        direccionModel.actualizaEstatusDireccion(id, estatus);
        return "/direccion/lista?faces-redirect=true";
    }

    public String actualizar() {
        //Obtiene direccion y despues reemplaza
        Asentamiento asentamientoBD = null;
        Direccion direccionBD = null;
        try {
            if (direccionModel != null && asentamientoModel != null) {
                direccionBD = direccionModel.cargaDireccion(this.iddireccion);
                if (direccionBD != null) {
                    asentamientoBD = asentamientoModel.cargaAsentamiento(idasentamiento);
                    if (asentamientoBD != null) {
                        if (direccionBD.getAsentamiento().getId() != asentamientoBD.getId()) {
                            direccionBD.setAsentamiento(asentamientoBD);
                        }
                        direccionBD.setNombre(nombre);
                        direccionBD.setReferencias(referencias);
                        direccionModel.actualizaDireccion(direccionBD);
                    } else {
                        throw new IllegalStateException("No existe el asentamiento para actualizar");
                    }
                }
            } else {
                throw new IllegalStateException("No existe la direccion para actualizar");
            }
            messageBean.setMensajeRespuesta("Se actualiza direccion");
        } catch (Exception ex) {
            messageBean.setMensajeRespuesta(ex.getMessage());
        }
        return "/direccion/direccionForm?faces-redirect=true";
    }

    public String insertar() {
        //Preparar direccion
        Asentamiento asentamiento = null;
        Direccion direccion = null;
        try {
            if (direccionModel != null && asentamientoModel != null) {
                direccion = new Direccion(nombre, referencias, new Date(), null, 10);
                asentamiento = asentamientoModel.cargaAsentamiento(idasentamiento);
                if (asentamiento != null) {
                    direccion.setAsentamiento(asentamiento);
                } else {
                    throw new IllegalStateException("No existe el asentamiento para insertar");
                }
                direccion = direccionModel.insertaDireccion(direccion);
                iddireccion = direccion.getIddireccion();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "/direccion/direccionForm?faces-redirect=true";
    }

    public void limpiaCampos() {
        idestado = null;
        idmunicipio = null;
        iddireccion = null;
        nombre = null;
        referencias = null;
    }

    public Integer getIdestado() {
        return idestado;
    }

    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
    }

    public Integer getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(Integer idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public Integer getIdasentamiento() {
        return idasentamiento;
    }

    public void setIdasentamiento(Integer idasentamiento) {
        this.idasentamiento = idasentamiento;
    }

    public Integer getIddireccion() {
        return iddireccion;
    }

    public void setIddireccion(Integer iddireccion) {
        this.iddireccion = iddireccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

}
