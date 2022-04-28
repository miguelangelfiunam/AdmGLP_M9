/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Local;
import mx.unam.dgtic.admglp.vo.Rol;

import java.util.List;

/**
 *
 * @author unam
 */
@Local
public interface RolEJB {
    
    List<Rol> getRoles();

    List<Rol> getRolesPorEstatus(Integer estatus);

    Rol getRol(Integer idRol);
    
    Rol insertaRol(Rol rol);
    
    Rol actualizaRol(Rol rol);
    
    void actualizaEstatusRol(Integer idRol, Integer estatus);
    
    void eliminaRol(Integer id);
}
