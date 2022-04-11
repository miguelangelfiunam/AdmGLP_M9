/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.modelo;

import java.util.List;
import mx.unam.dgtic.admglp.vo.Global;

/**
 * Interfaz para CRUD de globales
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/03/2022
 *
 */
public interface GlobalService {

    public Exception getError();

    public List<Global> getGlobales();

    public Global getGlobal(int idGlobal);
    
    public Global getGlobal(String nomGlobal);
    
    public Global deleteGlobal(int idGlobal);
    
    public Global updateGlobal(Global global);
    
    public Global insertGlobal(Global global);
    
}
