package mx.unam.dgtic.admglp.bean.form;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.bean.model.ArticuloModel;
import mx.unam.dgtic.admglp.bean.model.ClienteModel;
import mx.unam.dgtic.admglp.bean.model.ComentarioModel;
import mx.unam.dgtic.admglp.bean.model.DireccionModel;
import mx.unam.dgtic.admglp.bean.model.EmpleadoModel;
import mx.unam.dgtic.admglp.bean.model.OrdenModel;
import mx.unam.dgtic.admglp.bean.model.PedidoModel;
import mx.unam.dgtic.admglp.mensajes.MessageBean;
import mx.unam.dgtic.admglp.vo.Articulo;
import mx.unam.dgtic.admglp.vo.Cliente;
import mx.unam.dgtic.admglp.vo.Comentario;
import mx.unam.dgtic.admglp.vo.Direccion;
import mx.unam.dgtic.admglp.vo.Orden;
import mx.unam.dgtic.admglp.vo.Pedido;

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
    private Integer estatusPedido;
    private String observacion;
    //Para el comentario
    private Integer idComentario;
    private Integer numeroComentario;
    private String tipoComentario = "C";
    private String comentario;
    private String mensaje;
    private List<Integer> estatusListaCliente = Arrays.asList(10, 20, 30, 40, 90);

    @Inject
    private ClienteModel clienteModel;
    @Inject
    private EmpleadoModel empleadoModel;
    @Inject
    private DireccionModel direccionModel;
    @Inject
    private PedidoModel pedidoModel;
    @Inject
    private ArticuloModel articuloModel;
    @Inject
    private OrdenModel ordenModel;
    @Inject
    private ComentarioModel comentarioModel;

    @Inject
    private MessageBean messageBean;

    public String formularioOrden(Integer idCliente, Integer idPedido) {
        if (idPedido == null) {
            limpiaCampos();
        }

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
            } else {
                Pedido pedidoBD = pedidoModel.cargaPedido(idPedido);
                //Se obtienen datos
                if (pedidoBD != null) {
                    this.idPedido = pedidoBD.getId();
                    this.idCliente = pedidoBD.getCliente().getId();
                    this.idDireccion = pedidoBD.getDireccion().getIddireccion();

                    this.tipoPago = pedidoBD.getPago();
                    this.observacion = pedidoBD.getObservacion();
                    this.total = pedidoBD.getTotal();

                    this.ordenes = new ArrayList<>();
                    this.ordenes = pedidoBD.getOrdenesP();
                    this.estatusPedido = pedidoBD.getEstatus();
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

    public String actualizarEstatusOrden(Integer idPedido, Integer estatus) {
        try {
            pedidoModel.actualizaEstatusPedido(idPedido, estatus);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "/cliente/cliente?faces-redirect=true";
    }

    public String actualizar() {
        try {
            Direccion direccionBD = direccionModel.cargaDireccion(idDireccion);
            Pedido pedidoBD = pedidoModel.cargaPedido(idPedido);
            if (pedidoBD != null) {
                pedidoBD.setDireccion(direccionBD);
                pedidoBD.setPago(tipoPago);
                pedidoBD.setTotal(total);
                pedidoBD.setObservacion(observacion);
                pedidoModel.actualizaPedido(pedidoBD);
                for (Orden orden : ordenes) {
                    orden = ordenModel.actualizaOrden(orden);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Obtiene roles y despues reemplaza
        return "/cliente/pedido?faces-redirect=true";
    }

    public String insertar() {
        try {
            Cliente clienteBD = clienteModel.cargaCliente(idCliente);
            Direccion direccionBD = direccionModel.cargaDireccion(idDireccion);
            Pedido pedido = new Pedido(cliente, direccionBD, total, new Date(), null, tipoPago, new Date(), null, observacion, 10);
            for (Orden orden : ordenes) {
                orden.setPedido(pedido);
//                orden = ordenModel.insertaOrden(orden);
            }
            pedido.setOrdenesP(ordenes);
            pedido = pedidoModel.insertaPedido(pedido);
            idPedido = pedido.getId();

//            for (Orden orden : ordenes) {
//                orden.setPedido(pedido);
////                orden = ordenModel.insertaOrden(orden);
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "/cliente/pedido?faces-redirect=true";
    }

    public void limpiaCampos() {
        mensaje = null;
        //Prte del cliente
        idCliente = null;
        //Parte de la orden
        ordenes = new ArrayList<>();
        List<Articulo> articulos = articuloModel.cargaArticulos(10);
        for (Articulo articulo : articulos) {
            Orden orden = new Orden(articulo, 0, 0d, new Date(), null, 10);
            ordenes.add(orden);
            total = 0d;
        }
        //Parte del pedido
        idPedido = null;
        tipoPago = null;
        observacion = null;
        total = 0d;
        estatusPedido = null;
    }

    public void limpiaCamposComentario() {
        mensaje = null;
        idComentario = null;
        numeroComentario = null;
        tipoComentario = "C";
        comentario = null;
    }
    
    public String insertarComentario(){
        if(this.idPedido != null){
            Pedido pedidoBD = pedidoModel.cargaPedido(idPedido);
            numeroComentario = comentarioModel.cargaSiguienteNumeroComentario(idPedido);
            Comentario comentario = new Comentario(pedidoBD, this.numeroComentario, this.comentario, this.tipoComentario, new Date(), null, 10);
            comentario = comentarioModel.insertaComentario(comentario);
        }
        comentario = null;
        
        limpiaCamposComentario();
        return "/cliente/pedido?faces-redirect=true";
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

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public Integer getNumeroComentario() {
        return numeroComentario;
    }

    public void setNumeroComentario(Integer numeroComentario) {
        this.numeroComentario = numeroComentario;
    }

    public String getTipoComentario() {
        return tipoComentario;
    }

    public void setTipoComentario(String tipoComentario) {
        this.tipoComentario = tipoComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public List<Integer> getEstatusListaCliente() {
        return estatusListaCliente;
    }

    public void setEstatusListaCliente(List<Integer> estatusListaCliente) {
        this.estatusListaCliente = estatusListaCliente;
    }

    public Integer getEstatusPedido() {
        return estatusPedido;
    }

    public void setEstatusPedido(Integer estatusPedido) {
        this.estatusPedido = estatusPedido;
    }

}
