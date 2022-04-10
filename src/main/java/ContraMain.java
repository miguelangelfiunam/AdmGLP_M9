
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import mx.unam.dgtic.admglp.modelo.ContraService;
import mx.unam.dgtic.admglp.modelo.ContraServiceImpl;
import mx.unam.dgtic.admglp.vo.Contra;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author unam
 */
public class ContraMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
            System.out.println("MIGUEL ANGEL MARTINEZ RIVERA");
            System.out.println("CONTRA");
            ContraService contraService = new ContraServiceImpl(em);
            System.out.println("----------------");
            muestraContras(contraService);
            System.out.println("----------------");
            muestraContra(contraService);
            System.out.println("----------------");
            actualizaContra(contraService);
            System.out.println("----------------");
            borraEInsertaContra(contraService);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void muestraContras(ContraService contraService) {
        List<Contra> result = contraService.getContrasActivas();
        for (Contra contra : result) {
            System.out.println(contra);
        }
    }

    public static void muestraContra(ContraService contraService) {
        Contra u = contraService.getContra(1);
        System.out.println(u);
    }

    public static void actualizaContra(ContraService contraService) {
        Contra c = contraService.getContra(1);
        if (c != null) {
            System.out.println(c);
            c.setEstatus(20);
            contraService.updateContra(c);
            System.out.println(contraService.getContra(c.getId()));
        }
    }

    public static void borraEInsertaContra(ContraService contraService) {
        Contra c = contraService.deleteContra(1);
        System.out.println(c);
        if (c != null) {
            System.out.println("Insertado");
            System.out.println(contraService.insertContra(c));
        } else {
            System.out.println("No existe el contra para insertar");
        }
    }

}
