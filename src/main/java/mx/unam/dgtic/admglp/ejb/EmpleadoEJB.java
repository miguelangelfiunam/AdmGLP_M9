/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Local;
import mx.unam.dgtic.admglp.vo.Empleado;

import java.util.List;

/**
 *
 * @author unam
 */
@Local
public interface EmpleadoEJB {

    List<Empleado> getEmpleados();

    List<Empleado> getEmpleadosPorEstatus(Integer estatus);

    Empleado getEmpleado(Integer idEmpleado);
    
    Empleado getEmpleadoPorIdUsuario(Integer idUsuario);
    
    Boolean existeEmpleado(Integer idUsuario);
    
    Empleado insertaEmpleado(Empleado empleado);
    
    Empleado actualizaEmpleado(Empleado empleado);
    
    void actualizaEstatusEmpleado(Integer idEmpleado, Integer estatus);
    
    void eliminaEmpleado(Integer id);
}
