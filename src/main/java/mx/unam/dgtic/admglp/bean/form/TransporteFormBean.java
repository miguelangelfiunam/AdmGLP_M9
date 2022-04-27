package mx.unam.dgtic.admglp.bean.form;

import mx.unam.dgtic.admglp.bean.model.TransporteModel;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import mx.unam.dgtic.admglp.mensajes.MessageBean;
import mx.unam.dgtic.admglp.vo.Transporte;
import mx.unam.dgtic.admglp.vo.TransporteMarca;

/**
 * Bean con la informacion del transporte a mostrar en la vista
 *
 * @author unam
 */
@Named
@SessionScoped
public class TransporteFormBean implements Serializable {

    private static final long serialVersionUID = -4146681491856848089L;
    private Integer idtransporte;
    private Integer numerounidad;
    private Integer modelo;
    private String placa;
    private TransporteMarca marca;

    @Inject
    private TransporteModel transporteModel;

    @Inject
    private MessageBean messageBean;

    public String formularioTransporte() {
        idtransporte = null;
        numerounidad = null;
        modelo = null;
        placa = null;
        marca = null;
        return "/transporte/transporteForm?faces-redirect=true";
    }

    public String formularioTransporteID(Integer idTrans) {
        Transporte transporte = transporteModel.cargaTransporte(idTrans);
        if (transporte != null) {
            this.idtransporte = idTrans;
            numerounidad = transporte.getNumeroUnidad();
            modelo = transporte.getModelo();
            placa = transporte.getPlacas();
            marca = transporte.getMarca();
        }
        return "/transporte/transporteForm?faces-redirect=true";
    }

    public String actualizarEstatusTransporte(Integer id, Integer estatus) {
        transporteModel.actualizaEstatusTransporte(id, estatus);
        return "/transporte/lista?faces-redirect=true";
    }

    public String actualizar() {
        //Obtiene transporte y despues reemplaza
        Transporte transporteBD = null;
        try {
            if (transporteModel != null) {
                transporteBD = transporteModel.cargaTransporte(this.idtransporte);
                if (transporteBD != null) {
                    //Buscar Asentamiento por id
                    transporteBD.setNumeroUnidad(numerounidad);
                    transporteBD.setModelo(modelo);
                    transporteBD.setPlacas(placa);
                    transporteBD.setMarca(marca);
                    transporteBD = transporteModel.actualizaTransporte(transporteBD);
                }
            } else {
                throw new IllegalStateException("No existe el transporte para actualizar");
            }
            messageBean.setMensajeRespuesta("Se actualiza transporte");
        } catch (Exception ex) {
            messageBean.setMensajeRespuesta(ex.getMessage());
        }
        return "/transporte/transporteForm?faces-redirect=true";
    }

    public String insertar() {
        //Preparar transporte
        Transporte transporte = null;
        try {
            if (transporteModel != null) {
                transporte = new Transporte(numerounidad, modelo, placa, marca, new Date(), null, 10);
                transporte = transporteModel.insertaTransporte(transporte);
                idtransporte = transporte.getId();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "/transporte/transporteForm?faces-redirect=true";
    }

    public void limpiaCampos() {
        idtransporte = null;
        numerounidad = null;
        modelo = null;
        placa = null;
        marca = null;
    }

    public Integer getIdtransporte() {
        return idtransporte;
    }

    public void setIdtransporte(Integer idtransporte) {
        this.idtransporte = idtransporte;
    }

    public Integer getNumerounidad() {
        return numerounidad;
    }

    public void setNumerounidad(Integer numerounidad) {
        this.numerounidad = numerounidad;
    }

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public TransporteMarca getMarca() {
        return marca;
    }

    public void setMarca(TransporteMarca marca) {
        this.marca = marca;
    }

}
