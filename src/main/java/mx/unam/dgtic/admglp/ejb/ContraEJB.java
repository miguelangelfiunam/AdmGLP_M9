/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Local;
import mx.unam.dgtic.admglp.vo.Contra;

import java.util.List;

/**
 *
 * @author unam
 */
@Local
public interface ContraEJB {
    
    List<Contra> getContras();

    List<Contra> getContrasPorEstatus(Integer estatus);

    Contra getContra(Integer idContra);
    
    Contra insertaContra(Contra contra);
    
    Contra actualizaContra(Contra contra);
    
    void eliminaContra(Integer id);
}
