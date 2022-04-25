/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Local;
import mx.unam.dgtic.admglp.vo.Cliente;

import java.util.List;

/**
 *
 * @author unam
 */
@Local
public interface ClienteEJB {

    List<Cliente> getClientes();

    List<Cliente> getClientesPorEstatus(Integer estatus);

    Cliente getCliente(Integer idCliente);
    
    Cliente getClientePorIdUsuario(Integer idUsuario);
    
    Boolean existeCliente(Integer idUsuario);
    
    Integer getNumCliente();
    
    Cliente insertaCliente(Cliente cliente);
    
    Cliente actualizaCliente(Cliente cliente);
    
    void actualizaEstatusCliente(Integer idCliente, Integer estatus);
    
    void eliminaCliente(Integer id);
}
