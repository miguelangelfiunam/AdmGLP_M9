package mx.unam.dgtic.admglp.vo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author unam
 */
public enum TipoPago {
    DEBITO(1, "Tarjeta de Débito", 10),
    CREDITO(2, "Tarjeta de Crédito", 10),
    EFECTIVO(3, "Efectivo", 10),
    TRANSPERENCIA(4, "Transferencia bancaria", 10),
    CHEQUE(5, "Cheque Nominativo", 20);

    private Integer id;
    private String nombre;
    private Integer estatus;

    private TipoPago(Integer id, String nombre, Integer estatus) {
        this.id = id;
        this.nombre = nombre;
        this.estatus = estatus;
    }

    public static TipoPago getTipoPago(Integer id) {
        return Arrays.stream(TipoPago.values())
                .filter(tipo -> tipo.id.equals(id))
                .findFirst().get();
    }

    public static List<TipoPago> getTipoPagoPorEstatus(Integer estado) {
        return Arrays.stream(TipoPago.values())
                .filter(tipo -> tipo.estatus.equals(estado)).collect(Collectors.toList());
    }

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

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }
}
