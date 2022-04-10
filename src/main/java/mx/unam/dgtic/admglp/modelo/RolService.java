/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.modelo;

import java.util.List;
import mx.unam.dgtic.admglp.vo.Rol;

/**
 * Interfaz para CRUD de roles
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/03/2022
 *
 */
public interface RolService {

    public Exception getError();

    public List<Rol> getRolesActivos();
    
    public List<Rol> getRoles(Integer estatus);

    public Rol getRol(int idRol);
    
    public Rol deleteRol(int idRol);
    
    public Rol updateRol(Rol rol);
    
    public Rol insertRol(Rol rol);
    
}
