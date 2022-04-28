package mx.unam.dgtic.admglp.bean.form;

import mx.unam.dgtic.admglp.bean.model.TurnoModel;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import mx.unam.dgtic.admglp.bean.UsuarioBean;
import mx.unam.dgtic.admglp.mensajes.MessageBean;
import mx.unam.dgtic.admglp.vo.Turno;

/**
 * Bean con la informacion del turno a mostrar en la vista
 *
 * @author unam
 */
@Named
@SessionScoped
public class TurnoFormBean implements Serializable {

    private static final long serialVersionUID = -4146681491856848089L;
    private Integer idturno;
    private Date inicio;
    private Date fin;
    private Integer estatus;

    @Inject
    private TurnoModel turnoModel;
    @Inject
    private UsuarioBean usuarioBean;

    @Inject
    private MessageBean messageBean;
    
    public String formularioTurno() {
        idturno = null;
        inicio = null;
        fin = null;
        estatus = null;
        return "/turno/turnoForm?faces-redirect=true";
    }
    
    public String formularioTurnoID(Integer idEst) {
        Turno turno = turnoModel.cargaTurno(idEst);
        if (turno != null) {
            this.idturno = idEst;
            this.inicio = turno.getFecinicio();
            this.fin = turno.getFecfin();
            this.estatus = turno.getEstatus();
        }
        return "/turno/turnoForm?faces-redirect=true";
    }

    public String iniciarTurno() {
        Turno turno = null;
        try {
            Date fecActual = new Date();
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, 7);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);

            Date fecinicio = new Date();
            fecinicio = cal.getTime();
            if (fecActual.after(fecinicio) || fecActual.equals(fecinicio)) {
                //Se puede iniciar un turno
                turno = new Turno(fecinicio, null, new Date(), null, 10);
                usuarioBean.setTurnoActual(turnoModel.insertaTurno(turno));
            } else {
                //Se requiere que sean las 7:00 o despues
                int i = 0;
            }
        } catch (Exception e) {
            throw new IllegalStateException("Error");
        }
        return "/turno/lista?faces-redirect=true";
    }

    public String finalizarTurno() {
        Turno turno = null;
        try {
            turno = turnoModel.cargaTurnoActual();
            if (turno != null) {
                Date fecActual = new Date();
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.HOUR_OF_DAY, 15);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MILLISECOND, 0);

                Date fecfin = new Date();
                fecfin = cal.getTime();

                if (fecActual.after(fecfin) || fecActual.equals(fecfin)) {
                    //Se puede finalizar un turno
                    turno.setFecfin(fecfin);
//                    turno.setEstatus(20);
                    usuarioBean.setTurnoActual(turnoModel.actualizaTurno(turno));
                } else {
                    //Se requiere que sean las 15:00 o despues
                }

            }
        } catch (Exception e) {
        }
        return "/turno/lista?faces-redirect=true";
    }

    public String actualizarEstatusTurno(Integer id, Integer estatus) {
        turnoModel.actualizaEstatusTurno(id, estatus);
        return "/turno/lista?faces-redirect=true";
    }

    public String actualizar() {
        //Obtiene turno y despues reemplaza
        Turno turnoBD = null;
        try {
            if (turnoModel != null) {
                turnoBD = turnoModel.cargaTurno(this.idturno);
                if (turnoBD != null) {
                    //Buscar Asentamiento por id
                    turnoBD.setFecinicio(inicio);
                    turnoBD.setFecfin(fin);
                    turnoBD.setEstatus(estatus);
                    turnoBD = turnoModel.actualizaTurno(turnoBD);
                }
            } else {
                throw new IllegalStateException("No existe el turno para actualizar");
            }
            messageBean.setMensajeRespuesta("Se actualiza turno");
        } catch (Exception ex) {
            messageBean.setMensajeRespuesta(ex.getMessage());
        }

        //Obtiene roles y despues reemplaza
        return "/turno/turnoForm?faces-redirect=true";
    }

    public void limpiaCampos() {
        idturno = null;
        inicio = null;
        fin = null;
        estatus = null;
    }

    public Integer getIdturno() {
        return idturno;
    }

    public void setIdturno(Integer idturno) {
        this.idturno = idturno;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

}
