package mx.unam.dgtic.admglp.mensajes;

import java.io.Serializable;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class MessageBean implements Serializable {

    private static final long serialVersionUID = -4146681491856842222L;

    private String mensajeRespuesta;

    public String getMensajeRespuesta() {
        return mensajeRespuesta;
    }

    public void setMensajeRespuesta(String mensajeRespuesta) {
        this.mensajeRespuesta = mensajeRespuesta;
    }
}
