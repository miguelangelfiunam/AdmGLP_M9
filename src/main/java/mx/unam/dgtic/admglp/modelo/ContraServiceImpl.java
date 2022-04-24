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
import mx.unam.dgtic.admglp.vo.Contra;

/**
 * Servicio para consulta de contras
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/03/2022
 *
 */
public class ContraServiceImpl implements ContraService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public ContraServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Contra> getContras() {
        List<Contra> contras = new ArrayList<>();
        try {
            TypedQuery<Contra> query = em.createQuery("SELECT c FROM Contra c", Contra.class);
            contras = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener contras");
        }
        return contras;
    }

    @Override
    public List<Contra> getContras(Integer estatus) {
        List<Contra> contras = new ArrayList<>();
        try {
            TypedQuery<Contra> query = em.createQuery("SELECT c FROM Contra c WHERE c.estatus = :est", Contra.class);
            query.setParameter("est", estatus);
            contras = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener contras");
        }
        return contras;
    }

    @Override
    public Contra getContra(int idcontra) {
        return em.find(Contra.class, idcontra);
    }

    @Override
    public Contra deleteContra(int idContra) {
        Contra contra = null;
        try {
            contra = getContra(idContra);
            if (contra != null) {
                em.getTransaction().begin();
                em.remove(contra);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return contra;
    }

    @Override
    public Contra updateContra(Contra contra) {
        em.getTransaction().begin();
        contra.setFecact(new Date());
        em.merge(contra);
        em.getTransaction().commit();
        return contra;
    }

    @Override
    public Contra insertContra(Contra contra) {
        em.getTransaction().begin();
        em.persist(contra);
        em.getTransaction().commit();
        return contra;
    }
}
