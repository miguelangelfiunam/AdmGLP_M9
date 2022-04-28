package mx.unam.dgtic.admglp.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;

/**
 * Entidad Orden Mapeada en la base de datos
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 11/04/2022 - 11/04/2022
 *
 */
@Entity
@Table(name = "tr_pedido_articulo")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ped_art")
    private Integer id; // Identificador de orden

    @ManyToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    private Pedido pedido; // Pedido relacionado a esa orden

    @ManyToOne
    @JoinColumn(name = "id_articulo", referencedColumnName = "id_articulo")
    private Articulo articulo; // Articulo relacionado a la orden

    @Column(name = "ped_art_ti_cantidad")
    private Integer cantidad; // Cantidad de los articulos

    @Column(name = "ped_art_d_subtotal")
    private Double subtotal; // Subtotal de los articulos

    @Column(name = "ped_art_dt_fecha_registro")
    private Date fecreg; // Fecha de registro

    @Column(name = "ped_art_dt_fecha_actualizacion")
    private Date fecact; // Fecha de actualizacion

    @Column(name = "ped_art_si_estatus")
    private Integer estatus; // Estado de la orden

    public Orden() {
    }

    public Orden(Articulo articulo, Integer cantidad, Double subtotal) {
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public Orden(Articulo articulo, Integer cantidad, Double subtotal, Date fecreg, Date fecact, Integer estatus) {
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.fecreg = fecreg;
        this.fecact = fecact;
        this.estatus = estatus;
    }

    public Integer getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public Date getFecreg() {
        return fecreg;
    }

    public Date getFecact() {
        return fecact;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public void setFecreg(Date fecreg) {
        this.fecreg = fecreg;
    }

    public void setFecact(Date fecact) {
        this.fecact = fecact;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Orden{" + "id=" + id + ", pedido=" + pedido + ", articulo=" + articulo + ", cantidad=" + cantidad + ", subtotal=" + subtotal + ", fecreg=" + fecreg + ", fecact=" + fecact + ", estatus=" + estatus + '}';
    }

}
