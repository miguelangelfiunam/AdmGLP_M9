/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.Funciones.Funciones;
import mx.unam.dgtic.admglp.modelo.ComentarioServiceImpl;
import mx.unam.dgtic.admglp.vo.Comentario;

/**
 *
 * @author unam
 */
@Stateless
public class ComentarioEJBLocal implements ComentarioEJB {

    ComentarioServiceImpl es;

    @Override
    public List<Comentario> getComentarios() {
        List<Comentario> comentarios = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new ComentarioServiceImpl(em);
            comentarios = es.getComentarios();
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ComentarioService: " + e.getMessage() + "</p>";
            if (es.getError() != null) {
                mensaje += "<p>" + "Error en ComentarioEJBLocal -> getComentarios() -> ComentarioService -> getComentarios() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return comentarios;
    }

    @Override
    public List<Comentario> getComentariosPorEstatus(Integer estatus) {
        List<Comentario> comentarios = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new ComentarioServiceImpl(em);
            comentarios = es.getComentarios(estatus);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ComentarioService: " + e.getMessage() + "</p>";
            if (es.getError() != null) {
                mensaje += "<p>" + "Error en ComentarioEJBLocal -> getComentariosPorEstatus() -> ComentarioService -> getComentarios() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return comentarios;
    }

    @Override
    public Comentario getComentario(Integer idComentario) {
        Comentario comentario = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new ComentarioServiceImpl(em);
            comentario = es.getComentario(idComentario);

        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ComentarioServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en ComentarioEJBLocal -> getComentario() -> ComentarioService -> getComentario() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return comentario;
    }

    @Override
    public Boolean existeComentario(Integer idComentario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comentario insertaComentario(Comentario comentario) {
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new ComentarioServiceImpl(em);
            comentario = es.insertComentario(comentario);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ComentarioServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en ComentarioEJBLocal -> insertaComentario() -> ComentarioService -> insertComentario() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return comentario;
    }

    @Override
    public Comentario actualizaComentario(Comentario comentario) {
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new ComentarioServiceImpl(em);
            comentario = es.updateComentario(comentario);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ComentarioServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en ComentarioEJBLocal -> actualizaComentario() -> ComentarioService -> updateComentario() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return comentario;
    }

    @Override
    public void eliminaComentario(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizaEstatusComentario(Integer id, Integer estatus) {
        Comentario comentario = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new ComentarioServiceImpl(em);
            comentario = es.getComentario(id);
            if (comentario != null) {
                comentario.setEstatus(estatus);
                es.updateComentario(comentario);
            }
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ComentarioServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en ComentarioEJBLocal -> actualizaEstatusComentario() -> ComentarioService -> updateComentario() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
    }

    @Override
    public List<Comentario> getComentariosPorIdPedido(Integer idPedido, Integer estatus_comentario) {
        List<Comentario> comentarios = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new ComentarioServiceImpl(em);
            comentarios = es.getComentariosPorIdPedido(idPedido, estatus_comentario);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ComentarioServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en ComentarioEJBLocal -> getComentariosPorIdPedido() -> ComentarioService -> getComentariosPorIdPedido() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return comentarios;
    }

    @Override
    public Integer getNumComentario(Integer idPedido) {
        Integer numComentario = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new ComentarioServiceImpl(em);
            numComentario = es.getSigComentario(idPedido);

        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en ComentarioServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en ComentarioEJBLocal -> getNumComentario() -> ComentarioService -> getSigComentario() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return numComentario;
    }

}
