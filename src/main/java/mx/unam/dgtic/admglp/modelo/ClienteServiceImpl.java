/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.vo.Cliente;

/**
 * Servicio para consulta de clientes
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/03/2022
 *
 */
public class ClienteServiceImpl implements ClienteService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public ClienteServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
            clientes = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener clientes");
        }
        return clientes;
    }

    @Override
    public List<Cliente> getClientes(Integer estatus) {
        List<Cliente> clientes = new ArrayList<>();
        try {
            TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c WHERE c.estatus = :est", Cliente.class);
            query.setParameter("est", estatus);
            clientes = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener clientes");
        }
        return clientes;
    }

    @Override
    public Cliente getCliente(int idCliente) {
        return em.find(Cliente.class, idCliente);
    }

    @Override
    public Cliente deleteCliente(int idCliente) {
        Cliente cliente = null;
        try {
            cliente = getCliente(idCliente);
            if (cliente != null) {
                em.getTransaction().begin();
                em.remove(cliente);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
        em.getTransaction().begin();
        cliente.setFecact(new Date());
        em.merge(cliente);
        em.getTransaction().commit();
        return cliente;
    }

    @Override
    public Cliente insertCliente(Cliente cliente) {
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        return cliente;
    }

    @Override
    public Integer getSigCliente() {
        Integer numCliente;
        try {
            try {
                numCliente = em.createQuery("SELECT MAX(c.numerocliente) FROM Cliente c", Integer.class).getSingleResult();
                numCliente++;
            } catch (jakarta.persistence.NoResultException e) {
                //Error en caso de no encontrar registro, regreso null el objeto
                numCliente = 1;
            }
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener clientes");
        }
        return numCliente;
    }

    @Override
    public Cliente getClientePorIdUsuario(int idUsuario) {
        Cliente cliente = null;
        try {
            try {
                TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c WHERE c.usuario.idusuario = :idusu", Cliente.class);
                query.setParameter("idusu", idUsuario);
                cliente = query.getSingleResult();
            } catch (jakarta.persistence.NoResultException e) {
                //Error en caso de no encontrar registro, regreso null el objeto
            }
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener cliente por id de usuario");
        }
        return cliente;
    }

}
