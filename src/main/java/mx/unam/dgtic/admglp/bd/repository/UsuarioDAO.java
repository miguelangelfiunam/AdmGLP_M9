/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.unam.dgtic.admglp.bd.repository;

import java.util.List;

import mx.unam.dgtic.admglp.vo.Usuario;

/**
 *
 * @author unam
 */
public interface UsuarioDAO {
    List<Usuario> getUsuarios();

    List<Usuario> getUsuariosPorEstatus(Integer estatus);

    Usuario getUsuario(Integer idUsuario);
    
    Boolean existeUsuario(String apodo, String contra);
    
    Integer insertaUsuario(Usuario usuarioModel);
    
    void actualizaUsuario(Usuario usuarioModel);
    
    void eliminaUsuario(Integer id);
}
