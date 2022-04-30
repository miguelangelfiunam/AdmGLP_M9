package mx.unam.dgtic.admglp.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * Entidad Empleado de las personas que son empleados del sistema
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.0
 * @since 17/02/2022 - 26/04/2022
 *
 */
@Entity
@Table(name = "c_empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer id; // Identificador del empleado

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario; // Usuario relacionado al empleado

    @Column(name = "empleado_i_num_trab")
    private Integer numtrab; // Numero de trabajador

    @Column(name = "empleado_i_numero_ss")
    private String numss; // Numero de seguro social

    @Column(name = "empleado_c_rfc_trab")
    private String rfc; // RFC del trabajador

    @Column(name = "empleado_dt_fecha_registro")
    private Date fecreg; // Fecha de registro

    @Column(name = "empleado_dt_fecha_actualizacion")
    private Date fecact; // Fecha de actualizacion

    @Column(name = "empleado_si_estatus")
    private Integer estatus; // Estado del empleado

    @ManyToMany(mappedBy = "empleados")
    private List<Pedido> pedidos; // Roles relacionados al usuario

    public Empleado() {
    }

    public Empleado(Usuario usuario, Integer numtrab, String numss, String rfc, Date fecreg, Date fecact, Integer estatus) {
        this.usuario = usuario;
        this.numtrab = numtrab;
        this.numss = numss;
        this.rfc = rfc;
        this.fecreg = fecreg;
        this.fecact = fecact;
        this.estatus = estatus;
    }

    public Integer getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Integer getNumtrab() {
        return numtrab;
    }

    public String getNumss() {
        return numss;
    }

    public String getRfc() {
        return rfc;
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

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setNumtrab(Integer numtrab) {
        this.numtrab = numtrab;
    }

    public void setNumss(String numss) {
        this.numss = numss;
    }

    public void setFecreg(Date fecreg) {
        this.fecreg = fecreg;
    }

    public void setFecact(Date fecact) {
        this.fecact = fecact;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", usuario=" + usuario + ", numtrab=" + numtrab + ", numss=" + numss + ", rfc=" + rfc + ", fecreg=" + fecreg + ", fecact=" + fecact + ", estatus=" + estatus + '}';
    }

}
