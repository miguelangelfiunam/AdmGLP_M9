/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.bd.repository;

import java.util.List;

import mx.unam.dgtic.admglp.vo.Contra;

/**
 *
 * @author unam
 */
public interface ContraDAO {

    List<Contra> getContras();

    List<Contra> getContrasPorEstatus(Integer estatus);

    Contra getContra(Integer id);

    Boolean existeContra(String apodo, String contra);

    Integer insertaContra(Contra contraModel);

    void actualizaContra(Contra contraModel);

    void eliminaContra(Integer id);
}
