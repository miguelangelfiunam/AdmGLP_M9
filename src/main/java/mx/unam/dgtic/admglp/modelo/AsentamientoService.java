package mx.unam.dgtic.admglp.modelo;

import java.util.List;
import mx.unam.dgtic.admglp.vo.Asentamiento;

/**
 * Interfaz de servicio para consulta de asentamientos
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/03/2022
 *
 */
public interface AsentamientoService {

    public Exception getError();

    public List<Asentamiento> getAsentamientos();

    public List<Asentamiento> getAsentamientos(Integer estatus);

    public List<Asentamiento> getAsentamientosPorIdMunicipio(Integer idMunicipio, Integer estatus_asentamiento);

    public Asentamiento getAsentamiento(int idasentamiento);

    public Asentamiento deleteAsentamiento(int idasentamiento);

    public Asentamiento updateAsentamiento(Asentamiento asentamiento);

    public Asentamiento insertAsentamiento(Asentamiento asentamiento);

}
