
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
            System.out.println("CRUD USUARIO");
            UsuarioService usuarioService = new UsuarioServiceImpl(em);
            System.out.println("----------------");
            muestraUsuarios(usuarioService);
            System.out.println("----------------");
            String apodo = "mike";
            String contra = "123";
            Integer estatus = 10;
            muestraUsuario(usuarioService, apodo, contra, estatus);
            System.out.println("----------------");
            muestraUsuario(usuarioService);
            System.out.println("----------------");
            actualizaUsuario(usuarioService);
            System.out.println("----------------");
            borraEInsertaUsuario(usuarioService);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void muestraUsuarios(UsuarioService usuarioService) {
        List<Usuario> result = usuarioService.getUsuarios();
        for (Usuario usuario : result) {
            System.out.println(usuario);
            for (Rol rol : usuario.getRoles()) {
                System.out.println(rol);
            }
        }
    }

    public static void muestraUsuario(UsuarioService usuarioService) {
        Usuario u = usuarioService.getUsuario(1);
        System.out.println(u);
    }
    
    public static void muestraUsuario(UsuarioService usuarioService, String apodo, String contra, Integer estatus) {
        Usuario u = usuarioService.getUsuario(apodo, contra, estatus);
        System.out.println(u);
    }

    public static void actualizaUsuario(UsuarioService usuarioService) {
        Usuario u = usuarioService.getUsuario(1);
        if (u != null) {
            System.out.println(u);
            u.setApodo("dani_glp_2");
            usuarioService.updateUsuario(u);
            System.out.println(usuarioService.getUsuario(u.getIdusuario()));
        }
    }

    public static void borraEInsertaUsuario(UsuarioService usuarioService) {
        Usuario u = usuarioService.deleteUsuario(1);
        System.out.println("Borrado");
        System.out.println(u);
        if(u != null){
            System.out.println("Insertado");
            System.out.println(usuarioService.insertUsuario(u));
        }else{
            System.out.println("No existe el usuario para insertar");
        }
    }

}
