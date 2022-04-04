/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.unam.dgtic.admglp.bd.repository;

import java.util.List;

import mx.unam.dgtic.admglp.vo.Usuario_rol;

/**
 *
 * @author unam
 */
public interface Usuario_rolDAO {

    List<Usuario_rol> getRolesUsu(Integer idUsuario);

    Usuario_rol getRol(Integer id);

    Integer insertaRol(Usuario_rol usuario_rolModel);

    void actualizaRol(Usuario_rol usuario_rolModel);

    void eliminaRol(Integer id);
}
