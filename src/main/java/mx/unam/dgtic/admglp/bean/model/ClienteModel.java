package mx.unam.dgtic.admglp.bean.model;

import jakarta.enterprise.inject.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.ejb.ClienteEJBLocal;
import mx.unam.dgtic.admglp.vo.Cliente;

/**
 * Modelo para metodos de clientes
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/04/2022 - 26/04/2022
 *
 */
@Model
public class ClienteModel implements Serializable {

    private static final long serialVersionUID = -1000003;

    public List<Cliente> cargaClientes() {
        List<Cliente> clientes = null;
        ClienteEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ClienteEJBLocal) ctx.lookup("java:global/admglp/ClienteEJBLocal!mx.unam.dgtic.admglp.ejb.ClienteEJB");
            if (service != null) {
                clientes = service.getClientes();
            } else {
                clientes = new ArrayList<Cliente>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return clientes;
    }
    
    public List<Cliente> cargaClientesPorEstatus(Integer estatus) {
        List<Cliente> clientes = null;
        ClienteEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ClienteEJBLocal) ctx.lookup("java:global/admglp/ClienteEJBLocal!mx.unam.dgtic.admglp.ejb.ClienteEJB");
            if (service != null) {
                clientes = service.getClientesPorEstatus(estatus);
            } else {
                clientes = new ArrayList<Cliente>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return clientes;
    }

    public Cliente cargaCliente(Integer idcliente) {
        Cliente cliente = null;
        ClienteEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ClienteEJBLocal) ctx.lookup("java:global/admglp/ClienteEJBLocal!mx.unam.dgtic.admglp.ejb.ClienteEJB");
            if (service != null) {
                cliente = service.getCliente(idcliente);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cliente;
    }

    public Cliente actualizaCliente(Cliente cliente) {
        ClienteEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ClienteEJBLocal) ctx.lookup("java:global/admglp/ClienteEJBLocal!mx.unam.dgtic.admglp.ejb.ClienteEJB");
            if (service != null) {
                cliente = service.actualizaCliente(cliente);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cliente;
    }

    public void actualizaEstatusCliente(Integer idEmp, Integer estatus) {
        ClienteEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ClienteEJBLocal) ctx.lookup("java:global/admglp/ClienteEJBLocal!mx.unam.dgtic.admglp.ejb.ClienteEJB");
            if (service != null) {
                service.actualizaEstatusCliente(idEmp, estatus);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Cliente insertaCliente(Cliente cliente) {
        ClienteEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ClienteEJBLocal) ctx.lookup("java:global/admglp/ClienteEJBLocal!mx.unam.dgtic.admglp.ejb.ClienteEJB");
            if (service != null) {
                cliente = service.insertaCliente(cliente);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cliente;
    }

    public Integer cargaSiguienteNumeroCliente() {
        ClienteEJBLocal service = null;
        Integer numCliente = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ClienteEJBLocal) ctx.lookup("java:global/admglp/ClienteEJBLocal!mx.unam.dgtic.admglp.ejb.ClienteEJB");
            if (service != null) {
                numCliente = service.getNumCliente();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return numCliente;
    }

    public Cliente cargaClientePorIdUsuario(Integer idusuario) {
        Cliente cliente = null;
        ClienteEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ClienteEJBLocal) ctx.lookup("java:global/admglp/ClienteEJBLocal!mx.unam.dgtic.admglp.ejb.ClienteEJB");
            if (service != null) {
                cliente = service.getClientePorIdUsuario(idusuario);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cliente;
    }

}
