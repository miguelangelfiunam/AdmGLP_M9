/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.Funciones.Funciones;
import mx.unam.dgtic.admglp.modelo.ClienteServiceImpl;
import mx.unam.dgtic.admglp.vo.Cliente;

/**
 *
 * @author unam
 */
@Stateless
public class ClienteEJBLocal implements ClienteEJB {

    ClienteServiceImpl es;

    @Override
    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new ClienteServiceImpl(em);
            clientes = es.getClientes();
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ClienteService: " + e.getMessage() + "</p>";
            if (es.getError() != null) {
                mensaje += "<p>" + "Error en ClienteEJBLocal -> getClientes() -> ClienteService -> getClientes() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return clientes;
    }

    @Override
    public List<Cliente> getClientesPorEstatus(Integer estatus) {
        List<Cliente> clientes = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new ClienteServiceImpl(em);
            clientes = es.getClientes(estatus);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ClienteService: " + e.getMessage() + "</p>";
            if (es.getError() != null) {
                mensaje += "<p>" + "Error en ClienteEJBLocal -> getClientesPorEstatus() -> ClienteService -> getClientes() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return clientes;
    }

    @Override
    public Cliente getCliente(Integer idCliente) {
        Cliente cliente = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new ClienteServiceImpl(em);
            cliente = es.getCliente(idCliente);

        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ClienteServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en ClienteEJBLocal -> getCliente() -> ClienteService -> getCliente() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return cliente;
    }

    @Override
    public Boolean existeCliente(Integer idCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente insertaCliente(Cliente cliente) {
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new ClienteServiceImpl(em);
            cliente = es.insertCliente(cliente);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ClienteServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en ClienteEJBLocal -> insertaCliente() -> ClienteService -> insertaCliente() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return cliente;
    }

    @Override
    public Cliente actualizaCliente(Cliente cliente) {
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new ClienteServiceImpl(em);
            cliente = es.updateCliente(cliente);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ClienteServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en ClienteEJBLocal -> insertaCliente() -> ClienteService -> insertaCliente() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return cliente;
    }

    @Override
    public void eliminaCliente(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizaEstatusCliente(Integer id, Integer estatus) {
        Cliente cliente = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new ClienteServiceImpl(em);
            cliente = es.getCliente(id);
            if (cliente != null) {
                cliente.setEstatus(estatus);
                es.updateCliente(cliente);
            }
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ClienteServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en ClienteEJBLocal -> getCliente() -> ClienteService -> getCliente() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
    }

    @Override
    public Integer getNumCliente() {
        Integer numCliente = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new ClienteServiceImpl(em);
            numCliente = es.getSigCliente();

        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ClienteServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en ClienteEJBLocal -> getCliente() -> ClienteService -> getCliente() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return numCliente;
    }

    @Override
    public Cliente getClientePorIdUsuario(Integer idUsuario) {
        Cliente cliente = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new ClienteServiceImpl(em);
            cliente = es.getClientePorIdUsuario(idUsuario);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ClienteServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en ClienteEJBLocal -> getCliente() -> ClienteService -> getClientePorIdUsuario() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return cliente;
    }

}
