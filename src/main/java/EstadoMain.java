
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import mx.unam.dgtic.admglp.modelo.EstadoService;
import mx.unam.dgtic.admglp.modelo.EstadoServiceImpl;
import mx.unam.dgtic.admglp.vo.Estado;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author unam
 */
public class EstadoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
            System.out.println("MIGUEL ANGEL MARTINEZ RIVERA");
            System.out.println("ESTADO");
            EstadoService estadoService = new EstadoServiceImpl(em);
            System.out.println("----------------");
            muestraEstados(estadoService);
            System.out.println("----------------");
            muestraEstado(estadoService);
            System.out.println("----------------");
            actualizaEstado(estadoService);
            System.out.println("----------------");
            borraEInsertaEstado(estadoService);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void muestraEstados(EstadoService estadoService) {
        List<Estado> result = estadoService.getEstadosActivos();
        for (Estado estado : result) {
            System.out.println(estado);
        }
    }

    public static void muestraEstado(EstadoService estadoService) {
        Estado u = estadoService.getEstado(1);
        System.out.println(u);
    }

    public static void actualizaEstado(EstadoService estadoService) {
        Estado e = estadoService.getEstado(1);
        if (e != null) {
            System.out.println(e);
            e.setEstatus(20);
            estadoService.updateEstado(e);
            System.out.println(estadoService.getEstado(e.getId()));
        }
    }

    public static void borraEInsertaEstado(EstadoService estadoService) {
        Estado e = estadoService.deleteEstado(1);
        System.out.println("Borrado");
        System.out.println(e);
        if (e != null) {
            System.out.println("Insertado");
            System.out.println(estadoService.insertEstado(e));
        } else {
            System.out.println("No existe el estado para insertar");
        }
    }

}
