package mx.unam.dgtic.admglp.vo;

import java.util.Date;

/**
 * Clase Empleado
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.0
 * @since 17/02/2022 - 17/02/2022
 *
 */
public class Empleado {

    private Integer id;
    private Integer numtrab;
    private String numss;
    private String rfc;
    private Date fecreg;
    private Date fecact;
    private Integer estatus;
    
    public Integer getId() {
        return id;
    }

    public Integer getNumtrab() {
        return numtrab;
    }

    public String getNumss() {
        return numss;
    }

    public String getRfc() {
        return rfc;
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

    public void setNumtrab(Integer numtrab) {
        this.numtrab = numtrab;
    }

    public void setNumss(String numss) {
        this.numss = numss;
    }

    public void setFecreg(Date fecreg) {
        this.fecreg = fecreg;
    }

    public void setFecact(Date fecact) {
        this.fecact = fecact;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", numtrab=" + numtrab + ", numss=" + numss + ", rfc=" + rfc + ", fecreg=" + fecreg + ", fecact=" + fecact + ", estatus=" + estatus + '}';
    }
}
