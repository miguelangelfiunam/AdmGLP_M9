package mx.unam.dgtic.admglp.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.vo.Municipio;

/**
 * Servicio para consulta de municipios
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/04/2022
 *
 */
public class MunicipioServiceImpl implements MunicipioService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public MunicipioServiceImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Metodo para obtener municipios
     *
     * @return Lista de municipios encontrada
     */
    @Override
    public List<Municipio> getMunicipios() {
        List<Municipio> municipios = new ArrayList<>();
        try {
            TypedQuery<Municipio> query = em.createQuery("SELECT m FROM Municipio m WHERE m.estatus = :est", Municipio.class);
            query.setParameter("est", 10);
            municipios = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener municipios");
        }
        return municipios;
    }

    /**
     * Metodo para obtener municipios por identificador de estatus
     *
     * @param estatus Estatus del municipio
     * @return Lista de municipios encontrados
     */
    @Override
    public List<Municipio> getMunicipios(Integer estatus) {
        List<Municipio> municipios = new ArrayList<>();
        try {
            TypedQuery<Municipio> query = em.createQuery("SELECT m FROM Municipio m WHERE m.estatus = :est", Municipio.class);
            query.setParameter("est", estatus);
            municipios = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener municipios");
        }
        return municipios;
    }

    /**
     * Metodo para obtener un municipio
     *
     * @param idMunicipio Identificador de municipio
     * @return Bean obtenido
     */
    @Override
    public Municipio getMunicipio(int idMunicipio) {
        return em.find(Municipio.class, idMunicipio);
    }

    /**
     * Metodo para borrar un municipio
     *
     * @param idMunicipio Identificador de municipio
     * @return Bean borrado
     */
    @Override
    public Municipio deleteMunicipio(int idMunicipio) {
        Municipio municipio = null;
        try {
            municipio = getMunicipio(idMunicipio);
            if (municipio != null) {
                em.getTransaction().begin();
                em.remove(municipio);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return municipio;
    }

    /**
     * Metodo para actualizar un municipio
     *
     * @param municipio Identificador de municipio
     * @return Bean actualizado
     */
    @Override
    public Municipio updateMunicipio(Municipio municipio) {
        em.getTransaction().begin();
        municipio.setFecact(new Date());
        em.merge(municipio);
        em.getTransaction().commit();
        return municipio;
    }

    /**
     * Metodo para insertar un municipio
     *
     * @param municipio Identificador de municipio
     * @return Bean insertado
     */
    @Override
    public Municipio insertMunicipio(Municipio municipio) {
        em.getTransaction().begin();
        em.persist(municipio);
        em.getTransaction().commit();
        return municipio;
    }

    /**
     * Metodo para obtener los municipios por estado
     *
     * @param idEstado Identificador de estado
     * @param estatus_municipio Estatus del municipio
     * @return Lista de municipios encontrados
     */
    @Override
    public List<Municipio> getMunicipiosPorIdEstado(Integer idEstado, Integer estatus_municipio) {
        List<Municipio> municipios = new ArrayList<>();
        try {
            TypedQuery<Municipio> query = em.createQuery("SELECT m FROM Municipio m WHERE m.estado.id = :idEst AND m.estatus = :est", Municipio.class);
            query.setParameter("idEst", idEstado);
            query.setParameter("est", estatus_municipio);
            municipios = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener municipios");
        }
        return municipios;
    }
}
