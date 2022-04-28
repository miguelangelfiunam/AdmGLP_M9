package mx.unam.dgtic.admglp.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.vo.Orden;

/**
 * Servicio para consulta de ordenes
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/04/2022
 *
 */
public class OrdenServiceImpl implements OrdenService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public OrdenServiceImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Metodo para obtener ordenes
     *
     * @return Lista de ordenes encontrada
     */
    @Override
    public List<Orden> getOrdenes() {
        List<Orden> ordenes = new ArrayList<>();
        try {
            TypedQuery<Orden> query = em.createQuery("SELECT o FROM Orden o WHERE o.estatus = :est", Orden.class);
            query.setParameter("est", 10);
            ordenes = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener ordenes");
        }
        return ordenes;
    }

    /**
     * Metodo para obtener ordenes por identificador de estatus
     *
     * @param estatus Estatus del orden
     * @return Lista de ordenes encontrados
     */
    @Override
    public List<Orden> getOrdenes(Integer estatus) {
        List<Orden> ordenes = new ArrayList<>();
        try {
            TypedQuery<Orden> query = em.createQuery("SELECT o FROM Orden o WHERE o.estatus = :est", Orden.class);
            query.setParameter("est", estatus);
            ordenes = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener ordenes");
        }
        return ordenes;
    }

    /**
     * Metodo para obtener los ordenes por estado
     *
     * @param idEstado Identificador de estado
     * @param estatus_municipio Estatus del orden
     * @return Lista de ordenes encontrados
     */
    @Override
    public List<Orden> getOrdenesPorIdPedido(Integer idEstado, Integer estatus_municipio) {
        List<Orden> ordenes = new ArrayList<>();
        try {
            TypedQuery<Orden> query = em.createQuery("SELECT o FROM Orden o WHERE o.pedido.id = :idPed AND o.estatus = :est", Orden.class);
            query.setParameter("idPed", idEstado);
            query.setParameter("est", estatus_municipio);
            ordenes = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener ordenes");
        }
        return ordenes;
    }

    /**
     * Metodo para obtener un orden
     *
     * @param idOrden Identificador de orden
     * @return Bean obtenido
     */
    @Override
    public Orden getOrden(Integer idOrden) {
        return em.find(Orden.class, idOrden);
    }

    /**
     * Metodo para borrar un orden
     *
     * @param idOrden Identificador de orden
     * @return Bean borrado
     */
    @Override
    public Orden deleteOrden(Integer idOrden) {
        Orden orden = null;
        try {
            orden = getOrden(idOrden);
            if (orden != null) {
                em.getTransaction().begin();
                em.remove(orden);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return orden;
    }

    /**
     * Metodo para actualizar un orden
     *
     * @param orden Identificador de orden
     * @return Bean actualizado
     */
    @Override
    public Orden updateOrden(Orden orden) {
        em.getTransaction().begin();
        orden = em.merge(orden);
        em.getTransaction().commit();
        return orden;
    }

    /**
     * Metodo para insertar un orden
     *
     * @param orden Identificador de orden
     * @return Bean insertado
     */
    @Override
    public Orden insertOrden(Orden orden) {
        em.getTransaction().begin();
        em.persist(orden);
        em.getTransaction().commit();
        return orden;
    }

}
