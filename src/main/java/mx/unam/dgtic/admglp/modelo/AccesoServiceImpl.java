package mx.unam.dgtic.admglp.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.vo.Acceso;
import mx.unam.dgtic.admglp.vo.Usuario;

/**
 * Servicio para consulta de accesos
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/04/2022
 *
 */
public class AccesoServiceImpl implements AccesoService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public AccesoServiceImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Metodo para obtener los acceso del sistema completamente
     *
     * @return Lista de accesos completa
     */
    @Override
    public List<Acceso> getAccesos() {
        List<Acceso> accesos = new ArrayList<>();
        try {
            TypedQuery<Acceso> query = em.createQuery("SELECT u FROM Acceso u", Acceso.class);
            accesos = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener accesos");
        }
        return accesos;
    }

    /**
     * Metodo para obtener accesos dependiendo de los parametros de entrada
     *
     * @param estatus Estado del acceso
     * @param r_ini_1 Intervalo inicial de la fecha de inicio del acceso
     * @param r_ini_2 Intervalo final de la fecha de inicio del acceso
     * @param r_fin_1 Intervalo inicial de la fecha de fin del acceso
     * @param r_fin_2 Intervalo final de la fecha de fin del acceso
     * @param idUsu Identificador de usuario relacionado al acceso
     * @return Lista de accesos que coincidan
     */
    @Override
    public List<Acceso> getAccesosCriteria(Integer estatus, Date r_ini_1, Date r_ini_2, Date r_fin_1, Date r_fin_2, Integer idUsu) {
        List<Acceso> accesos = new ArrayList<>();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Acceso> c = cb.createQuery(Acceso.class);
            Root<Acceso> accesoRoot = c.from(Acceso.class);
            c.select(accesoRoot);
            c.distinct(true);
            Join<Acceso, Usuario> usu = accesoRoot.join("usuario", JoinType.LEFT);

            List<Predicate> criteria = new ArrayList<>();
            if (estatus != null) {
                ParameterExpression<Integer> p = cb.parameter(Integer.class, "est");
                criteria.add(cb.equal(accesoRoot.get("estatus"), p));
            }
            if (idUsu != null) {
                ParameterExpression<Integer> p = cb.parameter(Integer.class, "idUsu");
                criteria.add(cb.equal(usu.get("idusuario"), p));
            }

            if (r_ini_1 != null && r_ini_2 != null) {
                //between
                ParameterExpression<Date> p_1 = cb.parameter(Date.class, "fini_1");
                ParameterExpression<Date> p_2 = cb.parameter(Date.class, "fini_2");
                criteria.add(cb.between(accesoRoot.get("fecinicio"), p_1, p_2));
            } else if (r_ini_1 != null) {
                //greather than
                ParameterExpression<Date> p = cb.parameter(Date.class, "fini_1");
                criteria.add(cb.greaterThan(accesoRoot.get("fecinicio"), p));
            } else if (r_ini_2 != null) {
                //less than
                ParameterExpression<Date> p = cb.parameter(Date.class, "fini_2");
                criteria.add(cb.lessThan(accesoRoot.get("fecinicio"), p));
            }

            if (r_fin_1 != null && r_fin_2 != null) {
                //between
                ParameterExpression<Date> p_1 = cb.parameter(Date.class, "ffin_1");
                ParameterExpression<Date> p_2 = cb.parameter(Date.class, "ffin_2");
                criteria.add(cb.between(accesoRoot.get("fecfin"), p_1, p_2));
            } else if (r_fin_1 != null) {
                //greather than
                ParameterExpression<Date> p = cb.parameter(Date.class, "ffin_1");
                criteria.add(cb.greaterThan(accesoRoot.get("fecfin"), p));
            } else if (r_fin_2 != null) {
                //less than
                ParameterExpression<Date> p = cb.parameter(Date.class, "ffin_2");
                criteria.add(cb.lessThan(accesoRoot.get("fecfin"), p));
            }

            if (criteria.isEmpty()) {
                throw new RuntimeException("no criteria");
            } else if (criteria.size() == 1) {
                c.where(criteria.get(0));
            } else {
                c.where(cb.and(criteria.toArray(new Predicate[0])));
            }

            TypedQuery<Acceso> q = em.createQuery(c);
            if (estatus != null) {
                q.setParameter("est", estatus);
            }
            if (idUsu != null) {
                q.setParameter("idUsu", idUsu);
            }
            if (r_ini_1 != null && r_ini_2 != null) {
                q.setParameter("fini_1", r_ini_1);
                q.setParameter("fini_2", r_ini_2);
            } else if (r_ini_1 != null) {
                q.setParameter("fini_1", r_ini_1);
            } else if (r_ini_2 != null) {
                q.setParameter("fini_2", r_ini_2);
            }

            if (r_fin_1 != null && r_fin_2 != null) {
                q.setParameter("ffin_1", r_fin_1);
                q.setParameter("ffin_2", r_fin_2);
            } else if (r_fin_1 != null) {
                q.setParameter("ffin_1", r_fin_1);
            } else if (r_fin_2 != null) {
                q.setParameter("ffin_2", r_fin_2);
            }
            accesos = q.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener accesos por criteria");
        }
        return accesos;
    }

    /**
     * Obtener un acceso por su identificador
     *
     * @param idAcceso Identificador de acceso
     * @return Bean encontrado
     */
    @Override
    public Acceso getAcceso(int idAcceso) {
        return em.find(Acceso.class, idAcceso);
    }

    /**
     * Borrar un acceso por su identificador
     *
     * @param idAcceso Identificador de acceso
     * @return Bean borrado
     */
    @Override
    public Acceso deleteAcceso(int idAcceso) {
        Acceso acceso = null;
        try {
            acceso = getAcceso(idAcceso);
            if (acceso != null) {
                em.getTransaction().begin();
                em.remove(acceso);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return acceso;
    }

    /**
     * Metodo para actualizar el acceso indicado
     *
     * @param acceso Bean con la informacion que se va actualizar
     * @return Bean actualizado
     */
    @Override
    public Acceso updateAcceso(Acceso acceso) {
        em.getTransaction().begin();
        em.merge(acceso);
        em.getTransaction().commit();
        return acceso;
    }

    /**
     * Insercion de un acceso
     *
     * @param acceso Bean con la informacion que se va insertar
     * @return Bean insertado
     */
    @Override
    public Acceso insertAcceso(Acceso acceso) {
        em.getTransaction().begin();
        em.persist(acceso);
        em.getTransaction().commit();
        return acceso;
    }

}
