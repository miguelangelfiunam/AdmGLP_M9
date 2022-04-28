/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Local;
import mx.unam.dgtic.admglp.vo.Comentario;

import java.util.List;

/**
 *
 * @author unam
 */
@Local
public interface ComentarioEJB {

    List<Comentario> getComentarios();

    List<Comentario> getComentariosPorEstatus(Integer estatus);

    Comentario getComentario(Integer idComentario);

    Integer getNumComentario(Integer idPedido);

    List<Comentario> getComentariosPorIdPedido(Integer idPedido, Integer estatus_comentario);

    Boolean existeComentario(Integer idComentario);

    Comentario insertaComentario(Comentario comentario);

    Comentario actualizaComentario(Comentario comentario);

    void actualizaEstatusComentario(Integer idComentario, Integer estatus);

    void eliminaComentario(Integer id);
}
