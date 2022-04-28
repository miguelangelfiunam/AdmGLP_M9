package mx.unam.dgtic.admglp.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;

/**
 * Entidad Comentario asociado a un pedido
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 07/10/2021 - 26/04/2022
 *
 */
@Entity
@Table(name = "t_comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private Integer id; // Identificador de comentario

    @OneToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    private Pedido pedido; // Pedido relacionado al comentario

    @Column(name = "comentario_i_numero")
    private Integer numero; // Numero consecutivo de comentario

    @Column(name = "comentario_vc_comentario")
    private String comentario; // Comentario agregado

    @Column(name = "comentario_c_tipo")
    private String tipo; // Tipo de comentario

    @Column(name = "comentario_dt_fecha_registro")
    private Date fecreg; // Fecha de registro

    @Column(name = "comentario_dt_fecha_actualizacion")
    private Date fecact; // Fecha de actualizacion

    @Column(name = "comentario_si_estatus")
    private Integer estatus; // Estado del comentario

    public Comentario() {
    }

    public Comentario(Pedido pedido, Integer numero, String comentario, String tipo, Date fecreg, Date fecact, Integer estatus) {
        this.pedido = pedido;
        this.numero = numero;
        this.comentario = comentario;
        this.tipo = tipo;
        this.fecreg = fecreg;
        this.fecact = fecact;
        this.estatus = estatus;
    }

    public Integer getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getComentario() {
        return comentario;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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
        return "Comentario{" + "id=" + id + ", pedido=" + pedido + ", numero=" + numero + ", comentario=" + comentario + ", tipo=" + tipo + ", fecreg=" + fecreg + ", fecact=" + fecact + ", estatus=" + estatus + '}';
    }

}
