/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.modelo;

import java.util.List;
import mx.unam.dgtic.admglp.vo.Estado;

/**
 * Servicio para consulta de estados
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/03/2022
 *
 */
public interface EstadoService {

    public Exception getError();

    public List<Estado> getEstadosActivos();
    
    public List<Estado> getEstados(Integer estatus);

    public Estado getEstado(int idEstado);
    
    public Estado deleteEstado(int idEstado);
    
    public Estado updateEstado(Estado estado);
    
    public Estado insertEstado(Estado estado);
    
}
