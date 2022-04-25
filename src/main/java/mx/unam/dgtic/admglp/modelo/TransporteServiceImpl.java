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
import mx.unam.dgtic.admglp.vo.Transporte;

/**
 * Servicio para consulta de transportes
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/03/2022
 *
 */
public class TransporteServiceImpl implements TransporteService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public TransporteServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Transporte> getTransportes() {
        List<Transporte> transportes = new ArrayList<>();
        try {
            TypedQuery<Transporte> query = em.createQuery("SELECT t FROM Transporte t", Transporte.class);
            transportes = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener transportes");
        }
        return transportes;
    }

    @Override
    public List<Transporte> getTransportes(Integer estatus) {
        List<Transporte> transportes = new ArrayList<>();
        try {
            TypedQuery<Transporte> query = em.createQuery("SELECT t FROM Transporte t WHERE t.estatus = :est", Transporte.class);
            query.setParameter("est", estatus);
            transportes = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener transportes");
        }
        return transportes;
    }

    @Override
    public Transporte getTransporte(int idTransporte) {
        return em.find(Transporte.class, idTransporte);
    }

    @Override
    public Transporte deleteTransporte(int idTransporte) {
        Transporte transporte = null;
        try {
            transporte = getTransporte(idTransporte);
            if (transporte != null) {
                em.getTransaction().begin();
                em.remove(transporte);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return transporte;
    }

    @Override
    public Transporte updateTransporte(Transporte transporte) {
        em.getTransaction().begin();
        transporte.setFecact(new Date());
        em.merge(transporte);
        em.getTransaction().commit();
        return transporte;
    }

    @Override
    public Transporte insertTransporte(Transporte transporte) {
        em.getTransaction().begin();
        em.persist(transporte);
        em.getTransaction().commit();
        return transporte;
    }

}
