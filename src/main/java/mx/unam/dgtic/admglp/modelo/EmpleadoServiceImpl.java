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
import mx.unam.dgtic.admglp.vo.Empleado;

/**
 * Servicio para consulta de empleados
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/03/2022
 *
 */
public class EmpleadoServiceImpl implements EmpleadoService{

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public EmpleadoServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Empleado> getEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        try {
            TypedQuery<Empleado> query = em.createQuery("SELECT e FROM Empleado e", Empleado.class);
            empleados = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener empleados");
        }
        return empleados;
    }
    
    @Override
    public List<Empleado> getEmpleados(Integer estatus) {
        List<Empleado> empleados = new ArrayList<>();
        try {
            TypedQuery<Empleado> query = em.createQuery("SELECT u FROM Empleado u WHERE u.estatus = :est", Empleado.class);
            query.setParameter("est", estatus);
            empleados = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener empleados");
        }
        return empleados;
    }

    @Override
    public Empleado getEmpleado(int idempleado) {
        return em.find(Empleado.class, idempleado);
    }

    @Override
    public Empleado deleteEmpleado(int idempleado) {
        Empleado empleado = null;
        try {
            empleado = getEmpleado(idempleado);
            if (empleado != null) {
                em.getTransaction().begin();
                em.remove(empleado);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return empleado;
    }

    @Override
    public Empleado updateEmpleado(Empleado empleado) {
        em.getTransaction().begin();
        empleado.setFecact(new Date());
        em.merge(empleado);
        em.getTransaction().commit();
        return empleado;
    }

    @Override
    public Empleado insertEmpleado(Empleado empleado) {
        em.getTransaction().begin();
        em.persist(empleado);
        em.getTransaction().commit();
        return empleado;
    }

    @Override
    public Empleado getEmpleadoPorIdUsuario(int idUsuario) {
        Empleado empleado = null;
        try {
            TypedQuery<Empleado> query = em.createQuery("SELECT c FROM Empleado c WHERE c.usuario.idusuario = :idusu", Empleado.class);
            query.setParameter("idusu", idUsuario);
            empleado = query.getSingleResult();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener empleado por id de usuario");
        }
        return empleado;
    }
}
