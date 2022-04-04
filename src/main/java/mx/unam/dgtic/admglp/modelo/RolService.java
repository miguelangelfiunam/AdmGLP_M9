/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import mx.unam.dgtic.admglp.vo.Rol;

/**
 * Servicio para consulta de usuarios
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/03/2022
 *
 */
public class RolService {

    private Exception error;

    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public RolService(EntityManager em) {
        this.em = em;
    }

    public List<Rol> getRoles() {
        List<Rol> usuarios = new ArrayList<>();
        try {
            TypedQuery<Rol> query = em.createQuery("SELECT r FROM Rol r", Rol.class);
            usuarios = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener usuarios");
        }
        return usuarios;
    }
}
