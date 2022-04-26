/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.vo.Pedido;

/**
 * Servicio para consulta de pedidos
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 17/04/2022 - 26/04/2022
 *
 */
public class PedidoServiceImpl implements PedidoService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public PedidoServiceImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Metodo para obtener pedidos
     *
     * @return Lista de pedidos encontrada
     */
    @Override
    public List<Pedido> getPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        try {
            TypedQuery<Pedido> query = em.createQuery("SELECT p FROM Pedido p", Pedido.class);
            pedidos = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener pedidos");
        }
        return pedidos;
    }

    /**
     * Metodo para obtener pedidos por identificador de estatus
     *
     * @param estatus Estatus del pedido
     * @return Lista de pedidos encontrados
     */
    @Override
    public List<Pedido> getPedidos(Integer estatus) {
        List<Pedido> pedidos = new ArrayList<>();
        try {
            TypedQuery<Pedido> query = em.createQuery("SELECT p FROM Pedido p WHERE p.estatus = :est", Pedido.class);
            query.setParameter("est", estatus);
            pedidos = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener pedidos");
        }
        return pedidos;
    }

    /**
     * Metodo para obtener un pedido
     *
     * @param idPedido Identificador de pedido
     * @return Bean obtenido
     */
    @Override
    public Pedido getPedido(int idPedido) {
        return em.find(Pedido.class, idPedido);
    }

    /**
     * Metodo para borrar un pedido
     *
     * @param idPedido Identificador de pedido
     * @return Bean borrado
     */
    @Override
    public Pedido deletePedido(int idPedido) {
        Pedido pedido = null;
        try {
            pedido = getPedido(idPedido);
            if (pedido != null) {
                em.getTransaction().begin();
                em.remove(pedido);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pedido;
    }

    /**
     * Metodo para actualizar un pedido
     *
     * @param pedido Identificador de pedido
     * @return Bean actualizado
     */
    @Override
    public Pedido updatePedido(Pedido pedido) {
        em.getTransaction().begin();
        pedido.setFecact(new Date());
        em.merge(pedido);
        em.getTransaction().commit();
        return pedido;
    }

    /**
     * Metodo para insertar un pedido
     *
     * @param pedido Identificador de pedido
     * @return Bean insertado
     */
    @Override
    public Pedido insertPedido(Pedido pedido) {
        em.getTransaction().begin();
        em.persist(pedido);
        em.getTransaction().commit();
        return pedido;
    }

    /**
     * Metodo para obtener pedidos dependiendo a los parametros de entrada
     *
     * @param estatus Estatus del pedido
     * @param idCliente Identificador de cliente
     * @param idEmpleado Identificador de empleado
     * @param idDireccion Identificador de direccion
     * @param f_reg_ini Intervalo inicial de fecha de registro
     * @param f_reg_fin Intervalo final de fecha de registro
     * @param total Total del pedido
     * @return Lista de pedidos encontrados
     */
    @Override
    public List<Pedido> getPedidosCriteria(Integer estatus, Integer idCliente, Integer idEmpleado, Integer idDireccion, Date f_reg_ini, Date f_reg_fin, Double total) {
        List<Pedido> pedidos = new ArrayList<>();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Pedido> c = cb.createQuery(Pedido.class);
            Root<Pedido> pedidoRoot = c.from(Pedido.class);
            c.select(pedidoRoot);
            c.distinct(true);

            List<Predicate> criteria = new ArrayList<>();
            if (estatus != null) {
                ParameterExpression<Integer> p = cb.parameter(Integer.class, "est");
                criteria.add(cb.equal(pedidoRoot.get("estatus"), p));
            }
            if (idCliente != null) {
                ParameterExpression<Integer> p = cb.parameter(Integer.class, "idCliente");
                criteria.add(cb.equal(pedidoRoot.get("cliente").get("id"), p));
            }

            if (f_reg_ini != null && f_reg_fin != null) {
                //between
                ParameterExpression<Date> p_1 = cb.parameter(Date.class, "fini_1");
                ParameterExpression<Date> p_2 = cb.parameter(Date.class, "fini_2");
                criteria.add(cb.between(pedidoRoot.get("fecpedido"), p_1, p_2));
            } else if (f_reg_ini != null) {
                //greather than
                ParameterExpression<Date> p = cb.parameter(Date.class, "fini_1");
                criteria.add(cb.greaterThan(pedidoRoot.get("fecpedido"), p));
            } else if (f_reg_fin != null) {
                //less than
                ParameterExpression<Date> p = cb.parameter(Date.class, "fini_2");
                criteria.add(cb.lessThan(pedidoRoot.get("fecpedido"), p));
            }
            if (total != null) {
                ParameterExpression<Double> p = cb.parameter(Double.class, "tot");
                criteria.add(cb.greaterThan(pedidoRoot.get("total"), p));
            }

            if (criteria.isEmpty()) {
                throw new RuntimeException("no criteria");
            } else if (criteria.size() == 1) {
                c.where(criteria.get(0));
            } else {
                c.where(cb.and(criteria.toArray(new Predicate[0])));
            }

            TypedQuery<Pedido> q = em.createQuery(c);
            if (estatus != null) {
                q.setParameter("est", estatus);
            }
            if (idCliente != null) {
                q.setParameter("idCliente", idCliente);
            }
            if (f_reg_ini != null && f_reg_fin != null) {
                q.setParameter("fini_1", f_reg_ini);
                q.setParameter("fini_2", f_reg_fin);
            } else if (f_reg_ini != null) {
                q.setParameter("fini_1", f_reg_ini);
            } else if (f_reg_fin != null) {
                q.setParameter("fini_2", f_reg_fin);
            }
            if (total != null) {
                q.setParameter("tot", total);
            }

            pedidos = q.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener pedidos por criteria");
        }
        return pedidos;
    }

}
