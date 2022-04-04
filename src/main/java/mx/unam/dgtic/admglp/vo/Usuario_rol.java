package mx.unam.dgtic.admglp.vo;

import java.util.Date;

/**
 * Clase que hace match de una tabla intermedia entre usuario y rol
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.0
 * @since 20/11/2021 - 20/11/2021
 *
 */
public class Usuario_rol {

    private Integer idusuariorol;
    private Rol rol;
    private Usuario usuarioModel;
    private Date fecreg; // Fecha de registro
    private Date fecact; // Fecha de actualizacion
    private Integer estatus;

    public Usuario_rol() {
    }

    public Usuario_rol(Integer idusuariorol, Rol rol, Usuario usuarioModel, Date fecreg, Date fecact, Integer estatus) {
        this.idusuariorol = idusuariorol;
        this.rol = rol;
        this.usuarioModel = usuarioModel;
        this.fecreg = fecreg;
        this.fecact = fecact;
        this.estatus = estatus;
    }

    public Usuario_rol(Rol rol, Usuario usuarioModel, Date fecreg, Date fecact, Integer estatus) {
        this.rol = rol;
        this.usuarioModel = usuarioModel;
        this.fecreg = fecreg;
        this.fecact = fecact;
        this.estatus = estatus;
    }

    public Integer getIdusuariorol() {
        return idusuariorol;
    }

    public Rol getRol() {
        return rol;
    }

    public Usuario getUsuarioModel() {
        return usuarioModel;
    }

    public void setUsuarioModel(Usuario usuarioModel) {
        this.usuarioModel = usuarioModel;
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

    public void setIdusuariorol(Integer idusuariorol) {
        this.idusuariorol = idusuariorol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
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
        return "Usuario_rolModel{" + "idusuariorol=" + idusuariorol + ", rol=" + rol + ", usuarioModel=" + usuarioModel + ", fecreg=" + fecreg + ", fecact=" + fecact + ", estatus=" + estatus + '}';
    }
}
