package mx.unam.dgtic.admglp.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.mensajes.MessageBean;
import mx.unam.dgtic.admglp.vo.Cliente;
import mx.unam.dgtic.admglp.vo.Contra;
import mx.unam.dgtic.admglp.vo.Empleado;
import mx.unam.dgtic.admglp.vo.Rol;
import mx.unam.dgtic.admglp.vo.Usuario;

/**
 * Bean con la informacion del usuario a mostrar en la vista
 *
 * @author unam
 */
@Named
@SessionScoped
public class UsuarioFormBean implements Serializable {

    private static final long serialVersionUID = -4146681491856848089L;
    private Integer idusuario; // Identificador de usuario
    private String contra;
    private String apodo; // Seudonimo del usuario en la aplicacion
    private String correo1; // Correo electronico
    private String correo2; // Correo electronico
    private String nombre; // Nombre de la persona 100
    private String apellido1; // Primer apellido 100
    private String apellido2; // Segundo apellido 100
    private Integer edad;// Edad de la persona
    private String fnac; // Fecha de nacimiento
    private String telefono1; // Telefono del usuario
    private String telefono2; // Segundo telefono de contacto
    private List<Integer> roles = new ArrayList<>();
    //Parte del empleado
    private Integer idempleado; // Identificador de empleado
    private Integer numEmp; // numero de empleado
    private String numss; // numero de seguro social
    private String rfc; // RFC del empleado
    //Parte del cliente
    private Integer idcliente;
    private Integer numCli;
    @Inject
    private UsuarioModel usuarioModel;
    @Inject
    private ContraModel contraModel;
    @Inject
    private RolModel rolModel;
    @Inject
    private ClienteModel clienteModel;
    @Inject
    private EmpleadoModel empleadoModel;
    @Inject
    private MessageBean messageBean;

    public String formularioUsuario() {
        idusuario = null;
        contra = null;
        apodo = null;
        correo1 = null;
        correo2 = null;
        nombre = null;
        apellido1 = null;
        apellido2 = null;
        edad = null;
        fnac = null;
        telefono1 = null;
        telefono2 = null;
        roles = new ArrayList<>();
        //Parte del empleado
        idempleado = null;
        numEmp = null;
        numss = null;
        rfc = null;
        //Parte del cliente
        idcliente = null;
        numCli = null;
        return "/usuario/usuarioForm?faces-redirect=true";
    }

    public String formularioUsuarioID(Integer idUsu) {
        Usuario usuario = usuarioModel.cargaUsuario(idUsu);
        if (usuario != null) {
            this.idusuario = idUsu;
            this.contra = usuario.getContra().getContra();
            this.apodo = usuario.getApodo();
            this.correo1 = usuario.getCorreo1();
            this.correo2 = usuario.getCorreo2();
            this.nombre = usuario.getNombre();
            this.apellido1 = usuario.getApellido1();
            this.apellido2 = usuario.getApellido2();
            this.edad = usuario.getEdad();
            this.roles = new ArrayList<>();
            for (Rol rol : usuario.getRoles()) {
                this.roles.add(rol.getIdrol());
            }

            String pattern = "dd/MM/yyyy";
            DateFormat df = new SimpleDateFormat(pattern);
            this.fnac = df.format(usuario.getFnac());

            this.telefono1 = usuario.getTelefono1();
            this.telefono2 = usuario.getTelefono2();

            //Parte del empleado
            if (usuario.getEmpleado() != null) {
                if (usuario.getEmpleado().getEstatus() == 10) {
                    idempleado = usuario.getEmpleado().getId();
                    numEmp = usuario.getEmpleado().getNumtrab();
                    numss = usuario.getEmpleado().getNumss();
                    rfc = usuario.getEmpleado().getRfc();
                }
            }

            //Parte del cliente
            if (usuario.getCliente() != null) {
                if (usuario.getCliente().getEstatus() == 10) {
                    idcliente = usuario.getCliente().getId();
                    numCli = usuario.getCliente().getNumerocliente();
                }
            }
        }
        return "/usuario/usuarioForm?faces-redirect=true";
    }

    public String actualizarEstatusUsuario(Integer id, Integer estatus) {
        usuarioModel.actualizaEstatusPorUsuario(id, estatus);
        return "/usuario/lista?faces-redirect=true";
    }

    public String actualizar() {
        //Preparar roles
        List<Rol> rolesBD = new ArrayList<>();
        boolean bCliente = false;
        boolean bEmpleado = false;
        for (Integer idrol : roles) {
            try {
                if (rolModel != null) {
                    Rol rol = rolModel.cargaRol(idrol);
                    if (rol != null) {
                        rolesBD.add(rol);
                        if (rol.getNombre().equals("Cliente")) {
                            bCliente = true;
                        }
                        if (rol.getNombre().equals("Empleado")) {
                            bEmpleado = true;
                        }
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        //Obtiene usuario y despues reemplaza
        Usuario usuarioBD = null;
        Contra contraBD = null;
        try {
            if (usuarioModel != null && contraModel != null) {
                Date date_fnac = new SimpleDateFormat("dd/MM/yyyy").parse(fnac);
                usuarioBD = usuarioModel.cargaUsuario(this.idusuario);
                if (usuarioBD != null) {
                    usuarioBD.setRoles(rolesBD);
                    usuarioBD.setApodo(apodo);
                    usuarioBD.setCorreo1(correo1);
                    usuarioBD.setCorreo2(correo2);
                    usuarioBD.setNombre(nombre);
                    usuarioBD.setApellido1(apellido1);
                    usuarioBD.setApellido2(apellido2);
                    usuarioBD.setEdad(edad);
                    usuarioBD.setFnac(date_fnac);
                    usuarioBD.setTelefono1(telefono1);
                    usuarioBD.setTelefono2(telefono2);
                    usuarioBD = usuarioModel.actualizaUsuario(usuarioBD);

                    contraBD = usuarioBD.getContra();
                    contraBD.setContra(contra);
                    contraBD = contraModel.actualizaContra(contraBD);
                    usuarioBD.setContra(contraBD);

                    //para agregar
                    if (bCliente && idcliente == null) {
                        Cliente clienteAUX = clienteModel.cargaClientePorIdUsuario(idusuario);
                        if (clienteAUX != null) {
                            clienteModel.actualizaEstatusCliente(clienteAUX.getId(), 10);
                            idcliente = clienteAUX.getId();
                            numCli = clienteAUX.getNumerocliente();
                        } else {
                            numCli = clienteModel.cargaSiguienteNumeroCliente();
                            Cliente clienteBD = new Cliente(usuarioBD, numCli, new Date(), null, 10);
                            clienteBD = clienteModel.insertaCliente(clienteBD);
                            idcliente = clienteBD.getId();
                        }
                    }
                    //para quitar
                    if (!bCliente && idcliente != null) {
                        clienteModel.actualizaEstatusCliente(idcliente, 20);
                        idcliente = null;
                        numCli = null;
                    }

                    //para agregar
                    if (bEmpleado && idempleado == null) {
                        Empleado empleadoAUX = empleadoModel.cargaEmpleadoPorIdUsuario(idusuario);
                        if (empleadoAUX != null) {
                            empleadoModel.actualizaEstatusEmpleado(empleadoAUX.getId(), 10);
                            idempleado = empleadoAUX.getId();
                            numEmp = empleadoAUX.getNumtrab();
                            numss = empleadoAUX.getNumss();
                            rfc = empleadoAUX.getRfc();
                        } else {
                            Empleado empleadoBD = new Empleado(usuarioBD, numEmp, numss, rfc, new Date(), null, 10);
                            empleadoBD = empleadoModel.insertaEmpleado(empleadoBD);
                            idempleado = empleadoBD.getId();
                        }
                    }
                    //para quitar
                    if (!bEmpleado && idempleado != null) {
                        empleadoModel.actualizaEstatusEmpleado(idempleado, 20);
                        idempleado = null;
                        numEmp = null;
                        numss = null;
                        rfc = null;
                    }

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Obtiene roles y despues reemplaza
        return "/usuario/usuarioForm?faces-redirect=true";
    }

    public String insertar() {
        //Preparar roles
        List<Rol> rolesBD = new ArrayList<>();
        for (Integer idrol : roles) {
            try {
                if (rolModel != null) {
                    Rol rol = rolModel.cargaRol(idrol);
                    if (rol != null) {
                        rolesBD.add(rol);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        //Prepara contra
        Contra contraBD = null;
        try {
            if (contraModel != null) {
                contraBD = new Contra(contra, new Date(), null, 10);
                contraBD = contraModel.insertaContra(contraBD);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //Preparar usuario
        Usuario usuario = null;
        try {
            if (usuarioModel != null) {
                Date date_fnac = new SimpleDateFormat("dd/MM/yyyy").parse(fnac);
                usuario = new Usuario(contraBD, apodo, correo1, correo2, nombre, apellido1, apellido2, edad, date_fnac, telefono1, telefono2, new Date(), null, 10, rolesBD);
                usuario = usuarioModel.insertaUsuario(usuario);
                idusuario = usuario.getIdusuario();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //Checa si en los roles existe el rol de cliente para actualizar
        for (Rol rol : rolesBD) {
            if (rol.getNombre().equals("Cliente")) {
                if (idcliente == null && numCli == null) {
                    numCli = clienteModel.cargaSiguienteNumeroCliente();
                    Cliente clienteBD = new Cliente(usuario, numCli, new Date(), null, 10);
                    clienteBD = clienteModel.insertaCliente(clienteBD);
                    idcliente = clienteBD.getId();
                }
            } else if (rol.getNombre().equals("Empleado")) {
                if (idempleado == null) {
                    Empleado empleadoBD = new Empleado(usuario, numEmp, numss, rfc, new Date(), null, 10);
                    empleadoBD = empleadoModel.insertaEmpleado(empleadoBD);
                    idempleado = empleadoBD.getId();
                }
            }
        }
        return "/usuario/usuarioForm?faces-redirect=true";
    }

    public void limpiaCampos() {
        idusuario = null;
        contra = null;
        apodo = null;
        correo1 = null;
        correo2 = null;
        nombre = null;
        apellido1 = null;
        apellido2 = null;
        edad = null;
        fnac = null;
        telefono1 = null;
        telefono2 = null;
        roles = new ArrayList<>();
        //Parte del empleado
        idempleado = null;
        numEmp = null;
        numss = null;
        rfc = null;
        //Parte del cliente
        idcliente = null;
        numCli = null;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getCorreo1() {
        return correo1;
    }

    public void setCorreo1(String correo1) {
        this.correo1 = correo1;
    }

    public String getCorreo2() {
        return correo2;
    }

    public void setCorreo2(String correo2) {
        this.correo2 = correo2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getFnac() {
        return fnac;
    }

    public void setFnac(String fnac) {
        this.fnac = fnac;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public List<Integer> getRoles() {
        return roles;
    }

    public void setRoles(List<Integer> roles) {
        this.roles = roles;
    }

    public Integer getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

    public Integer getNumEmp() {
        return numEmp;
    }

    public void setNumEmp(Integer numEmp) {
        this.numEmp = numEmp;
    }

    public String getNumss() {
        return numss;
    }

    public void setNumss(String numss) {
        this.numss = numss;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Integer getNumCli() {
        return numCli;
    }

    public void setNumCli(Integer numCli) {
        this.numCli = numCli;
    }

}
