/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.vo.Rol;

/**
 * Servicio para consulta de rols
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/03/2022
 *
 */
public class RolServiceImpl implements RolService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public RolServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Rol> getRoles() {
        List<Rol> roles = new ArrayList<>();
        try {
            TypedQuery<Rol> query = em.createQuery("SELECT r FROM Rol r", Rol.class);
            roles = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener rols");
        }
        return roles;
    }

    @Override
    public List<Rol> getRoles(Integer estatus) {
        List<Rol> rols = new ArrayList<>();
        try {
            TypedQuery<Rol> query = em.createQuery("SELECT r FROM Rol r WHERE r.estatus = :est", Rol.class);
            query.setParameter("est", estatus);
            rols = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener rols");
        }
        return rols;
    }

    @Override
    public Rol getRol(int idRol) {
        return em.find(Rol.class, idRol);
    }

    @Override
    public Rol deleteRol(int idRol) {
        Rol rol = null;
        try {
            rol = getRol(idRol);
            if (rol != null) {
                em.getTransaction().begin();
                em.remove(rol);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rol;
    }

    @Override
    public Rol updateRol(Rol rol) {
        em.getTransaction().begin();
        rol.setFecact(new Date());
        em.merge(rol);
        em.getTransaction().commit();
        return rol;
    }

    @Override
    public Rol insertRol(Rol rol) {
        em.getTransaction().begin();
        em.persist(rol);
        em.getTransaction().commit();
        return rol;
    }

}
