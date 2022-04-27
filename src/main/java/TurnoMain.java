
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.modelo.TurnoService;
import mx.unam.dgtic.admglp.modelo.TurnoServiceImpl;
import mx.unam.dgtic.admglp.vo.Turno;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author unam
 */
public class TurnoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admglp");
            EntityManager em = emf.createEntityManager();
            System.out.println("MIGUEL ANGEL MARTINEZ RIVERA");
            System.out.println("CRUD TURNO");
            TurnoService turnoService = new TurnoServiceImpl(em);
            System.out.println("----------------");
            muestraTurnos(turnoService);
            System.out.println("----------------");
            muestraTurno(turnoService);

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, 7);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);

            Date date = new Date();
            date = cal.getTime();
            System.out.println(date.toString());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(sdf.format(date));
            Integer estatus = 10;
            System.out.println("----------------");
            muestraTurnoActual(turnoService, date, estatus);

            System.out.println("----------------");
            actualizaTurno(turnoService);
            System.out.println("----------------");
            borraEInsertaTurno(turnoService);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void muestraTurnos(TurnoService turnoService) {
        List<Turno> result = turnoService.getTurnos();
        for (Turno turno : result) {
            System.out.println(turno);
        }
    }

    public static void muestraTurno(TurnoService turnoService) {
        Turno u = turnoService.getTurno(1);
        System.out.println(u);
    }

    public static void muestraTurnoActual(TurnoService turnoService, Date fecha, Integer estatus) {
        Turno u = turnoService.getTurnoActual(fecha, estatus);
        if (u != null) {
            System.out.println(u);
        } else {
            System.out.println("Sin turno");
        }

    }

    public static void actualizaTurno(TurnoService turnoService) {
        Turno a = turnoService.getTurno(1);
        if (a != null) {
            System.out.println(a);
            a.setEstatus(20);
            turnoService.updateTurno(a);
            System.out.println(turnoService.getTurno(a.getId()));
        }
    }

    public static void borraEInsertaTurno(TurnoService turnoService) {
        Turno a = turnoService.deleteTurno(1);
        System.out.println("Borrado");
        System.out.println(a);
        if (a != null) {
            System.out.println("Insertado");
            System.out.println(turnoService.insertTurno(a));
        } else {
            System.out.println("No existe el turno para insertar");
        }
    }

}
