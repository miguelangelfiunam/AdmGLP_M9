/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.modelo;

import java.util.List;
import mx.unam.dgtic.admglp.vo.Asentamiento;

/**
 * Servicio para consulta de usuarios
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/03/2022
 *
 */
public interface AsentamientoService {

    public Exception getError();

    public List<Asentamiento> getAsentamientosActivos();
    
    public List<Asentamiento> getAsentamientos(Integer estatus);

    public Asentamiento getAsentamiento(int idusuario);
    
    public Asentamiento deleteAsentamiento(int idusuario);
    
    public Asentamiento updateAsentamiento(Asentamiento usuario);
    
    public Asentamiento insertAsentamiento(Asentamiento usuario);
    
}
