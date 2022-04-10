
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import mx.unam.dgtic.admglp.modelo.ClienteService;
import mx.unam.dgtic.admglp.modelo.ClienteServiceImpl;
import mx.unam.dgtic.admglp.vo.Cliente;
import mx.unam.dgtic.admglp.vo.Direccion;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author unam
 */
public class ClienteMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
            System.out.println("MIGUEL ANGEL MARTINEZ RIVERA");
            System.out.println("CRUD CLIENTE");
            ClienteService clienteService = new ClienteServiceImpl(em);
            System.out.println("----------------");
            muestraClientes(clienteService);
            System.out.println("----------------");
            muestraCliente(clienteService);
            System.out.println("----------------");
            actualizaCliente(clienteService);
            System.out.println("----------------");
            borraEInsertaCliente(clienteService);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void muestraClientes(ClienteService clienteService) {
        List<Cliente> result = clienteService.getClientesActivos();
        for (Cliente cliente : result) {
            System.out.println(cliente);
            for (Direccion direccion : cliente.getDirecciones()) {
                System.out.println(direccion);
            }
        }
    }

    public static void muestraCliente(ClienteService clienteService) {
        Cliente u = clienteService.getCliente(1);
        System.out.println(u);
    }

    public static void actualizaCliente(ClienteService clienteService) {
        Cliente c = clienteService.getCliente(1);
        if (c != null) {
            System.out.println(c);
            c.setEstatus(10);
            clienteService.updateCliente(c);
            System.out.println(clienteService.getCliente(c.getId()));
        }
    }

    public static void borraEInsertaCliente(ClienteService clienteService) {
        Cliente c = clienteService.deleteCliente(1);
        System.out.println("Borrado");
        System.out.println(c);
        if (c != null) {
            System.out.println("Insertado");
            System.out.println(clienteService.insertCliente(c));
        } else {
            System.out.println("No existe el cliente para insertar");
        }
    }

}
