package mx.unam.dgtic.admglp.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.vo.Rol;

/**
 * Servicio para consulta de rols
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/04/2022
 *
 */
public class RolServiceImpl implements RolService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public RolServiceImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Metodo para obtener roles
     *
     * @return Lista de roles encontrada
     */
    @Override
    public List<Rol> getRoles() {
        List<Rol> roles = new ArrayList<>();
        try {
            TypedQuery<Rol> query = em.createQuery("SELECT r FROM Rol r", Rol.class);
            roles = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener rols");
        }
        return roles;
    }

    /**
     * Metodo para obtener roles por identificador de estatus
     *
     * @param estatus Estatus del rol
     * @return
     */
    @Override
    public List<Rol> getRoles(Integer estatus) {
        List<Rol> rols = new ArrayList<>();
        try {
            TypedQuery<Rol> query = em.createQuery("SELECT r FROM Rol r WHERE r.estatus = :est", Rol.class);
            query.setParameter("est", estatus);
            rols = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener rols");
        }
        return rols;
    }

    /**
     * Metodo para obtener un rol
     *
     * @param idRol Identificador de rol
     * @return Bean obtenido
     */
    @Override
    public Rol getRol(int idRol) {
        return em.find(Rol.class, idRol);
    }

    /**
     * Metodo para borrar un rol
     *
     * @param idRol Identificador de rol
     * @return Bean borrado
     */
    @Override
    public Rol deleteRol(int idRol) {
        Rol rol = null;
        try {
            rol = getRol(idRol);
            if (rol != null) {
                em.getTransaction().begin();
                em.remove(rol);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rol;
    }

    /**
     * Metodo para actualizar un rol
     *
     * @param rol Identificador de rol
     * @return Bean actualizado
     */
    @Override
    public Rol updateRol(Rol rol) {
        em.getTransaction().begin();
        rol.setFecact(new Date());
        em.merge(rol);
        em.getTransaction().commit();
        return rol;
    }

    /**
     * Metodo para insertar un rol
     *
     * @param rol Identificador de rol
     * @return Bean insertado
     */
    @Override
    public Rol insertRol(Rol rol) {
        em.getTransaction().begin();
        em.persist(rol);
        em.getTransaction().commit();
        return rol;
    }

}
