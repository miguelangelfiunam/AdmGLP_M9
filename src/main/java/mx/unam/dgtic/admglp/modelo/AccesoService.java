package mx.unam.dgtic.admglp.modelo;

import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.vo.Acceso;

/**
 * Interfaz de servicio para consulta de accesos
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/04/2022
 *
 */
public interface AccesoService {

    public Exception getError();

    public List<Acceso> getAccesos();

    public List<Acceso> getAccesosCriteria(Integer estatus, Date r_ini_1, Date r_ini_2, Date r_fin_1, Date r_fin_2, Integer idEmpleado);

    public Acceso getAcceso(int idAcceso);

    public Acceso deleteAcceso(int idAcceso);

    public Acceso updateAcceso(Acceso acceso);

    public Acceso insertAcceso(Acceso acceso);

}
