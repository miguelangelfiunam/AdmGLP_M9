package mx.unam.dgtic.admglp.vo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * Entidad Pedido donde se realiza la creación y entrega de pedidos
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 11/04/2022 - 26/04/2022
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

    @JoinTable(
        name = "tr_empleado_pedido",
        joinColumns = @JoinColumn(name = "id_pedido", nullable = false),
        inverseJoinColumns = @JoinColumn(name="id_empleado", nullable = false)
    )
    @ManyToMany
    private List<Empleado> empleados; // Empleados relacionados al pedido

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.PERSIST)
    private List<Orden> ordenesP; // Ordenes relacionadas al pedido
    
    @OneToMany(mappedBy = "pedido")
    private List<Comentario> comentarios; // Ordenes relacionadas al pedido

    public Pedido() {
    }

    public Pedido(Cliente cliente, Direccion direccion, Double total, Date fecpedido, Date fecentrega, Integer pago, Date fecreg, Date fecact, String observacion, Integer estatus) {
        this.cliente = cliente;
        this.direccion = direccion;
        this.total = total;
        this.fecpedido = fecpedido;
        this.fecentrega = fecentrega;
        this.pago = pago;
        this.fecreg = fecreg;
        this.fecact = fecact;
        this.observacion = observacion;
        this.estatus = estatus;
    } 

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

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public List<Orden> getOrdenesP() {
        return ordenesP;
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

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void setOrdenesP(List<Orden> ordenesP) {
        this.ordenesP = ordenesP;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", total=" + total + ", fecpedido=" + fecpedido + ", fecentrega=" + fecentrega + ", pago=" + pago + ", fecreg=" + fecreg + ", fecact=" + fecact + ", observacion=" + observacion + ", estatus=" + estatus + '}';
    }

}
