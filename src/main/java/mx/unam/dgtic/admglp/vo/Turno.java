package mx.unam.dgtic.admglp.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

/**
 * Entidad Turno que registra las entradas y salidas del usuario
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 11/04/2022 - 26/04/2022
 *
 */
@Entity
@Table(name = "t_turno")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno")
    private Integer id; // Identificador de turno

    @Column(name = "turno_dt_fecha_inicio_turno")
    private Date fecinicio; // Fecha de registro

    @Column(name = "turno_dt_fecha_fin_turno")
    private Date fecfin; // Fecha de registro

    @Column(name = "turno_dt_fecha_registro")
    private Date fecreg; // Fecha de registro

    @Column(name = "turno_dt_fecha_actualizacion")
    private Date fecact; // Fecha de actualizacion

    @Column(name = "turno_si_estatus")
    private Integer estatus; // Estado del transporte

    public Turno() {
        
    }

    public Turno(Date fecinicio, Date fecfin, Date fecreg, Date fecact, Integer estatus) {
        this.fecinicio = fecinicio;
        this.fecfin = fecfin;
        this.fecreg = fecreg;
        this.fecact = fecact;
        this.estatus = estatus;
    }

    public Integer getId() {
        return id;
    }

    public Date getFecinicio() {
        return fecinicio;
    }

    public Date getFecfin() {
        return fecfin;
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

    public void setFecinicio(Date fecinicio) {
        this.fecinicio = fecinicio;
    }

    public void setFecfin(Date fecfin) {
        this.fecfin = fecfin;
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
        return "Turno{" + "id=" + id + ", fecinicio=" + fecinicio + ", fecfin=" + fecfin + ", fecreg=" + fecreg + ", fecact=" + fecact + ", estatus=" + estatus + '}';
    }
    
}
