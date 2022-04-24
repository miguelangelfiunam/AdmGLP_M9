/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Local;
import mx.unam.dgtic.admglp.vo.Usuario;

import java.util.List;

/**
 *
 * @author unam
 */
@Local
public interface UsuarioEJB {

    List<Usuario> getUsuarios();

    List<Usuario> getUsuariosPorEstatus(Integer estatus);

    Usuario getUsuario(Integer idUsuario);
    
    Usuario getUsuario(String apodo, String contra, Integer estatus);
    
    Boolean existeUsuario(String apodo, String contra);
    
    Usuario insertaUsuario(Usuario usuarioModel);
    
    Usuario actualizaUsuario(Usuario usuarioModel);
    
    void actualizaEstatusUsuario(Integer id, Integer estatus);
    
    void eliminaUsuario(Integer id);
}
