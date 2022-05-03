package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Local;
import mx.unam.dgtic.admglp.vo.Estatus;

import java.util.List;

/**
 *
 * @author unam
 */
@Local
public interface EstatusEJB {

    List<Estatus> getEstatusLista();

    List<Estatus> getEstatusLista(String tabla, Integer activo);

    List<Estatus> getEstatusListaPorActivo(Integer activo);

    Estatus getEstatusObjeto(Integer idEstatus);
    
    Estatus getEstatusObjeto(String tabla, Integer numEstatus, Integer activo);

    Boolean existeEstatusObjeto(Integer idEstatus);

    Estatus insertaEstatusObjeto(Estatus estatus);

    Estatus actualizaEstatusObjeto(Estatus estatus);

    void actualizaActivoEstatus(Integer idEstatus, Integer activo);

    void eliminaEstatusObjeto(Integer id);
}
