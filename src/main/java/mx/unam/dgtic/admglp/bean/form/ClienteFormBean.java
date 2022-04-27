package mx.unam.dgtic.admglp.bean.form;

import mx.unam.dgtic.admglp.bean.model.UsuarioModel;
import mx.unam.dgtic.admglp.bean.model.ClienteModel;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import mx.unam.dgtic.admglp.mensajes.MessageBean;
import mx.unam.dgtic.admglp.vo.Cliente;
import mx.unam.dgtic.admglp.vo.Usuario;

/**
 * Bean con la informacion del cliente a mostrar en la vista
 *
 * @author unam
 */
@Named
@SessionScoped
public class ClienteFormBean implements Serializable {

    private static final long serialVersionUID = -4146681491856848089L;
    private Integer idusuario; // Identificador de usuario
    private Integer idcliente; // Identificador de cliente
    private Integer numCliente; // Numero de cliente

    @Inject
    private ClienteModel clienteModel;

    @Inject
    private UsuarioModel usuarioModel;

    @Inject
    private MessageBean messageBean;

    public String formularioCliente() {
        idusuario = null;
        idcliente = null;
        numCliente = null;
        return "/cliente/clienteForm?faces-redirect=true";
    }

    public String formularioClienteID(Integer idusuario, Integer idEmp) {
        Cliente cliente = clienteModel.cargaCliente(idEmp);
        if (cliente != null) {
            this.idusuario = idusuario;
            this.idcliente = idEmp;
            this.numCliente = cliente.getNumerocliente();
        }
        return "/cliente/clienteForm?faces-redirect=true";
    }

    public String actualizarEstatusCliente(Integer id, Integer estatus) {
        try {
            if (clienteModel != null) {
                clienteModel.actualizaEstatusCliente(id, estatus);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "/cliente/lista?faces-redirect=true";
    }

    public String actualizar() {
        //Obtiene cliente y despues reemplaza
        Cliente clienteBD = null;
        try {
            if (clienteModel != null) {
                clienteBD = clienteModel.cargaCliente(this.idcliente);
                if (clienteBD != null) {
                    clienteBD = clienteModel.actualizaCliente(clienteBD);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Obtiene roles y despues reemplaza
        return "/cliente/lista?faces-redirect=true";
    }

    public String insertar() {
        //Preparar cliente
        Cliente cliente = null;
        Usuario usuario = null;
        try {
            if (usuarioModel != null) {
                if (idusuario != null) {
                    usuario = usuarioModel.cargaUsuario(idusuario);
                }
            }
            if (clienteModel != null) {
                if (usuario != null) {
                    Integer sigCliente = clienteModel.cargaSiguienteNumeroCliente();
                    cliente = new Cliente(usuario, sigCliente, new Date(), null, 10);
                    clienteModel.insertaCliente(cliente);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "/cliente/lista?faces-redirect=true";
    }

    public void limpiaCampos() {
        idusuario = null;
        idcliente = null;
        numCliente = null;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Integer getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(Integer numCliente) {
        this.numCliente = numCliente;
    }

    public MessageBean getMessageBean() {
        return messageBean;
    }

    public void setMessageBean(MessageBean messageBean) {
        this.messageBean = messageBean;
    }

}
