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
 * Clase Usuario
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 07/10/2021 - 20/11/2021
 *
 */
@Entity
@Table(name = "tr_turno_empleado_transporte")
public class Empleadoturno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno_empleado_transporte")
    private Integer id; // Identificador de registro del empleado a un turno y transporte

    @OneToOne
    @JoinColumn(name = "id_turno", referencedColumnName = "id_turno")
    private Turno turno; // Turno asignado al empleado

    @OneToOne
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    private Empleado empleado; // Empleado asignado al turno

    @OneToOne
    @JoinColumn(name = "id_transporte", referencedColumnName = "id_transporte")
    private Transporte transporte; // Transporte asignado al empleado

    @Column(name = "turno_emp_trans_dt_fecha_entrada")
    private Date fecreg; // Fecha de registro

    @Column(name = "turno_emp_trans_dt_fecha_salida")
    private Date fecact; // Fecha de actualizacion

    @Column(name = "turno_emp_trans_si_estatus")
    private Integer estatus; // Estado del registro

    public Integer getId() {
        return id;
    }

    public Turno getTurno() {
        return turno;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Transporte getTransporte() {
        return transporte;
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

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
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
        return "Empleadoturno{" + "id=" + id + ", turno=" + turno + ", empleado=" + empleado + ", transporte=" + transporte + ", fecreg=" + fecreg + ", fecact=" + fecact + ", estatus=" + estatus + '}';
    }

}
