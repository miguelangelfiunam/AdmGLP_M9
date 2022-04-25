/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.DB;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javax.naming.InitialContext;

/**
 *
 * @author unam
 */
public class Conexion {

    public static EntityManagerFactory emf;
    public static InitialContext ctx;

    public static EntityManager createEntityManager() {
        try {
            if (emf == null) {
                emf = Persistence.createEntityManagerFactory("admglp");
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return emf.createEntityManager();
    }
    
    public static InitialContext createInitialContext() {
        try {
            if (ctx == null) {
                ctx = new InitialContext();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return ctx;
    }
}
