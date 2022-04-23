/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.modelo;

import java.util.List;
import mx.unam.dgtic.admglp.vo.Asentamiento;

/**
 * Servicio para consulta de asentamientos
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/03/2022
 *
 */
public interface AsentamientoService {

    public Exception getError();

    public List<Asentamiento> getAsentamientos();
    
    public List<Asentamiento> getAsentamientos(Integer estatus);

    public Asentamiento getAsentamiento(int idasentamiento);
    
    public Asentamiento deleteAsentamiento(int idasentamiento);
    
    public Asentamiento updateAsentamiento(Asentamiento asentamiento);
    
    public Asentamiento insertAsentamiento(Asentamiento asentamiento);
    
}
