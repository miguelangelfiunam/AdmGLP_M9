package mx.unam.dgtic.admglp.modelo;

import java.util.List;
import mx.unam.dgtic.admglp.vo.Cliente;

/**
 * Interfaz para CRUD de clientes
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/03/2022
 *
 */
public interface ClienteService {

    public Exception getError();

    public List<Cliente> getClientes();
    
    public List<Cliente> getClientes(Integer estatus);

    public Cliente getCliente(int idCliente);
    
    public Cliente getClientePorIdUsuario(int idUsuario);
    
    public Cliente deleteCliente(int idCliente);
    
    public Cliente updateCliente(Cliente cliente);
    
    public Cliente insertCliente(Cliente cliente);
    
    public Integer getSigCliente();
    
}
