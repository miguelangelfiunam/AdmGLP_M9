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
 * @since 26/03/2022 - 26/04/2022
 *
 */
public class EmpleadoServiceImpl implements EmpleadoService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public EmpleadoServiceImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Metodo para obtener empleados
     *
     * @return Lista de empleados encontrada
     */
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

    /**
     * Metodo para obtener empleados por identificador de estatus
     *
     * @param estatus Estatus del empleado
     * @return Lista de empleados encontrados
     */
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

    /**
     * Metodo para obtener un empleado
     *
     * @param idEmpleado Identificador de empleado
     * @return Bean obtenido
     */
    @Override
    public Empleado getEmpleado(int idEmpleado) {
        return em.find(Empleado.class, idEmpleado);
    }

    /**
     * Metodo para borrar un empleado
     *
     * @param idEmpleado Identificador de empleado
     * @return Bean borrado
     */
    @Override
    public Empleado deleteEmpleado(int idEmpleado) {
        Empleado empleado = null;
        try {
            empleado = getEmpleado(idEmpleado);
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

    /**
     * Metodo para actualizar un empleado
     *
     * @param empleado Identificador de empleado
     * @return Bean actualizado
     */
    @Override
    public Empleado updateEmpleado(Empleado empleado) {
        em.getTransaction().begin();
        empleado.setFecact(new Date());
        em.merge(empleado);
        em.getTransaction().commit();
        return empleado;
    }

    /**
     * Metodo para insertar un empleado
     *
     * @param empleado Identificador de empleado
     * @return Bean insertado
     */
    @Override
    public Empleado insertEmpleado(Empleado empleado) {
        em.getTransaction().begin();
        em.persist(empleado);
        em.getTransaction().commit();
        return empleado;
    }

    /**
     * Metodo para obtener un empleado por identificador de usuario
     *
     * @param idUsuario Identificador de usuario
     * @return Bean encontrado
     */
    @Override
    public Empleado getEmpleadoPorIdUsuario(int idUsuario) {
        Empleado empleado = null;
        try {
            try {
                TypedQuery<Empleado> query = em.createQuery("SELECT c FROM Empleado c WHERE c.usuario.idusuario = :idusu", Empleado.class);
                query.setParameter("idusu", idUsuario);
                empleado = query.getSingleResult();
            } catch (jakarta.persistence.NoResultException e) {
                //Error en caso de no encontrar registro, regreso null el objeto
            }
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener empleado por id de usuario");
        }
        return empleado;
    }
}
