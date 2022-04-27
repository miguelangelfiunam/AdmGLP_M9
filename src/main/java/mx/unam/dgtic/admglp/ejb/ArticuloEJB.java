/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Local;
import mx.unam.dgtic.admglp.vo.Articulo;

import java.util.List;

/**
 *
 * @author unam
 */
@Local
public interface ArticuloEJB {

    List<Articulo> getArticulos();

    List<Articulo> getArticulosPorEstatus(Integer estatus);

    Articulo getArticulo(Integer idArticulo);
    
    Boolean existeArticulo(Integer idArticulo);
    
    Articulo insertaArticulo(Articulo articulo);
    
    Articulo actualizaArticulo(Articulo articulo);
    
    void actualizaEstatusArticulo(Integer idArticulo, Integer estatus);
    
    void eliminaArticulo(Integer id);
}
