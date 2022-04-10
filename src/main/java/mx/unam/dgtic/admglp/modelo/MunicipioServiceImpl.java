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
import mx.unam.dgtic.admglp.vo.Municipio;

/**
 * Servicio para consulta de municipios
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/03/2022
 *
 */
public class MunicipioServiceImpl implements MunicipioService{

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public MunicipioServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Municipio> getMunicipiosActivos() {
        List<Municipio> municipios = new ArrayList<>();
        try {
            TypedQuery<Municipio> query = em.createQuery("SELECT m FROM Municipio m WHERE m.estatus = :est", Municipio.class);
            query.setParameter("est", 10);
            municipios = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener municipios");
        }
        return municipios;
    }
    
    @Override
    public List<Municipio> getMunicipios(Integer estatus) {
        List<Municipio> municipios = new ArrayList<>();
        try {
            TypedQuery<Municipio> query = em.createQuery("SELECT m FROM Municipio m WHERE m.estatus = :est", Municipio.class);
            query.setParameter("est", estatus);
            municipios = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener municipios");
        }
        return municipios;
    }

    @Override
    public Municipio getMunicipio(int idmunicipio) {
        return em.find(Municipio.class, idmunicipio);
    }

    @Override
    public Municipio deleteMunicipio(int idmunicipio) {
        Municipio municipio = null;
        try {
            municipio = getMunicipio(idmunicipio);
            if (municipio != null) {
                em.getTransaction().begin();
                em.remove(municipio);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return municipio;
    }

    @Override
    public Municipio updateMunicipio(Municipio municipio) {
        em.getTransaction().begin();
        municipio.setFecact(new Date());
        em.persist(municipio);
        em.getTransaction().commit();
        return municipio;
    }

    @Override
    public Municipio insertMunicipio(Municipio municipio) {
        em.getTransaction().begin();
        em.persist(municipio);
        em.getTransaction().commit();
        return municipio;
    }
}
