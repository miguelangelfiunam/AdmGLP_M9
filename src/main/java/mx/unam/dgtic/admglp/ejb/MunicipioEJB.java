/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Local;
import mx.unam.dgtic.admglp.vo.Municipio;

import java.util.List;

/**
 *
 * @author unam
 */
@Local
public interface MunicipioEJB {

    List<Municipio> getMunicipios();

    List<Municipio> getMunicipiosPorEstatus(Integer estatus);

    Municipio getMunicipio(Integer idMunicipio);
    
    List<Municipio> getMunicipiosPorIdEstado(Integer idEstado, Integer estatus_municipio);
    
    Boolean existeMunicipio(Integer idUsuario);
    
    Municipio insertaMunicipio(Municipio municipio);
    
    Municipio actualizaMunicipio(Municipio municipio);
    
    void actualizaEstatusMunicipio(Integer idMunicipio, Integer estatus);
    
    void eliminaMunicipio(Integer id);
}
