package mx.unam.dgtic.admglp.vo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;

/**
 * Clase Contra donde se guardaran la contrase�a del usuario cifrada
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.0
 * @since 21/11/2021 - 21/11/2021
 *
 */
@Entity
@Table(name = "t_contra")
public class Contra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contra")
    private Integer id;

    @Column(name = "contra_vc_contra_cifrado")
    private String contra;

    @Column(name = "contra_dt_fecha_registro")
    private Date fecreg; // Fecha de registro

    @Column(name = "contra_dt_fecha_actualizacion")
    private Date fecact; // Fecha de actualizacion

    @Column(name = "contra_si_estatus")
    private Integer estatus; // Estatus del registro en la base
    
    @OneToOne(mappedBy="contra", cascade = CascadeType.ALL)
    private Usuario usuario;

    public Contra(Integer id) {
        this.id = id;
    }

    public Contra() {
    }

    public Contra(Integer id, String contra, Date fecreg, Date fecact, Integer estatus) {
        this.id = id;
        this.contra = contra;
        this.fecreg = fecreg;
        this.fecact = fecact;
        this.estatus = estatus;
    }

    public Contra(String contra, Date fecreg, Date fecact, Integer estatus) {
        this.contra = contra;
        this.fecreg = fecreg;
        this.fecact = fecact;
        this.estatus = estatus;
    }

    public Integer getId() {
        return id;
    }

    public String getContra() {
        return contra;
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

    public void setContra(String contra) {
        this.contra = contra;
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
        return "Contra{" + "id=" + id + ", contra=" + contra + ", fecreg=" + fecreg + ", fecact=" + fecact + ", estatus=" + estatus + '}';
    }

}
