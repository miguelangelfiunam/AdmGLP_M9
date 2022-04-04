/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.unam.dgtic.admglp.bd.repository;

import java.util.List;

import mx.unam.dgtic.admglp.vo.Rol;

/**
 *
 * @author unam
 */
public interface RolDAO {

    List< Rol> getRoles();

    List< Rol> getRolesPorEstatus(Integer estatus);

    Rol getRol(Integer id);

    Boolean existeRol(Integer id);

    Integer insertaRol(Rol contraModel);

    void actualizaRol(Rol contraModel);

    void eliminaRol(Integer id);
}
