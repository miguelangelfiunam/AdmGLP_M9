package mx.unam.dgtic.admglp.modelo;

import java.util.List;
import mx.unam.dgtic.admglp.vo.Transporte;

/**
 * Interfaz de servicio para consulta de transportes
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 16/04/2022 - 16/04/2022
 *
 */
public interface TransporteService {

    public Exception getError();

    public List<Transporte> getTransportes();
    
    public List<Transporte> getTransportes(Integer estatus);

    public Transporte getTransporte(int idtransporte);
    
    public Transporte deleteTransporte(int idtransporte);
    
    public Transporte updateTransporte(Transporte transporte);
    
    public Transporte insertTransporte(Transporte transporte);
    
}
