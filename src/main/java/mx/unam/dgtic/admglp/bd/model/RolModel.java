package mx.unam.dgtic.admglp.bd.model;

import java.util.Date;

/**
 * Clase rol que hace match con el catalogo de roles
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.0
 * @since 20/11/2021 - 20/11/2021
 *
 */
public class RolModel {

    private Integer idrol; // Identificador del rol
    private String nombre; // Nombre del rol
    private String tipo; // Tipo del rol
    private Date fecreg; // Fecha de registro
    private Date fecact; // Fecha de actualizacion
    private Integer estatus; // Estatus del registro en la base

    public RolModel() {
    }

    public RolModel(Integer idrol) {
        this.idrol = idrol;
    }

    public RolModel(Integer idrol, String nombre, String tipo, Date fecreg, Date fecact, Integer estatus) {
        this.idrol = idrol;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fecreg = fecreg;
        this.fecact = fecact;
        this.estatus = estatus;
    }

    public Integer getIdrol() {
        return idrol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
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

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        return "Rol{" + "idrol=" + idrol + ", nombre=" + nombre + ", tipo=" + tipo + ", fecreg=" + fecreg + ", fecact=" + fecact + ", estatus=" + estatus + '}';
    }
}
