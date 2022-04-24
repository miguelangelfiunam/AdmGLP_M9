/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Local;
import mx.unam.dgtic.admglp.vo.Acceso;

import java.util.List;

/**
 *
 * @author unam
 */
@Local
public interface AccesoEJB {
    
    List<Acceso> getAccesos();

    List<Acceso> getAccesosPorEstatus(Integer estatus);

    Acceso getAcceso(Integer idAcceso);
    
    Acceso insertaAcceso(Acceso acceso);
    
    Acceso actualizaAcceso(Acceso acceso);
    
    Acceso finalizaAcceso(Integer id);
    
    Acceso eliminaAcceso(Integer id);
}
