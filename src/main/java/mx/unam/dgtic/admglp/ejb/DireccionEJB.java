package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Local;
import mx.unam.dgtic.admglp.vo.Direccion;

import java.util.List;

/**
 *
 * @author unam
 */
@Local
public interface DireccionEJB {

    List<Direccion> getDirecciones();

    List<Direccion> getDireccionesPorEstatus(Integer estatus);

    List<Direccion> getDireccionesPorIdAsentamiento(Integer idAsentamiento, Integer estatus_direccion);

//    List<Direccion> getDireccionesPorCliente(Integer idCliente, Integer estatus_direccion);

    Direccion getDireccion(Integer idDireccion);

    Direccion insertaDireccion(Direccion direccion);

    Direccion actualizaDireccion(Direccion direccion);

    void actualizaEstatusDireccion(Integer idDireccion, Integer status);

    void eliminaDireccion(Integer id);
}
