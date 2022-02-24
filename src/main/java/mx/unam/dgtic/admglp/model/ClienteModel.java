package mx.unam.dgtic.admglp.model;

import java.util.Date;

/**
 * Clase Cliente
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.0
 * @since 16/02/2022 - 16/02/2022
 *
 */
public class ClienteModel {

    private Integer id;
    private Integer numerocliente;
    private Date fecreg;
    private Date fecact;
    private Integer estatus;

    public Integer getId() {
        return id;
    }

    public Integer getNumerocliente() {
        return numerocliente;
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

    public void setNumerocliente(Integer numerocliente) {
        this.numerocliente = numerocliente;
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
        return "Cliente{" + "id=" + id + ", numerocliente=" + numerocliente + ", fecreg=" + fecreg + ", fecact=" + fecact + ", estatus=" + estatus + '}';
    }
}
