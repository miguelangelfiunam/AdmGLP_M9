package mx.unam.dgtic.admglp.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.vo.Estado;

/**
 * Servicio para consulta de estados
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/04/2022
 *
 */
public class EstadoServiceImpl implements EstadoService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public EstadoServiceImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Metodo para obtener estados
     *
     * @return Lista de estados encontrada
     */
    @Override
    public List<Estado> getEstados() {
        List<Estado> estados = new ArrayList<>();
        try {
            TypedQuery<Estado> query = em.createQuery("SELECT e FROM Estado e", Estado.class);
            estados = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener estados");
        }
        return estados;
    }

    /**
     * Metodo para obtener estados por identificador de estatus
     *
     * @param estatus Estatus del estado
     * @return Lista de estados encontrados
     */
    @Override
    public List<Estado> getEstados(Integer estatus) {
        List<Estado> estados = new ArrayList<>();
        try {
            TypedQuery<Estado> query = em.createQuery("SELECT u FROM Estado u WHERE u.estatus = :est", Estado.class);
            query.setParameter("est", estatus);
            estados = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener estados");
        }
        return estados;
    }

    /**
     * Metodo para obtener un estado
     *
     * @param idTurno Identificador de estado
     * @return Bean obtenido
     */
    @Override
    public Estado getEstado(int idEstado) {
        return em.find(Estado.class, idEstado);
    }

    /**
     * Metodo para borrar un estado
     *
     * @param idTurno Identificador de estado
     * @return Bean borrado
     */
    @Override
    public Estado deleteEstado(int idEstado) {
        Estado estado = null;
        try {
            estado = getEstado(idEstado);
            if (estado != null) {
                em.getTransaction().begin();
                em.remove(estado);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return estado;
    }

    /**
     * Metodo para actualizar un estado
     *
     * @param estado Identificador de estado
     * @return Bean actualizado
     */
    @Override
    public Estado updateEstado(Estado estado) {
        em.getTransaction().begin();
        estado.setFecact(new Date());
        em.merge(estado);
        em.getTransaction().commit();
        return estado;
    }

    /**
     * Metodo para insertar un estado
     *
     * @param estado Identificador de estado
     * @return Bean insertado
     */
    @Override
    public Estado insertEstado(Estado estado) {
        em.getTransaction().begin();
        em.persist(estado);
        em.getTransaction().commit();
        return estado;
    }

}
