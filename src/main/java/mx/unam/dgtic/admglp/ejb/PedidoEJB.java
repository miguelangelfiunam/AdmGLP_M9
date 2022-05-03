package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Local;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.vo.Pedido;
import mx.unam.dgtic.admglp.vo.TipoPago;

/**
 * Interfaz EJB para consulta de pedidos
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 28/04/2022 - 28/04/2022
 *
 */
@Local
public interface PedidoEJB {

    List<Pedido> cargaPedidos();

    List<Pedido> cargaPedidos(Integer estatus);

    List<Pedido> cargaPedidosCriteria(Integer estatus, Integer idCliente, 
            Integer idEmpleado, Integer idDireccion, 
            Date f_ped_ini, Date f_ped_fin, Double total, List<Integer> listaEstatus);

    Pedido cargaPedido(Integer idPedido);

    Pedido eliminaPedido(Integer idPedido);

    Pedido actualizaPedido(Pedido pedido);
    
    Pedido actualizaEstatusPedido(Integer idPedido, Integer estatus);

    Pedido insertaPedido(Pedido pedido);
    
    List<TipoPago> cargaTiposPago(Integer estatus);

}
