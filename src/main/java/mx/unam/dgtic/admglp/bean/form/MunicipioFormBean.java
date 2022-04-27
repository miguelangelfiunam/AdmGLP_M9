package mx.unam.dgtic.admglp.bean.form;

import mx.unam.dgtic.admglp.bean.model.MunicipioModel;
import mx.unam.dgtic.admglp.bean.model.EstadoModel;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import mx.unam.dgtic.admglp.mensajes.MessageBean;
import mx.unam.dgtic.admglp.vo.Estado;
import mx.unam.dgtic.admglp.vo.Municipio;

/**
 * Bean con la informacion del municipio a mostrar en la vista
 *
 * @author unam
 */
@Named
@SessionScoped
public class MunicipioFormBean implements Serializable {

    private static final long serialVersionUID = -4146681491856848089L;
    private Integer idestado;
    private Integer idmunicipio;
    private String clave;
    private String nombre;

    @Inject
    private MunicipioModel municipioModel;
    @Inject
    private EstadoModel estadoModel;

    @Inject
    private MessageBean messageBean;

    public String formularioMunicipio() {
        idestado = null;
        idmunicipio = null;
        clave = null;
        nombre = null;
        return "/municipio/municipioForm?faces-redirect=true";
    }

    public String formularioMunicipioID(Integer idMun) {
        Municipio municipio = municipioModel.cargaMunicipio(idMun);
        if (municipio != null) {
            this.idestado = municipio.getEstado().getId();
            this.idmunicipio = idMun;
            this.clave = municipio.getClave();
            this.nombre = municipio.getNombre();
        }
        return "/municipio/municipioForm?faces-redirect=true";
    }

    public String actualizarEstatusMunicipio(Integer id, Integer estatus) {
        municipioModel.actualizaEstatusMunicipio(id, estatus);
        return "/municipio/lista?faces-redirect=true";
    }

    public String actualizar() {
        //Obtiene municipio y despues reemplaza
        Estado estadoBD = null;
        Municipio municipioBD = null;
        try {
            if (municipioModel != null && estadoModel != null) {
                municipioBD = municipioModel.cargaMunicipio(this.idmunicipio);
                if (municipioBD != null) {
                    estadoBD = estadoModel.cargaEstado(idestado);
                    if (estadoBD != null) {
                        if (municipioBD.getEstado().getId() != estadoBD.getId()) {
                            municipioBD.setEstado(estadoBD);
                        }
                        //Buscar Asentamiento por id
                        municipioBD.setNombre(nombre);
                        municipioBD.setClave(clave);
                        municipioModel.actualizaMunicipio(municipioBD);
                    } else {
                        throw new IllegalStateException("No existe el estado para actualizar");
                    }
                }
            } else {
                throw new IllegalStateException("No existe el municipio para actualizar");
            }
            messageBean.setMensajeRespuesta("Se actualiza municipio");
        } catch (Exception ex) {
            messageBean.setMensajeRespuesta(ex.getMessage());
        }
        return "/municipio/municipioForm?faces-redirect=true";
    }

    public String insertar() {
        //Preparar municipio
        Estado estado = null;
        Municipio municipio = null;
        try {
            if (municipioModel != null && estadoModel != null) {
                municipio = new Municipio(clave, nombre, new Date(), null, 10);
                estado = estadoModel.cargaEstado(idestado);
                if (estado != null) {
                    municipio.setEstado(estado);
                } else {
                    throw new IllegalStateException("No existe el estado para insertar");
                }
                municipio = municipioModel.insertaMunicipio(municipio);
                idmunicipio = municipio.getId();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "/municipio/municipioForm?faces-redirect=true";
    }

    public void limpiaCampos() {
        idestado = null;
        idmunicipio = null;
        clave = null;
        nombre = null;
    }

    public Integer getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(Integer idmunicipio) {
        this.idmunicipio = idmunicipio;
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

}
