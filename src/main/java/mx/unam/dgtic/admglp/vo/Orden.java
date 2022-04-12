package mx.unam.dgtic.admglp.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;

/**
 * Clase Orden
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

    @OneToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    private Pedido pedido;

    @OneToOne
    @JoinColumn(name = "id_articulo", referencedColumnName = "id_articulo")
    private Articulo articulo;

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
