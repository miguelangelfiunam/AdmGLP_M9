package mx.unam.dgtic.admglp.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.vo.Asentamiento;

/**
 * Servicio para consulta de asentamientos
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/04/2022
 *
 */
public class AsentamientoServiceImpl implements AsentamientoService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public AsentamientoServiceImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Metodo para obtener los asentamientos
     *
     * @return Lista de asentamientos encontrados
     */
    @Override
    public List<Asentamiento> getAsentamientos() {
        List<Asentamiento> asentamientos = new ArrayList<>();
        try {
            TypedQuery<Asentamiento> query = em.createQuery("SELECT a FROM Asentamiento a", Asentamiento.class);
            asentamientos = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener asentamientos");
        }
        return asentamientos;
    }

    /**
     * Metodo para obtener los asentamientos por estatus
     *
     * @param estatus Estatus a buscar en los asentamientos
     * @return
     */
    @Override
    public List<Asentamiento> getAsentamientos(Integer estatus) {
        List<Asentamiento> asentamientos = new ArrayList<>();
        try {
            TypedQuery<Asentamiento> query = em.createQuery("SELECT a FROM Asentamiento a WHERE a.estatus = :est", Asentamiento.class);
            query.setParameter("est", estatus);
            asentamientos = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener asentamientos");
        }
        return asentamientos;
    }

    /**
     * Metodo para obtener un asentamiento
     *
     * @param idAsentamiento Identificador de asentamiento
     * @return Asentamiento encontrado
     */
    @Override
    public Asentamiento getAsentamiento(int idAsentamiento) {
        return em.find(Asentamiento.class, idAsentamiento);
    }

    /**
     * Metodo que borra un asentamiento
     *
     * @param idAsentamiento Identificador de asentamiento
     * @return Bean Borrado
     */
    @Override
    public Asentamiento deleteAsentamiento(int idAsentamiento) {
        Asentamiento asentamiento = null;
        try {
            asentamiento = getAsentamiento(idAsentamiento);
            if (asentamiento != null) {
                em.getTransaction().begin();
                em.remove(asentamiento);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return asentamiento;
    }

    /**
     * Metodo que actualiza un asentamineto
     *
     * @param asentamiento Bean con la informacion a actualizar
     * @return Bean actualizado
     */
    @Override
    public Asentamiento updateAsentamiento(Asentamiento asentamiento) {
        em.getTransaction().begin();
        asentamiento.setFecact(new Date());
        em.merge(asentamiento);
        em.getTransaction().commit();
        return asentamiento;
    }

    /**
     * Metodo que inserta un asentamineto
     *
     * @param asentamiento Bean con la informacion a insertar
     * @return Bean insertado
     */
    @Override
    public Asentamiento insertAsentamiento(Asentamiento asentamiento) {
        em.getTransaction().begin();
        em.persist(asentamiento);
        em.getTransaction().commit();
        return asentamiento;
    }

    /**
     * Metodo para obtener asentamientos por municipio y estatus
     *
     * @param idMunicipio Identificador de municipio
     * @param estatus_asentamiento Estatus del asentamiento
     * @return Lista de asentamientos que coincidan
     */
    @Override
    public List<Asentamiento> getAsentamientosPorIdMunicipio(Integer idMunicipio, Integer estatus_asentamiento) {
        List<Asentamiento> asentamientos = new ArrayList<>();
        try {
            TypedQuery<Asentamiento> query = em.createQuery("SELECT a FROM Asentamiento a WHERE a.municipio.id = :idMun AND a.estatus = :est", Asentamiento.class);
            query.setParameter("idMun", idMunicipio);
            query.setParameter("est", estatus_asentamiento);
            asentamientos = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener asentamientos");
        }
        return asentamientos;
    }

}
