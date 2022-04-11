
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import mx.unam.dgtic.admglp.modelo.GlobalService;
import mx.unam.dgtic.admglp.modelo.GlobalServiceImpl;
import mx.unam.dgtic.admglp.vo.Global;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author unam
 */
public class GlobalMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
            System.out.println("MIGUEL ANGEL MARTINEZ RIVERA");
            System.out.println("CRUD GLOBAL");
            GlobalService globalService = new GlobalServiceImpl(em);
            System.out.println("----------------");
            muestraGlobales(globalService);
            System.out.println("----------------");
            muestraGlobal(globalService);
            System.out.println("----------------");
            String nombre = "autor";
            muestraGlobal(globalService, nombre);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void muestraGlobales(GlobalService globalService) {
        List<Global> result = globalService.getGlobales();
        for (Global global : result) {
            System.out.println(global);
        }
    }

    public static void muestraGlobal(GlobalService globalService) {
        Global u = globalService.getGlobal(1);
        System.out.println(u);
    }
    
    public static void muestraGlobal(GlobalService globalService, String nombre) {
        Global u = globalService.getGlobal(nombre);
        System.out.println(u);
    }

}
