package mx.unam.dgtic.admglp.vo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * Clase Usuario
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 07/10/2021 - 20/11/2021
 *
 */
@Entity
@Table(name = "t_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idusuario; // Identificador de usuario

    @OneToOne
    @JoinColumn(name="id_contra", referencedColumnName="id_contra")
    private Contra contra; // Contra relacionada al usuario

    @Column(name = "usuario_vc_apodo")
    private String apodo; // Seudonimo del usuario en la aplicacion

    @Column(name = "usuario_vc_correo1")
    private String correo1; // Correo electronico

    @Column(name = "usuario_vc_correo2")
    private String correo2; // Correo electronico

    @Column(name = "usuario_vc_nombre")
    private String nombre; // Nombre de la persona 100

    @Column(name = "usuario_vc_apellido1")
    private String apellido1; // Primer apellido 100

    @Column(name = "usuario_vc_apellido2")
    private String apellido2; // Segundo apellido 100

    @Column(name = "usuario_ti_edad")
    private Integer edad;// Edad de la persona

    @Column(name = "usuario_d_fec_nacimiento")
    private Date fnac; // Fecha de nacimiento

    @Column(name = "usuario_vc_telefono1")
    private String telefono1; // Telefono del usuario

    @Column(name = "usuario_vc_telefono2")
    private String telefono2; // Segundo telefono de contacto

    @Column(name = "usuario_dt_fecha_registro")
    private Date fecreg; // Fecha de Inicio de acceso a la aplicacion

    @Column(name = "usuario_dt_fecha_actualizacion")
    private Date fecact; // Fecha de fin de acceso a la aplicacion

    @Column(name = "usuario_si_estatus")
    private Integer estatus; // Estado del usuario
    
    @JoinTable(
        name = "tr_usuario_rol",
        joinColumns = @JoinColumn(name = "id_usuario", nullable = false),
        inverseJoinColumns = @JoinColumn(name="id_rol", nullable = false)
    )
    @ManyToMany
    private List<Rol> roles; // Roles relacionados al usuario
    
    @OneToOne(mappedBy="usuario", cascade = CascadeType.ALL)
    private Empleado empleado; //Empleado relacionado al usuario
    
    @OneToOne(mappedBy="usuario", cascade = CascadeType.ALL)
    private Cliente cliente; // Cliente relacionado al usuario
    
    @OneToMany(mappedBy = "usuario")
    private List<Acceso> accesos; // Accesos relacionados al usuario

    public Usuario() {
    }

    public Usuario(Contra contra, String apodo, String correo1, String correo2, String nombre, String apellido1, String apellido2, Integer edad, Date fnac, String telefono1, String telefono2, Date fecreg, Date fecact, Integer estatus) {
        this.contra = contra;
        this.apodo = apodo;
        this.correo1 = correo1;
        this.correo2 = correo2;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
        this.fnac = fnac;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.fecreg = fecreg;
        this.fecact = fecact;
        this.estatus = estatus;
    }

    public Usuario(Integer idusuario, String apodo, String correo1, String correo2, String nombre, String apellido1, String apellido2, Integer edad, Date fnac, String telefono1, String telefono2, Date fecreg, Date fecact, Integer estatus) {
        this.idusuario = idusuario;
        this.apodo = apodo;
        this.correo1 = correo1;
        this.correo2 = correo2;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
        this.fnac = fnac;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.fecreg = fecreg;
        this.fecact = fecact;
        this.estatus = estatus;
    }

    public Usuario(Contra contra, String apodo, String correo1, String correo2, String nombre, String apellido1, String apellido2, Integer edad, Date fnac, String telefono1, String telefono2, Date fecreg, Date fecact, Integer estatus, List<Rol> roles) {
        this.contra = contra;
        this.apodo = apodo;
        this.correo1 = correo1;
        this.correo2 = correo2;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
        this.fnac = fnac;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.fecreg = fecreg;
        this.fecact = fecact;
        this.estatus = estatus;
        this.roles = roles;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public Contra getContra() {
        return contra;
    }

    public String getApodo() {
        return apodo;
    }

    public String getCorreo1() {
        return correo1;
    }

    public String getCorreo2() {
        return correo2;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public Integer getEdad() {
        return edad;
    }

    public Date getFnac() {
        return fnac;
    }

    public String getTelefono1() {
        return telefono1;
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

    public List<Rol> getRoles() {
        return roles;
    }

    public List<Acceso> getAccesos() {
        return accesos;
    }
    
    public Empleado getEmpleado() {
        return empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public void setCorreo1(String correo1) {
        this.correo1 = correo1;
    }

    public void setCorreo2(String correo2) {
        this.correo2 = correo2;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setFnac(Date fnac) {
        this.fnac = fnac;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
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

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public void setContra(Contra contra) {
        this.contra = contra;
    }

    public void setAccesos(List<Acceso> accesos) {
        this.accesos = accesos;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idusuario=" + idusuario + ", apodo=" + apodo + ", correo1=" + correo1 + ", correo2=" + correo2 + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", edad=" + edad + ", fnac=" + fnac + ", telefono1=" + telefono1 + ", telefono2=" + telefono2 + ", fecreg=" + fecreg + ", fecact=" + fecact + ", estatus=" + estatus + ", contra=" + contra + '}';
    }

}
