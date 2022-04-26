package mx.unam.dgtic.admglp.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import mx.unam.dgtic.admglp.mensajes.MessageBean;
import mx.unam.dgtic.admglp.vo.Asentamiento;
import mx.unam.dgtic.admglp.vo.Direccion;

/**
 * Bean con la informacion del direccion a mostrar en la vista
 *
 * @author unam
 */
@Named
@SessionScoped
public class DireccionFormBean implements Serializable {

    private static final long serialVersionUID = -4146681491856848089L;
    private Integer iddireccion; // Identificador de direccion
    private Integer idestado; // Identificador de direccion
    private Integer idmunicipio; // Identificador de direccion
    private Integer idasentamiento; // Identificador de direccion

    private String nombre;
    private String referencias;

    @Inject
    private DireccionModel direccionModel;
    @Inject
    private AsentamientoModel asentamientoModel;
    @Inject
    private MunicipioModel municipioModel;
    @Inject
    private EstadoModel estadoModel;

    @Inject
    private MessageBean messageBean;

    public String formularioDireccion() {
        iddireccion = null;
        idestado = null;
        idmunicipio = null;
        idasentamiento = null;
        nombre = null;
        referencias = null;
        return "/direccion/direccionForm?faces-redirect=true";
    }

    public String formularioDireccionID(Integer idDir) {
        Direccion direccion = direccionModel.cargaDireccion(idDir);
        if (direccion != null) {
            this.iddireccion = idDir;
            idasentamiento = direccion.getAsentamiento().getId();
            idmunicipio = direccion.getAsentamiento().getMunicipio().getId();
            idestado = direccion.getAsentamiento().getMunicipio().getEstado().getId();
            
            
            this.nombre = direccion.getNombre();
            this.referencias = direccion.getReferencias();
        }
        return "/direccion/direccionForm?faces-redirect=true";
    }

    public String actualizarEstatusDireccion(Integer id, Integer estatus) {
        direccionModel.actualizaEstatusDireccion(id, estatus);
        return "/direccion/lista?faces-redirect=true";
    }

    public String actualizar() {
        //Obtiene direccion y despues reemplaza
        Direccion direccionBD = null;
        try {
            if (direccionModel != null) {
                direccionBD = direccionModel.cargaDireccion(this.iddireccion);
                if (direccionBD != null) {
                    //Buscar Asentamiento por id
                    direccionBD.setNombre(nombre);
                    direccionBD.setReferencias(referencias);
                    direccionBD = direccionModel.actualizaDireccion(direccionBD);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Obtiene roles y despues reemplaza
        return "/direccion/direccionForm?faces-redirect=true";
    }

    public String insertar() {
        

        //Prepara contra
        Asentamiento asentamientoBD = null;
        try {
            if (asentamientoModel != null) {
                if(idasentamiento != null){
                    asentamientoBD = asentamientoModel.cargaAsentamiento(idasentamiento);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

//        //Preparar direccion
//        Direccion direccion = null;
//        try {
//            if (direccionModel != null) {
//                Date date_fnac = new SimpleDateFormat("dd/MM/yyyy").parse(fnac);
//                direccion = new Direccion(estadoBD, apodo, correo1, correo2, nombre, apellido1, apellido2, edad, date_fnac, telefono1, telefono2, new Date(), null, 10, rolesBD);
//                direccion = direccionModel.insertaDireccion(direccion);
//                iddireccion = direccion.getIddireccion();
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

        return "/direccion/direccionForm?faces-redirect=true";
    }

    public void limpiaCampos() {
        iddireccion = null;
        idestado = null;
        idmunicipio = null;
        idasentamiento = null;
        nombre = null;
        referencias = null;
    }

    public Integer getIddireccion() {
        return iddireccion;
    }

    public void setIddireccion(Integer iddireccion) {
        this.iddireccion = iddireccion;
    }

    public Integer getIdestado() {
        return idestado;
    }

    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
    }

    public Integer getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(Integer idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public Integer getIdasentamiento() {
        return idasentamiento;
    }

    public void setIdasentamiento(Integer idasentamiento) {
        this.idasentamiento = idasentamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

   
}
