
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import mx.unam.dgtic.admglp.modelo.EmpleadoService;
import mx.unam.dgtic.admglp.modelo.EmpleadoServiceImpl;
import mx.unam.dgtic.admglp.vo.Empleado;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author unam
 */
public class EmpleadoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
            System.out.println("MIGUEL ANGEL MARTINEZ RIVERA");
            System.out.println("EMPLEADO");
            EmpleadoService empleadoService = new EmpleadoServiceImpl(em);
            System.out.println("----------------");
            muestraEmpleados(empleadoService);
            System.out.println("----------------");
            muestraEmpleado(empleadoService);
            System.out.println("----------------");
            actualizaEmpleado(empleadoService);
            System.out.println("----------------");
            borraEInsertaEmpleado(empleadoService);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void muestraEmpleados(EmpleadoService empleadoService) {
        List<Empleado> result = empleadoService.getEmpleadosActivos();
        for (Empleado empleado : result) {
            System.out.println(empleado);
        }
    }

    public static void muestraEmpleado(EmpleadoService empleadoService) {
        Empleado u = empleadoService.getEmpleado(1);
        System.out.println(u);
    }

    public static void actualizaEmpleado(EmpleadoService empleadoService) {
        Empleado e = empleadoService.getEmpleado(1);
        if (e != null) {
            System.out.println(e);
            e.setEstatus(20);
            empleadoService.updateEmpleado(e);
            System.out.println(empleadoService.getEmpleado(e.getId()));
        }
    }

    public static void borraEInsertaEmpleado(EmpleadoService empleadoService) {
        Empleado e = empleadoService.deleteEmpleado(1);
        System.out.println("Borrado");
        System.out.println(e);
        if (e != null) {
            System.out.println("Insertado");
            System.out.println(empleadoService.insertEmpleado(e));
        } else {
            System.out.println("No existe el empleado para insertar");
        }
    }

}
