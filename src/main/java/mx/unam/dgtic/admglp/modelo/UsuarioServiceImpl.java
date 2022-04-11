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
import mx.unam.dgtic.admglp.vo.Usuario;

/**
 * Servicio para consulta de usuarios
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/03/2022 - 26/03/2022
 *
 */
public class UsuarioServiceImpl implements UsuarioService {

    private Exception error;

    @Override
    public Exception getError() {
        return error;
    }

    protected EntityManager em;

    public UsuarioServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Usuario> getUsuariosActivos() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.estatus = :est", Usuario.class);
            query.setParameter("est", 10);
            usuarios = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener usuarios");
        }
        return usuarios;
    }
    
    @Override
    public List<Usuario> getUsuarios(Integer estatus) {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.estatus = :est", Usuario.class);
            query.setParameter("est", estatus);
            usuarios = query.getResultList();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener usuarios");
        }
        return usuarios;
    }

    @Override
    public Usuario getUsuario(int idusuario) {
        return em.find(Usuario.class, idusuario);
    }

    @Override
    public Usuario deleteUsuario(int idusuario) {
        Usuario usuario = null;
        try {
            usuario = getUsuario(idusuario);
            if (usuario != null) {
                em.getTransaction().begin();
                em.remove(usuario);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usuario;
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        em.getTransaction().begin();
        usuario.setFecact(new Date());
        em.persist(usuario);
        em.getTransaction().commit();
        return usuario;
    }

    @Override
    public Usuario insertUsuario(Usuario usuario) {
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        return usuario;
    }

    @Override
    public Usuario getUsuario(String apodo, String contra, Integer estatus) {
         Usuario usuario =null;
        try {
            String sqlSelect = "SELECT u "
                    + "FROM Usuario u, Contra c "
                    + "WHERE "
                    + "u.contra.id = c.id "
                    + "AND u.apodo = :nick "
                    + "AND c.contra = :pass "
                    + "AND u.estatus = :est";
            TypedQuery<Usuario> query = em.createQuery(sqlSelect, Usuario.class);
            query.setParameter("nick", apodo);
            query.setParameter("pass", contra);
            query.setParameter("est", estatus);
            usuario = query.getSingleResult();
        } catch (Exception e) {
            this.error = e;
            throw new RuntimeException("Error al obtener usuarios");
        }
        return usuario;
    }

}
