package mx.unam.dgtic.admglp.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.vo.Turno;

/**
 * Servicio para consulta de turnos
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 17/04/2022 - 26/04/2022
 *
 */
public class TurnoServiceImpl implements TurnoService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public TurnoServiceImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Metodo para obtener turnos
     *
     * @return Lista de turnos encontrada
     */
    @Override
    public List<Turno> getTurnos() {
        List<Turno> turnos = new ArrayList<>();
        try {
            TypedQuery<Turno> query = em.createQuery("SELECT t FROM Turno t", Turno.class);
            turnos = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener turnos");
        }
        return turnos;
    }

    /**
     * Metodo para obtener turnos por identificador de estatus
     *
     * @param estatus Estatus del turno
     * @return Lista de turnos encontrados
     */
    @Override
    public List<Turno> getTurnos(Integer estatus) {
        List<Turno> turnos = new ArrayList<>();
        try {
            TypedQuery<Turno> query = em.createQuery("SELECT t FROM Turno t WHERE t.estatus = :est", Turno.class);
            query.setParameter("est", estatus);
            turnos = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener turnos por estatus");
        }
        return turnos;
    }

    /**
     * Metodo para obtener un turno
     *
     * @param idTurno Identificador de turno
     * @return Bean obtenido
     */
    @Override
    public Turno getTurno(int idTurno) {
        return em.find(Turno.class, idTurno);
    }

    /**
     * Metodo para borrar un turno
     *
     * @param idTurno Identificador de turno
     * @return Bean borrado
     */
    @Override
    public Turno deleteTurno(int idTurno) {
        Turno turno = null;
        try {
            turno = getTurno(idTurno);
            if (turno != null) {
                em.getTransaction().begin();
                em.remove(turno);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return turno;
    }

    /**
     * Metodo para actualizar un turno
     *
     * @param turno Identificador de turno
     * @return Bean actualizado
     */
    @Override
    public Turno updateTurno(Turno turno) {
        em.getTransaction().begin();
        turno.setFecact(new Date());
        em.merge(turno);
        em.getTransaction().commit();
        return turno;
    }

    /**
     * Metodo para insertar un turno
     *
     * @param turno Identificador de turno
     * @return Bean insertado
     */
    @Override
    public Turno insertTurno(Turno turno) {
        em.getTransaction().begin();
        em.persist(turno);
        em.getTransaction().commit();
        return turno;
    }

    /**
     * Obtiene el turno del dia actual por fecha y hora en el date
     *
     * @param inicio_turno Fecha de inicio a buscar
     * @return Bean con la informacion del turno
     */
    @Override
    public Turno getTurnoActual(Date inicio_turno) {
        Turno turno = null;
        try {
            TypedQuery<Turno> query = em.createQuery("SELECT t FROM Turno t WHERE t.fecinicio = :fecIni", Turno.class);
            query.setParameter("fecIni", inicio_turno);
            try {
                turno = query.getSingleResult();
            } catch (jakarta.persistence.NoResultException e) {
                //Error en caso de no encontrar registro, regreso null el objeto
            }
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener turno por fecha de inicio");
        }
        return turno;
    }

}
