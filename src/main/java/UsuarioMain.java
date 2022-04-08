
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import mx.unam.dgtic.admglp.modelo.UsuarioService;
import mx.unam.dgtic.admglp.modelo.UsuarioServiceImpl;
import mx.unam.dgtic.admglp.vo.Rol;
import mx.unam.dgtic.admglp.vo.Usuario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author unam
 */
public class UsuarioMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
            System.out.println("MIGUEL ANGEL MARTINEZ RIVERA");
            System.out.println("USUARIO");
            UsuarioService instance = new UsuarioServiceImpl(em);

            List<Usuario> result = instance.getUsuarios();
            for (Usuario usuario : result) {
                System.out.println(usuario);
                for (Rol rol : usuario.getRoles()) {
                    System.out.println(rol);
                }
            }
            
            Usuario u = instance.getUsuario(1);
            System.out.println(u);
            
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
