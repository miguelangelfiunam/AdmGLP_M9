/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Local;
import java.util.List;
import mx.unam.dgtic.admglp.vo.Global;

/**
 *
 * @author unam
 */
@Local
public interface GlobalEJB {

    List<Global> getGlobales();

    Global getGlobal(String nomGlobal);

}
