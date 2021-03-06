package mx.unam.dgtic.admglp.modelo;

import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.vo.Turno;

/**
 * Interfaz de servicio para consulta de turnos
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 17/04/2022 - 26/04/2022
 *
 */
public interface TurnoService {

    Exception getError();

    List<Turno> getTurnos();

    Turno getTurnoActual(Date inicio_turno, Integer estatus);

    List<Turno> getTurnos(Integer estatus);

    Turno getTurno(int idturno);

    Turno deleteTurno(int idturno);

    Turno updateTurno(Turno turno);

    Turno insertTurno(Turno turno);

}
