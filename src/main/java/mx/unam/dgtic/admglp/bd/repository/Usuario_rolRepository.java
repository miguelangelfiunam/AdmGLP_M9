/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.unam.dgtic.admglp.bd.repository;

import java.util.List;
import mx.unam.dgtic.admglp.bd.model.Usuario_rolModel;

/**
 *
 * @author unam
 */
public interface Usuario_rolRepository {

    List<Usuario_rolModel> getRolesUsu(Integer idUsuario);

    Usuario_rolModel getRol(Integer id);

    Integer insertaRol(Usuario_rolModel usuario_rolModel);

    void actualizaRol(Usuario_rolModel usuario_rolModel);

    void eliminaRol(Integer id);
}
