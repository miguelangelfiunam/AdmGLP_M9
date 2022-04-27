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
@Table(name = "c_estatus")
public class Estatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estatus")
    private Integer id; // Identificador de estado

    @Column(name = "estatus_si_num_estatus")
    private Integer numero; // Clave de estado

    @Column(name = "estatus_vc_nom_tabla")
    private String tabla; // Nombre del estado

    @Column(name = "estatus_vc_nombre_estatus")
    private String nombre; // Nombre del estado

    @Column(name = "estatus_vc_descripcion")
    private String descripcion; // Nombre del estado

    @Column(name = "estatus_dt_fecha_registro")
    private Date fecreg; // Fecha de registro

    @Column(name = "estatus_dt_fecha_actualizacion")
    private Date fecact; // Fecha de actualizacion

    @Column(name = "estatus_c_activo")
    private Integer activo; // Estatus del registro en la base

    public Estatus() {
    }

    public Estatus(Integer numero, String tabla, String nombre, String descripcion, Date fecreg, Date fecact, Integer activo) {
        this.numero = numero;
        this.tabla = tabla;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecreg = fecreg;
        this.fecact = fecact;
        this.activo = activo;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getTabla() {
        return tabla;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecreg() {
        return fecreg;
    }

    public Date getFecact() {
        return fecact;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecreg(Date fecreg) {
        this.fecreg = fecreg;
    }

    public void setFecact(Date fecact) {
        this.fecact = fecact;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Estatus{" + "id=" + id + ", numero=" + numero + ", tabla=" + tabla + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecreg=" + fecreg + ", fecact=" + fecact + ", activo=" + activo + '}';
    }

}
