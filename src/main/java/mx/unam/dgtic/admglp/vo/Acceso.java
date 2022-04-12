package mx.unam.dgtic.admglp.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;

/**
 * Clase Acceso para registrar los inicios y fines de sesion de los usuarios
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.0
 * @since 11/04/2022 - 11/04/2022
 *
 */
@Entity
@Table(name = "t_acceso")
public class Acceso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_acceso")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario; // Usuario relacionado con la fecha de acceso

    @Column(name = "acceso_dt_fecha_inicio_acceso")
    private Date fecinicio; // Fecha inicio de acceso a la aplicacion

    @Column(name = "acceso_dt_fecha_fin_acceso")
    private Date fecfin; // Fecha fin de acceso a la aplicacion

    @Column(name = "acceso_descripcion")
    private String telefono2; // Descripcion del inicio de sesion caso correcto o no

    @Column(name = "acceso_dt_fecha_registro")
    private Date fecreg; // Fecha de registro en la base

    @Column(name = "acceso_dt_fecha_actualizacion")
    private Date fecact; // Fecha de actualizacion en la base

    @Column(name = "acceso_si_estatus")
    private Integer estatus; // Estado del acceso

    public Integer getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Date getFecinicio() {
        return fecinicio;
    }

    public Date getFecfin() {
        return fecfin;
    }

    public String getTelefono2() {
        return telefono2;
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

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setFecinicio(Date fecinicio) {
        this.fecinicio = fecinicio;
    }

    public void setFecfin(Date fecfin) {
        this.fecfin = fecfin;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
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
        return "Acceso{" + "id=" + id + ", usuario=" + usuario + ", fecinicio=" + fecinicio + ", fecfin=" + fecfin + ", telefono2=" + telefono2 + ", fecreg=" + fecreg + ", fecact=" + fecact + ", estatus=" + estatus + '}';
    }
}
