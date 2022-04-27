package mx.unam.dgtic.admglp.modelo;

import java.util.List;
import mx.unam.dgtic.admglp.vo.Estatus;

/**
 * Interfaz de servicio para consulta de estatus
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/04/2022
 *
 */
public interface EstatusService {

    public Exception getError();

    public List<Estatus> getEstatusLista();

    public List<Estatus> getEstatusLista(Integer estatus);

    public List<Estatus> getEstatusLista(String tabla, Integer estatus);

    public Estatus getEstatusObjeto(int idEstatus);

    public Estatus deleteEstatusObjeto(int idEstatus);

    public Estatus updateEstatusObjeto(Estatus estatus);

    public Estatus insertEstatusObjeto(Estatus estatus);

}
