package mx.unam.dgtic.admglp.vo;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
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
 * Entidad Cliente donde se obtiene la informacion de las personas que son
 * clientes
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.0
 * @since 16/02/2022 - 26/04/2022
 *
 */
@Entity
@Table(name = "c_cliente")
@Access(AccessType.FIELD)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id; // Identificador unico de cliente

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario; // Usuario relacionado al cliente

    @Column(name = "cliente_i_numero")
    private Integer numerocliente; // Numero unico de cliente

    @Column(name = "cliente_dt_fecha_registro")
    private Date fecreg; // Fecha de registro

    @Column(name = "cliente_dt_fecha_actualizacion")
    private Date fecact; // Fecha de actualizacion

    @Column(name = "cliente_si_estatus")
    private Integer estatus; // Estado del cliente

    @JoinTable(
            name = "tr_cliente_direccion",
            joinColumns = @JoinColumn(name = "id_cliente", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_direccion", nullable = false)
    )
    @ManyToMany
    private List<Direccion> direcciones;

    public Cliente() {
    }

    public Cliente(Usuario usuario, Integer numerocliente, Date fecreg, Date fecact, Integer estatus) {
        this.usuario = usuario;
        this.numerocliente = numerocliente;
        this.fecreg = fecreg;
        this.fecact = fecact;
        this.estatus = estatus;
    }

    public Cliente(Usuario usuario, Integer numerocliente, Date fecreg, Date fecact, Integer estatus, List<Direccion> direcciones) {
        this.usuario = usuario;
        this.numerocliente = numerocliente;
        this.fecreg = fecreg;
        this.fecact = fecact;
        this.estatus = estatus;
        this.direcciones = direcciones;
    }

    public Integer getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Integer getNumerocliente() {
        return numerocliente;
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

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setNumerocliente(Integer numerocliente) {
        this.numerocliente = numerocliente;
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

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", usuario=" + usuario + ", numerocliente=" + numerocliente + ", fecreg=" + fecreg + ", fecact=" + fecact + ", estatus=" + estatus + '}';
    }

}
