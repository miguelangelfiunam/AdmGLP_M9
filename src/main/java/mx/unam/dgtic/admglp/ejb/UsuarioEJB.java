/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Local;
import mx.unam.dgtic.admglp.vo.Rol;
import mx.unam.dgtic.admglp.vo.Usuario;

import java.util.List;

/**
 *
 * @author unam
 */
@Local
public interface UsuarioEJB {

    List<Usuario> getUsuarios();
    
    List<Rol> getRoles();

    List<Usuario> getUsuariosPorEstatus(Integer estatus);

    Usuario getUsuario(Integer idUsuario);
    
    Boolean existeUsuario(String apodo, String contra);
    
    Integer insertaUsuario(Usuario usuarioModel);
    
    void actualizaUsuario(Usuario usuarioModel);
    
    void eliminaUsuario(Integer id);
}