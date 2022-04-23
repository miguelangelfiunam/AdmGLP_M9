package mx.unam.dgtic.admglp.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author unam
 */
@Named
@SessionScoped
public class ClienteBean implements Serializable  {
    private static final long serialVersionUID = -4146681491856848089L;
    
   public String ejemplo(){
       int dato = 0;
       return "cliente";
   } 
}
