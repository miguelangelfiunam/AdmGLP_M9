/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Local;
import java.util.Date;
import mx.unam.dgtic.admglp.vo.Turno;

import java.util.List;

/**
 *
 * @author unam
 */
@Local
public interface TurnoEJB {

    List<Turno> getTurnos();

    Turno getTurnoActual(Date inicio_turno, Integer estatus);

    List<Turno> getTurnosPorEstatus(Integer estatus);

    Turno getTurno(Integer idTurno);

    Turno insertaTurno(Turno turnoModel);

    Turno actualizaTurno(Turno turnoModel);

    void actualizaEstatusTurno(Integer id, Integer estatus);

    Turno eliminaTurno(Integer id);
}
