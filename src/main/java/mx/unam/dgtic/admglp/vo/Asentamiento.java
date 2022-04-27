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
 * Entidad Asentamiento donde se obtienen los asentamientos realcionados a las
 * direcciones
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.0
 * @since 26/04/2022 - 26/04/2022
 *
 */
@Entity
@Table(name = "c_asentamiento")
public class Asentamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asentamiento")
    private Integer id; // Identificador unico de asentamiento

    @OneToOne
    @JoinColumn(name = "id_municipio", referencedColumnName = "id_municipio")
    private Municipio municipio; // Municipio relacionado al asentamiento

    @Column(name = "asenta_c_clave")
    private String clave; // Clave de asentamiento

    @Column(name = "asenta_c_codigo_postal")
    private String codigoPostal; // Codigo postal del asentamiento

    @Column(name = "asenta_vc_tipo")
    private String tipo; //Tipo de asentamiento

    @Column(name = "asenta_vc_nombre")
    private String nombre; //Nombre del asentamiento

    @Column(name = "asenta_dt_fecha_registro")
    private Date fecreg; // Fecha de registro

    @Column(name = "asenta_dt_fecha_actualizacion")
    private Date fecact; // Fecha de actualizacion

    @Column(name = "asenta_si_estatus")
    private Integer estatus; // Estatus del registro en la base

    public Asentamiento(String clave, String codigoPostal, String tipo, String nombre, Date fecreg, Date fecact, Integer estatus) {
        this.clave = clave;
        this.codigoPostal = codigoPostal;
        this.tipo = tipo;
        this.nombre = nombre;
        this.fecreg = fecreg;
        this.fecact = fecact;
        this.estatus = estatus;
    }

    public Asentamiento() {
    }

    public Integer getId() {
        return id;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public String getClave() {
        return clave;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getTipo() {
        return tipo;
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

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        return "Asentamiento{" + "id=" + id + ", municipio=" + municipio + ", clave=" + clave + ", codigoPostal=" + codigoPostal + ", tipo=" + tipo + ", nombre=" + nombre + ", fecreg=" + fecreg + ", fecact=" + fecact + ", estatus=" + estatus + '}';
    }

}
