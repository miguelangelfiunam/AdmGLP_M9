package mx.unam.dgtic.admglp.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.vo.Estatus;

/**
 * Servicio para consulta de estados
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/04/2022
 *
 */
public class EstatusServiceImpl implements EstatusService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public EstatusServiceImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Metodo para obtener estados
     *
     * @return Lista de estados encontrada
     */
    @Override
    public List<Estatus> getEstatusLista() {
        List<Estatus> estados = new ArrayList<>();
        try {
            TypedQuery<Estatus> query = em.createQuery("SELECT e FROM Estatus e", Estatus.class);
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
     * @param estatus Estatus del estatus
     * @return Lista de estados encontrados
     */
    @Override
    public List<Estatus> getEstatusLista(Integer activo) {
        List<Estatus> estados = new ArrayList<>();
        try {
            TypedQuery<Estatus> query = em.createQuery("SELECT e FROM Estatus e WHERE e.activo = :act", Estatus.class);
            query.setParameter("act", activo);
            estados = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener estados");
        }
        return estados;
    }

    /**
     * Metodo para obtener los estatus por nombre de tabla
     *
     * @param tabla Nombre de la tabla
     * @param estatus
     * @return
     */
    @Override
    public List<Estatus> getEstatusLista(String tabla, Integer activo) {
        List<Estatus> estados = new ArrayList<>();
        try {
            TypedQuery<Estatus> query = em.createQuery("SELECT e FROM Estatus e WHERE e.tabla = :tab AND e.activo = :act", Estatus.class);
            query.setParameter("tab", tabla);
            query.setParameter("act", activo);
            estados = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener estados");
        }
        return estados;
    }

    /**
     * Metodo para obtener un estatus
     *
     * @param idTurno Identificador de estatus
     * @return Bean obtenido
     */
    @Override
    public Estatus getEstatusObjeto(int idEstatus) {
        return em.find(Estatus.class, idEstatus);
    }

    /**
     * Metodo para borrar un estatus
     *
     * @param idTurno Identificador de estatus
     * @return Bean borrado
     */
    @Override
    public Estatus deleteEstatusObjeto(int idEstatus) {
        Estatus estatus = null;
        try {
            estatus = getEstatusObjeto(idEstatus);
            if (estatus != null) {
                em.getTransaction().begin();
                em.remove(estatus);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return estatus;
    }

    /**
     * Metodo para actualizar un estatus
     *
     * @param estatus Identificador de estatus
     * @return Bean actualizado
     */
    @Override
    public Estatus updateEstatusObjeto(Estatus estatus) {
        em.getTransaction().begin();
        estatus.setFecact(new Date());
        em.merge(estatus);
        em.getTransaction().commit();
        return estatus;
    }

    /**
     * Metodo para insertar un estatus
     *
     * @param estatus Identificador de estatus
     * @return Bean insertado
     */
    @Override
    public Estatus insertEstatusObjeto(Estatus estatus) {
        em.getTransaction().begin();
        em.persist(estatus);
        em.getTransaction().commit();
        return estatus;
    }

    @Override
    public Estatus getEstatusObjeto(String tabla, Integer numEstatus, Integer activo) {
         Estatus estatus = null;
        try {
            TypedQuery<Estatus> query = em.createQuery("SELECT e FROM Estatus e WHERE e.numero = :num AND e.tabla = :tab AND e.activo = :act ", Estatus.class);
            query.setParameter("num", numEstatus);
            query.setParameter("tab", tabla);
            query.setParameter("act", activo);
            estatus = query.getSingleResult();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener estatuss");
        }
        return estatus;
    }

}
