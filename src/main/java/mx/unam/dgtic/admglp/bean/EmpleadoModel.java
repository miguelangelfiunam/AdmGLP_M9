/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.bean;

import jakarta.enterprise.inject.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import mx.unam.dgtic.admglp.DB.Conexion;
import mx.unam.dgtic.admglp.ejb.EmpleadoEJBLocal;
import mx.unam.dgtic.admglp.vo.Empleado;

/**
 *
 * @author unam
 */
@Model
public class EmpleadoModel implements Serializable {

    private static final long serialVersionUID = -1000003;

    public List<Empleado> cargaEmpleados() {
        List<Empleado> empleados = null;
        EmpleadoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (EmpleadoEJBLocal) ctx.lookup("java:global/admglp/EmpleadoEJBLocal!mx.unam.dgtic.admglp.ejb.EmpleadoEJB");
            if (service != null) {
                empleados = service.getEmpleados();
            } else {
                empleados = new ArrayList<Empleado>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return empleados;
    }

    public Empleado cargaEmpleado(Integer idempleado) {
        Empleado empleado = null;
        EmpleadoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (EmpleadoEJBLocal) ctx.lookup("java:global/admglp/EmpleadoEJBLocal!mx.unam.dgtic.admglp.ejb.EmpleadoEJB");
            if (service != null) {
                empleado = service.getEmpleado(idempleado);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return empleado;
    }

    public Empleado actualizaEmpleado(Empleado empleado) {
        EmpleadoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (EmpleadoEJBLocal) ctx.lookup("java:global/admglp/EmpleadoEJBLocal!mx.unam.dgtic.admglp.ejb.EmpleadoEJB");
            if (service != null) {
                empleado = service.actualizaEmpleado(empleado);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return empleado;
    }

    public void actualizaEstatusEmpleado(Integer idEmp, Integer estatus) {
        EmpleadoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (EmpleadoEJBLocal) ctx.lookup("java:global/admglp/EmpleadoEJBLocal!mx.unam.dgtic.admglp.ejb.EmpleadoEJB");
            if (service != null) {
                service.actualizaEstatusEmpleado(idEmp, estatus);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Empleado insertaEmpleado(Empleado empleado) {
        EmpleadoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (EmpleadoEJBLocal) ctx.lookup("java:global/admglp/EmpleadoEJBLocal!mx.unam.dgtic.admglp.ejb.EmpleadoEJB");
            if (service != null) {
                empleado = service.insertaEmpleado(empleado);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return empleado;
    }
    
    public Empleado cargaEmpleadoPorIdUsuario(Integer idusuario) {
        Empleado empleado = null;
        EmpleadoEJBLocal service = null;
        try {
            InitialContext ctx = Conexion.createInitialContext();
            service = (EmpleadoEJBLocal) ctx.lookup("java:global/admglp/EmpleadoEJBLocal!mx.unam.dgtic.admglp.ejb.EmpleadoEJB");
            if (service != null) {
                empleado = service.getEmpleadoPorIdUsuario(idusuario);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return empleado;
    }
}
