package mx.unam.dgtic.admglp.modelo;

import java.util.List;
import mx.unam.dgtic.admglp.vo.Orden;

/**
 * Interfaz para CRUD de ordens
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/04/2022
 *
 */
public interface OrdenService {

    Exception getError();

    List<Orden> getOrdenes();

    List<Orden> getOrdenes(Integer estatus);

    List<Orden> getOrdenesPorIdPedido(Integer idPedido, Integer estatus_orden);

    Orden getOrden(Integer idOrden);

    Orden deleteOrden(Integer idOrden);

    Orden updateOrden(Orden orden);

    Orden insertOrden(Orden orden);

}
