package mx.unam.dgtic.admglp.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

/**
 * Entidad Transporte para mostrar las unidades disponibles para entrega de pedidos
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 11/04/2022 - 26/04/2022
 *
 */
@Entity
@Table(name = "c_transporte")
public class Transporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transporte")
    private Integer id; // Identificador de transporte

    @Column(name = "trans_i_numero_unidad")
    private Integer numeroUnidad; // Numero de la unidad

    @Column(name = "trans_i_modelo")
    private Integer modelo; // Modelo de la unidad

    @Column(name = "trans_vc_placas")
    private String placas; // Placas de la unidad

    @Column(name = "trans_vc_marca")
    @Enumerated(EnumType.STRING)
    private TransporteMarca marca; //Marca del transporte

    @Column(name = "trans_dt_fecha_registro")
    private Date fecreg; // Fecha de registro

    @Column(name = "trans_dt_fecha_actualizacion")
    private Date fecact; // Fecha de actualizacion

    @Column(name = "trans_si_estatus")
    private Integer estatus; // Estado del transporte

    public Transporte() {
    }

    public Transporte(Integer numeroUnidad, Integer modelo, String placas, TransporteMarca marca, Date fecreg, Date fecact, Integer estatus) {
        this.numeroUnidad = numeroUnidad;
        this.modelo = modelo;
        this.placas = placas;
        this.marca = marca;
        this.fecreg = fecreg;
        this.fecact = fecact;
        this.estatus = estatus;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumeroUnidad() {
        return numeroUnidad;
    }

    public Integer getModelo() {
        return modelo;
    }

    public String getPlacas() {
        return placas;
    }

    public TransporteMarca getMarca() {
        return marca;
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

    public void setNumeroUnidad(Integer numeroUnidad) {
        this.numeroUnidad = numeroUnidad;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public void setMarca(TransporteMarca marca) {
        this.marca = marca;
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
        return "Transporte{" + "id=" + id + ", numeroUnidad=" + numeroUnidad + ", modelo=" + modelo + ", placas=" + placas + ", marca=" + marca + ", fecreg=" + fecreg + ", fecact=" + fecact + ", estatus=" + estatus + '}';
    }

}
