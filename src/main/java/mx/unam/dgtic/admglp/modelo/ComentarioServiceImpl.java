package mx.unam.dgtic.admglp.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.vo.Comentario;

/**
 * Servicio para consulta de comentarios
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/04/2022
 *
 */
public class ComentarioServiceImpl implements ComentarioService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public ComentarioServiceImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Metodo para obtener comentarios
     *
     * @return Lista de comentarios encontrada
     */
    @Override
    public List<Comentario> getComentarios() {
        List<Comentario> comentarios = new ArrayList<>();
        try {
            TypedQuery<Comentario> query = em.createQuery("SELECT c FROM Comentario c WHERE c.estatus = :est", Comentario.class);
            query.setParameter("est", 10);
            comentarios = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener comentarios");
        }
        return comentarios;
    }

    /**
     * Metodo para obtener comentarios por identificador de estatus
     *
     * @param estatus Estatus del comentario
     * @return Lista de comentarios encontrados
     */
    @Override
    public List<Comentario> getComentarios(Integer estatus) {
        List<Comentario> comentarios = new ArrayList<>();
        try {
            TypedQuery<Comentario> query = em.createQuery("SELECT c FROM Comentario c WHERE c.estatus = :est", Comentario.class);
            query.setParameter("est", estatus);
            comentarios = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener comentarios");
        }
        return comentarios;
    }

    /**
     * Metodo para obtener un comentario
     *
     * @param idComentario Identificador de comentario
     * @return Bean obtenido
     */
    @Override
    public Comentario getComentario(Integer idComentario) {
        return em.find(Comentario.class, idComentario);
    }

    /**
     * Metodo para obtener el numero de cliente siguiente
     *
     * @return Numero de cliente consecutivo
     */
    @Override
    public Integer getSigComentario(Integer idPedido) {
        Integer numComentario;
        try {
            try {
                numComentario = em.createQuery("SELECT MAX(c.numero) FROM Comentario c WHERE c.pedido.id = :idPed", Integer.class).setParameter("idPed", idPedido).getSingleResult();
                if (numComentario == null) {
                    numComentario = 1;
                } else {
                    numComentario++;
                }

            } catch (jakarta.persistence.NoResultException e) {
                //Error en caso de no encontrar registro, regreso null el objeto
                numComentario = 1;
            }
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener comentarios");
        }
        return numComentario;
    }

    /**
     * Metodo para borrar un comentario
     *
     * @param idComentario Identificador de comentario
     * @return Bean borrado
     */
    @Override
    public Comentario deleteComentario(Integer idComentario) {
        Comentario comentario = null;
        try {
            comentario = getComentario(idComentario);
            if (comentario != null) {
                em.getTransaction().begin();
                em.remove(comentario);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return comentario;
    }

    /**
     * Metodo para actualizar un comentario
     *
     * @param comentario Identificador de comentario
     * @return Bean actualizado
     */
    @Override
    public Comentario updateComentario(Comentario comentario) {
        em.getTransaction().begin();
        comentario.setFecact(new Date());
        em.merge(comentario);
        em.getTransaction().commit();
        return comentario;
    }

    /**
     * Metodo para insertar un comentario
     *
     * @param comentario Identificador de comentario
     * @return Bean insertado
     */
    @Override
    public Comentario insertComentario(Comentario comentario) {
        em.getTransaction().begin();
        em.persist(comentario);
        em.getTransaction().commit();
        return comentario;
    }

    /**
     * Metodo para obtener los comentarios por estado
     *
     * @param idEstado Identificador de estado
     * @param estatus_comentario Estatus del comentario
     * @return Lista de comentarios encontrados
     */
    @Override
    public List<Comentario> getComentariosPorIdPedido(Integer idPedido, Integer estatus_comentario) {
        List<Comentario> comentarios = new ArrayList<>();
        try {
            TypedQuery<Comentario> query = em.createQuery("SELECT c FROM Comentario c WHERE c.pedido.id = :idPed AND c.estatus = :est", Comentario.class);
            query.setParameter("idPed", idPedido);
            query.setParameter("est", estatus_comentario);
            comentarios = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener comentarios");
        }
        return comentarios;
    }
}
