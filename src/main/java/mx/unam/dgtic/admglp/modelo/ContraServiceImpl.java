package mx.unam.dgtic.admglp.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.vo.Contra;

/**
 * Servicio para consulta de contras
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/04/2022
 *
 */
public class ContraServiceImpl implements ContraService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public ContraServiceImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Metodo para obtener contras
     *
     * @return Lista de contras encontrada
     */
    @Override
    public List<Contra> getContras() {
        List<Contra> contras = new ArrayList<>();
        try {
            TypedQuery<Contra> query = em.createQuery("SELECT c FROM Contra c", Contra.class);
            contras = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener contras");
        }
        return contras;
    }

    /**
     * Metodo para obtener contras por identificador de estatus
     *
     * @param estatus Estatus de la contra
     * @return Lista de contras encontradas
     */
    @Override
    public List<Contra> getContras(Integer estatus) {
        List<Contra> contras = new ArrayList<>();
        try {
            TypedQuery<Contra> query = em.createQuery("SELECT c FROM Contra c WHERE c.estatus = :est", Contra.class);
            query.setParameter("est", estatus);
            contras = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener contras");
        }
        return contras;
    }

    /**
     * Metodo para obtener una contra
     *
     * @param idContra Identificador de contra
     * @return Bean obtenido
     */
    @Override
    public Contra getContra(int idContra) {
        return em.find(Contra.class, idContra);
    }

    /**
     * Metodo para obtener una contra
     *
     * @param idContra Identificador de contra
     * @return Bean obtenido
     */
    @Override
    public Contra deleteContra(int idContra) {
        Contra contra = null;
        try {
            contra = getContra(idContra);
            if (contra != null) {
                em.getTransaction().begin();
                em.remove(contra);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return contra;
    }

    /**
     * Metodo para insertar una contra
     *
     * @param contra Identificador de contra
     * @return Bean insertado
     */
    @Override
    public Contra updateContra(Contra contra) {
        em.getTransaction().begin();
        contra.setFecact(new Date());
        em.merge(contra);
        em.getTransaction().commit();
        return contra;
    }

    /**
     * Metodo para insertar una contra
     *
     * @param contra Identificador de contra
     * @return Bean insertado
     */
    @Override
    public Contra insertContra(Contra contra) {
        em.getTransaction().begin();
        em.persist(contra);
        em.getTransaction().commit();
        return contra;
    }
}
