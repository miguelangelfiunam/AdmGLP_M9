/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Local;
import mx.unam.dgtic.admglp.vo.Asentamiento;

import java.util.List;

/**
 *
 * @author unam
 */
@Local
public interface AsentamientoEJB {

    List<Asentamiento> getAsentamientos();

    List<Asentamiento> getAsentamientosPorEstatus(Integer estatus);

    Asentamiento getAsentamiento(Integer idAsentamiento);
    
    List<Asentamiento> getAsentamientosPorIdMunicipio(Integer idMunicipio, Integer estatus_asentamiento);
    
    Boolean existeAsentamiento(Integer idUsuario);
    
    Asentamiento insertaAsentamiento(Asentamiento asentamiento);
    
    Asentamiento actualizaAsentamiento(Asentamiento asentamiento);
    
    void actualizaEstatusAsentamiento(Integer idAsentamiento, Integer estatus);
    
    void eliminaAsentamiento(Integer id);
}
