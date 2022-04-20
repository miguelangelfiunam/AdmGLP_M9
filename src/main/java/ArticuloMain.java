
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import mx.unam.dgtic.admglp.modelo.ArticuloService;
import mx.unam.dgtic.admglp.modelo.ArticuloServiceImpl;
import mx.unam.dgtic.admglp.vo.Articulo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author unam
 */
public class ArticuloMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
            System.out.println("MIGUEL ANGEL MARTINEZ RIVERA");
            System.out.println("CRUD ARTICULO");
            ArticuloService articuloService = new ArticuloServiceImpl(em);
            System.out.println("----------------");
            muestraArticulos(articuloService);
            System.out.println("----------------");
            muestraArticulo(articuloService);
            System.out.println("----------------");
            actualizaArticulo(articuloService);
            System.out.println("----------------");
            borraEInsertaArticulo(articuloService);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void muestraArticulos(ArticuloService articuloService) {
        List<Articulo> result = articuloService.getArticulos();
        for (Articulo articulo : result) {
            System.out.println(articulo);
        }
    }

    public static void muestraArticulo(ArticuloService articuloService) {
        Articulo u = articuloService.getArticulo(1);
        System.out.println(u);
    }

    public static void actualizaArticulo(ArticuloService articuloService) {
        Articulo a = articuloService.getArticulo(1);
        if (a != null) {
            System.out.println(a);
            a.setEstatus(20);
            articuloService.updateArticulo(a);
            System.out.println(articuloService.getArticulo(a.getId()));
        }
    }

    public static void borraEInsertaArticulo(ArticuloService articuloService) {
        Articulo a = articuloService.deleteArticulo(1);
        System.out.println("Borrado");
        System.out.println(a);
        if (a != null) {
            System.out.println("Insertado");
            System.out.println(articuloService.insertArticulo(a));
        } else {
            System.out.println("No existe el articulo para insertar");
        }
    }

}
