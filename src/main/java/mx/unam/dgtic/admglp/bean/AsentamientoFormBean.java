package mx.unam.dgtic.admglp.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import mx.unam.dgtic.admglp.mensajes.MessageBean;
import mx.unam.dgtic.admglp.vo.Asentamiento;
import mx.unam.dgtic.admglp.vo.Municipio;

/**
 * Bean con la informacion del asentamiento a mostrar en la vista
 *
 * @author unam
 */
@Named
@SessionScoped
public class AsentamientoFormBean implements Serializable {

    private static final long serialVersionUID = -4146681491856848089L;
    private Integer idestado;
    private Integer idmunicipio;
    private Integer idasentamiento;
    private String clave;
    private String codigopostal;
    private String tipo;
    private String nombre;
    @Inject
    private EstadoModel estadoModel;
    @Inject
    private MunicipioModel municipioModel;
    @Inject
    private AsentamientoModel asentamientoModel;

    @Inject
    private MessageBean messageBean;

    public String formularioAsentamiento() {
        idestado = null;
        idmunicipio = null;
        idasentamiento = null;
        clave = null;
        codigopostal = null;
        tipo = null;
        nombre = null;
        return "/asentamiento/asentamientoForm?faces-redirect=true";
    }

    public String formularioAsentamientoID(Integer idAse) {
        Asentamiento asentamiento = asentamientoModel.cargaAsentamiento(idAse);
        if (asentamiento != null) {
            this.idestado = asentamiento.getMunicipio().getEstado().getId();
            this.idmunicipio = asentamiento.getMunicipio().getId();
            this.idasentamiento = idAse;
            this.clave = asentamiento.getClave();
            this.codigopostal = asentamiento.getCodigoPostal();
            this.tipo = asentamiento.getTipo();
            this.nombre = asentamiento.getNombre();
        }
        return "/asentamiento/asentamientoForm?faces-redirect=true";
    }

    public String actualizarEstatusAsentamiento(Integer id, Integer estatus) {
        asentamientoModel.actualizaEstatusAsentamiento(id, estatus);
        return "/asentamiento/lista?faces-redirect=true";
    }

    public String actualizar() {
        //Obtiene asentamiento y despues reemplaza
        Municipio municipioBD = null;
        Asentamiento asentamientoBD = null;
        try {
            if (asentamientoModel != null && municipioModel != null) {
                asentamientoBD = asentamientoModel.cargaAsentamiento(this.idasentamiento);
                if (asentamientoBD != null) {
                    municipioBD = municipioModel.cargaMunicipio(idmunicipio);
                    if (municipioBD != null) {
                        if (asentamientoBD.getMunicipio().getId() != municipioBD.getId()) {
                            asentamientoBD.setMunicipio(municipioBD);
                        }
                        asentamientoBD.setClave(clave);
                        asentamientoBD.setCodigoPostal(codigopostal);
                        asentamientoBD.setTipo(tipo);
                        asentamientoBD.setNombre(nombre);
                        asentamientoModel.actualizaAsentamiento(asentamientoBD);
                    } else {
                        throw new IllegalStateException("No existe el estado para actualizar");
                    }
                }
            } else {
                throw new IllegalStateException("No existe el asentamiento para actualizar");
            }
            messageBean.setMensajeRespuesta("Se actualiza asentamiento");
        } catch (Exception ex) {
            messageBean.setMensajeRespuesta(ex.getMessage());
        }
        return "/asentamiento/asentamientoForm?faces-redirect=true";
    }

    public String insertar() {
        //Preparar asentamiento
        Municipio municipio = null;
        Asentamiento asentamiento = null;
        try {
            if (asentamientoModel != null && municipioModel != null) {
                asentamiento = new Asentamiento(clave,codigopostal,tipo, nombre, new Date(), null, 10);
                municipio = municipioModel.cargaMunicipio(idmunicipio);
                if (municipio != null) {
                    asentamiento.setMunicipio(municipio);
                } else {
                    throw new IllegalStateException("No existe el municipio para insertar");
                }
                asentamiento = asentamientoModel.insertaAsentamiento(asentamiento);
                idasentamiento = asentamiento.getId();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "/asentamiento/asentamientoForm?faces-redirect=true";
    }

    public void limpiaCampos() {
        idestado = null;
        idmunicipio = null;
        idasentamiento = null;
        clave = null;
        codigopostal = null;
        tipo = null;
        nombre = null;
    }

    public Integer getIdasentamiento() {
        return idasentamiento;
    }

    public void setIdasentamiento(Integer idasentamiento) {
        this.idasentamiento = idasentamiento;
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

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
