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
import mx.unam.dgtic.admglp.vo.Estado;

/**
 * Servicio para consulta de estados
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/03/2022
 *
 */
public class EstadoServiceImpl implements EstadoService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public EstadoServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Estado> getEstados() {
        List<Estado> estados = new ArrayList<>();
        try {
            TypedQuery<Estado> query = em.createQuery("SELECT e FROM Estado e", Estado.class);
            estados = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener estados");
        }
        return estados;
    }

    @Override
    public List<Estado> getEstados(Integer estatus) {
        List<Estado> estados = new ArrayList<>();
        try {
            TypedQuery<Estado> query = em.createQuery("SELECT u FROM Estado u WHERE u.estatus = :est", Estado.class);
            query.setParameter("est", estatus);
            estados = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener estados");
        }
        return estados;
    }

    @Override
    public Estado getEstado(int idEstado) {
        return em.find(Estado.class, idEstado);
    }

    @Override
    public Estado deleteEstado(int idEstado) {
        Estado estado = null;
        try {
            estado = getEstado(idEstado);
            if (estado != null) {
                em.getTransaction().begin();
                em.remove(estado);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return estado;
    }

    @Override
    public Estado updateEstado(Estado estado) {
        em.getTransaction().begin();
        estado.setFecact(new Date());
        em.persist(estado);
        em.getTransaction().commit();
        return estado;
    }

    @Override
    public Estado insertEstado(Estado estado) {
        em.getTransaction().begin();
        em.persist(estado);
        em.getTransaction().commit();
        return estado;
    }

}
