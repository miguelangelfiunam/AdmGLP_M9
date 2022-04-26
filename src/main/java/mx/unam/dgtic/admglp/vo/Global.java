package mx.unam.dgtic.admglp.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad Global mapeada con la base de datos, que relaciona datos de la
 * aplicacion desplegada
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/04/2022 - 26/04/2022
 *
 */
@Entity
@Table(name = "c_global")
public class Global {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_global")
    private Integer id; //Identificador de dato unico

    @Column(name = "global_vc_nombre")
    private String nombre; //Nombre del campo 

    @Column(name = "global_vc_valor")
    private String valor; //Valor del campo

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Global{" + "id=" + id + ", nombre=" + nombre + ", valor=" + valor + '}';
    }
}
