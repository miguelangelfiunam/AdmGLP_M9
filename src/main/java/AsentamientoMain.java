
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import mx.unam.dgtic.admglp.modelo.AsentamientoService;
import mx.unam.dgtic.admglp.modelo.AsentamientoServiceImpl;
import mx.unam.dgtic.admglp.vo.Asentamiento;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author unam
 */
public class AsentamientoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
            System.out.println("MIGUEL ANGEL MARTINEZ RIVERA");
            System.out.println("ASENTAMIENTO");
            AsentamientoService asentamientoService = new AsentamientoServiceImpl(em);
            System.out.println("----------------");
            muestraAsentamientos(asentamientoService);
            System.out.println("----------------");
            muestraAsentamiento(asentamientoService);
            System.out.println("----------------");
            actualizaAsentamiento(asentamientoService);
            System.out.println("----------------");
            borraEInsertaAsentamiento(asentamientoService);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void muestraAsentamientos(AsentamientoService asentamientoService) {
        List<Asentamiento> result = asentamientoService.getAsentamientosActivos();
        for (Asentamiento asentamiento : result) {
            System.out.println(asentamiento);
        }
    }

    public static void muestraAsentamiento(AsentamientoService asentamientoService) {
        Asentamiento u = asentamientoService.getAsentamiento(1);
        System.out.println(u);
    }

    public static void actualizaAsentamiento(AsentamientoService asentamientoService) {
        Asentamiento a = asentamientoService.getAsentamiento(1);
        if (a != null) {
            System.out.println(a);
            a.setEstatus(20);
            asentamientoService.updateAsentamiento(a);
            System.out.println(asentamientoService.getAsentamiento(a.getId()));
        }
    }

    public static void borraEInsertaAsentamiento(AsentamientoService asentamientoService) {
        Asentamiento a = asentamientoService.deleteAsentamiento(1);
        System.out.println("Borrado");
        System.out.println(a);
        if (a != null) {
            System.out.println("Insertado");
            System.out.println(asentamientoService.insertAsentamiento(a));
        } else {
            System.out.println("No existe el asentamiento para insertar");
        }
    }

}
