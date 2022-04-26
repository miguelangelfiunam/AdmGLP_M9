package mx.unam.dgtic.admglp.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import mx.unam.dgtic.admglp.vo.Global;

/**
 * Servicio para consulta de globales
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/04/2022
 *
 */
public class GlobalServiceImpl implements GlobalService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public GlobalServiceImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Metodo para obtener globales
     *
     * @return Lista de globales encontrada
     */
    @Override
    public List<Global> getGlobales() {
        List<Global> globales = new ArrayList<>();
        try {
            TypedQuery<Global> query = em.createQuery("SELECT g FROM Global g", Global.class);
            globales = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener globals");
        }
        return globales;
    }

    /**
     * Metodo para obtener un global
     *
     * @param idGlobal Identificador de global
     * @return Bean obtenido
     */
    @Override
    public Global getGlobal(int idGlobal) {
        return em.find(Global.class, idGlobal);
    }

    /**
     * Metodo para obtener un global
     *
     * @param nomGlobal Nombre de la global
     * @return Bean obtenido
     */
    @Override
    public Global getGlobal(String nomGlobal) {
        Global global = null;
        try {
            try {
                TypedQuery<Global> query = em.createQuery("SELECT g FROM Global g WHERE g.nombre = :name", Global.class);
                query.setParameter("name", nomGlobal);
                global = query.getSingleResult();
            } catch (jakarta.persistence.NoResultException e) {
                //Error en caso de no encontrar registro, regreso null el objeto
            }
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener globals");
        }
        return global;
    }

    /**
     * Metodo para borrar un global
     *
     * @param idGlobal Identificador del global
     * @return Bean borrado
     */
    @Override
    public Global deleteGlobal(int idGlobal) {
        Global global = null;
        try {
            global = getGlobal(idGlobal);
            if (global != null) {
                em.getTransaction().begin();
                em.remove(global);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return global;
    }

    /**
     * Metodo para actualizar un global
     *
     * @param global Identificador del global
     * @return Bean actualizado
     */
    @Override
    public Global updateGlobal(Global global) {
        em.getTransaction().begin();
        em.merge(global);
        em.getTransaction().commit();
        return global;
    }

    /**
     * Metodo para insertar un global
     *
     * @param global Identificador de global
     * @return Bean insertado
     */
    @Override
    public Global insertGlobal(Global global) {
        em.getTransaction().begin();
        em.persist(global);
        em.getTransaction().commit();
        return global;
    }

}
