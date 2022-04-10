
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import mx.unam.dgtic.admglp.modelo.DireccionService;
import mx.unam.dgtic.admglp.modelo.DireccionServiceImpl;
import mx.unam.dgtic.admglp.vo.Direccion;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author unam
 */
public class DireccionMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
            System.out.println("MIGUEL ANGEL MARTINEZ RIVERA");
            System.out.println("CRUD DIRECCION");
            DireccionService direccionService = new DireccionServiceImpl(em);
            System.out.println("----------------");
            muestraDireccions(direccionService);
            System.out.println("----------------");
            muestraDireccion(direccionService);
            System.out.println("----------------");
            actualizaDireccion(direccionService);
            System.out.println("----------------");
            borraEInsertaDireccion(direccionService);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void muestraDireccions(DireccionService direccionService) {
        List<Direccion> result = direccionService.getDireccionesActivas();
        for (Direccion direccion : result) {
            System.out.println(direccion);
        }
    }

    public static void muestraDireccion(DireccionService direccionService) {
        Direccion u = direccionService.getDireccion(1);
        System.out.println(u);
    }

    public static void actualizaDireccion(DireccionService direccionService) {
        Direccion u = direccionService.getDireccion(1);
        if (u != null) {
            System.out.println(u);
            u.setEstatus(10);
            direccionService.updateDireccion(u);
            System.out.println(direccionService.getDireccion(u.getIddireccion()));
        }
    }

    public static void borraEInsertaDireccion(DireccionService direccionService) {
        Direccion u = direccionService.deleteDireccion(1);
        System.out.println("Borrado");
        System.out.println(u);
        if(u != null){
            System.out.println("Insertado");
            System.out.println(direccionService.insertDireccion(u));
        }else{
            System.out.println("No existe el direccion para insertar");
        }
    }

}
