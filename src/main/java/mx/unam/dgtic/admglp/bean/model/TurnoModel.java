package mx.unam.dgtic.admglp.bean.model;

import jakarta.enterprise.inject.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.naming.InitialContext;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.ejb.TurnoEJBLocal;
import mx.unam.dgtic.admglp.vo.Turno;

/**
 *
 * @author unam
 */
@Model
public class TurnoModel implements Serializable {

    private static final long serialVersionUID = -1000003;

    public List<Turno> cargaTurnos() {
        List<Turno> turnos = null;
        TurnoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (TurnoEJBLocal) ctx.lookup("java:global/admglp/TurnoEJBLocal!mx.unam.dgtic.admglp.ejb.TurnoEJB");
            if (service != null) {
                turnos = service.getTurnos();
            } else {
                turnos = new ArrayList<Turno>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return turnos;
    }

    public List<Turno> cargaTurnos(Integer estatus) {
        List<Turno> turnos = null;
        TurnoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (TurnoEJBLocal) ctx.lookup("java:global/admglp/TurnoEJBLocal!mx.unam.dgtic.admglp.ejb.TurnoEJB");
            if (service != null) {
                turnos = service.getTurnosPorEstatus(estatus);
            } else {
                turnos = new ArrayList<Turno>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return turnos;
    }

    public Turno cargaTurno(Integer idturno) {
        Turno turno = null;
        TurnoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (TurnoEJBLocal) ctx.lookup("java:global/admglp/TurnoEJBLocal!mx.unam.dgtic.admglp.ejb.TurnoEJB");
            if (service != null) {
                turno = service.getTurno(idturno);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return turno;
    }

    public Turno cargaTurnoActual() {
        Turno turno = null;
        TurnoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (TurnoEJBLocal) ctx.lookup("java:global/admglp/TurnoEJBLocal!mx.unam.dgtic.admglp.ejb.TurnoEJB");
            if (service != null) {
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.HOUR_OF_DAY, 7);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MILLISECOND, 0);

                Date date = new Date();
                date = cal.getTime();
                turno = service.getTurnoActual(date, 10);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return turno;
    }

    public Turno actualizaTurno(Turno turno) {
        TurnoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (TurnoEJBLocal) ctx.lookup("java:global/admglp/TurnoEJBLocal!mx.unam.dgtic.admglp.ejb.TurnoEJB");
            if (service != null) {
                turno = service.actualizaTurno(turno);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return turno;
    }

    public void actualizaEstatusTurno(Integer idEmp, Integer estatus) {
        TurnoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (TurnoEJBLocal) ctx.lookup("java:global/admglp/TurnoEJBLocal!mx.unam.dgtic.admglp.ejb.TurnoEJB");
            if (service != null) {
                service.actualizaEstatusTurno(idEmp, estatus);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Turno insertaTurno(Turno turno) {
        TurnoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (TurnoEJBLocal) ctx.lookup("java:global/admglp/TurnoEJBLocal!mx.unam.dgtic.admglp.ejb.TurnoEJB");
            if (service != null) {
                turno = service.insertaTurno(turno);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return turno;
    }
}
