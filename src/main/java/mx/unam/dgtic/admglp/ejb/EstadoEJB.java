/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Local;
import mx.unam.dgtic.admglp.vo.Estado;

import java.util.List;

/**
 *
 * @author unam
 */
@Local
public interface EstadoEJB {

    List<Estado> getEstados();

    List<Estado> getEstadosPorEstatus(Integer estatus);

    Estado getEstado(Integer idEstado);
    
    Boolean existeEstado(Integer idUsuario);
    
    Estado insertaEstado(Estado estado);
    
    Estado actualizaEstado(Estado estado);
    
    void actualizaEstatusEstado(Integer idEstado, Integer estatus);
    
    void eliminaEstado(Integer id);
}
