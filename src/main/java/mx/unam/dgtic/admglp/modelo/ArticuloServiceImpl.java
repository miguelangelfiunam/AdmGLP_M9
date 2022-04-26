package mx.unam.dgtic.admglp.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.vo.Articulo;

/**
 * Servicio para consulta de articulos
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/04/2022
 *
 */
public class ArticuloServiceImpl implements ArticuloService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public ArticuloServiceImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Metodo para obtener todos los articulos
     *
     * @return Lista de articulos encontrados
     */
    @Override
    public List<Articulo> getArticulos() {
        List<Articulo> articulos = new ArrayList<>();
        try {
            TypedQuery<Articulo> query = em.createQuery("SELECT a FROM Articulo a", Articulo.class);
            articulos = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener articulos");
        }
        return articulos;
    }

    /**
     * Metodo para obtener articulos por estatus
     *
     * @param estatus Estatus a buscar
     * @return Lista de articulos encontrados por estatus
     */
    @Override
    public List<Articulo> getArticulos(Integer estatus) {
        List<Articulo> articulos = new ArrayList<>();
        try {
            TypedQuery<Articulo> query = em.createQuery("SELECT a FROM Articulo a WHERE a.estatus = :est", Articulo.class);
            query.setParameter("est", estatus);
            articulos = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener articulos");
        }
        return articulos;
    }

    /**
     * Metodo para obtener un articulo por su identificador
     *
     * @param idArticulo Identificador de articulo
     * @return Bean con la informacion encontrada
     */
    @Override
    public Articulo getArticulo(int idArticulo) {
        return em.find(Articulo.class, idArticulo);
    }

    /**
     * Metodo para borrar un articulo por su identificador
     *
     * @param idArticulo Identificador de articulo
     * @return Bean con la informacion borrada
     */
    @Override
    public Articulo deleteArticulo(int idArticulo) {
        Articulo articulo = null;
        try {
            articulo = getArticulo(idArticulo);
            if (articulo != null) {
                em.getTransaction().begin();
                em.remove(articulo);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return articulo;
    }

    /**
     * Metodo para actualizar un articulo
     *
     * @param articulo Bean con la informacion a actualizar
     * @return Bean con la informacion actualizada
     */
    @Override
    public Articulo updateArticulo(Articulo articulo) {
        em.getTransaction().begin();
        articulo.setFecact(new Date());
        em.merge(articulo);
        em.getTransaction().commit();
        return articulo;
    }

    /**
     * Metodo para insertar un articulo
     *
     * @param articulo Bean con la informacion a actualizar
     * @return Bean con la informacion insertada
     */
    @Override
    public Articulo insertArticulo(Articulo articulo) {
        em.getTransaction().begin();
        em.persist(articulo);
        em.getTransaction().commit();
        return articulo;
    }

}
