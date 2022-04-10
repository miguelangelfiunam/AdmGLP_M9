
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import mx.unam.dgtic.admglp.modelo.RolService;
import mx.unam.dgtic.admglp.modelo.RolServiceImpl;
import mx.unam.dgtic.admglp.vo.Rol;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author unam
 */
public class RolMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
            System.out.println("MIGUEL ANGEL MARTINEZ RIVERA");
            System.out.println("CRUD ROL");
            RolService rolService = new RolServiceImpl(em);
            System.out.println("----------------");
            muestraRoles(rolService);
            System.out.println("----------------");
            muestraRol(rolService);
            System.out.println("----------------");
            actualizaRol(rolService);
            System.out.println("----------------");
            borraEInsertaRol(rolService);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void muestraRoles(RolService rolService) {
        List<Rol> result = rolService.getRolesActivos();
        for (Rol rol : result) {
            System.out.println(rol);
        }
    }

    public static void muestraRol(RolService rolService) {
        Rol u = rolService.getRol(1);
        System.out.println(u);
    }

    public static void actualizaRol(RolService rolService) {
        Rol a = rolService.getRol(1);
        if (a != null) {
            System.out.println(a);
            a.setEstatus(20);
            rolService.updateRol(a);
            System.out.println(rolService.getRol(a.getIdrol()));
        }
    }

    public static void borraEInsertaRol(RolService rolService) {
        Rol r = rolService.deleteRol(1);
        System.out.println("Insertado");
        System.out.println(r);
        if (r != null) {
            System.out.println("Borrado");
            System.out.println(rolService.insertRol(r));
        } else {
            System.out.println("No existe el rol para insertar");
        }
    }

}
