package mx.unam.dgtic.admglp.modelo;

import java.util.List;
import mx.unam.dgtic.admglp.vo.Contra;

/**
 * Interfaz de servicio para consulta de contras
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/04/2022
 *
 */
public interface ContraService {

    public Exception getError();

    public List<Contra> getContras();

    public List<Contra> getContras(Integer estatus);

    public Contra getContra(int idContra);

    public Contra deleteContra(int idContra);

    public Contra updateContra(Contra contra);

    public Contra insertContra(Contra contra);

}
