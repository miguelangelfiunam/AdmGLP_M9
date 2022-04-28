package mx.unam.dgtic.admglp.bean.model;

import jakarta.enterprise.inject.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.ejb.ComentarioEJBLocal;
import mx.unam.dgtic.admglp.vo.Comentario;

/**
 * Modelo para metodos de comentarios
 *
 * @author Miguel Angel Martinez Rivera
 * @version 1.0.1
 * @since 26/04/2022 - 26/04/2022
 *
 */
@Model
public class ComentarioModel implements Serializable {

    private static final long serialVersionUID = -1000003;

    public List<Comentario> cargaComentarios() {
        List<Comentario> comentarios = null;
        ComentarioEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ComentarioEJBLocal) ctx.lookup("java:global/admglp/ComentarioEJBLocal!mx.unam.dgtic.admglp.ejb.ComentarioEJB");
            if (service != null) {
                comentarios = service.getComentarios();
            } else {
                comentarios = new ArrayList<Comentario>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return comentarios;
    }

    public List<Comentario> cargaComentariosPorIdEstaus(Integer estatus_comentario) {
        List<Comentario> comentarios = null;
        ComentarioEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ComentarioEJBLocal) ctx.lookup("java:global/admglp/ComentarioEJBLocal!mx.unam.dgtic.admglp.ejb.ComentarioEJB");
            if (service != null) {
                comentarios = service.getComentariosPorEstatus(estatus_comentario);
            } else {
                comentarios = new ArrayList<Comentario>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return comentarios;
    }

    public Comentario cargaComentario(Integer idcomentario) {
        Comentario comentario = null;
        ComentarioEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ComentarioEJBLocal) ctx.lookup("java:global/admglp/ComentarioEJBLocal!mx.unam.dgtic.admglp.ejb.ComentarioEJB");
            if (service != null) {
                comentario = service.getComentario(idcomentario);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return comentario;
    }

    public Integer cargaSiguienteNumeroComentario(Integer idPedido) {
        ComentarioEJBLocal service = null;
        Integer numComentario = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ComentarioEJBLocal) ctx.lookup("java:global/admglp/ComentarioEJBLocal!mx.unam.dgtic.admglp.ejb.ComentarioEJB");
            if (service != null) {
                numComentario = service.getNumComentario(idPedido);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return numComentario;
    }

    public List<Comentario> cargaComentariosPorIdPedido(Integer idPedido, Integer estatus_comentario) {
        List<Comentario> comentarios = null;
        ComentarioEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ComentarioEJBLocal) ctx.lookup("java:global/admglp/ComentarioEJBLocal!mx.unam.dgtic.admglp.ejb.ComentarioEJB");
            if (service != null) {
                comentarios = service.getComentariosPorIdPedido(idPedido, estatus_comentario);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return comentarios;
    }

    public Comentario insertaComentario(Comentario comentario) {
        ComentarioEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ComentarioEJBLocal) ctx.lookup("java:global/admglp/ComentarioEJBLocal!mx.unam.dgtic.admglp.ejb.ComentarioEJB");
            if (service != null) {
                comentario = service.insertaComentario(comentario);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return comentario;
    }

    public Comentario actualizaComentario(Comentario comentario) {
        ComentarioEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ComentarioEJBLocal) ctx.lookup("java:global/admglp/ComentarioEJBLocal!mx.unam.dgtic.admglp.ejb.ComentarioEJB");
            if (service != null) {
                comentario = service.actualizaComentario(comentario);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return comentario;
    }

    public void actualizaEstatusComentario(Integer idEmp, Integer estatus) {
        ComentarioEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (ComentarioEJBLocal) ctx.lookup("java:global/admglp/ComentarioEJBLocal!mx.unam.dgtic.admglp.ejb.ComentarioEJB");
            if (service != null) {
                service.actualizaEstatusComentario(idEmp, estatus);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
