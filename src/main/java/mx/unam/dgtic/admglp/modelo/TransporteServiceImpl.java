package mx.unam.dgtic.admglp.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.vo.Transporte;

/**
 * Servicio para consulta de transportes
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/04/2022
 *
 */
public class TransporteServiceImpl implements TransporteService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public TransporteServiceImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Metodo para obtener transportes
     *
     * @return Lista de transportes encontrados
     */
    @Override
    public List<Transporte> getTransportes() {
        List<Transporte> transportes = new ArrayList<>();
        try {
            TypedQuery<Transporte> query = em.createQuery("SELECT t FROM Transporte t", Transporte.class);
            transportes = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener transportes");
        }
        return transportes;
    }

    /**
     * Metodo para obtener trasnportes por estatus
     *
     * @param estatus Estatus a buscar
     * @return Lista de transportes encontrados
     */
    @Override
    public List<Transporte> getTransportes(Integer estatus) {
        List<Transporte> transportes = new ArrayList<>();
        try {
            TypedQuery<Transporte> query = em.createQuery("SELECT t FROM Transporte t WHERE t.estatus = :est", Transporte.class);
            query.setParameter("est", estatus);
            transportes = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener transportes");
        }
        return transportes;
    }

    /**
     * Metodo para obtener un trasnporte
     *
     * @param idTransporte Identificador de transporte
     * @return Bean encontrado
     */
    @Override
    public Transporte getTransporte(int idTransporte) {
        return em.find(Transporte.class, idTransporte);
    }

    /**
     * Metodo para eliminar un trasnporte
     *
     * @param idTransporte Identificador de transporte
     * @return Bean eliminado
     */
    @Override
    public Transporte deleteTransporte(int idTransporte) {
        Transporte transporte = null;
        try {
            transporte = getTransporte(idTransporte);
            if (transporte != null) {
                em.getTransaction().begin();
                em.remove(transporte);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return transporte;
    }

    /**
     * Metodo para actualizar un trasnporte
     *
     * @param idTransporte Identificador de transporte
     * @return Bean actualizado
     */
    @Override
    public Transporte updateTransporte(Transporte transporte) {
        em.getTransaction().begin();
        transporte.setFecact(new Date());
        em.merge(transporte);
        em.getTransaction().commit();
        return transporte;
    }

    /**
     * Metodo para insertar un trasnporte
     *
     * @param idTransporte Identificador de transporte
     * @return Bean insertado
     */
    @Override
    public Transporte insertTransporte(Transporte transporte) {
        em.getTransaction().begin();
        em.persist(transporte);
        em.getTransaction().commit();
        return transporte;
    }

}
