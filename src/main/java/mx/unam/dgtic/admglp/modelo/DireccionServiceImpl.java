package mx.unam.dgtic.admglp.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.vo.Direccion;

/**
 * Servicio para consulta de direccions
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/04/2022
 *
 */
public class DireccionServiceImpl implements DireccionService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public DireccionServiceImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Metodo para obtener direcciones
     *
     * @return Lista de direcciones encontradas
     */
    @Override
    public List<Direccion> getDirecciones() {
        List<Direccion> direccions = new ArrayList<>();
        try {
            TypedQuery<Direccion> query = em.createQuery("SELECT d FROM Direccion d", Direccion.class);
            direccions = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener direcciones");
        }
        return direccions;
    }

    /**
     * Metodo para obtener direcciones por identificador de estatus
     *
     * @param estatus Estatus de la direccion
     * @return Lista de direcciones encontradas
     */
    @Override
    public List<Direccion> getDirecciones(Integer estatus) {
        List<Direccion> direccions = new ArrayList<>();
        try {
            TypedQuery<Direccion> query = em.createQuery("SELECT d FROM Direccion d WHERE d.estatus = :est", Direccion.class);
            query.setParameter("est", estatus);
            direccions = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener direccions");
        }
        return direccions;
    }

    /**
     * Metodo para obtener un direccion
     *
     * @param idDireccion Identificador de direccion
     * @return Bean obtenido
     */
    @Override
    public Direccion getDireccion(int idDireccion) {
        return em.find(Direccion.class, idDireccion);
    }

    /**
     * Metodo para borrar un direccion
     *
     * @param idDireccion Identificador de direccion
     * @return Bean borrado
     */
    @Override
    public Direccion deleteDireccion(int idDireccion) {
        Direccion direccion = null;
        try {
            direccion = getDireccion(idDireccion);
            if (direccion != null) {
                em.getTransaction().begin();
                em.remove(direccion);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return direccion;
    }

    /**
     * Metodo para actualizar un direccion
     *
     * @param direccion Identificador de direccion
     * @return Bean actualizado
     */
    @Override
    public Direccion updateDireccion(Direccion direccion) {
        em.getTransaction().begin();
        direccion.setFecact(new Date());
        em.merge(direccion);
        em.getTransaction().commit();
        return direccion;
    }

    /**
     * Metodo para insertar un direccion
     *
     * @param direccion Identificador de direccion
     * @return Bean insertado
     */
    @Override
    public Direccion insertDireccion(Direccion direccion) {
        em.getTransaction().begin();
        em.persist(direccion);
        em.getTransaction().commit();
        return direccion;
    }

    /**
     * Metodo para obtener las direcciones por asentamiento y estatus de
     * direccion
     *
     * @param idAsentamiento Identificador de asentamiento
     * @param estatus_direccion Estatus de didreccion
     * @return Lista de direcciones encontradas
     */
    @Override
    public List<Direccion> getDireccionesPorIdAsentamiento(Integer idAsentamiento, Integer estatus_direccion) {
        List<Direccion> direccions = new ArrayList<>();
        try {
            TypedQuery<Direccion> query = em.createQuery("SELECT d FROM Direccion d WHERE d.asentamiento.id = :idAsen AND d.estatus = :est", Direccion.class);
            query.setParameter("idAsen", idAsentamiento);
            query.setParameter("est", estatus_direccion);
            direccions = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener direcciones por id de asentamiento y estatus");
        }
        return direccions;
    }
}
