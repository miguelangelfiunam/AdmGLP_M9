/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.modelo;

import java.util.List;
import mx.unam.dgtic.admglp.vo.Empleado;

/**
 * Interfaz para CRUD de empleados
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/03/2022
 *
 */
public interface EmpleadoService {

    public Exception getError();

    public List<Empleado> getEmpleados();
    
    public List<Empleado> getEmpleados(Integer estatus);

    public Empleado getEmpleado(int idEmpleado);
    
    public Empleado getEmpleadoPorIdUsuario(int idUsuario);
    
    public Empleado deleteEmpleado(int idEmpleado);
    
    public Empleado updateEmpleado(Empleado empleado);
    
    public Empleado insertEmpleado(Empleado empleado);
    
}
