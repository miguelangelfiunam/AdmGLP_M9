
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.modelo.PedidoService;
import mx.unam.dgtic.admglp.modelo.PedidoServiceImpl;
import mx.unam.dgtic.admglp.vo.Pedido;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author unam
 */
public class PedidoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
            System.out.println("MIGUEL ANGEL MARTINEZ RIVERA");
            System.out.println("CRUD PEDIDO");
            PedidoService accesoService = new PedidoServiceImpl(em);
//            System.out.println("----------------");
//            muestraPedidos(accesoService);
//            System.out.println("----------------");
//            muestraPedido(accesoService);
            System.out.println("----------------");
//            Integer status = 10;
            Integer status = null;
            
            Integer idCliente = 1;
//            Integer idCliente = null;

//            Integer idEmpleado = 1;
            Integer idEmpleado = null;
            
//            Integer idDireccion = 1;
            Integer idDireccion = null;
            
//            Double total = 500.0;
            Double total = null;

//            String sfecIni_1 = "01/12/2021 07:00:00";
//            Date fecIni_1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(sfecIni_1);
            Date fecIni_1 = null;

//            String sfecIni_2 = "30/01/2022 07:00:00";
//            Date fecIni_2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(sfecIni_2);
            Date fecIni_2 = null;

            muestraPedidosCriteria(accesoService, status, idCliente, idEmpleado, idDireccion, fecIni_1, fecIni_2, total);
//            System.out.println("----------------");
//            actualizaPedido(accesoService);
//            System.out.println("----------------");
//            borraEInsertaPedido(accesoService);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void muestraPedidosCriteria(PedidoService accesoService, Integer estatus, Integer idCliente, Integer idEmpleado, Integer idDireccion, Date fecReg_1, Date fecReg_2, Double total) {
        List<Pedido> result = accesoService.getPedidosCriteria(estatus, idCliente, idEmpleado, idDireccion, fecReg_1, fecReg_2, total);
        for (Pedido acceso : result) {
            System.out.println(acceso);
        }
        System.out.println(result.size());
    }

    public static void muestraPedidos(PedidoService accesoService) {
        List<Pedido> result = accesoService.getPedidos();
        for (Pedido acceso : result) {
            System.out.println(acceso);
        }
    }

    public static void muestraPedido(PedidoService accesoService) {
        Pedido u = accesoService.getPedido(1);
        System.out.println(u);
    }

    public static void actualizaPedido(PedidoService accesoService) {
        Pedido e = accesoService.getPedido(1);
        if (e != null) {
            System.out.println(e);
            e.setEstatus(20);
            accesoService.updatePedido(e);
            System.out.println(accesoService.getPedido(e.getId()));
        }
    }

    public static void borraEInsertaPedido(PedidoService accesoService) {
        Pedido e = accesoService.deletePedido(1);
        System.out.println("Borrado");
        System.out.println(e);
        if (e != null) {
            System.out.println("Insertado");
            System.out.println(accesoService.insertPedido(e));
        } else {
            System.out.println("No existe el acceso para insertar");
        }
    }

}
