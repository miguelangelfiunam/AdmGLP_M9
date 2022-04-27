/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Local;
import mx.unam.dgtic.admglp.vo.Transporte;

import java.util.List;
import mx.unam.dgtic.admglp.vo.TransporteMarca;

/**
 *
 * @author unam
 */
@Local
public interface TransporteEJB {

    List<Transporte> getTransportes();

    List<Transporte> getTransportesPorEstatus(Integer estatus);
    
    List<TransporteMarca> getMarcasTransportes();

    Transporte getTransporte(Integer idTransporte);
    
    Boolean existeTransporte(Integer idTransporte);
    
    Transporte insertaTransporte(Transporte transporte);
    
    Transporte actualizaTransporte(Transporte transporte);
    
    void actualizaEstatusTransporte(Integer idTransporte, Integer estatus);
    
    void eliminaTransporte(Integer id);
}
