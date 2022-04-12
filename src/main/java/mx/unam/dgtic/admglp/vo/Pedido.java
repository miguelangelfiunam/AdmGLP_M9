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
 * Clase Pedido
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 11/04/2022 - 11/04/2022
 *
 */
@Entity
@Table(name = "t_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer id; // Identificador de pedido

    @OneToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente; // Cliente que realiza el pedido

    @OneToOne
    @JoinColumn(name = "id_direccion", referencedColumnName = "id_direccion")
    private Direccion direccion; // Direccion a donde dejar el pedido

    @Column(name = "pedido_d_total")
    private Double total; // Total del pedido

    @Column(name = "pedido_dt_fecha_pedido")
    private Date fecpedido; // Fecha en que se realiza el pedido

    @Column(name = "pedido_dt_fecha_entrega")
    private Date fecentrega; // Fecha de entrega del pedido

    @Column(name = "pedido_i_tipo_pago")
    private Integer pago; // Tipo de pago

    @Column(name = "pedido_dt_fecha_registro")
    private Date fecreg; // Fecha de registro

    @Column(name = "pedido_dt_fecha_actualizacion")
    private Date fecact; // Fecha de actualizacion

    @Column(name = "pedido_vc_observacion")
    private String observacion; // Observaciones al pedido

    @Column(name = "pedido_si_estatus")
    private Integer estatus; // Estado del pedido

    public Integer getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Double getTotal() {
        return total;
    }

    public Date getFecpedido() {
        return fecpedido;
    }

    public Date getFecentrega() {
        return fecentrega;
    }

    public Integer getPago() {
        return pago;
    }

    public Date getFecreg() {
        return fecreg;
    }

    public Date getFecact() {
        return fecact;
    }

    public String getObservacion() {
        return observacion;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setFecpedido(Date fecpedido) {
        this.fecpedido = fecpedido;
    }

    public void setFecentrega(Date fecentrega) {
        this.fecentrega = fecentrega;
    }

    public void setPago(Integer pago) {
        this.pago = pago;
    }

    public void setFecreg(Date fecreg) {
        this.fecreg = fecreg;
    }

    public void setFecact(Date fecact) {
        this.fecact = fecact;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", cliente=" + cliente + ", direccion=" + direccion + ", total=" + total + ", fecpedido=" + fecpedido + ", fecentrega=" + fecentrega + ", pago=" + pago + ", fecreg=" + fecreg + ", fecact=" + fecact + ", observacion=" + observacion + ", estatus=" + estatus + '}';
    }

}
