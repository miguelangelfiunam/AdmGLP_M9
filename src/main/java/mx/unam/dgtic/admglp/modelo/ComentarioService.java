package mx.unam.dgtic.admglp.modelo;

import java.util.List;
import mx.unam.dgtic.admglp.vo.Comentario;

/**
 * Interfaz para CRUD de comentarios
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/04/2022
 *
 */
public interface ComentarioService {

    public Exception getError();

    public List<Comentario> getComentarios();

    public List<Comentario> getComentarios(Integer estatus);

    public List<Comentario> getComentariosPorIdPedido(Integer idPedido, Integer estatus_comentario);

    public Comentario getComentario(Integer idComentario);

    public Integer getSigComentario(Integer idPedido);

    public Comentario deleteComentario(Integer idComentario);

    public Comentario updateComentario(Comentario comentario);

    public Comentario insertComentario(Comentario comentario);

}
