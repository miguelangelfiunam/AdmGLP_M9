package mx.unam.dgtic.admglp.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * Entidad rol que hace match con el catalogo de roles
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 20/11/2021 - 26/14/2022
 *
 */
@Entity
@Table(name = "c_rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer idrol; // Identificador del rol
    
    @Column(name = "rol_vc_nombre")
    private String nombre; // Nombre del rol
    
    @Column(name = "rol_c_tipo_rol")
    private String tipo; // Tipo del rol
    
    @Column(name = "rol_dt_fecha_registro")
    private Date fecreg; // Fecha de registro
    
    @Column(name = "rol_dt_fecha_actualizacion")
    private Date fecact; // Fecha de actualizacion
    
    @Column(name = "rol_si_estatus")
    private Integer estatus; // Estatus del registro en la base
    
    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios; // Lista de usuarios relacionados al rol

    public Rol() {
    }

    public Rol(Integer idrol) {
        this.idrol = idrol;
    }

    public Rol(Integer idrol, String nombre, String tipo, Date fecreg, Date fecact, Integer estatus) {
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

    public List<Usuario> getUsuarios() {
        return usuarios;
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

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "Rol{" + "idrol=" + idrol + ", nombre=" + nombre + ", tipo=" + tipo + ", fecreg=" + fecreg + ", fecact=" + fecact + ", estatus=" + estatus + '}';
    }
}
