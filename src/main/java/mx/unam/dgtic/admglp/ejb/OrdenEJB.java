package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Local;
import mx.unam.dgtic.admglp.vo.Orden;

import java.util.List;

/**
 *
 * @author unam
 */
@Local
public interface OrdenEJB {

    List<Orden> getOrdenes();

    List<Orden> getOrdenesPorEstatus(Integer estatus);

    Orden getOrden(Integer idOrden);
    
    List<Orden> getOrdenesPorIdPedido(Integer idPedido, Integer estatus_orden);
    
    Boolean existeOrden(Integer idOrden);
    
    Orden insertaOrden(Orden orden);
    
    Orden actualizaOrden(Orden orden);
    
    void actualizaEstatusOrden(Integer idOrden, Integer estatus);
    
    void eliminaOrden(Integer id);
}
