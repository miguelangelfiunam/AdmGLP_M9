/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.ejb;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.model.ContraModel;
import mx.unam.dgtic.admglp.model.RolModel;

/**
 *
 * @author unam
 */
@Named
@SessionScoped
public class ListaContrasBean implements Serializable {

    private static final long serialVersionUID = -4146681491856848089L;
    List<ContraModel> contraModels;

    public ListaContrasBean() {
        this.contraModels = new ArrayList<>();
        contraModels.add(new ContraModel(1, "123", new Date(), null, 10));
        contraModels.add(new ContraModel(2, "456", new Date(), null, 10));
        contraModels.add(new ContraModel(3, "789", new Date(), null, 10));
    }

    public List<ContraModel> getContraModels() {
        return contraModels;
    }

    public void setContraModels(List<ContraModel> contraModels) {
        this.contraModels = contraModels;
    }

    @Override
    public String toString() {
        return "ListaContrasBean{" + "contraModels=" + contraModels + '}';
    }

}
