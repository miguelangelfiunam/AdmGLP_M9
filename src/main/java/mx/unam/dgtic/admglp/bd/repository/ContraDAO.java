/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.bd.repository;

import java.util.List;

import mx.unam.dgtic.admglp.vo.ContraModel;

/**
 *
 * @author unam
 */
public interface ContraDAO {

    List<ContraModel> getContras();

    List<ContraModel> getContrasPorEstatus(Integer estatus);

    ContraModel getContra(Integer id);

    Boolean existeContra(String apodo, String contra);

    Integer insertaContra(ContraModel contraModel);

    void actualizaContra(ContraModel contraModel);

    void eliminaContra(Integer id);
}
