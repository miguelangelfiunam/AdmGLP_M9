/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.modelo;

import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.vo.Turno;

/**
 * Servicio para consulta de turnos
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 17/04/2022 - 17/04/2022
 *
 */
public interface TurnoService {

    public Exception getError();

    public List<Turno> getTurnos();
    
    public Turno getTurnoActual(Date inicio_turno);
    
    public List<Turno> getTurnos(Integer estatus);

    public Turno getTurno(int idturno);
    
    public Turno deleteTurno(int idturno);
    
    public Turno updateTurno(Turno turno);
    
    public Turno insertTurno(Turno turno);
    
}
