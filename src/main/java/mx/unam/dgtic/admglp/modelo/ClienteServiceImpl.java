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

    /**
     * Metodo para obtener clientes
     *
     * @return Lista de clientes obtenidos
     */
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

    /**
     * Metodo para obtener clientes por estatus
     *
     * @param estatus Estatus a buscar
     * @return Lista de clientes con ese estatus
     */
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

    /**
     * Metodo para obtener un cliente
     *
     * @param idCliente Identificador de cliente
     * @return Bean obtenido
     */
    @Override
    public Cliente getCliente(int idCliente) {
        return em.find(Cliente.class, idCliente);
    }

    /**
     * Metodo para borrar un cliente
     *
     * @param idCliente Identificador de cliente
     * @return Bean borrado
     */
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

    /**
     * Metodo para actualizar un cliente
     *
     * @param idCliente Identificador de cliente
     * @return Bean actualizado
     */
    @Override
    public Cliente updateCliente(Cliente cliente) {
        em.getTransaction().begin();
        cliente.setFecact(new Date());
        em.merge(cliente);
        em.getTransaction().commit();
        return cliente;
    }

    /**
     * Metodo para insertar un cliente
     *
     * @param idCliente Identificador de cliente
     * @return Bean insertado
     */
    @Override
    public Cliente insertCliente(Cliente cliente) {
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        return cliente;
    }

    /**
     * Metodo para obtener el numero de cliente siguiente
     *
     * @return Numero de cliente consecutivo
     */
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

    /**
     * Metodo para obtener un cliente por el identificador de usuario
     *
     * @param idUsuario Identificador de usuario
     * @return Bean con la informacion obtenida
     */
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
