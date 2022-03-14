/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.unam.dgtic.admglp.bd.repository;

import java.util.List;
import mx.unam.dgtic.admglp.bd.model.RolModel;

/**
 *
 * @author unam
 */
public interface RolDAOJDBC {

    List< RolModel> getRoles();

    List< RolModel> getRolesPorEstatus(Integer estatus);

    RolModel getRol(Integer id);

    Boolean existeRol(Integer id);

    Integer insertaRol(RolModel contraModel);

    void actualizaRol(RolModel contraModel);

    void eliminaRol(Integer id);
}
