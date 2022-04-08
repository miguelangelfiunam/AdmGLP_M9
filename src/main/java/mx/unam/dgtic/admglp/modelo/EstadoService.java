/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import mx.unam.dgtic.admglp.vo.Estado;

/**
 * Servicio para consulta de usuarios
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/03/2022
 *
 */
public class EstadoService {

    private Exception error;

    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public EstadoService(EntityManager em) {
        this.em = em;
    }

    public List<Estado> getEstados() {
        TypedQuery<Estado> query = em.createQuery("SELECT e FROM Estado e", Estado.class);
        return query.getResultList();
    }
}
