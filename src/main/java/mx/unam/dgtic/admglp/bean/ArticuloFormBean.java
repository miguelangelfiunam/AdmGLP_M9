package mx.unam.dgtic.admglp.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import mx.unam.dgtic.admglp.mensajes.MessageBean;
import mx.unam.dgtic.admglp.vo.Articulo;

/**
 * Bean con la informacion del articulo a mostrar en la vista
 *
 * @author unam
 */
@Named
@SessionScoped
public class ArticuloFormBean implements Serializable {

    private static final long serialVersionUID = -4146681491856848089L;
    private Integer idarticulo;
    private String nombre;
    private Double precio;
    private Date actualizacion;

    @Inject
    private ArticuloModel articuloModel;

    @Inject
    private MessageBean messageBean;

    public String formularioArticulo() {
        idarticulo = null;
        nombre = null;
        precio = null;
        actualizacion = null;
        return "/articulo/articuloForm?faces-redirect=true";
    }

    public String formularioArticuloID(Integer idArt) {
        Articulo articulo = articuloModel.cargaArticulo(idArt);
        if (articulo != null) {
            this.idarticulo = idArt;
            this.nombre = articulo.getNombre();
            this.precio = articulo.getPrecio();
            this.actualizacion = articulo.getFecact();
        }
        return "/articulo/articuloForm?faces-redirect=true";
    }

    public String actualizarEstatusArticulo(Integer id, Integer estatus) {
        articuloModel.actualizaEstatusArticulo(id, estatus);
        return "/articulo/lista?faces-redirect=true";
    }

    public String actualizar() {
        //Obtiene articulo y despues reemplaza
        Articulo articuloBD = null;
        try {
            if (articuloModel != null) {
                articuloBD = articuloModel.cargaArticulo(this.idarticulo);
                if (articuloBD != null) {
                    //Buscar Asentamiento por id
                    articuloBD.setNombre(nombre);
                    articuloBD.setPrecio(precio);
                    articuloBD = articuloModel.actualizaArticulo(articuloBD);
                }
            } else {
                throw new IllegalStateException("No existe el articulo para actualizar");
            }
            messageBean.setMensajeRespuesta("Se actualiza articulo");
        } catch (Exception ex) {
            messageBean.setMensajeRespuesta(ex.getMessage());
        }
        return "/articulo/articuloForm?faces-redirect=true";
    }

    public String insertar() {
        //Preparar articulo
        Articulo articulo = null;
        try {
            if (articuloModel != null) {
                articulo = new Articulo(nombre, precio, new Date(), null, 10);
                articulo = articuloModel.insertaArticulo(articulo);
                idarticulo = articulo.getId();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "/articulo/articuloForm?faces-redirect=true";
    }

    public void limpiaCampos() {
        idarticulo = null;
        nombre = null;
        precio = null;
        actualizacion = null;
    }

    public Integer getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(Integer idarticulo) {
        this.idarticulo = idarticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Date getActualizacion() {
        return actualizacion;
    }

    public void setActualizacion(Date actualizacion) {
        this.actualizacion = actualizacion;
    }

    
}
