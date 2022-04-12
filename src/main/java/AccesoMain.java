
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.modelo.AccesoService;
import mx.unam.dgtic.admglp.modelo.AccesoServiceImpl;
import mx.unam.dgtic.admglp.vo.Acceso;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author unam
 */
public class AccesoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
            System.out.println("MIGUEL ANGEL MARTINEZ RIVERA");
            System.out.println("CRUD ACCESO");
            AccesoService accesoService = new AccesoServiceImpl(em);
//            System.out.println("----------------");
//            muestraAccesos(accesoService);
//            System.out.println("----------------");
//            muestraAcceso(accesoService);
            System.out.println("----------------");
            Integer status = null;
            Integer idUsuario = 1;

//            String sfecIni_1 = "01/12/2021 07:00:00";
//            Date fecIni_1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(sfecIni_1);
            Date fecIni_1 = null;

//            String sfecIni_2 = "30/01/2022 07:00:00";
//            Date fecIni_2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(sfecIni_2);
            Date fecIni_2 = null;

//            String sfecFin_1 = "31/12/1998 07:00:00";
//            Date fecFin_1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(sfecFin_1);
            Date fecFin_1 = null;

//            String sfecFin_2 = "31/12/1998 07:00:00";
//            Date fecFin_2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(sfecFin_2);
            Date fecFin_2 = null;

            muestraAccesosCriteria(accesoService, status, fecIni_1, fecIni_2, fecFin_1, fecFin_2, idUsuario);
//            System.out.println("----------------");
//            actualizaAcceso(accesoService);
//            System.out.println("----------------");
//            borraEInsertaAcceso(accesoService);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void muestraAccesosCriteria(AccesoService accesoService, Integer estatus, Date fecIni_1, Date fecIni_2, Date fecFin_1, Date fecFin_2, Integer idEmpleado) {
        List<Acceso> result = accesoService.getAccesosCriteria(estatus, fecIni_1, fecIni_2, fecFin_1, fecFin_2, idEmpleado);
        for (Acceso acceso : result) {
            System.out.println(acceso);
        }
        System.out.println(result.size());
    }

    public static void muestraAccesos(AccesoService accesoService) {
        List<Acceso> result = accesoService.getAccesos();
        for (Acceso acceso : result) {
            System.out.println(acceso);
        }
    }

    public static void muestraAcceso(AccesoService accesoService) {
        Acceso u = accesoService.getAcceso(1);
        System.out.println(u);
    }

    public static void actualizaAcceso(AccesoService accesoService) {
        Acceso e = accesoService.getAcceso(1);
        if (e != null) {
            System.out.println(e);
            e.setEstatus(20);
            accesoService.updateAcceso(e);
            System.out.println(accesoService.getAcceso(e.getId()));
        }
    }

    public static void borraEInsertaAcceso(AccesoService accesoService) {
        Acceso e = accesoService.deleteAcceso(1);
        System.out.println("Borrado");
        System.out.println(e);
        if (e != null) {
            System.out.println("Insertado");
            System.out.println(accesoService.insertAcceso(e));
        } else {
            System.out.println("No existe el acceso para insertar");
        }
    }

}
