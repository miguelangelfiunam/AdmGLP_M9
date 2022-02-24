package mx.unam.dgtic.admglp.model;

import java.util.Date;

/**
 * Clase Contra donde se guardaran la contrase�a del usuario cifrada
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.0
 * @since 21/11/2021 - 21/11/2021
 *
 */
public class ContraModel {

    private Integer id;
    private String contra;
    private Date fecreg; // Fecha de registro
    private Date fecact; // Fecha de actualizacion
    private Integer estatus; // Estatus del registro en la base

    public ContraModel(Integer id, String contra, Date fecreg, Date fecact, Integer estatus) {
        this.id = id;
        this.contra = contra;
        this.fecreg = fecreg;
        this.fecact = fecact;
        this.estatus = estatus;
    }

    public ContraModel(String contra, Date fecreg, Date fecact, Integer estatus) {
        this.contra = contra;
        this.fecreg = fecreg;
        this.fecact = fecact;
        this.estatus = estatus;
    }

    public ContraModel() {
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
