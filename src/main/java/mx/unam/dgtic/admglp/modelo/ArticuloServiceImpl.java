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
import mx.unam.dgtic.admglp.vo.Articulo;

/**
 * Servicio para consulta de articulos
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/03/2022
 *
 */
public class ArticuloServiceImpl implements ArticuloService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public ArticuloServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Articulo> getArticulos() {
        List<Articulo> articulos = new ArrayList<>();
        try {
            TypedQuery<Articulo> query = em.createQuery("SELECT a FROM Articulo a", Articulo.class);
            articulos = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener articulos");
        }
        return articulos;
    }

    @Override
    public List<Articulo> getArticulos(Integer estatus) {
        List<Articulo> articulos = new ArrayList<>();
        try {
            TypedQuery<Articulo> query = em.createQuery("SELECT a FROM Articulo a WHERE a.estatus = :est", Articulo.class);
            query.setParameter("est", estatus);
            articulos = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener articulos");
        }
        return articulos;
    }

    @Override
    public Articulo getArticulo(int idArticulo) {
        return em.find(Articulo.class, idArticulo);
    }

    @Override
    public Articulo deleteArticulo(int idArticulo) {
        Articulo articulo = null;
        try {
            articulo = getArticulo(idArticulo);
            if (articulo != null) {
                em.getTransaction().begin();
                em.remove(articulo);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return articulo;
    }

    @Override
    public Articulo updateArticulo(Articulo articulo) {
        em.getTransaction().begin();
        articulo.setFecact(new Date());
        em.persist(articulo);
        em.getTransaction().commit();
        return articulo;
    }

    @Override
    public Articulo insertArticulo(Articulo articulo) {
        em.getTransaction().begin();
        em.persist(articulo);
        em.getTransaction().commit();
        return articulo;
    }

}
