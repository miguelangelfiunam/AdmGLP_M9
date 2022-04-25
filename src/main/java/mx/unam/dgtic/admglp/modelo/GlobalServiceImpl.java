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
import mx.unam.dgtic.admglp.vo.Global;
import mx.unam.dgtic.admglp.vo.Global;

/**
 * Servicio para consulta de globals
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/03/2022
 *
 */
public class GlobalServiceImpl implements GlobalService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public GlobalServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Global> getGlobales() {
        List<Global> globales = new ArrayList<>();
        try {
            TypedQuery<Global> query = em.createQuery("SELECT g FROM Global g", Global.class);
            globales = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener globals");
        }
        return globales;
    }

    @Override
    public Global getGlobal(int idGlobal) {
        return em.find(Global.class, idGlobal);
    }

    @Override
    public Global getGlobal(String nomGlobal) {
        Global global = null;
        try {
            try {
                TypedQuery<Global> query = em.createQuery("SELECT g FROM Global g WHERE g.nombre = :name", Global.class);
                query.setParameter("name", nomGlobal);
                global = query.getSingleResult();
            } catch (jakarta.persistence.NoResultException e) {
                //Error en caso de no encontrar registro, regreso null el objeto
            }
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener globals");
        }
        return global;
    }

    @Override
    public Global deleteGlobal(int idGlobal) {
        Global global = null;
        try {
            global = getGlobal(idGlobal);
            if (global != null) {
                em.getTransaction().begin();
                em.remove(global);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return global;
    }

    @Override
    public Global updateGlobal(Global global) {
        em.getTransaction().begin();
        em.merge(global);
        em.getTransaction().commit();
        return global;
    }

    @Override
    public Global insertGlobal(Global global) {
        em.getTransaction().begin();
        em.persist(global);
        em.getTransaction().commit();
        return global;
    }

}
