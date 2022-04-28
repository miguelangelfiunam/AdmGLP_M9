package mx.unam.dgtic.admglp.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * Entidad Articulo donde se agregan los articulos a vender
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.0
 * @since 21/11/2021 - 21/11/2021
 *
 */
@Entity
@Table(name = "c_articulo")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_articulo")
    private Integer id; // Identificador unico de articulo

    @Column(name = "articulo_vc_nombre")
    private String nombre; // Nombre del articulo

    @Column(name = "articulo_d_precio_articulo")
    private Double precio; // Precio del articulo

    @Column(name = "articulo_dt_fecha_registro")
    private Date fecreg; // Fecha de registro

    @Column(name = "articulo_dt_fecha_actualizacion")
    private Date fecact; // Fecha de actualizacion

    @Column(name = "articulo_si_estatus")
    private Integer estatus; // Estatus del registro en la base

    @OneToMany(mappedBy = "articulo")
    private List<Orden> ordenesA; // Ordenes relacionadas al articulo

    public Articulo() {
    }

    public Articulo(String nombre, Double precio, Date fecreg, Date fecact, Integer estatus) {
        this.nombre = nombre;
        this.precio = precio;
        this.fecreg = fecreg;
        this.fecact = fecact;
        this.estatus = estatus;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
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

    public List<Orden> getOrdenes() {
        return ordenesA;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
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

    public void setOrdenes(List<Orden> ordenesA) {
        this.ordenesA = ordenesA;
    }

    @Override
    public String toString() {
        return "Articulo{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", fecreg=" + fecreg + ", fecact=" + fecact + ", estatus=" + estatus + '}';
    }
}
