
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import mx.unam.dgtic.admglp.modelo.MunicipioService;
import mx.unam.dgtic.admglp.vo.Asentamiento;
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
            System.out.println("Municipio");
            MunicipioService instance = new MunicipioService(em);

            List<Municipio> result = instance.getMunicipios();
            for (Municipio municipio : result) {
                System.out.println(municipio);
                for (Asentamiento asentamiento : municipio.getAsentamientos()) {
                    System.out.println("\t" + asentamiento);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
