package mx.unam.dgtic.admglp.modelo;

import java.util.List;
import mx.unam.dgtic.admglp.vo.Direccion;

/**
 * Interfaz para CRUD de direcciones
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/03/2022
 *
 */
public interface DireccionService {

    public Exception getError();

    public List<Direccion> getDirecciones();
    
    public List<Direccion> getDirecciones(Integer estatus);
    
    public List<Direccion> getDireccionesPorIdAsentamiento(Integer idAsentamiento, Integer estatus_direccion);
    
    public List<Direccion> getDireccionesPorIdCliente(Integer idCliente, Integer estatus_direccion);

    public Direccion getDireccion(int idDireccion);
    
    public Direccion deleteDireccion(int idDireccion);
    
    public Direccion updateDireccion(Direccion municipio);
    
    public Direccion insertDireccion(Direccion municipio);
    
}
