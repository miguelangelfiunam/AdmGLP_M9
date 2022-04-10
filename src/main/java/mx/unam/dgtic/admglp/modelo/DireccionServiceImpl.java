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
import mx.unam.dgtic.admglp.vo.Direccion;

/**
 * Servicio para consulta de direccions
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/03/2022
 *
 */
public class DireccionServiceImpl implements DireccionService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public DireccionServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Direccion> getDireccionesActivas() {
        List<Direccion> direccions = new ArrayList<>();
        try {
            TypedQuery<Direccion> query = em.createQuery("SELECT d FROM Direccion d WHERE d.estatus = :est", Direccion.class);
            query.setParameter("est", 10);
            direccions = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener direcciones");
        }
        return direccions;
    }

    @Override
    public List<Direccion> getDirecciones(Integer estatus) {
        List<Direccion> direccions = new ArrayList<>();
        try {
            TypedQuery<Direccion> query = em.createQuery("SELECT d FROM Direccion d WHERE d.estatus = :est", Direccion.class);
            query.setParameter("est", estatus);
            direccions = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener direccions");
        }
        return direccions;
    }

    @Override
    public Direccion getDireccion(int idDireccion) {
        return em.find(Direccion.class, idDireccion);
    }

    @Override
    public Direccion deleteDireccion(int idDireccion) {
        Direccion direccion = null;
        try {
            direccion = getDireccion(idDireccion);
            if (direccion != null) {
                em.getTransaction().begin();
                em.remove(direccion);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return direccion;
    }

    @Override
    public Direccion updateDireccion(Direccion direccion) {
        em.getTransaction().begin();
        direccion.setFecact(new Date());
        em.persist(direccion);
        em.getTransaction().commit();
        return direccion;
    }

    @Override
    public Direccion insertDireccion(Direccion direccion) {
        em.getTransaction().begin();
        em.persist(direccion);
        em.getTransaction().commit();
        return direccion;
    }
}
