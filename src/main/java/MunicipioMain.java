
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import mx.unam.dgtic.admglp.modelo.MunicipioService;
import mx.unam.dgtic.admglp.modelo.MunicipioServiceImpl;
import mx.unam.dgtic.admglp.vo.Municipio;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author unam
 */
public class MunicipioMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
            System.out.println("MIGUEL ANGEL MARTINEZ RIVERA");
            System.out.println("CRUD MUNICIPIO");
            MunicipioService municipioService = new MunicipioServiceImpl(em);
            System.out.println("----------------");
            muestraMunicipios(municipioService);
            System.out.println("----------------");
            muestraMunicipio(municipioService);
            System.out.println("----------------");
            actualizaMunicipio(municipioService);
            System.out.println("----------------");
            borraEInsertaMunicipio(municipioService);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void muestraMunicipios(MunicipioService municipioService) {
        List<Municipio> result = municipioService.getMunicipiosActivos();
        for (Municipio municipio : result) {
            System.out.println(municipio);
        }
    }

    public static void muestraMunicipio(MunicipioService municipioService) {
        Municipio u = municipioService.getMunicipio(1);
        System.out.println(u);
    }

    public static void actualizaMunicipio(MunicipioService municipioService) {
        Municipio m = municipioService.getMunicipio(1);
        if (m != null) {
            System.out.println(m);
            m.setEstatus(20);
            municipioService.updateMunicipio(m);
            System.out.println(municipioService.getMunicipio(m.getId()));
        }
    }

    public static void borraEInsertaMunicipio(MunicipioService municipioService) {
        Municipio m = municipioService.deleteMunicipio(1);
        System.out.println("Borrado");
        System.out.println(m);
        if (m != null) {
            System.out.println("Insertado");
            System.out.println(municipioService.insertMunicipio(m));
        } else {
            System.out.println("No existe el municipio para insertar");
        }
    }

}
