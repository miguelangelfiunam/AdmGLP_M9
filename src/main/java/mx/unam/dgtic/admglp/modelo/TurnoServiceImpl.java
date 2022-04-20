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
import mx.unam.dgtic.admglp.vo.Turno;

/**
 * Servicio para consulta de turnos
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 17/04/2022 - 17/04/2022
 *
 */
public class TurnoServiceImpl implements TurnoService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public TurnoServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Turno> getTurnos() {
        List<Turno> turnos = new ArrayList<>();
        try {
            TypedQuery<Turno> query = em.createQuery("SELECT t FROM Turno t", Turno.class);
            turnos = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener turnos");
        }
        return turnos;
    }

    @Override
    public List<Turno> getTurnos(Integer estatus) {
        List<Turno> turnos = new ArrayList<>();
        try {
            TypedQuery<Turno> query = em.createQuery("SELECT t FROM Turno t WHERE t.estatus = :est", Turno.class);
            query.setParameter("est", estatus);
            turnos = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener turnos");
        }
        return turnos;
    }

    @Override
    public Turno getTurno(int idTurno) {
        return em.find(Turno.class, idTurno);
    }

    @Override
    public Turno deleteTurno(int idTurno) {
        Turno turno = null;
        try {
            turno = getTurno(idTurno);
            if (turno != null) {
                em.getTransaction().begin();
                em.remove(turno);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return turno;
    }

    @Override
    public Turno updateTurno(Turno turno) {
        em.getTransaction().begin();
        turno.setFecact(new Date());
        em.persist(turno);
        em.getTransaction().commit();
        return turno;
    }

    @Override
    public Turno insertTurno(Turno turno) {
        em.getTransaction().begin();
        em.persist(turno);
        em.getTransaction().commit();
        return turno;
    }

}
