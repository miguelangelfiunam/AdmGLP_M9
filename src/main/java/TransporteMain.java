
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import mx.unam.dgtic.admglp.modelo.TransporteService;
import mx.unam.dgtic.admglp.modelo.TransporteServiceImpl;
import mx.unam.dgtic.admglp.vo.Transporte;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author unam
 */
public class TransporteMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
            System.out.println("MIGUEL ANGEL MARTINEZ RIVERA");
            System.out.println("CRUD TRANSPORTE");
            TransporteService transporteService = new TransporteServiceImpl(em);
            System.out.println("----------------");
            muestraTransportes(transporteService);
            System.out.println("----------------");
            muestraTransporte(transporteService);
            System.out.println("----------------");
            actualizaTransporte(transporteService);
            System.out.println("----------------");
            borraEInsertaTransporte(transporteService);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void muestraTransportes(TransporteService transporteService) {
        List<Transporte> result = transporteService.getTransportes();
        for (Transporte transporte : result) {
            System.out.println(transporte);
        }
    }

    public static void muestraTransporte(TransporteService transporteService) {
        Transporte u = transporteService.getTransporte(1);
        System.out.println(u);
    }

    public static void actualizaTransporte(TransporteService transporteService) {
        Transporte a = transporteService.getTransporte(1);
        if (a != null) {
            System.out.println(a);
            a.setEstatus(20);
            transporteService.updateTransporte(a);
            System.out.println(transporteService.getTransporte(a.getId()));
        }
    }

    public static void borraEInsertaTransporte(TransporteService transporteService) {
        Transporte a = transporteService.deleteTransporte(1);
        System.out.println("Borrado");
        System.out.println(a);
        if (a != null) {
            System.out.println("Insertado");
            System.out.println(transporteService.insertTransporte(a));
        } else {
            System.out.println("No existe el transporte para insertar");
        }
    }

}
