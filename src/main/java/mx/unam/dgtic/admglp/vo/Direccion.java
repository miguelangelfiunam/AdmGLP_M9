package mx.unam.dgtic.admglp.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * Entidad Direccion donde se agrega informacion de entrega del pedido
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 07/10/2021 - 26/04/2022
 *
 */
@Entity
@Table(name = "t_direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Integer iddireccion; // Identificador de direccion

    @OneToOne
    @JoinColumn(name = "id_asentamiento", referencedColumnName = "id_asentamiento")
    private Asentamiento asentamiento; // Asentamiento relacionado a la direccion

    @Column(name = "direccion_vc_nombre")
    private String nombre; // Direccion agregada

    @Column(name = "direccion_vc_referencias")
    private String referencias; //Referencias de la direccion

    @Column(name = "direccion_dt_fecha_registro")
    private Date fecreg; // Fecha de registro

    @Column(name = "direccion_dt_fecha_actualizacion")
    private Date fecact; // Fecha de actualizacion

    @Column(name = "direccion_si_estatus")
    private Integer estatus; // Estado de la direccion

    @ManyToMany(mappedBy = "direcciones")
    private List<Cliente> clientes; // Clientes relacionados a la direccion

    public Direccion() {
    }

    public Direccion(String nombre, String referencias, Date fecreg, Date fecact, Integer estatus) {
        this.nombre = nombre;
        this.referencias = referencias;
        this.fecreg = fecreg;
        this.fecact = fecact;
        this.estatus = estatus;
    }

    public Integer getIddireccion() {
        return iddireccion;
    }

    public Asentamiento getAsentamiento() {
        return asentamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getReferencias() {
        return referencias;
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

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setIddireccion(Integer iddireccion) {
        this.iddireccion = iddireccion;
    }

    public void setAsentamiento(Asentamiento asentamiento) {
        this.asentamiento = asentamiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
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

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "Direccion{" + "iddireccion=" + iddireccion + ", nombre=" + nombre + ", referencias=" + referencias + ", fecreg=" + fecreg + ", fecact=" + fecact + ", estatus=" + estatus + '}';
    }

}
