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
import mx.unam.dgtic.admglp.modelo.EmpleadoServiceImpl;
import mx.unam.dgtic.admglp.vo.Empleado;

/**
 *
 * @author unam
 */
@Stateless
public class EmpleadoEJBLocal implements EmpleadoEJB {

    EmpleadoServiceImpl es;

    @Override
    public List<Empleado> getEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new EmpleadoServiceImpl(em);
            empleados = es.getEmpleados();
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en EmpleadoService: " + e.getMessage() + "</p>";
            if (es.getError() != null) {
                mensaje += "<p>" + "Error en EmpleadoEJBLocal -> getEmpleados() -> EmpleadoService -> getEmpleados() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return empleados;
    }

    @Override
    public List<Empleado> getEmpleadosPorEstatus(Integer estatus) {
        List<Empleado> empleados = new ArrayList<>();
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new EmpleadoServiceImpl(em);
            empleados = es.getEmpleados(estatus);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en EmpleadoService: " + e.getMessage() + "</p>";
            if (es.getError() != null) {
                mensaje += "<p>" + "Error en EmpleadoEJBLocal -> getEmpleadosPorEstatus() -> EmpleadoService -> getEmpleados() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return empleados;
    }

    @Override
    public Empleado getEmpleado(Integer idEmpleado) {
        Empleado empleado = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new EmpleadoServiceImpl(em);
            empleado = es.getEmpleado(idEmpleado);

        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en EmpleadoServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en EmpleadoEJBLocal -> getEmpleado() -> EmpleadoService -> getEmpleado() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return empleado;
    }

    @Override
    public Boolean existeEmpleado(Integer idEmpleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado insertaEmpleado(Empleado empleado) {
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new EmpleadoServiceImpl(em);
            empleado = es.insertEmpleado(empleado);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en EmpleadoServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en EmpleadoEJBLocal -> insertaEmpleado() -> EmpleadoService -> insertaEmpleado() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return empleado;
    }

    @Override
    public Empleado actualizaEmpleado(Empleado empleado) {
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new EmpleadoServiceImpl(em);
            empleado = es.updateEmpleado(empleado);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en EmpleadoServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en EmpleadoEJBLocal -> insertaEmpleado() -> EmpleadoService -> insertaEmpleado() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return empleado;
    }

    @Override
    public void eliminaEmpleado(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizaEstatusEmpleado(Integer id, Integer estatus) {
        Empleado empleado = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new EmpleadoServiceImpl(em);
            empleado = es.getEmpleado(id);
            if (empleado != null) {
                empleado.setEstatus(estatus);
                es.updateEmpleado(empleado);
            }
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en EmpleadoServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en EmpleadoEJBLocal -> getEmpleado() -> EmpleadoService -> getEmpleado() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
    }

    @Override
    public Empleado getEmpleadoPorIdUsuario(Integer idUsuario) {
        Empleado empleado = null;
        try {
            EntityManager em = Conexion.createEntityManager();
            es = new EmpleadoServiceImpl(em);
            empleado = es.getEmpleadoPorIdUsuario(idUsuario);
        } catch (Exception e) {
            String mensaje = "";
            mensaje += "<p>Error en EmpleadoServiceImpl: " + e.getMessage() + "</p>";

            if (es.getError() != null) {
                mensaje += "<p>" + "Error en EmpleadoEJBLocal -> getEmpleado() -> EmpleadoService -> getEmpleadoPorIdUsuario() " + es.getError().getMessage() + "</p>";
            }
            try {
                Funciones.mandaCorreo("Error", mensaje, "dgpe.curso.04@gmail.com");
            } catch (Exception eCorreo) {
            }
        }
        return empleado;
    }

}
