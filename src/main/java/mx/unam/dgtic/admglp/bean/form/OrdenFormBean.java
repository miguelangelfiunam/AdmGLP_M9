package mx.unam.dgtic.admglp.bean.form;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.bean.model.ArticuloModel;
import mx.unam.dgtic.admglp.bean.model.ClienteModel;
import mx.unam.dgtic.admglp.mensajes.MessageBean;
import mx.unam.dgtic.admglp.vo.Articulo;
import mx.unam.dgtic.admglp.vo.Cliente;
import mx.unam.dgtic.admglp.vo.Orden;

/**
 * Bean con la informacion del orden a mostrar en la vista
 *
 * @author unam
 */
@Named
@SessionScoped
public class OrdenFormBean implements Serializable {

    private static final long serialVersionUID = -4146681491856848089L;
    //Parte del cliente
    private Integer idCliente;
    private Integer idDireccion;
    private Cliente cliente;
    //Parte de la orden
    private List<Orden> ordenes;
    //Parte del pedido
    private Integer idPedido;
    private Double total;
    private Integer tipoPago;
    private String observacion;
    private String mensaje;

    @Inject
    private ArticuloModel articuloModel;
//    @Inject
//    private PedidoModel pedidoModel;
    @Inject
    private ClienteModel clienteModel;

    @Inject
    private MessageBean messageBean;

    public String formularioOrden(Integer idCliente, Integer idPedido) {
        limpiaCampos();
        cliente = clienteModel.cargaCliente(idCliente);
        if (cliente != null) {
            this.idCliente = idCliente;
            if (idPedido == null) {
                ordenes = new ArrayList<>();
                List<Articulo> articulos = articuloModel.cargaArticulos(10);
                for (Articulo articulo : articulos) {
                    Orden orden = new Orden(articulo, 0, 0d, new Date(), null, 10);
                    ordenes.add(orden);
                    total = 0d;
                }
            }
        } else {
            this.mensaje = "No existe un cliente como tal, si lo requiere inicie sesión nuevamente";
        }

        return "/cliente/pedido?faces-redirect=true";
    }

    public void actualizaOrden() {
        total = 0d;
        for (Orden orden : ordenes) {
            Double precio = orden.getArticulo().getPrecio();
            Integer cantidad = orden.getCantidad();
            Double subtotal = precio * cantidad;
            orden.setSubtotal(subtotal);
            total += subtotal;
        }
    }

    public String actualizarEstatusOrden(Integer id, Integer estatus) {
        try {

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "/cliente/pedido?faces-redirect=true";
    }

    public String actualizar() {
        try {

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Obtiene roles y despues reemplaza
        return "/cliente/pedido?faces-redirect=true";
    }

    public String insertar() {
        try {

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "/orden/lista?faces-redirect=true";
    }

    public void limpiaCampos() {
        mensaje = null;
        //Prte del cliente
        idCliente = null;
        //Parte de la orden
        ordenes = new ArrayList<>();
        //Parte del pedido
        idPedido = null;
        tipoPago = null;
        observacion = null;
        total = 0d;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(Integer tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

}
