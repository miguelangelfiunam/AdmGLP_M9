package mx.unam.dgtic.admglp.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

/**
 * Entidad Estado mapeada con la base de datos
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/04/2022 - 26/04/2022
 *
 */
@Entity
@Table(name = "c_estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Integer id; // Identificador de estado

    @Column(name = "estado_c_clave")
    private String clave; // Clave de estado

    @Column(name = "estado_vc_nombre")
    private String nombre; // Nombre del estado

    @Column(name = "estado_dt_fecha_registro")
    private Date fecreg; // Fecha de registro

    @Column(name = "estado_dt_fecha_actualizacion")
    private Date fecact; // Fecha de actualizacion

    @Column(name = "estado_si_estatus")
    private Integer estatus; // Estatus del registro en la base

    public Estado() {
    }

    public Estado(String clave, String nombre, Date fecreg, Date fecact, Integer estatus) {
        this.clave = clave;
        this.nombre = nombre;
        this.fecreg = fecreg;
        this.fecact = fecact;
        this.estatus = estatus;
    }

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Estado{" + "id=" + id + ", clave=" + clave + ", nombre=" + nombre + ", fecreg=" + fecreg + ", fecact=" + fecact + ", estatus=" + estatus + '}';
    }
}
