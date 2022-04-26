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
 * Entidad EmpleadoPedido con relacion a esa dos entidades
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 11/04/2022 - 26/04/2022
 *
 */
@Entity
@Table(name = "tr_empleado_pedido")
public class Empleadopedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado_pedido")
    private Integer id; // Identificador de empleado relacionado al pedido

    @ManyToOne
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    private Empleado empleado; // Empleado relacionado al pedido

    @ManyToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    private Pedido pedido; // Pedido relacionado al empleado

    @Column(name = "emp_ped_dt_fecha_registro")
    private Date fecreg; // Fecha de registro

    @Column(name = "emp_ped_dt_fecha_actualizacion")
    private Date fecact; // Fecha de actualizacion

    @Column(name = "emp_ped_si_estatus")
    private Integer estatus; // Estado de la asignacion de pedido al empleado

    public Integer getId() {
        return id;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Pedido getPedido() {
        return pedido;
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

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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
        return "Empleadopedido{" + "id=" + id + ", empleado=" + empleado + ", pedido=" + pedido + ", fecreg=" + fecreg + ", fecact=" + fecact + ", estatus=" + estatus + '}';
    }

}
