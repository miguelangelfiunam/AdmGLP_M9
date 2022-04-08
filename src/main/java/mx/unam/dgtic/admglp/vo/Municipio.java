package mx.unam.dgtic.admglp.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author unam
 */
@Entity
@Table(name = "c_municipio")
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_municipio")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    private Estado estado;

    @OneToMany(mappedBy = "municipio")
    private Collection<Asentamiento> asentamientos = new ArrayList<Asentamiento>();

    @Column(name = "municipio_c_clave")
    private String clave;

    @Column(name = "municipio_vc_nombre")
    private String nombre;

    @Column(name = "municipio_dt_fecha_registro")
    private Date fecreg; // Fecha de registro

    @Column(name = "municipio_dt_fecha_actualizacion")
    private Date fecact; // Fecha de actualizacion

    @Column(name = "municipio_si_estado")
    private Integer estatus; // Estatus del registro en la base

    public Municipio() {
    }

    public Municipio(String clave, String nombre, Date fecreg, Date fecact, Integer estatus) {
        this.clave = clave;
        this.nombre = nombre;
        this.fecreg = fecreg;
        this.fecact = fecact;
        this.estatus = estatus;
    }

    public Municipio(Estado estado, String clave, String nombre, Date fecreg, Date fecact, Integer estatus) {
        this.estado = estado;
        this.clave = clave;
        this.nombre = nombre;
        this.fecreg = fecreg;
        this.fecact = fecact;
        this.estatus = estatus;
    }

    public Integer getId() {
        return id;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
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

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Collection<Asentamiento> getAsentamientos() {
        return asentamientos;
    }
    

    @Override
    public String toString() {
        return "Municipio{" + "id=" + id + ", estado=" + estado + ", clave=" + clave + ", nombre=" + nombre + ", fecreg=" + fecreg + ", fecact=" + fecact + ", estatus=" + estatus + '}';
    }

}
