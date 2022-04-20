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
import mx.unam.dgtic.admglp.vo.Asentamiento;

/**
 * Servicio para consulta de asentamientos
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/03/2022
 *
 */
public class AsentamientoServiceImpl implements AsentamientoService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public AsentamientoServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Asentamiento> getAsentamientosActivos() {
        List<Asentamiento> asentamientos = new ArrayList<>();
        try {
            TypedQuery<Asentamiento> query = em.createQuery("SELECT a FROM Asentamiento a WHERE a.estatus = :est", Asentamiento.class);
            query.setParameter("est", 10);
            asentamientos = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener asentamientos");
        }
        return asentamientos;
    }

    @Override
    public List<Asentamiento> getAsentamientos(Integer estatus) {
        List<Asentamiento> asentamientos = new ArrayList<>();
        try {
            TypedQuery<Asentamiento> query = em.createQuery("SELECT a FROM Asentamiento a WHERE a.estatus = :est", Asentamiento.class);
            query.setParameter("est", estatus);
            asentamientos = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener asentamientos");
        }
        return asentamientos;
    }

    @Override
    public Asentamiento getAsentamiento(int idAsentamiento) {
        return em.find(Asentamiento.class, idAsentamiento);
    }

    @Override
    public Asentamiento deleteAsentamiento(int idAsentamiento) {
        Asentamiento asentamiento = null;
        try {
            asentamiento = getAsentamiento(idAsentamiento);
            if (asentamiento != null) {
                em.getTransaction().begin();
                em.remove(asentamiento);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return asentamiento;
    }

    @Override
    public Asentamiento updateAsentamiento(Asentamiento asentamiento) {
        em.getTransaction().begin();
        asentamiento.setFecact(new Date());
        em.persist(asentamiento);
        em.getTransaction().commit();
        return asentamiento;
    }

    @Override
    public Asentamiento insertAsentamiento(Asentamiento asentamiento) {
        em.getTransaction().begin();
        em.persist(asentamiento);
        em.getTransaction().commit();
        return asentamiento;
    }

}
