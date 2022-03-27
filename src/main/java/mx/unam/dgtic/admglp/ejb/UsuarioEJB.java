/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Local;
import mx.unam.dgtic.admglp.vo.RolModel;
import mx.unam.dgtic.admglp.vo.UsuarioModel;

import java.util.List;

/**
 *
 * @author unam
 */
@Local
public interface UsuarioEJB {

    List<UsuarioModel> getUsuarios();
    
    List<RolModel> getRoles();

    List<UsuarioModel> getUsuariosPorEstatus(Integer estatus);

    UsuarioModel getUsuario(Integer idUsuario);
    
    Boolean existeUsuario(String apodo, String contra);
    
    Integer insertaUsuario(UsuarioModel usuarioModel);
    
    void actualizaUsuario(UsuarioModel usuarioModel);
    
    void eliminaUsuario(Integer id);
}
