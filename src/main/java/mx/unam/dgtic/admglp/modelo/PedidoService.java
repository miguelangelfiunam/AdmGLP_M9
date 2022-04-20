/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.modelo;

import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.vo.Pedido;

/**
 * Servicio para consulta de pedidos
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 16/04/2022 - 16/04/2022
 *
 */
public interface PedidoService {

    public Exception getError();

    public List<Pedido> getPedidos();

    public List<Pedido> getPedidos(Integer estatus);

    public List<Pedido> getPedidosCriteria(Integer estatus, Integer idCliente, 
            Integer idEmpleado, Integer idDireccion, 
            Date f_ped_ini, Date f_ped_fin, Double total);

    public Pedido getPedido(int idpedido);

    public Pedido deletePedido(int idpedido);

    public Pedido updatePedido(Pedido pedido);

    public Pedido insertPedido(Pedido pedido);

}
