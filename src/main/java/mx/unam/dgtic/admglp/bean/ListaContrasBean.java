/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import mx.unam.dgtic.admglp.vo.Contra;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author unam
 */
@Named
@SessionScoped
public class ListaContrasBean implements Serializable {

    private static final long serialVersionUID = -4146681491856848089L;
    List<Contra> contraModels;

    public ListaContrasBean() {
        this.contraModels = new ArrayList<>();
        contraModels.add(new Contra(1, "123", new Date(), null, 10));
        contraModels.add(new Contra(2, "456", new Date(), null, 10));
        contraModels.add(new Contra(3, "789", new Date(), null, 10));
    }

    public List<Contra> getContraModels() {
        return contraModels;
    }

    public void setContraModels(List<Contra> contraModels) {
        this.contraModels = contraModels;
    }

    @Override
    public String toString() {
        return "ListaContrasBean{" + "contraModels=" + contraModels + '}';
    }

}
